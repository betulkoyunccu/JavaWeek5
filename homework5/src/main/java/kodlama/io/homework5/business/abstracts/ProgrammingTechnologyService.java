package kodlama.io.homework5.business.abstracts;

import kodlama.io.homework5.business.requests.programmingtechnology.CreateProgrammingTechnologyRequest;
import kodlama.io.homework5.business.requests.programmingtechnology.UpdateProgrammingTechnologyRequest;
import kodlama.io.homework5.business.responses.programmingtechnology.*;

import java.util.List;

public interface ProgrammingTechnologyService {
    List<GetAllProgrammingTechnologiesResponse> getAll();

    GetByIdProgrammingTechnologyResponse getById(Long id);

    CreateProgrammingTechnologyResponse create(CreateProgrammingTechnologyRequest request);

    UpdateProgrammingTechnologyResponse update(UpdateProgrammingTechnologyRequest request);

    DeleteProgrammingTechnologyResponse deleteById(Long id);
}