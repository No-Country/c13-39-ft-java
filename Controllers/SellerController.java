package com.nicoz.NZWanderlust.controller;

import com.nicoz.NZWanderlust.NewSellerRequest;
import com.nicoz.NZWanderlust.Service.SellerService;
import com.nicoz.NZWanderlust.Entity.Seller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @GetMapping("/sellers")
    public List<Seller> getSellers(){
        return sellerService.getSellers();
    }

    @PostMapping("/sellers")
    public void addSeller(@RequestBody NewSellerRequest request){
        sellerService.addSeller(request);
    }

    @PutMapping("/seller/{sellerId}")
    public ResponseEntity<Seller> updateSeller(@PathVariable("sellerId") Long id,
                                           @RequestBody Seller sellerDetails){
        return sellerService.updateSeller(id, sellerDetails);
    }

    @DeleteMapping("/seller/{sellerId}")
    public void deleteSeller(@PathVariable("sellerId") Long id){
        sellerService.deleteSeller(id);
    }
}
