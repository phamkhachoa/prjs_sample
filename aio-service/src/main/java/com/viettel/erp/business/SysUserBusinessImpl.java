package com.viettel.erp.business;

import com.viettel.erp.bo.SysUserBO;
import com.viettel.erp.dao.SysUserDAO;
import com.viettel.erp.dto.SysUserDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("sysUserBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SysUserBusinessImpl extends BaseFWBusinessImpl<SysUserDAO, SysUserDTO, SysUserBO> implements SysUserBusiness {

    @Autowired
    private SysUserDAO sysUserDAO;


    public SysUserBusinessImpl() {
        tModel = new SysUserBO();
        tDAO = sysUserDAO;
    }

    @Override
    public SysUserDAO gettDAO() {
        return sysUserDAO;
    }

    @Override
    public long count() {
        return sysUserDAO.count("SysUserBO", null);
    }

    @Override
    public List<SysUserDTO> getForAutoComplete(SysUserDTO query) {
        return sysUserDAO.getForAutoComplete(query);
    }


}
