package DocumentBenchTest.demobenchtest.business.absratcs;

import java.util.List;

import DocumentBenchTest.demobenchtest.core.utilities.results.DataResult;
import DocumentBenchTest.demobenchtest.entities.concretes.GeneralInserGenerator;
import DocumentBenchTest.demobenchtest.entities.concretes.NumericGenerator;
public interface GeneratorService {
	DataResult<List<NumericGenerator>> getAll();
	String add(GeneralInserGenerator generalInserGenerator);
}
