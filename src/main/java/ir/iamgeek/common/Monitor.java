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
    @Around("execution(* ir.iamgeek.repository.PersonDA.* (..))")
    public Object monitor(ProceedingJoinPoint point) throws Throwable {
        Method declaredMethod = point.getTarget().getClass().getDeclaredMethod(point.getSignature().getName(), Connection.class, Person.class);
        Transactional annotation = declaredMethod.getDeclaredAnnotation(Transactional.class);
        if (annotation != null) {
            Connection connection = JDBC.getConnection();
            Object proceed = point.proceed(new Object[]{connection});
            connection.commit();
            connection.close();
            return proceed;
        }
        return null;
    }

}
