package kodlama.io.homework5.webApi.controllers;

import kodlama.io.homework5.business.abstracts.ProgrammingTechnologyTypeService;
import kodlama.io.homework5.business.requests.programmingtechnologytype.CreateProgrammingTechnologyTypeRequest;
import kodlama.io.homework5.business.requests.programmingtechnologytype.UpdateProgrammingTechnologyTypeRequest;
import kodlama.io.homework5.business.responses.programmingtechnologytype.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmingTechnologyTypes")
@RequiredArgsConstructor
public class ProgrammingTechnologyTypesController {

    private final ProgrammingTechnologyTypeService programmingTechnologyTypeService;

    @GetMapping
    public List<GetAllProgrammingTechnologyTypesResponse> getAll() {
        return programmingTechnologyTypeService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgrammingTechnologyTypeResponse getById(@PathVariable("id") Long id) {
        return programmingTechnologyTypeService.getById(id);
    }

    @PostMapping
    public CreateProgrammingTechnologyTypeResponse create(CreateProgrammingTechnologyTypeRequest request) {
        return programmingTechnologyTypeService.create(request);
    }

    @PutMapping
    public UpdateProgrammingTechnologyTypeResponse update(UpdateProgrammingTechnologyTypeRequest request) {
        return programmingTechnologyTypeService.update(request);
    }

    @DeleteMapping("/{id}")
    public DeleteProgrammingTechnologyTypeResponse delete(@PathVariable("id") Long id) {
        return programmingTechnologyTypeService.deleteById(id);
    }
}