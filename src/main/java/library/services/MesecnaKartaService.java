package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.MesecnaKarta;
import library.repository.MesecnaKartaRepository;

@Service
public class MesecnaKartaService {

	private MesecnaKartaRepository mesecnaKartaRepository;
	
	@Autowired
	public MesecnaKartaService(MesecnaKartaRepository mesecnaKartaRepository) {
		this.mesecnaKartaRepository = mesecnaKartaRepository;
	}
	
	public List<MesecnaKarta> findAll() {
		return mesecnaKartaRepository.findAll();
	}
	
	public List<MesecnaKarta> findByUsername(String username) {
		return mesecnaKartaRepository.findByUsername(username);
	}
	
	public MesecnaKarta save(MesecnaKarta mesecnaKarta) {
		return mesecnaKartaRepository.save(mesecnaKarta);
	}
	
	public MesecnaKarta findOne(Long id) {
		return mesecnaKartaRepository.findOne(id);
	}
	
	public void delete(Long id) {
		mesecnaKartaRepository.delete(id);
	}
}
