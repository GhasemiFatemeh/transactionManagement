package ir.iamgeek.common;

import ir.iamgeek.annotation.Transactional;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class Monitor {
    @Around("execution(* ir.iamgeek.repository.PersonDA.* (..))")
    public void monitor(ProceedingJoinPoint point) throws Throwable{
        Method declaredMethod = point.getTarget().getClass().getDeclaredMethod(point.getSignature().getName());
        Transactional annotation = declaredMethod.getDeclaredAnnotation(Transactional.class);
        if (annotation!=null){
            point.proceed();
        }


    }

}
