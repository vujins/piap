package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Autobus;
import library.services.AutobusService;

@RestController
@RequestMapping("/autobus")
public class AutobusController {

	private AutobusService autobusService;

	@Autowired
	public AutobusController(AutobusService autobusService) {
		super();
		this.autobusService = autobusService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Autobus save(@RequestBody Autobus autobus) {
		return autobusService.save(autobus);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Autobus> findAll() {
		return autobusService.findAll();
	}
	
}
