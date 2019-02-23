package akademia.cars.repository;

import akademia.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //component controller, restController, service
public interface CarRepository extends JpaRepository<Car, Long> {


}

