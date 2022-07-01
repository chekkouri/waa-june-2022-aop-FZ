package miu.edu.lab3.Aspect;


import miu.edu.lab3.Aspect.Annotation.PostHeaderExeption;
import miu.edu.lab3.Service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class PostRequestValidator {
    private final ActivityLogService activityLogService;
    private final HttpServletRequest httpServlet;



    public PostRequestValidator(ActivityLogService activityLogService, HttpServletRequest httpServlet) {
        this.activityLogService = activityLogService;
        this.httpServlet = httpServlet;
    }

    @Pointcut(value  ="execution(* miu.edu.lab3.Service.ServiceImpl..*(..))")
    public void getPointCut() {
    }

    @Around("getPointCut()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if(httpServlet.getMethod().equals("POST") && httpServlet.getHeader("AOP-IS-AWESOME")==null) {
            throw new PostHeaderExeption("AOP-IS-AWESOME header is not present ");
        }
        return proceedingJoinPoint.proceed();
    }
}
