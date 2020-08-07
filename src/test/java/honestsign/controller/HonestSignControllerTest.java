package honestsign.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import honestsign.domain.Deal;
import honestsign.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HonestSignController.class)
public class HonestSignControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void createEmployeeAPI() throws Exception {
        Deal deal = new Deal();
        deal.setCustomer("123456789");
        deal.setSeller("123456789");
        Product prod1 = new Product();
        prod1.setName("prod1");
        prod1.setCode("1234567890123");
        Product prod2 = new Product();
        prod2.setName("prod2");
        prod2.setCode("1234567890123");
        deal.setProducts(new Product[]{prod1, prod2});

        mvc.perform( MockMvcRequestBuilders
                .post("/")
                .content(asJsonString(deal))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
