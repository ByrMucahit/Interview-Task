package istlink.CellBroadcastTestBench.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import istlink.CellBroadcastTestBench.business.abstracts.GeneratorService;
import istlink.CellBroadcastTestBench.core.utilities.results.DataResult;
import istlink.CellBroadcastTestBench.entities.concretes.GeneralInserGenerator;
import istlink.CellBroadcastTestBench.entities.concretes.NumericGenerator;

@RestController
@RequestMapping("/api/generators")
@CrossOrigin
public class CellBroadCastController {
	private GeneratorService generatorService;
	
	@Autowired
	public CellBroadCastController(GeneratorService generatorService) {
		super();
		this.generatorService = generatorService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<NumericGenerator>> getAll(){
		return this.generatorService.getAll();
	}
	@PostMapping("/add")
	public String add(@RequestBody GeneralInserGenerator generalInserGenerator){
		return this.generatorService.add(generalInserGenerator);
	}
}
