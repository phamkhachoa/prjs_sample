package com.viettel.coms.business;

import com.viettel.coms.bo.MerEntityBO;
import com.viettel.coms.dao.MerEntityDAO;
import com.viettel.coms.dto.MerEntitySimpleDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("merEntityBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MerEntityBusinessImpl extends BaseFWBusinessImpl<MerEntityDAO, MerEntitySimpleDTO, MerEntityBO>
        implements MerEntityBusiness {

    @Autowired
    private MerEntityDAO merEntityDAO;

    public MerEntityBusinessImpl() {
        tModel = new MerEntityBO();
        tDAO = merEntityDAO;
    }

    @Override
    public MerEntityDAO gettDAO() {
        return merEntityDAO;
    }

    @Override
    public long count() {
        return merEntityDAO.count("MerEntityBO", null);
    }

}
