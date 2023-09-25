package com.nicoz.NZWanderlust.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class TicketTravelBuyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketTravelBuyerId;
    @ManyToOne
    private Post post;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;
    private Double price;
    private String startDate;
    private String endDate;


}