package istlink.CellBroadcastTestBench.business.abstracts;

import java.util.List;

import istlink.CellBroadcastTestBench.core.utilities.results.DataResult;
import istlink.CellBroadcastTestBench.entities.concretes.GeneralInserGenerator;
import istlink.CellBroadcastTestBench.entities.concretes.NumericGenerator;

public interface GeneratorService {
	DataResult<List<NumericGenerator>> getAll();
	String add(GeneralInserGenerator generalInserGenerator);
}
