package kodlama.io.homework5.business.businessAspects.validation;

import kodlama.io.homework5.business.requests.programmingtechnology.CreateProgrammingTechnologyRequest;
import kodlama.io.homework5.business.requests.programmingtechnology.UpdateProgrammingTechnologyRequest;
import kodlama.io.homework5.exception.classes.programmingtechnologytype.ProgrammingTechnologyValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ProgrammingTechnologyValidator {

    @Before("kodlama.io.devs.business.businessaspects.pointcutdeclarations.ProgrammingTechnologyPointcutDeclarations.getMethodsToValidate()")
    public void validateGivenObject(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(
                arg -> {
                    if (arg instanceof CreateProgrammingTechnologyRequest) {
                        CreateProgrammingTechnologyRequest param = ((CreateProgrammingTechnologyRequest) arg);
                        if (param.getName().isBlank()) {
                            throw new ProgrammingTechnologyValidationException("Programming technology name can't be null or blank value.");
                        }
                    } else if (arg instanceof UpdateProgrammingTechnologyRequest) {
                        UpdateProgrammingTechnologyRequest param = ((UpdateProgrammingTechnologyRequest) arg);
                        if (param.getName().isBlank()) {
                            throw new ProgrammingTechnologyValidationException("Programming technology name can't be null or blank value.");
                        }
                    }
                }
        );
    }

}