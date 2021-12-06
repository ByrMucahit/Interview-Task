package DocumentBenchTest.demobenchtest.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import DocumentBenchTest.demobenchtest.entities.concretes.NumericGenerator;
public interface GeneratorDao  extends JpaRepository<NumericGenerator, Integer>{

}
