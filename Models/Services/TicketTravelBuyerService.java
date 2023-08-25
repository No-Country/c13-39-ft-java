package com.nicoz.NZWanderlust.Service;

import com.nicoz.NZWanderlust.Entity.TicketTravelBuyer;
import com.nicoz.NZWanderlust.NewTicketTravelBuyerRequest;
import com.nicoz.NZWanderlust.Repository.TicketTravelBuyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketTravelBuyerService {
    private final TicketTravelBuyerRepository ticketTravelBuyerRepository;

    public TicketTravelBuyerService(TicketTravelBuyerRepository ticketTravelBuyerRepository){
        this.ticketTravelBuyerRepository = ticketTravelBuyerRepository;
    }

    public List<TicketTravelBuyer> getTicketTravelBuyers(){
        return ticketTravelBuyerRepository.findAll();
    }


    public void addTicketTravelBuyer(NewTicketTravelBuyerRequest ticketTravelBuyerRequest){
        TicketTravelBuyer ticketTravelBuyer = new TicketTravelBuyer();
        ticketTravelBuyer.setPostId(ticketTravelBuyerRequest.getPostId());
        ticketTravelBuyer.setBuyerId(ticketTravelBuyerRequest.getBuyerId());
        ticketTravelBuyer.setPrice(ticketTravelBuyerRequest.getPrice());
        ticketTravelBuyer.setStartDate(ticketTravelBuyerRequest.getStartDate());
        ticketTravelBuyer.setEndDate(ticketTravelBuyerRequest.getEndDate());
        ticketTravelBuyerRepository.save(ticketTravelBuyer);
    }

    public ResponseEntity<TicketTravelBuyer> updateTicketTravelBuyer(Long id, TicketTravelBuyer ticketTravelBuyerDetails){
        Optional<TicketTravelBuyer> optionalTicketTravelBuyer = ticketTravelBuyerRepository.findById(id);
        if (!optionalTicketTravelBuyer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        TicketTravelBuyer ticketTravelBuyer = optionalTicketTravelBuyer.get();
        ticketTravelBuyer.setPostId(ticketTravelBuyerDetails.getPostId());
        ticketTravelBuyer.setBuyerId(ticketTravelBuyerDetails.getBuyerId());
        ticketTravelBuyer.setPrice(ticketTravelBuyerDetails.getPrice());
        ticketTravelBuyer.setStartDate(ticketTravelBuyerDetails.getStartDate());
        ticketTravelBuyer.setEndDate(ticketTravelBuyer.getEndDate());
        TicketTravelBuyer updatedTicketTravelBuyer = ticketTravelBuyerRepository.save(ticketTravelBuyer);
        return new ResponseEntity<>(updatedTicketTravelBuyer, HttpStatus.OK);
    }

    public void deleteTicketTravelBuyer(Long id){
        ticketTravelBuyerRepository.deleteById(id);
    }
}
