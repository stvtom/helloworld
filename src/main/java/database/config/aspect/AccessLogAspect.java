package database.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class AccessLogAspect {

    @Pointcut("execution(* database.controller.*.*(..))")
    public void pointCut(){
    };

    @Before("pointCut()")
    public void before(JoinPoint point) {
        log.info("===Before切面拦截===：{}", Arrays.asList(point.getArgs()));
    }

    @After(value = "pointCut()")
    private void logEnd(){
        System.out.println("<<<End");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    private void logReturn(Object result){
        System.out.println("---Return:" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    private void logException(Throwable exception){
        System.out.println("!exception:" + exception);
    }

    @Around("pointCut()")
    private Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("====Before Around====");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("====After  Around====");

        return result;
    }
}
