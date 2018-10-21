package ru.eremin.enterprise.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.*;
import java.util.logging.Logger;

@Logged
@Interceptor
public class LogInterceptor {

    private static final Logger LOGGER  = Logger.getLogger(LogInterceptor.class.getSimpleName());

    @AroundInvoke
    public Object addLog(InvocationContext context)throws Exception{
        LOGGER.info(context.getMethod().getName());
        return context.proceed();
    }
}
