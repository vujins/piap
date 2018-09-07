package library.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.LinijaMedjugradska;
import library.services.LinijaMedjugradskaService;

@RestController
@RequestMapping("/medjugradska")
public class LinijaMedjugradskaController {
	
	private LinijaMedjugradskaService linijaMedjugradskaService;

	@Autowired
	public LinijaMedjugradskaController(LinijaMedjugradskaService linijaMedjugradskaService) {
		this.linijaMedjugradskaService = linijaMedjugradskaService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<LinijaMedjugradska> findAll() {
		return linijaMedjugradskaService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public LinijaMedjugradska save(@RequestBody LinijaMedjugradska linijaMedjugradska) {
		return linijaMedjugradskaService.save(linijaMedjugradska);
	}
}
