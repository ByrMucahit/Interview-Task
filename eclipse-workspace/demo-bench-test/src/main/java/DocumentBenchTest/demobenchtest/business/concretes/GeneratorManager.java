package DocumentBenchTest.demobenchtest.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DocumentBenchTest.demobenchtest.business.absratcs.GeneratorService;
import DocumentBenchTest.demobenchtest.core.utilities.results.DataResult;
import DocumentBenchTest.demobenchtest.core.utilities.results.SuccessDataResult;
import DocumentBenchTest.demobenchtest.dataAccess.abstracts.GeneratorDao;
import DocumentBenchTest.demobenchtest.dataAccess.abstracts.InsertDao;
import DocumentBenchTest.demobenchtest.entities.concretes.GeneralInserGenerator;
import DocumentBenchTest.demobenchtest.entities.concretes.NumericGenerator;


@Service
public class GeneratorManager implements GeneratorService {
	private GeneratorDao generateDao;
	private InsertDao inserDao;
	
	@Autowired
	public GeneratorManager(GeneratorDao generateDao, InsertDao inserDao) {
		super();
		this.generateDao = generateDao;
		this.inserDao = inserDao;
	}

	@Override
	public DataResult<List<NumericGenerator>> getAll() {
		// TODO Auto-generated method stub
		System.out.println(generateDao.findAll());
		return new SuccessDataResult<List<NumericGenerator>> (generateDao.findAll(),"Data has been listed");
	}

	@Override
	public String add(GeneralInserGenerator generalInserGenerator) {
		// TODO Auto-generated method stub
		this.inserDao.save(generalInserGenerator);
		return "Data has been added";
	}
}
