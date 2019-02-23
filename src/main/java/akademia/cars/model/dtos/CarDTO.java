package akademia.cars.model.dtos;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {


    private String brand;
    private String model;
    private String power;
    private String plate;
    private String message;


}
