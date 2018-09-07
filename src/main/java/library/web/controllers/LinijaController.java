package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Linija;
import library.services.LinijaService;

@RestController
@RequestMapping("/linija")
public class LinijaController {
	
	private LinijaService linijaService;

	@Autowired
	public LinijaController(LinijaService linijaService) {
		super();
		this.linijaService = linijaService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Linija save(@RequestBody Linija linija) {
		return linijaService.save(linija);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Linija> findAll() {
		return linijaService.findAll();
	}
	
}
