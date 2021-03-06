package database.config.sync;

import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;


/**
 * 线程池 实现传递MDC
 */
public class HydraThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    private static final long serialVersionUID = 1L;
    private boolean useFixedContext = false;
    private Map<String, String> fixedContext;

    public HydraThreadPoolTaskExecutor() {
        super();
    }

    public HydraThreadPoolTaskExecutor(Map<String, String> fixedContext) {
        super();
        this.fixedContext = fixedContext;
        useFixedContext = (fixedContext != null);
    }

    private Map<String, String> getContextForTask() {
        return useFixedContext ? fixedContext : MDC.getCopyOfContextMap();
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrapExecute(command, getContextForTask()));
    }


    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return super.submit(wrapSubmit(task, getContextForTask()));
    }

    private <T> Callable<T> wrapSubmit(Callable<T> task, final Map<String, String> context) {
        return () -> {
            Map<String, String> previous = MDC.getCopyOfContextMap();
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            try {
                return task.call();
            } finally {
                if (previous == null) {
                    MDC.clear();
                } else {
                    MDC.setContextMap(previous);
                }
            }
        };
    }

    private Runnable wrapExecute(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            Map<String, String> previous = MDC.getCopyOfContextMap();
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            try {
                runnable.run();
            } finally {
                if (previous == null) {
                    MDC.clear();
                } else {
                    MDC.setContextMap(previous);
                }
            }
        };
    }

}
