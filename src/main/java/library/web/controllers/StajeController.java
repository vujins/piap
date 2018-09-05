package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Staje;
import library.services.StajeService;

@RestController
@RequestMapping("/staje")
public class StajeController {
	
	private StajeService stajeService;

	@Autowired
	public StajeController(StajeService stajeService) {
		this.stajeService = stajeService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Staje> findAll() {
		return stajeService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Staje save(@RequestBody Staje staje) {
		return stajeService.save(staje);
	}
}
