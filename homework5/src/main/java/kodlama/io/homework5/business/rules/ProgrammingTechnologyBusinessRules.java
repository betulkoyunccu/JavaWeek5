package kodlama.io.homework5.business.rules;

import kodlama.io.homework5.dataAccess.abstracts.ProgrammingTechnologyRepository;
import kodlama.io.homework5.entities.concretes.ProgrammingTechnology;
import kodlama.io.homework5.exception.classes.programmingtechnology.ProgrammingTechnologyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProgrammingTechnologyBusinessRules {

    private final ProgrammingTechnologyRepository programmingTechnologyRepository;

    public void programmingTechnologyNameMustBeUniqueWhenCreating(ProgrammingTechnology programmingTechnology) {
        ProgrammingTechnology existence = programmingTechnologyRepository.findAll().stream().filter(p -> p.getName().equalsIgnoreCase(programmingTechnology.getName())).findAny().orElse(null);
        if (existence != null) throw new RuntimeException("Programming technology name exist.");
    }

    public void programmingTechnologyNameMustBeUniqueWhenUpdating(ProgrammingTechnology programmingTechnology) {
        ProgrammingTechnology existence = programmingTechnologyRepository.findAll().stream().filter(p -> p.getName().equalsIgnoreCase(programmingTechnology.getName()) && p.getId() != programmingTechnology.getId()).findAny().orElse(null);
        if (existence != null) throw new RuntimeException("Programming technology name exist.");
    }

    public void programmingTechnologyMustExistWhenRequested(Long id) {
        programmingTechnologyRepository
                .findById(id).orElseThrow(() -> new ProgrammingTechnologyNotFoundException("Requested programming technology does not exist."));
    }
}