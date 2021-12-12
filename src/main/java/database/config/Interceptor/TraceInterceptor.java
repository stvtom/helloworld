package database.config.Interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Logback 添加请求追踪ID
 * https://blog.csdn.net/weixin_43723635/article/details/107201479
 */
@Component
public class TraceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        initTraceId(request);
        return true;
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

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.clear();
    }
}
