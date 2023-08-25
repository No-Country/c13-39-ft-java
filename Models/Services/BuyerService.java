package com.nicoz.NZWanderlust.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nicoz.NZWanderlust.Entity.Buyer;
import com.nicoz.NZWanderlust.Repository.BuyerRepository;

@Service
public class BuyerService {
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@Transactional
	public Buyer newBuyer(Buyer buyer) {

		Buyer newBuyer = new Buyer();
		newBuyer.setAddress(buyer.getAddress());
		newBuyer.setPhoneNumber(buyer.getPhoneNumber());		
		newBuyer.setBuyerLevelID(buyer.getBuyerLevelID());	

		return buyerRepository.save(newBuyer);

	}

	
    @Transactional
    public void deleteBuyer(Integer id) {
        	Buyer buyer = searchBuyer(id);
        	buyerRepository.delete(buyer);
    }   
	
	@Transactional(readOnly = true)
	public Buyer searchBuyer(Integer id) {
		return buyerRepository.findById(id).get();
	}
	
	@Transactional
	public Buyer updateBuyer(Buyer buyer)  {
			Buyer buyerToUpdate = searchBuyer(buyer.getUserID());
			buyerToUpdate.setAddress(buyer.getAddress());
			buyerToUpdate.setPhoneNumber(buyer.getPhoneNumber());		
			return buyerRepository.save(buyerToUpdate);

	}

	

}
