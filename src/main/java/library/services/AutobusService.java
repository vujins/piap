package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.domain.Autobus;
import library.repository.AutobusRepository;

@Service
public class AutobusService {

	private AutobusRepository autobusRepository;

	@Autowired
	public AutobusService(AutobusRepository autobusRepository) {
		super();
		this.autobusRepository = autobusRepository;
	}
	
	public Autobus save(Autobus autobus) {
		//TODO proveri da li je slika vec u prevozniku, mozda :O
		//vec nije dozvoljeno da autobusi imaju iste slike :)
		return autobusRepository.save(autobus);
	}
	
	public List<Autobus> findAll() {
		return autobusRepository.findAll();
	}
	
}
