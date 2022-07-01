package miu.edu.lab3.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
    public class LoggerAspect {
    @Pointcut("@annotation(miu.edu.lab3.Aspect.Annotation.ActivityLog)")
    public void activityLogAnnotation() {
    }

    @Before("activityLogAnnotation()")
    public void log(JoinPoint joinPoint) {
        System.out.println("Method Name: " + joinPoint.getSignature().getName());
        System.out.println("ID: " + joinPoint.getStaticPart().getId());


    }
}
