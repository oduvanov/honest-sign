package honestsign.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel
@Data
public class Deal {
    @NotNull(message = "Customer cannot be null")
    @Size(min = 9, max = 9, message = "Field size is 9")
    private String customer;

    @NotNull(message = "Seller cannot be null")
    @Size(min = 9, max = 9, message = "Field size is 9")
    private String seller;

    @Valid
    @NotNull(message = "Products cannot be null")
    private Product[] products;
}
