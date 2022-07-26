package ir.iamgeek.common;

import ir.iamgeek.annotation.Transactional;
import ir.iamgeek.entity.Person;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Connection;

@Aspect
@Component
public class Monitor {

    public static final ThreadLocal THREAD_LOCAL =new ThreadLocal();

    @Around("execution(* ir.iamgeek.repository.PersonDA.* (..))")
    public Object monitor(ProceedingJoinPoint point) throws Throwable {
        Method declaredMethod = point.getTarget().getClass().getDeclaredMethod(point.getSignature().getName(),  Person.class);
        Object[] args = point.getArgs();
        Transactional annotation = declaredMethod.getDeclaredAnnotation(Transactional.class);
        Connection connection = (Connection) THREAD_LOCAL.get();
        if (annotation != null) {
            connection = JDBC.getConnection();
            Object proceed = point.proceed(new Object[]{args[0]});
            connection.commit();
            connection.close();
            return proceed;
        }
        return null;
    }

}
