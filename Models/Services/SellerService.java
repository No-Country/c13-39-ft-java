package com.nicoz.NZWanderlust.Service;

import com.nicoz.NZWanderlust.NewSellerRequest;
import com.nicoz.NZWanderlust.Entity.Seller;
import com.nicoz.NZWanderlust.Repository.SellerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> getSellers(){
        return sellerRepository.findAll();
    }


    public void addSeller(NewSellerRequest sellerRequest){
        Seller seller = new Seller();
        seller.setCompanyName(sellerRequest.getCompanyName());
        seller.setPhone(sellerRequest.getPhone());
        sellerRepository.save(seller);
    }

    public ResponseEntity<Seller> updateSeller(Long id, Seller sellerDetails){
        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        if (!optionalSeller.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Seller seller = optionalSeller.get();
        seller.setCompanyName(sellerDetails.getCompanyName());
        seller.setPhone(sellerDetails.getPhone());
        Seller updatedSeller = sellerRepository.save(seller);
        return new ResponseEntity<>(updatedSeller, HttpStatus.OK);
    }

    public void deleteSeller(Long id){
        sellerRepository.deleteById(id);
    }
}
