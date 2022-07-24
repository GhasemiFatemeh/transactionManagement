package ir.iamgeek.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Monitor {
    @Around("execution(* ir.iamgeek.transactionManagement.*(Connection))")
    public void monitor(ProceedingJoinPoint point) throws Throwable{
        point.proceed();

    }

}
