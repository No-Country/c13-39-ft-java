package com.nicoz.NZWanderlust.controller;

import com.nicoz.NZWanderlust.Entity.SupportTicket;
import com.nicoz.NZWanderlust.NewSupportTicketRequest;
import com.nicoz.NZWanderlust.Service.SupportTicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupportTicketController {
    private final SupportTicketService supportTicketService;

    public SupportTicketController(SupportTicketService supportTicketService){
        this.supportTicketService = supportTicketService;
    }

    @GetMapping("/supportTicket")
    public List<SupportTicket> getSupportTicket(){
        return supportTicketService.getSupportTicket();
    }

    @PostMapping("/supportTicket")
    public void addSupportTicket(@RequestBody NewSupportTicketRequest request){
        supportTicketService.addSupportTicket(request);
    }

    @PutMapping("/supportTicket/{supportTicketId}")
    public ResponseEntity<SupportTicket> updateSupportTicket(@PathVariable("supportTicketId") Long id,
                                               @RequestBody SupportTicket supportTicketDetails){
        return supportTicketService.updateSupportTicket(id, supportTicketDetails);
    }

    @DeleteMapping("/supportTicket/{supportTicketId}")
    public void deleteSupportTicket(@PathVariable("supportTicketId") Long id){
        supportTicketService.deleteSupportTicket(id);
    }
}
