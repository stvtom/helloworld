package database.config;

import database.config.Interceptor.TraceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Resource
    private TraceInterceptor traceInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceInterceptor);
    }

}
