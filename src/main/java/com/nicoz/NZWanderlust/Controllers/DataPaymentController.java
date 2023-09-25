package com.nicoz.NZWanderlust.Controllers;

import com.nicoz.NZWanderlust.Entities.DataPayment;
import com.nicoz.NZWanderlust.Services.DataPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataPaymentController {
    private final DataPaymentService dataPaymentService;

    public DataPaymentController(DataPaymentService dataPaymentService) {
        this.dataPaymentService = dataPaymentService;
    }

    @GetMapping("/dataPayment/")
    public List<DataPayment> getAllDataPayment() { return dataPaymentService.getDataPayments();}

    @PutMapping("/dataPayment/{id}")
    public ResponseEntity<DataPayment> updateDataPayment(@RequestBody DataPayment dataPayment, @PathVariable Long id) { return dataPaymentService.updateDataPayment(id, dataPayment);}
}
