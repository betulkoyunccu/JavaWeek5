package kodlama.io.homework5.business.abstracts;

import kodlama.io.homework5.business.requests.programminglanguage.CreateProgrammingLanguageRequest;
import kodlama.io.homework5.business.requests.programminglanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.homework5.business.responses.programminglanguage.*;
import kodlama.io.homework5.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguagesResponse> getAll();

    GetByIdProgrammingLanguageResponse getById(Long id);

    CreateProgrammingLanguageResponse create(CreateProgrammingLanguageRequest createRequest);

    UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateRequest);

    DeleteProgrammingLanguageResponse deleteById(Long id);
}