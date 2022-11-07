package kodlama.io.homework5.business.concretes;

import kodlama.io.homework5.business.abstracts.ProgrammingLanguageService;
import kodlama.io.homework5.business.customannotations.ValidateRequest;
import kodlama.io.homework5.business.mapper.programminglanguage.ProgrammingLanguageMapper;
import kodlama.io.homework5.business.requests.programminglanguage.CreateProgrammingLanguageRequest;
import kodlama.io.homework5.business.requests.programminglanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.homework5.business.responses.programminglanguage.*;
import kodlama.io.homework5.business.rules.ProgrammingLanguageBusinessRules;
import kodlama.io.homework5.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.homework5.entities.concretes.ProgrammingLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private final ProgrammingLanguageRepository programmingLanguageRepository;
    private final ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;
    private final ProgrammingLanguageMapper programmingLanguageMapper;

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        return programmingLanguageRepository.findAll().stream()
                .map(p -> programmingLanguageMapper.programmingLanguageToGetAllProgrammingLanguagesResponse(p))
                .collect(Collectors.toList());
    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(Long id) {
        programmingLanguageBusinessRules.programmingLanguageMustExistWhenRequested(id);
        return programmingLanguageMapper
                .programmingLanguageToGetByIdProgrammingLanguageResponse(programmingLanguageRepository.findById(id).get());
    }

    @Override
    @ValidateRequest
    public CreateProgrammingLanguageResponse create(CreateProgrammingLanguageRequest createRequest) {
        ProgrammingLanguage programmingLanguage = programmingLanguageMapper
                .createProgrammingLanguageRequestToProgrammingLanguage(createRequest);

        programmingLanguageBusinessRules.programmingLanguageNameMustBeUniqueWhenCreating(programmingLanguage);

        return programmingLanguageMapper.programmingLanguageToCreateProgrammingLanguageResponse(
                programmingLanguageRepository.save(programmingLanguage)
        );
    }

    @Override
    @ValidateRequest
    public UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateRequest) {
        programmingLanguageBusinessRules.programmingLanguageMustExistWhenRequested(updateRequest.getId());

        ProgrammingLanguage programmingLanguage = programmingLanguageMapper
                .updateProgrammingLanguageRequestToProgrammingLanguage(updateRequest);

        programmingLanguageBusinessRules.programmingLanguageNameMustBeUniqueWhenUpdating(programmingLanguage);

        return programmingLanguageMapper.programmingLanguageToUpdateProgrammingLanguageResponse(
                programmingLanguageRepository.save(programmingLanguage)
        );
    }

    @Override
    public DeleteProgrammingLanguageResponse deleteById(Long id) {
        programmingLanguageBusinessRules.programmingLanguageMustExistWhenRequested(id);

        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
        programmingLanguageRepository.deleteById(programmingLanguage.getId());
        return programmingLanguageMapper.programmingLanguageToDeleteProgrammingLanguageResponse(programmingLanguage);
    }
}