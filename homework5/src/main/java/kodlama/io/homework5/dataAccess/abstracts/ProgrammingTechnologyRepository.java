package kodlama.io.homework5.dataAccess.abstracts;

import kodlama.io.homework5.entities.concretes.ProgrammingTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology, Long> {
}