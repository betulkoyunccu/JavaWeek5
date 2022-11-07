package kodlama.io.homework5.business.concretes;

import kodlama.io.homework5.business.abstracts.ProgrammingTechnologyTypeService;
import kodlama.io.homework5.business.customannotations.ValidateRequest;
import kodlama.io.homework5.business.mapper.programmingtechnologytype.ProgrammingTechnologyTypeMapper;
import kodlama.io.homework5.business.requests.programmingtechnologytype.CreateProgrammingTechnologyTypeRequest;
import kodlama.io.homework5.business.requests.programmingtechnologytype.UpdateProgrammingTechnologyTypeRequest;
import kodlama.io.homework5.business.responses.programmingtechnologytype.*;
import kodlama.io.homework5.business.rules.ProgrammingTechnologyTypeBusinessRules;
import kodlama.io.homework5.dataAccess.abstracts.ProgrammingTechnologyTypeRepository;
import kodlama.io.homework5.entities.concretes.ProgrammingTechnologyType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgrammingTechnologyTypeManager implements ProgrammingTechnologyTypeService {

    private final ProgrammingTechnologyTypeRepository programmingTechnologyTypeRepository;
    private final ProgrammingTechnologyTypeMapper mapper;
    private final ProgrammingTechnologyTypeBusinessRules businessRules;


    @Override
    public List<GetAllProgrammingTechnologyTypesResponse> getAll() {
        return programmingTechnologyTypeRepository.findAll().stream()
                .map(p -> mapper.programmingTechnologyTypeToGetAllProgrammingTechnologyTypesResponse(p)).collect(Collectors.toList());
    }

    @Override
    public GetByIdProgrammingTechnologyTypeResponse getById(Long id) {
        businessRules.programmingTechnologyTypeMustExistWhenRequested(id);
        return mapper.programmingTechnologyTypeToGetByIdProgrammingTechnologyTypeResponse(programmingTechnologyTypeRepository.findById(id).get());
    }

    @Override
    @ValidateRequest
    public CreateProgrammingTechnologyTypeResponse create(CreateProgrammingTechnologyTypeRequest request) {
        ProgrammingTechnologyType programmingTechnologyType = mapper.createProgrammingTechnologyTypeRequestToProgrammingTechnologyType(request);
        businessRules.programmingTechnologyTypeNameMustBeUniqueWhenCreating(programmingTechnologyType);
        return mapper.programmingTechnologyTypeToCreateProgrammingTechnologyTypeResponse(programmingTechnologyTypeRepository.save(programmingTechnologyType));
    }

    @Override
    @ValidateRequest
    public UpdateProgrammingTechnologyTypeResponse update(UpdateProgrammingTechnologyTypeRequest request) {
        businessRules.programmingTechnologyTypeMustExistWhenRequested(request.getId());
        ProgrammingTechnologyType programmingTechnologyTypeToUpdate = programmingTechnologyTypeRepository.findById(request.getId()).get();

        ProgrammingTechnologyType programmingTechnologyType = mapper.updateProgrammingTechnologyTypeRequestToProgrammingTechnologyType(request);
        businessRules.programmingTechnologyTypeNameMustBeUniqueWhenUpdating(programmingTechnologyType);

        programmingTechnologyTypeToUpdate.setName(programmingTechnologyType.getName());
        return mapper.programmingTechnologyTypeToUpdateProgrammingTechnologyTypeResponse(programmingTechnologyTypeRepository.save(programmingTechnologyTypeToUpdate));
    }

    @Override
    public DeleteProgrammingTechnologyTypeResponse deleteById(Long id) {
        businessRules.programmingTechnologyTypeMustExistWhenRequested(id);
        ProgrammingTechnologyType programmingTechnologyType = programmingTechnologyTypeRepository.findById(id).get();
        programmingTechnologyTypeRepository.deleteById(id);
        return mapper.programmingTechnologyTypeToDeleteProgrammingTechnologyTypeResponse(programmingTechnologyType);
    }
}