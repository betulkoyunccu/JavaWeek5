package kodlama.io.homework5.business.businessAspects.pointcutdeclarations;

import org.aspectj.lang.annotation.Pointcut;

public class GlobalPointCutDeclarations {
    @Pointcut("execution(* kodlama.io.devs.business.concretes.*.*(..))")
    public void getServiceMethods() {
    }

}