package kodlama.io.homework5.business.rules;

import kodlama.io.homework5.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.homework5.entities.concretes.ProgrammingLanguage;
import kodlama.io.homework5.exception.classes.programminglanguage.ProgrammingLanguageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProgrammingLanguageBusinessRules {

    private final ProgrammingLanguageRepository programmingLanguageRepository;

    public void programmingLanguageNameMustBeUniqueWhenCreating(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage existence = programmingLanguageRepository.findAll().stream().filter(p -> p.getName().equalsIgnoreCase(programmingLanguage.getName())).findAny().orElse(null);
        if (existence != null) throw new RuntimeException("Programming Language name exist.");
    }

    public void programmingLanguageNameMustBeUniqueWhenUpdating(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage existence = programmingLanguageRepository.findAll().stream().filter(p -> p.getName().equalsIgnoreCase(programmingLanguage.getName()) && p.getId() != programmingLanguage.getId()).findAny().orElse(null);
        if (existence != null) throw new RuntimeException("Programming Language name exist.");
    }

    public void programmingLanguageMustExistWhenRequested(Long id) {
        programmingLanguageRepository
                .findById(id).orElseThrow(() -> new ProgrammingLanguageNotFoundException("Requested programming language does not exist."));
    }
}