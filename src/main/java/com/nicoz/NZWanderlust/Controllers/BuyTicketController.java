package com.nicoz.NZWanderlust.Controllers;

import com.nicoz.NZWanderlust.Entities.TicketTravelBuyer;
import com.nicoz.NZWanderlust.Entities.User;
import com.nicoz.NZWanderlust.Entities.UserLevel;
import com.nicoz.NZWanderlust.Services.TicketTravelBuyerService;
import com.nicoz.NZWanderlust.Services.UserLevelService;
import com.nicoz.NZWanderlust.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BuyTicketController {
    private final UserService userService;
    private final UserLevelService userLevelService;
    private final TicketTravelBuyerService ticketTravelBuyerService;


    public BuyTicketController(UserService userService, UserLevelService userLevelService, TicketTravelBuyerService ticketTravelBuyerService) {
        this.userService = userService;
        this.userLevelService = userLevelService;
        this.ticketTravelBuyerService = ticketTravelBuyerService;
    }

    @PutMapping("addBuyerToTicket/{userId}/{ticketId}/")
    public ResponseEntity<?> addBuyerToTicket(@PathVariable Long userId, @PathVariable Long ticketId){
        User user = userService.getUser(userId);
        TicketTravelBuyer ticket = ticketTravelBuyerService.getTicket(ticketId);
        if(ticket.getUser()!=null){
            System.out.println("no se puede comprar");
            return ResponseEntity.notFound().build();
        }
        ticket.setUser(user);
        ticketTravelBuyerService.updateOnlyTicketTravelBuyer(ticketId, ticket);
        UserLevel userLevel = userLevelService.searchUserLevel(userId);
     /* */   userLevel.setNumberOfTickets(userLevel.getNumberOfTickets()+1);
        UserLevel userLevelUpdate = userLevelService.updateOnlyUserLevel(userId, userLevel );
        return new ResponseEntity<>(userLevelUpdate, HttpStatus.OK);
    }

   @GetMapping("getTicketsByBuyer/{userId}/")
    public ResponseEntity<?> getTicketsByBuyer(@PathVariable Long userId){
        User user = userService.getUser(userId); //?
        List<TicketTravelBuyer> ticketsByBuyer = user.getTicketTravelBuyerList();
        return new ResponseEntity<>(ticketsByBuyer , HttpStatus.OK);

    }

}
