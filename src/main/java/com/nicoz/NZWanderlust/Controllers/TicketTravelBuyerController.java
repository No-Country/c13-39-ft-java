package com.nicoz.NZWanderlust.Controllers;

import com.nicoz.NZWanderlust.Entities.TicketTravelBuyer;
import com.nicoz.NZWanderlust.Services.TicketTravelBuyerService;
import com.nicoz.NZWanderlust.NewTicketTravelBuyerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketTravelBuyerController {
    private final TicketTravelBuyerService ticketTravelBuyerService;

    public TicketTravelBuyerController(TicketTravelBuyerService ticketTravelBuyerService){
        this.ticketTravelBuyerService = ticketTravelBuyerService;
    }

    @GetMapping("/ticketTravelBuyer")
    public List<TicketTravelBuyer> getTicketTravelBuyers(){
        return ticketTravelBuyerService.getTicketTravelBuyers();}

    @PostMapping("/ticketTravelBuyer")
    public void addTicketTravelBuyer(@RequestBody NewTicketTravelBuyerRequest request){
        ticketTravelBuyerService.addTicketTravelBuyer(request);
    }

    @PutMapping("/ticketTravelBuyer/{ticketTravelBuyerId}")
    public ResponseEntity<TicketTravelBuyer> updateTicketTravelBuyer(@PathVariable("ticketTravelBuyerId") Long id, @RequestBody TicketTravelBuyer ticketTravelBuyerDetails){
        return ticketTravelBuyerService.updateTicketTravelBuyer(id, ticketTravelBuyerDetails);
    }

    @DeleteMapping("/ticketTravelBuyer/{ticketTravelBuyerId}")
    public void deleteTicketTravelBuyer(@PathVariable("ticketTravelBuyerId") Long id){
        ticketTravelBuyerService.deleteTicketTravelBuyer(id);
    }
}
