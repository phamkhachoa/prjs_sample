/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.wms.webservice;

import com.viettel.service.base.pojo.ConditionBean;
import com.viettel.wms.dto.IProjInvestProjectDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

/**
 * @author hunglq9
 */
@org.apache.cxf.feature.Features(features = "org.apache.cxf.feature.LoggingFeature")
@WebService(targetNamespace = "http://webservice.wms.viettel.com/")
public interface IProjInvestProjectWS {

    @WebMethod(operationName = "getTotal")
    long getTotal() throws Exception;


    @WebMethod(operationName = "getAll")
    public List<IProjInvestProjectDTO> getAll() throws java.lang.Exception;

    @WebMethod(operationName = "getOneById")
    IProjInvestProjectDTO getOneById(Long costCenterId) throws Exception;

    @WebMethod(operationName = "save")
    Long save(IProjInvestProjectDTO costCenterBO) throws Exception;

    @WebMethod(operationName = "delete")
    void delete(IProjInvestProjectDTO costCenterBO) throws Exception;

    @WebMethod(operationName = "searchByHql")
    List<IProjInvestProjectDTO> searchByHql(String hql, List<ConditionBean> conditionBeans) throws Exception;

    @WebMethod(operationName = "searchByHql2")
    List<IProjInvestProjectDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
            throws Exception;

    @WebMethod(operationName = "countByHql")
    Long countByHql(String hql, List<ConditionBean> conditionBeans) throws Exception;

    @WebMethod(operationName = "executeByHql")
    int executeByHql(String hql, List<ConditionBean> conditionBeans) throws Exception;

    @WebMethod(operationName = "getSysDate")
    Date getSysDate() throws Exception;

    @WebMethod(operationName = "getNextValSequence")
    Long getNextValSequence(String sequense) throws Exception;
}
