package library.web.controllers;

import java.util.List;

import org.jtransfo.internal.JTransfoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.domain.LinijaMedjugradska;
import library.domain.Prevoznik;
import library.domain.data.LinijaMedjugradskaData;
import library.services.LinijaMedjugradskaService;
import library.services.PrevoznikService;
import library.services.StajalisteService;

@RestController
@RequestMapping("/medjugradska")
public class LinijaMedjugradskaController {
	
	private LinijaMedjugradskaService linijaMedjugradskaService;
	private PrevoznikService prevoznikService;
	private StajalisteService stajalisteService;

	@Autowired
	public LinijaMedjugradskaController(LinijaMedjugradskaService linijaMedjugradskaService, PrevoznikService prevoznikService, StajalisteService stajalisteService) {
		this.linijaMedjugradskaService = linijaMedjugradskaService;
		this.prevoznikService = prevoznikService;
		this.stajalisteService = stajalisteService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<LinijaMedjugradska> findAll(@RequestParam(name = "prevoznik", required = false) String prevoznik) {
//		Prevoznik p;
//		if (prevoznik != null) { 
//			p = prevoznikService.findFromNaziv(prevoznik); 
//			return linijaMedjugradskaService.findFromPrevoznik(p);
//		}
		return linijaMedjugradskaService.findAll(prevoznik);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public LinijaMedjugradska save(@RequestBody LinijaMedjugradska linijaMedjugradska) {
		return linijaMedjugradskaService.save(linijaMedjugradska);
	}
	

	
	@RequestMapping(path = "{prevoznik}", method = RequestMethod.GET)
	public List<LinijaMedjugradska> findFromPrevoznik(@PathVariable("prevoznik") String naziv) {
		Prevoznik prevoznik = prevoznikService.findFromNaziv(naziv);
		
		//TODO namesti za ulogovane i goste
//		if (ulogovan) {
//			
//		} else {
//			
//		}
		
		return linijaMedjugradskaService.findFromPrevoznik(prevoznik);
	}
	
//	@RequestMapping(path = "/gost", method = RequestMethod.GET)
//	public List<LinijaMedjugradskaData> findAllForGost() {
//		List<LinijaMedjugradska> linije = findAll();
//
//		JTransfo jtransfo = new JTransfoImpl();
//		
//		return jtransfo.convertList(linije, LinijaMedjugradskaData.class);
//	}
	
	@RequestMapping(path = "/gost/{prevoznik}", method = RequestMethod.GET)
	public List<LinijaMedjugradskaData> findFromPrevoznikGost(@PathVariable("prevoznik") String naziv) {
		
		return new JTransfoImpl().convertList(findFromPrevoznik(naziv), LinijaMedjugradskaData.class);
	}
	
//	@RequestMapping(path = "{polaziste/odrediste}")
//	public List<LinijaMedjugradska> findFromLinija(@PathVariable("polaziste/odrediste") String linija) {
//		return linijaMedjugradskaService.findFromLinija(linija);
//	}
}

















