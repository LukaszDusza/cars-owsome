package akademia.cars.model.dtos;

import lombok.*;

@Data
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
