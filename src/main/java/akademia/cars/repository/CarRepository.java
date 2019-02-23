package akademia.cars.repository;

import akademia.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //component controller, restController, service
public interface CarRepository extends JpaRepository<Car, Long> {


  //  @Query(value = "select * from car where plate = ?1", nativeQuery = true) //SQL
    @Query(value = "select c from Car c where c.plate = ?1") //JPQL
    Optional<Car> findCarByPlate(String plate);
}



