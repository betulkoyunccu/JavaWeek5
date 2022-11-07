package kodlama.io.homework5.business.abstracts;

import kodlama.io.homework5.business.requests.programmingtechnologytype.CreateProgrammingTechnologyTypeRequest;
import kodlama.io.homework5.business.requests.programmingtechnologytype.UpdateProgrammingTechnologyTypeRequest;
import kodlama.io.homework5.business.responses.programmingtechnologytype.*;

import java.util.List;

public interface ProgrammingTechnologyTypeService {
    List<GetAllProgrammingTechnologyTypesResponse> getAll();

    GetByIdProgrammingTechnologyTypeResponse getById(Long id);

    CreateProgrammingTechnologyTypeResponse create(CreateProgrammingTechnologyTypeRequest request);

    UpdateProgrammingTechnologyTypeResponse update(UpdateProgrammingTechnologyTypeRequest request);

    DeleteProgrammingTechnologyTypeResponse deleteById(Long id);
}