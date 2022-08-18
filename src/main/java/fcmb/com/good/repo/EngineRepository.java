package fcmb.com.good.repo;

import fcmb.com.good.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Integer> {


	
}
