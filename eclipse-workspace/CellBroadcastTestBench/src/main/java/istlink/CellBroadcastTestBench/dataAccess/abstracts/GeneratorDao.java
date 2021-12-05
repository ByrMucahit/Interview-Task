package istlink.CellBroadcastTestBench.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import istlink.CellBroadcastTestBench.entities.concretes.NumericGenerator;

public interface GeneratorDao  extends JpaRepository<NumericGenerator, Integer>{

}
