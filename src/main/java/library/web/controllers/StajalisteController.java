package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Stajaliste;
import library.services.StajalisteService;

@RestController
@RequestMapping("/stajaliste")
public class StajalisteController {
	private StajalisteService stajalisteService;

	@Autowired
	public StajalisteController(StajalisteService stajalisteService) {
		this.stajalisteService = stajalisteService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Stajaliste> findAll() {
		return stajalisteService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Stajaliste save(@RequestBody Stajaliste stajaliste) {
		return stajalisteService.save(stajaliste);
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		stajalisteService.delete(id);
	}
}
