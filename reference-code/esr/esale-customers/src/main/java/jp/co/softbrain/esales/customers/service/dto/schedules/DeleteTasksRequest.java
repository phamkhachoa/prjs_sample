package jp.co.softbrain.esales.customers.service.dto.schedules;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DeleteTasksRequest
 *
 * @author lequyphuc
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class DeleteTasksRequest implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5451987078610182449L;

    /**
     * taskIdList
     */
    private List<TaskIdInput> taskIdList;
    /**
     * processFlg
     */
    private Integer processFlg;

}
