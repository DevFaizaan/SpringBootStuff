package repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Juice;

@Repository
public interface JuiceRepo extends JpaRepository<Juice, Integer> {

}
