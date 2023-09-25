package com.nicoz.NZWanderlust.Services;

import com.nicoz.NZWanderlust.Entities.TicketTravelBuyer;
import com.nicoz.NZWanderlust.Repositories.TicketTravelBuyerRepository;
import com.nicoz.NZWanderlust.NewTicketTravelBuyerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketTravelBuyerService {
    private final TicketTravelBuyerRepository ticketTravelBuyerRepository;

    public TicketTravelBuyerService(TicketTravelBuyerRepository ticketTravelBuyerRepository) {
        this.ticketTravelBuyerRepository = ticketTravelBuyerRepository;
    }

    public List<TicketTravelBuyer> getTicketTravelBuyers() {
        return ticketTravelBuyerRepository.findAll();
    }

    public TicketTravelBuyer getTicket(Long id) {
        return ticketTravelBuyerRepository.findById(id).get();
    }

    //only when post entity is generated
    public TicketTravelBuyer addTicketTravelBuyer(NewTicketTravelBuyerRequest ticketTravelBuyerRequest) {
        TicketTravelBuyer ticketTravelBuyer = new TicketTravelBuyer();
        ticketTravelBuyer.setPost(ticketTravelBuyerRequest.getPost());
        ticketTravelBuyer.setUser(ticketTravelBuyerRequest.getUser());
        ticketTravelBuyer.setPrice(ticketTravelBuyerRequest.getPrice());
        ticketTravelBuyer.setStartDate(ticketTravelBuyerRequest.getStartDate());
        ticketTravelBuyer.setEndDate(ticketTravelBuyerRequest.getEndDate());
        ticketTravelBuyerRepository.save(ticketTravelBuyer);
        return ticketTravelBuyer;
    }

    public ResponseEntity<TicketTravelBuyer> updateTicketTravelBuyer(Long id, TicketTravelBuyer ticketTravelBuyerDetails) {
        Optional<TicketTravelBuyer> optionalTicketTravelBuyer = ticketTravelBuyerRepository.findById(id);
        if (!optionalTicketTravelBuyer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        TicketTravelBuyer ticketTravelBuyer = optionalTicketTravelBuyer.get();
        //ticketTravelBuyer.setPostId(ticketTravelBuyerDetails.getPostId()); //?
        //ticketTravelBuyer.setUser(ticketTravelBuyerDetails.getUser()); //?
        ticketTravelBuyer.setPrice(ticketTravelBuyerDetails.getPrice());
        ticketTravelBuyer.setStartDate(ticketTravelBuyerDetails.getStartDate());  //?
        ticketTravelBuyer.setEndDate(ticketTravelBuyer.getEndDate());         //?
        TicketTravelBuyer updatedTicketTravelBuyer = ticketTravelBuyerRepository.save(ticketTravelBuyer);
        return new ResponseEntity<>(updatedTicketTravelBuyer, HttpStatus.OK);
    }

    public void deleteTicketTravelBuyer(Long id) {
        Optional<TicketTravelBuyer> optionalTicketTravelBuyer = ticketTravelBuyerRepository.findById(id);
        if (!optionalTicketTravelBuyer.isPresent()) {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        TicketTravelBuyer ticketTravelBuyer = optionalTicketTravelBuyer.get();

        ticketTravelBuyer.setUser(null);
        ticketTravelBuyerRepository.save(ticketTravelBuyer); //the relationship with user is deleted
        ticketTravelBuyerRepository.deleteById(id);
        System.out.println("TTB is deleted");
    }

    /* public List<TicketTravelBuyer> getTicketTravelBuyersByUser(Long id){
         List<TicketTravelBuyer> tickets = ticketTravelBuyerRepository.findAll();
         System.out.println(tickets);
         tickets.stream().filter((e) -> e.getBuyer().getBuyerId() == (Long) id).collect(Collectors.toList());
         return tickets;
     }*/
    public TicketTravelBuyer updateOnlyTicketTravelBuyer(Long id, TicketTravelBuyer ticketTravelBuyerDetails) {
        Optional<TicketTravelBuyer> optionalTicketTravelBuyer = ticketTravelBuyerRepository.findById(id);
        if (!optionalTicketTravelBuyer.isPresent()) {
            return null;
        }
        TicketTravelBuyer ticketTravelBuyer = optionalTicketTravelBuyer.get();
        ticketTravelBuyer.setUser(ticketTravelBuyerDetails.getUser()); //?
        TicketTravelBuyer updatedTicketTravelBuyer = ticketTravelBuyerRepository.save(ticketTravelBuyer);
        return updatedTicketTravelBuyer;
    }
}
