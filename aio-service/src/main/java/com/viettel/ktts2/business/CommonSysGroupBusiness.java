package com.viettel.ktts2.business;

import com.viettel.ktts2.dao.CommonSysGroupDao;
import com.viettel.ktts2.dto.CTreeModel;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CommonSysGroupBusiness extends BaseFWBusinessImpl {
    @Autowired
    CommonSysGroupDao commonSysGroupDao;

    public List<CTreeModel> getSysGroupAjax(Long parentId) {
        return commonSysGroupDao.getSysGroupAjax(parentId);

    }
}
