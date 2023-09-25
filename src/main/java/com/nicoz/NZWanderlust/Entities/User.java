package com.nicoz.NZWanderlust.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reputationScore")
    private ReputationScore reputationScore;

    private String address;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userLevel")
    private UserLevel userLevel;

    @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH)
    private List<TicketTravelBuyer> ticketTravelBuyerList = new ArrayList<>();

    //break with User foreign key in TicketTravelBuyer
    public void iterateAndModifyTickets() {
        for (TicketTravelBuyer ticket : ticketTravelBuyerList) {
            ticket.setUser(null);
        }
    }
}