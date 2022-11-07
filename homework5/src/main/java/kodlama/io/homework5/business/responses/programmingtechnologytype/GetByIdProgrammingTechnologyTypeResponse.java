package kodlama.io.homework5.business.responses.programmingtechnologytype;

import kodlama.io.homework5.entities.concretes.ProgrammingTechnology;
import lombok.Data;

import java.util.List;

@Data
public class GetByIdProgrammingTechnologyTypeResponse {
    private Long id;
    private String name;
    private List<ProgrammingTechnology> programmingTechnologies;
}