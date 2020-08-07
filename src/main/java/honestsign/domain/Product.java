package honestsign.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel
@Data
public class Product {
    @NotNull(message = "Product name cannot be null")
    private String name;

    @NotNull(message = "Product code cannot be null")
    @Size(min = 13, max = 13, message = "Field size is 13")
    private String code;
}
