package com.nicoz.NZWanderlust.Services;

import com.nicoz.NZWanderlust.Entities.SupportTicket;
import com.nicoz.NZWanderlust.NewSupportTicketRequest;
import com.nicoz.NZWanderlust.Repositories.SupportTicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportTicketService {
    private final SupportTicketRepository supportTicketRepository ;

    public SupportTicketService(SupportTicketRepository supportTicketRepository){
        this.supportTicketRepository = supportTicketRepository;
    }

    public List<SupportTicket> getSupportTicket(){
        return supportTicketRepository.findAll();
    }


    public void addSupportTicket(NewSupportTicketRequest supportTicketRequest){
        SupportTicket supportTicket = new SupportTicket();
        supportTicket.setUserId(supportTicketRequest.getUserId());
        supportTicket.setStatus(supportTicketRequest.getStatus());
        supportTicket.setDetails(supportTicketRequest.getDetails());
        supportTicket.setAffected(supportTicketRequest.getAffected());
        supportTicketRepository.save(supportTicket);
    }

    public ResponseEntity<SupportTicket> updateSupportTicket(Long id, SupportTicket supportTicketDetails){
        Optional<SupportTicket> optionalSupportTicket = supportTicketRepository.findById(id);
        if (!optionalSupportTicket.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SupportTicket supportTicket = optionalSupportTicket.get();
        supportTicket.setUserId(supportTicketDetails.getUserId());
        supportTicket.setStatus(supportTicketDetails.getStatus());
        supportTicket.setDetails(supportTicketDetails.getDetails());
        supportTicket.setAffected(supportTicketDetails.getAffected());
        SupportTicket updatedSupportTicket = supportTicketRepository.save(supportTicket);
        return new ResponseEntity<>(updatedSupportTicket, HttpStatus.OK);
    }

    public void deleteSupportTicket(Long id){
        supportTicketRepository.deleteById(id);
    }
}
