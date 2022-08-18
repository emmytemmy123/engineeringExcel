package fcmb.com.good.service;

import fcmb.com.good.model.Engine;
import fcmb.com.good.repo.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import java.util.List;

@Service
@Data
public class AppService {
	
	@Autowired
	EngineRepository engineRepository;

	public List<Engine> listAll() {
		return engineRepository.findAll();
	}
}
