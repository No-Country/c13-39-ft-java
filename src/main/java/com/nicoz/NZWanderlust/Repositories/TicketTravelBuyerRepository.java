package com.nicoz.NZWanderlust.Repositories;

import com.nicoz.NZWanderlust.Entities.TicketTravelBuyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketTravelBuyerRepository extends JpaRepository<TicketTravelBuyer, Long> {

   /* @Query("FROM TicketTravelBuyer t WHERE t.user.userId  = ?1")
    List<TicketTravelBuyer> getAllTicketTravelBuyersById(Long id);
    */
}
