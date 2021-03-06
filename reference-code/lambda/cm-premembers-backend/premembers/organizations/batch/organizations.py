import inspect

from premembers.common import common_utils, eventhelper
from premembers.organizations.logic import organizationsBatch_logic
from premembers.organizations.logic import organizationTask_logic


def execute_delete_organization_handler(event, context):
    task_id = eventhelper.get_task_id(event)
    message_id = eventhelper.get_message_id(event)
    receipt_handle = eventhelper.get_receipt_handle(event)

    common_utils.begin_logger(task_id, __name__, inspect.currentframe())

    # batch delete organization delay task
    result = organizationsBatch_logic.execute_delete_organization(task_id)

    if result is True:
        # 正常終了処理
        organizationTask_logic.processing_finish(task_id, message_id,
                                                 receipt_handle)
    else:
        organizationTask_logic.processing_error(task_id, message_id)


def execute_organization_task_controller_handler(event, context):
    trace_id = event['id']
    common_utils.begin_logger(trace_id, __name__, inspect.currentframe())
    # Call Task Controller
    organizationsBatch_logic.execute_organization_task_controller(trace_id)
