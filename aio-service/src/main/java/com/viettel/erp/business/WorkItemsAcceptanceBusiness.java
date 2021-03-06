package com.viettel.erp.business;

import com.viettel.erp.dto.WorkItemsAcceptanceDTO;
import com.viettel.erp.dto.approDTO;

import java.util.List;

public interface WorkItemsAcceptanceBusiness {

    long count();

    //tungpv
    List<WorkItemsAcceptanceDTO> doSearchWorkItemsAcceptance(WorkItemsAcceptanceDTO criteria);

    public boolean deleteWorkItemAcceptList(List<String> listString);

    public boolean addWorkItemAcceptList(WorkItemsAcceptanceDTO criteria);

    public boolean updateIsActive(List<Long> listId);

    public Long appro(approDTO obj);
    //end tungpv
}
