package kodlama.io.homework5.business.responses.programminglanguage;

import kodlama.io.homework5.entities.concretes.ProgrammingTechnology;
import lombok.Data;

import java.util.List;

@Data
public class GetAllProgrammingLanguagesResponse {
	private Long id;
	private String name;
	private List<ProgrammingTechnology> programmingTechnologies;

}