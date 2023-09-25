package com.nicoz.NZWanderlust.Repositories;


import com.nicoz.NZWanderlust.Entities.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
}
