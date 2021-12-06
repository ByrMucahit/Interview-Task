package DocumentBenchTest.demobenchtest.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import DocumentBenchTest.demobenchtest.entities.concretes.GeneralInserGenerator;

public interface InsertDao extends JpaRepository<GeneralInserGenerator, Integer> {

}
