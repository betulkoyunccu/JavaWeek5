package kodlama.io.homework5.business.requests.programmingtechnology;

import lombok.Data;

@Data
public class UpdateProgrammingTechnologyRequest {
	private Long id;
	private Long programmingLanguageId;
	private Long programmingTechnologyTypeId;
	private String name;
}