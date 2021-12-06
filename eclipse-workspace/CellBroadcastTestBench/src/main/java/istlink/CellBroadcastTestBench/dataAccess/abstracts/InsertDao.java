package istlink.CellBroadcastTestBench.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import istlink.CellBroadcastTestBench.entities.concretes.GeneralInserGenerator;
public interface InsertDao extends JpaRepository<GeneralInserGenerator, Integer>{

}
