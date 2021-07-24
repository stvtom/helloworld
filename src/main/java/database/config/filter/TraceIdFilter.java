package database.config.filter;

import database.config.Interceptor.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * SpringBoot Logback日志配置
 * https://www.cnblogs.com/lspz/p/6473686.html
 */
//需要在HelloApplication上加@ServletComponentScan(basePackages = "database.config")配合使用
// 此次没使用
@WebFilter(urlPatterns = "/*", filterName = "traceIdFilter")
@Order(1)
@Slf4j
//1.AOP加载顺序（切面加载顺序）、2.配置类加载顺序
public class TraceIdFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.info("==============进入拦截器拦截================");
        //traceId初始化
        initTraceId((HttpServletRequest) servletRequest);
        //执行后续过滤器
        filterChain.doFilter(servletRequest,servletResponse);
    }
    /**
     * traceId初始化
     */
    private void initTraceId(HttpServletRequest request) {

        //尝试获取http请求中的traceId
        String traceId = request.getParameter("traceId");

        //如果当前traceId为空或者为默认traceId，则生成新的traceId
        if (StringUtils.isBlank(traceId) || TraceIdUtil.defaultTraceId(traceId)){
            traceId = TraceIdUtil.genTraceId();
        }
        //设置traceId
        TraceIdUtil.setTraceId(traceId);
    }
}
