package kodlama.io.homework5.business.businessAspects.validation;

import kodlama.io.homework5.business.requests.programmingtechnologytype.CreateProgrammingTechnologyTypeRequest;
import kodlama.io.homework5.business.requests.programmingtechnologytype.UpdateProgrammingTechnologyTypeRequest;
import kodlama.io.homework5.exception.classes.programmingtechnologytype.ProgrammingTechnologyTypeValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ProgrammingTechnologyTypeValidator {

    @Before("kodlama.io.devs.business.businessaspects.pointcutdeclarations.ProgrammingTechnologyTypePointcutDeclarations.getMethodsToValidate()")
    public void validateGivenObject(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(
                arg -> {
                    if (arg instanceof CreateProgrammingTechnologyTypeRequest) {
                        CreateProgrammingTechnologyTypeRequest param = ((CreateProgrammingTechnologyTypeRequest) arg);
                        if (param.getName().isBlank()) {
                            throw new ProgrammingTechnologyTypeValidationException("Programming technology type name can't be null or blank value.");
                        }
                    } else if (arg instanceof UpdateProgrammingTechnologyTypeRequest) {
                        UpdateProgrammingTechnologyTypeRequest param = ((UpdateProgrammingTechnologyTypeRequest) arg);
                        if (param.getName().isBlank()) {
                            throw new ProgrammingTechnologyTypeValidationException("Programming technology type name can't be null or blank value.");
                        }
                    }
                }
        );
    }

}