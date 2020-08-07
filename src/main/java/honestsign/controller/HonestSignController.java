package honestsign.controller;

import honestsign.domain.Deal;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HonestSignController {

    @PostMapping("/")
    public ResponseEntity<Deal> newDeal(@Valid @RequestBody Deal deal) {
        return ResponseEntity.ok().build();
    }

}
