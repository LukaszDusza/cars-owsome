package akademia.cars.mappers;

import akademia.cars.commons.Mapper;
import akademia.cars.model.Car;
import akademia.cars.model.dtos.CarDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements Mapper<Car, CarDTO> {


    @Override
    public CarDTO map(Car from) {

        return CarDTO.builder()
                .brand(from.getBrand())
                .model(from.getModel())
                .power(from.getPower())
                .plate(from.getPlate())
                .message("Siemka")
                .build();
    }
}
