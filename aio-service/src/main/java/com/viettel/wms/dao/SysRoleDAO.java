/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.viettel.wms.dao;

import com.viettel.service.base.dao.BaseFWDAOImpl;
import com.viettel.wms.bo.SysRoleBO;
import com.viettel.wms.dto.SysRoleDTO;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author TruongBX3
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("sysRoleDAO")
public class SysRoleDAO extends BaseFWDAOImpl<SysRoleBO, Long> {

    public SysRoleDAO() {
        this.model = new SysRoleBO();
    }

    public SysRoleDAO(Session session) {
        this.session = session;
    }

    public List<SysRoleDTO> doSearchSysRole(SysRoleDTO obj) {
        StringBuilder sql = new StringBuilder("SELECT u.USER_ROLE_ID userRoleId, "
                + "s.CODE code, "
                + "s.NAME name, "
                + "s.DESCRIPTION description "
                + "FROM VPS_OWNER.USER_ROLE u "
                + "INNER JOIN VPS_OWNER.SYS_ROLE s on u.SYS_ROLE_ID = s.SYS_ROLE_ID "
//				+ "WHERE u.USER_ROLE_ID = :user "
        );
        if (obj.getUser() != null) {
            sql.append("WHERE u.SYS_USER_ID = :user ");
        }
        sql.append(" ORDER BY s.CODE");
        StringBuilder sqlCount = new StringBuilder("SELECT COUNT(*) FROM (");
        sqlCount.append(sql.toString());
        sqlCount.append(")");
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        SQLQuery queryCount = getSession().createSQLQuery(sqlCount.toString());

        query.addScalar("userRoleId", new StringType());
        query.addScalar("code", new StringType());
        query.addScalar("name", new StringType());
        query.addScalar("description", new StringType());

        query.setResultTransformer(Transformers.aliasToBean(SysRoleDTO.class));
        if (obj.getUser() != null) {
            query.setLong("user", obj.getUser());
            queryCount.setLong("user", obj.getUser());
        }
        query.setFirstResult((obj.getPage().intValue() - 1) * obj.getPageSize().intValue());
        query.setMaxResults(obj.getPageSize().intValue());
        obj.setTotalRecord(((BigDecimal) queryCount.uniqueResult()).intValue());


        return query.list();
    }
}
