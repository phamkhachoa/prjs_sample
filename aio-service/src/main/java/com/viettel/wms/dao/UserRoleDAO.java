/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.viettel.wms.dao;

import com.viettel.coms.dto.SysUserCOMSDTO;
import com.viettel.service.base.dao.BaseFWDAOImpl;
import com.viettel.wms.bo.UserRoleBO;
import com.viettel.wms.dto.UserRoleDTO;
import com.viettel.wms.utils.ValidateUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author TruongBX3
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("userRoleDAO")
public class UserRoleDAO extends BaseFWDAOImpl<UserRoleBO, Long> {

    public UserRoleDAO() {
        this.model = new UserRoleBO();
    }

    public UserRoleDAO(Session session) {
        this.session = session;
    }

    //Danh sách vai trò đã được gán cho người dùng 
    public List<UserRoleDTO> doSearchUserRole(UserRoleDTO obj) {
        StringBuilder sql = new StringBuilder("SELECT u.USER_ROLE_ID userRoleId, "
                + "s.CODE code, "
                + "s.NAME name, "
                + "u.IS_ACTIVE isActive, "
                + "u.SYS_ROLE_ID sysRoleId , "
                + "u.SYS_USER_ID sysUserId , "
                + "s.DESCRIPTION description, "
                + "su.LOGIN_NAME loginName "
                + "FROM VPS_OWNER.USER_ROLE u "
                + "INNER JOIN VPS_OWNER.SYS_ROLE s on u.SYS_ROLE_ID = s.SYS_ROLE_ID "
                + "INNER JOIN VPS_OWNER.SYS_USER su ON su.SYS_USER_ID = u.SYS_USER_ID "
                + "WHERE u.IS_ACTIVE = 1 "
        );
        if (StringUtils.isNotEmpty(obj.getLoginName())) {
            sql.append("AND upper(su.LOGIN_NAME) = upper(:loginName) ");
        }
        sql.append(" ORDER BY s.CODE");
        StringBuilder sqlCount = new StringBuilder("SELECT COUNT(*) FROM (");
        sqlCount.append(sql.toString());
        sqlCount.append(")");
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        SQLQuery queryCount = getSession().createSQLQuery(sqlCount.toString());


        query.addScalar("userRoleId", new LongType());
        query.addScalar("loginName", new StringType());
        query.addScalar("code", new StringType());
        query.addScalar("name", new StringType());
        query.addScalar("description", new StringType());
        query.addScalar("isActive", new LongType());
        query.addScalar("sysRoleId", new LongType());
        query.addScalar("sysUserId", new LongType());


        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));
        if (StringUtils.isNotEmpty(obj.getLoginName())) {
            query.setParameter("loginName", obj.getLoginName());
            queryCount.setParameter("loginName", obj.getLoginName());
        }
        query.setFirstResult((obj.getPage().intValue() - 1) * obj.getPageSize().intValue());
        query.setMaxResults(obj.getPageSize().intValue());
        obj.setTotalRecord(((BigDecimal) queryCount.uniqueResult()).intValue());

        return query.list();
    }

    //End
    //Danh sách vai trò chưa được gán cho người dùng
    public List<UserRoleDTO> doSearchRole(UserRoleDTO obj) {
        StringBuilder sql = new StringBuilder("SELECT s.CODE code,"
                + "s.NAME name, "
                + "s.SYS_ROLE_ID sysRoleId , "
                + "s.DESCRIPTION description "
                + "FROM VPS_OWNER.SYS_ROLE s "
                + "WHERE NOT EXISTS "
                + "(SELECT * FROM VPS_OWNER.USER_ROLE u "
                + "WHERE s.SYS_ROLE_ID = u.SYS_ROLE_ID "
                + "AND u.SYS_USER_ID = :sysUserId "
                + "AND u.IS_ACTIVE = 1"
                + ") "
        );
        if (StringUtils.isNotEmpty(obj.getKeySearch())) {
            sql.append(" AND (upper(s.NAME) LIKE upper(:keySearch) escape '&' OR upper(s.CODE) LIKE upper(:keySearch) escape '&')");
        }

        sql.append(" ORDER BY s.CODE");
        StringBuilder sqlCount = new StringBuilder("SELECT COUNT(*) FROM (");
        sqlCount.append(sql.toString());
        sqlCount.append(")");
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        SQLQuery queryCount = getSession().createSQLQuery(sqlCount.toString());

        query.addScalar("code", new StringType());
        query.addScalar("name", new StringType());
        query.addScalar("description", new StringType());
        query.addScalar("sysRoleId", new LongType());


        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));
        if (obj.getSysUserId() != null) {
            query.setLong("sysUserId", obj.getSysUserId());
            queryCount.setLong("sysUserId", obj.getSysUserId());
        }
        if (StringUtils.isNotEmpty(obj.getKeySearch())) {
            query.setParameter("keySearch", "%" + ValidateUtils.validateKeySearch(obj.getKeySearch()) + "%");
            queryCount.setParameter("keySearch", "%" + ValidateUtils.validateKeySearch(obj.getKeySearch()) + "%");
        }
        query.setFirstResult((obj.getPage().intValue() - 1) * obj.getPageSize().intValue());
        query.setMaxResults(obj.getPageSize().intValue());
        obj.setTotalRecord(((BigDecimal) queryCount.uniqueResult()).intValue());

        return query.list();
    }

    //Lay tat ca vai tro chua duoc gan cho nguoi dung
    public List<UserRoleDTO> getAllUserRole(UserRoleDTO obj) {
        StringBuilder sql = new StringBuilder("SELECT s.CODE code,"
                + "s.NAME name, "
                + "s.SYS_ROLE_ID sysRoleId , "
                + "s.DESCRIPTION description "
                + "FROM VPS_OWNER.SYS_ROLE s "
                + "WHERE NOT EXISTS "
                + "(SELECT * FROM VPS_OWNER.USER_ROLE u "
                + "WHERE s.SYS_ROLE_ID = u.SYS_ROLE_ID "
                + "AND u.SYS_USER_ID = :sysUserId "
                + "AND u.IS_ACTIVE = 1"
                + ") "
        );
        if (StringUtils.isNotEmpty(obj.getKeySearch())) {
            sql.append(" AND (upper(s.NAME) LIKE upper(:keySearch) escape '&' OR upper(s.CODE) LIKE upper(:keySearch) escape '&')");
        }

        sql.append(" ORDER BY s.CODE");
        SQLQuery query = getSession().createSQLQuery(sql.toString());

        query.addScalar("code", new StringType());
        query.addScalar("name", new StringType());
        query.addScalar("description", new StringType());
        query.addScalar("sysRoleId", new LongType());


        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));
        if (obj.getSysUserId() != null) {
            query.setLong("sysUserId", obj.getSysUserId());
        }
        if (StringUtils.isNotEmpty(obj.getKeySearch())) {
            query.setParameter("keySearch", "%" + ValidateUtils.validateKeySearch(obj.getKeySearch()) + "%");
        }

        return query.list();
    }

    //End
    //Danh sách Miền dữ liệu kho vai trò của người dùng
    public List<UserRoleDTO> doSearchUserRoleData(UserRoleDTO obj) {
        StringBuilder sql = new StringBuilder("select distinct VPS_OWNER.USER_ROLE_DATA.DOMAIN_DATA_ID domainDataId,VPS_OWNER.USER_ROLE_DATA.USER_ROLE_ID userRoleId, VPS_OWNER.DOMAIN_DATA.DATA_CODE dataCode,"
                + "VPS_OWNER.DOMAIN_DATA.DATA_NAME dataName "
                + "from VPS_OWNER.USER_ROLE "
                + "inner join VPS_OWNER.SYS_ROLE on VPS_OWNER.USER_ROLE.SYS_ROLE_ID = VPS_OWNER.SYS_ROLE.SYS_ROLE_ID "
                + "inner join  VPS_OWNER.USER_ROLE_DATA on VPS_OWNER.USER_ROLE_DATA.USER_ROLE_ID=VPS_OWNER.USER_ROLE.USER_ROLE_ID "
                + "inner join VPS_OWNER.DOMAIN_DATA on VPS_OWNER.USER_ROLE_DATA.DOMAIN_DATA_ID=VPS_OWNER.DOMAIN_DATA.DOMAIN_DATA_ID "
                + "inner join VPS_OWNER.DOMAIN_TYPE on VPS_OWNER.DOMAIN_DATA.DOMAIN_TYPE_ID=VPS_OWNER.DOMAIN_TYPE.DOMAIN_TYPE_ID "
                + "inner join VPS_OWNER.SYS_USER on VPS_OWNER.SYS_USER.SYS_USER_ID = VPS_OWNER.USER_ROLE.SYS_USER_ID "
                + "where VPS_OWNER.USER_ROLE_DATA.USER_ROLE_ID = :userRoleId "
                + "and VPS_OWNER.USER_ROLE.IS_ACTIVE=1 "
                + "and VPS_OWNER.DOMAIN_TYPE.CODE='KTTS_LIST_STOCK' ");

        SQLQuery query = getSession().createSQLQuery(sql.toString());


        query.addScalar("dataCode", new StringType());
        query.addScalar("dataName", new StringType());
        query.addScalar("domainDataId", new LongType());
        query.addScalar("userRoleId", new LongType());


        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));

        if (obj.getUserRoleId() != null) {
            query.setLong("userRoleId", obj.getUserRoleId());
        }
        return query.list();
    }

    //End
    //AutoComplete Kho vai trò
    @SuppressWarnings("unchecked")
    public List<UserRoleDTO> getForAutoCompleteUserRoleData(UserRoleDTO obj) {
        String sql = "select VPS_OWNER.DOMAIN_DATA.DOMAIN_DATA_ID domainDataId,"
                + "VPS_OWNER.DOMAIN_DATA.DATA_CODE code,"
                + "VPS_OWNER.DOMAIN_DATA.DATA_NAME name "
                + "from VPS_OWNER.DOMAIN_DATA "
                + "inner join VPS_OWNER.DOMAIN_TYPE on VPS_OWNER.DOMAIN_DATA.DOMAIN_TYPE_ID=VPS_OWNER.DOMAIN_TYPE.DOMAIN_TYPE_ID "
                + "WHERE VPS_OWNER.DOMAIN_TYPE.CODE='KTTS_LIST_STOCK' ";

        StringBuilder stringBuilder = new StringBuilder(sql);

        stringBuilder.append(" AND ROWNUM <=10 ");
        if (StringUtils.isNotEmpty(obj.getKeySearch())) {
            stringBuilder.append(" AND (upper(VPS_OWNER.DOMAIN_DATA.DATA_NAME) LIKE upper(:keySearch) escape '&' OR upper(VPS_OWNER.DOMAIN_DATA.DATA_CODE) LIKE upper(:keySearch) escape '&')");
        }

        stringBuilder.append(" ORDER BY VPS_OWNER.DOMAIN_DATA.DATA_NAME");


        SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

        query.addScalar("name", new StringType());
        query.addScalar("code", new StringType());
        query.addScalar("domainDataId", new LongType());

        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));

        if (StringUtils.isNotEmpty(obj.getKeySearch())) {
            query.setParameter("keySearch", "%" + ValidateUtils.validateKeySearch(obj.getKeySearch()) + "%");
        }
        return query.list();
    }
    //End autocomplete//////////////

    //Xóa kho vai trò//
    public void deleteUserRoleData(UserRoleDTO obj) {
        StringBuilder sql = new StringBuilder("Delete from VPS_OWNER.USER_ROLE_DATA where VPS_OWNER.USER_ROLE_DATA.DOMAIN_DATA_ID = :domainDataId and VPS_OWNER.USER_ROLE_DATA.USER_ROLE_ID = :userRoleId");
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));
        query.setLong("domainDataId", obj.getDomainDataId());
        query.setLong("userRoleId", obj.getUserRoleId());
        int result = query.executeUpdate();
    }

    //End
    //Them moi kho vai tro nguoi dung
    public void insertUserRoleData(UserRoleDTO obj) {
        int result = 0;
        StringBuilder sql = new StringBuilder("insert into VPS_OWNER.USER_ROLE_DATA(VPS_OWNER.USER_ROLE_DATA.USER_ROLE_ID,VPS_OWNER.USER_ROLE_DATA.DOMAIN_DATA_ID,VPS_OWNER.USER_ROLE_DATA.IS_DEFAULT) "
                + " VALUES(:userRoleId,:domainDataId,:isDefault)");
        SQLQuery query = null;
        query = getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));
        query.setLong("domainDataId", obj.getDomainDataId());
        query.setLong("userRoleId", obj.getUserRoleId());
        query.setLong("isDefault", obj.getIsDefault());
        result = query.executeUpdate();
    }

    //End
    //AutoCompleleteUser
    @SuppressWarnings("unchecked")
    public List<SysUserCOMSDTO> getForAutoComplete(SysUserCOMSDTO obj) {
        String sql = "SELECT distinct su.SYS_USER_ID sysUserId"
                + " ,su.LOGIN_NAME loginName"
                + " ,su.EMPLOYEE_CODE employeeCode"
                + " FROM VPS_OWNER.SYS_USER su"
                + " WHERE su.STATUS=1 ";

        StringBuilder stringBuilder = new StringBuilder(sql);


        if (StringUtils.isNotEmpty(obj.getLoginName())) {
            stringBuilder.append(" AND (upper(su.LOGIN_NAME) LIKE upper(:loginName) escape '&' OR upper(su.EMPLOYEE_CODE) LIKE upper(:loginName) escape '&')");
        }


        stringBuilder.append(" ORDER BY su.EMPLOYEE_CODE");

        SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

        query.addScalar("sysUserId", new LongType());
        query.addScalar("loginName", new StringType());
        query.addScalar("employeeCode", new StringType());

        query.setResultTransformer(Transformers.aliasToBean(SysUserCOMSDTO.class));

        if (StringUtils.isNotEmpty(obj.getLoginName())) {
            query.setParameter("loginName", "%" + ValidateUtils.validateKeySearch(obj.getLoginName()) + "%");
        }

        return query.list();
    }

    //End
    //Bổ sung vai trò vào bảng UserRole
    public void insertRole(UserRoleDTO obj) {
        int result = 0;
        StringBuilder sql = new StringBuilder("insert into VPS_OWNER.USER_ROLE(VPS_OWNER.USER_ROLE.SYS_ROLE_ID,VPS_OWNER.USER_ROLE.SYS_USER_ID,VPS_OWNER.USER_ROLE.IS_ACTIVE,VPS_OWNER.USER_ROLE.USER_ROLE_ID) "
                + " VALUES(:sysRoleId,:sysUserId,:isActive,:userRoleId)");
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));
        query.setLong("sysRoleId", obj.getSysRoleId());
        query.setLong("isActive", obj.getIsActive());
        query.setLong("sysUserId", obj.getSysUserId());
        query.setLong("userRoleId", this.maxId() + 1);
        result = query.executeUpdate();
    }

    //End
    //Update vai trò trong bảng UserRole
    public void updateRole(UserRoleDTO obj) {
        int result = 0;
        StringBuilder sql = new StringBuilder("update VPS_OWNER.USER_ROLE "
                + "set VPS_OWNER.USER_ROLE.SYS_ROLE_ID =:sysRoleId,"
                + "VPS_OWNER.USER_ROLE.SYS_USER_ID=:sysUserId,"
                + "VPS_OWNER.USER_ROLE.IS_ACTIVE=:isActive,"
                + "VPS_OWNER.USER_ROLE.USER_ROLE_ID=:userRoleId"
                + " where VPS_OWNER.USER_ROLE.SYS_ROLE_ID =:sysRoleId "
                + "And VPS_OWNER.USER_ROLE.SYS_USER_ID=:sysUserId");
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));
        query.setLong("sysRoleId", obj.getSysRoleId());
        query.setLong("isActive", obj.getIsActive());
        query.setLong("sysUserId", obj.getSysUserId());
        query.setLong("userRoleId", this.userRoleId(obj.getSysUserId(), obj.getSysRoleId()));
        result = query.executeUpdate();
    }

    //End
    @SuppressWarnings("unchecked")
    public List<SysUserCOMSDTO> getForAutoCompleteSysUser(SysUserCOMSDTO obj) {
        String sql = "SELECT distinct su.SYS_USER_ID sysUserId,"
                + "su.FULL_NAME fullName,"
                + "su.EMPLOYEE_CODE employeeCode,"
                + "su.EMAIL email"
                + " FROM VPS_OWNER.SYS_USER su"
                + " WHERE 1=1 ";

        StringBuilder stringBuilder = new StringBuilder(sql);


        stringBuilder.append(" AND ROWNUM <=10 ");
        if (StringUtils.isNotEmpty(obj.getFullName())) {
            stringBuilder.append(" AND (upper(su.FULL_NAME) LIKE upper(:fullName) escape '&' OR upper(su.EMPLOYEE_CODE) LIKE upper(:fullName) escape '&')");
        }

        stringBuilder.append(" ORDER BY su.EMPLOYEE_CODE");

        SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

        query.addScalar("sysUserId", new LongType());
        query.addScalar("fullName", new StringType());
        query.addScalar("employeeCode", new StringType());
        query.addScalar("email", new StringType());

        query.setResultTransformer(Transformers.aliasToBean(SysUserCOMSDTO.class));

        if (StringUtils.isNotEmpty(obj.getFullName())) {
            query.setParameter("fullName", "%" + ValidateUtils.validateKeySearch(obj.getFullName()) + "%");
        }

        return query.list();
    }

    // Hàm truy vấn dữ liệu trong bảng UserRole
    public UserRoleDTO findOneUserRole(Long sysUserId, Long sysRoleId) {
        String sql = "select u.SYS_USER_ID sysUserId,u.SYS_ROLE_ID sysRoleId from VPS_OWNER.USER_ROLE u where u.SYS_USER_ID=:sysUserId and u.SYS_ROLE_ID=:sysRoleId";
        StringBuilder stringBuilder = new StringBuilder(sql);
        SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());
        query.addScalar("sysUserId", new LongType());
        query.addScalar("sysRoleId", new LongType());
        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));
        query.setLong("sysUserId", sysUserId);
        query.setLong("sysRoleId", sysRoleId);
        return (UserRoleDTO) query.uniqueResult();
    }

    //End
    //Lay Max UserRoleId
    public Long maxId() {
        String sql = "select NVL(max(USER_ROLE_ID),0) from VPS_OWNER.USER_ROLE";
        StringBuilder stringBuilder = new StringBuilder(sql);
        SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());
        return ((java.math.BigDecimal) query.uniqueResult()).longValue();
    }

    //End
    //Lay UserRoleId theo SysRoleId and SysUserId
    public Long userRoleId(Long sysUserId, Long sysRoleId) {
        String sql = "select ur.USER_ROLE_ID from VPS_OWNER.USER_ROLE ur where ur.SYS_ROLE_ID=:sysRoleId and ur.SYS_USER_ID=:sysUserId ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());
        query.setLong("sysRoleId", sysRoleId);
        query.setLong("sysUserId", sysUserId);
        return ((java.math.BigDecimal) query.uniqueResult()).longValue();
    }
    //End

    //Ham Lay ra tat ca kho vai tro nguoi dung
    public List<UserRoleDTO> getAllUserRoleData(UserRoleDTO obj) {
        StringBuilder sql = new StringBuilder("select distinct VPS_OWNER.USER_ROLE_DATA.DOMAIN_DATA_ID domainDataId,VPS_OWNER.USER_ROLE_DATA.USER_ROLE_ID userRoleId, VPS_OWNER.DOMAIN_DATA.DATA_CODE dataCode,"
                + "VPS_OWNER.DOMAIN_DATA.DATA_NAME dataName "
                + "from VPS_OWNER.USER_ROLE "
                + "inner join VPS_OWNER.SYS_ROLE on VPS_OWNER.USER_ROLE.SYS_ROLE_ID = VPS_OWNER.SYS_ROLE.SYS_ROLE_ID "
                + "inner join  VPS_OWNER.USER_ROLE_DATA on VPS_OWNER.USER_ROLE_DATA.USER_ROLE_ID=VPS_OWNER.USER_ROLE.USER_ROLE_ID "
                + "inner join VPS_OWNER.DOMAIN_DATA on VPS_OWNER.USER_ROLE_DATA.DOMAIN_DATA_ID=VPS_OWNER.DOMAIN_DATA.DOMAIN_DATA_ID "
                + "inner join VPS_OWNER.DOMAIN_TYPE on VPS_OWNER.DOMAIN_DATA.DOMAIN_TYPE_ID=VPS_OWNER.DOMAIN_TYPE.DOMAIN_TYPE_ID "
                + "inner join VPS_OWNER.SYS_USER on VPS_OWNER.SYS_USER.SYS_USER_ID = VPS_OWNER.USER_ROLE.SYS_USER_ID "
                + "where VPS_OWNER.USER_ROLE_DATA.USER_ROLE_ID = :userRoleId "
                + "and VPS_OWNER.USER_ROLE.IS_ACTIVE=1 "
                + "and VPS_OWNER.DOMAIN_TYPE.CODE='KTTS_LIST_STOCK' ");

        sql.append(" ORDER BY VPS_OWNER.DOMAIN_DATA.DATA_CODE");
        SQLQuery query = getSession().createSQLQuery(sql.toString());


        query.addScalar("dataCode", new StringType());
        query.addScalar("dataName", new StringType());
        query.addScalar("domainDataId", new LongType());
        query.addScalar("userRoleId", new LongType());


        query.setResultTransformer(Transformers.aliasToBean(UserRoleDTO.class));

        if (obj.getUserRoleId() != null) {
            query.setLong("userRoleId", obj.getUserRoleId());
        }


        return query.list();
    }
    //End
}
