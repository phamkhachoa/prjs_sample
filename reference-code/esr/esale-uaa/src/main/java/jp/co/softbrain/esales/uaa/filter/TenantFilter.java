package jp.co.softbrain.esales.uaa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jp.co.softbrain.esales.config.Constants;
import jp.co.softbrain.esales.uaa.tenant.util.JwtTokenUtil;
import jp.co.softbrain.esales.uaa.tenant.util.TenantContextHolder;

/**
 * TenantFilter class to get tenantId in request header, process every request
 *
 */
@Component
@Order(1)
public class TenantFilter implements Filter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * @see javax.servlet.Filter.doFilter(...)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String tenantId = jwtTokenUtil.getTenantIdFromToken();
        if (tenantId == null || tenantId.length() <= 0) {
            tenantId = req.getHeader(Constants.HEADER_TENANT_ID);
        }
        TenantContextHolder.setTenantId(tenantId);
        chain.doFilter(request, response);
    }
}
