/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.viettel.coms.dao;

import com.viettel.coms.bo.TmpnContractBO;
import com.viettel.service.base.dao.BaseFWDAOImpl;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author TruongBX3
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("tmpnContractDAO")
public class TmpnContractDAO extends BaseFWDAOImpl<TmpnContractBO, Long> {

    public TmpnContractDAO() {
        this.model = new TmpnContractBO();
    }

    public TmpnContractDAO(Session session) {
        this.session = session;
    }

    public List<Long> getTargetInDB(Long totalMonthPlanId) {
        // TODO Auto-generated method stub
        StringBuilder sql = new StringBuilder(
                "SELECT TMPN_CONTRACT_ID tmpnContractId from TMPN_CONTRACT where TOTAL_MONTH_PLAN_ID = :totalMonthPlanId");
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.setParameter("totalMonthPlanId", totalMonthPlanId);
        query.addScalar("tmpnContractId", new LongType());
        List<Long> val = query.list();
        return val;
    }

    public void deleteContract(List<Long> deleteList) {
        // TODO Auto-generated method stub
        if (deleteList != null) {
            StringBuilder sql = new StringBuilder("Delete TMPN_CONTRACT where TMPN_CONTRACT_ID in :deleteList");
            SQLQuery query = getSession().createSQLQuery(sql.toString());
            query.setParameterList("deleteList", deleteList);
            query.executeUpdate();
        }

    }
}
