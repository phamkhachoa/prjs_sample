package jp.co.softbrain.esales.tenants.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jp.co.softbrain.esales.tenants.tenant.util.TenantContextHolder;
import jp.co.softbrain.esales.config.Constants;
import jp.co.softbrain.esales.errors.CustomException;
import jp.co.softbrain.esales.tenants.tenant.util.JwtTokenUtil;

@Component
public class TenantInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String tenantId = jwtTokenUtil.getTenantIdFromToken();
        if (tenantId == null || tenantId.length() <= 0) {
            tenantId = request.getHeader(Constants.HEADER_TENANT_ID);
        }
        
        // validate tenant
        if (StringUtils.isNoneBlank(tenantId) && !tenantId.matches(Constants.TENANT_FORMAT)) {
            throw new CustomException("Tenant invalid");
        }
        else {
            TenantContextHolder.setTenantId(tenantId);
        }
        TenantContextHolder.setTenantId(tenantId);
        return true;
    }
}
