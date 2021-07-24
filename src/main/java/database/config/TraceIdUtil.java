package database.config;


import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * SpringBoot项目中通过MDC和自定义Filter操作traceId实现日志链路追踪
 * https://blog.csdn.net/hanchao5272/article/details/92107651
 */
public class TraceIdUtil {

    private static final String TRACE_ID = "traceId";

    /**
     * 当traceId为空时，显示的traceId。随意。
     */
    private static final String DEFAULT_TRACE_ID = "0";

    /**
     * 设置traceId
     */
    public static void setTraceId(String traceId) {
        //如果参数为空，则设置默认traceId
        traceId = StringUtils.isBlank(traceId) ? DEFAULT_TRACE_ID : traceId;
        //将traceId放到MDC中
        MDC.put(TRACE_ID, traceId);
    }

    /**
     * 获取traceId
     */
    public static String getTraceId() {
        //获取
        String traceId = MDC.get(TRACE_ID);
        //如果traceId为空，则返回默认值
        return StringUtils.isBlank(traceId) ? DEFAULT_TRACE_ID : traceId;
    }

    public static Boolean defaultTraceId(String traceId) {
        return DEFAULT_TRACE_ID.equals(traceId);
    }

    /**
     * 生成traceId
     */
    public static String genTraceId() {
        return UUID.randomUUID().toString();
    }




}
