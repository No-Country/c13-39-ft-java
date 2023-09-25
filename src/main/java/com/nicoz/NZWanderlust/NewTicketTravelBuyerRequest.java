package com.nicoz.NZWanderlust;

import com.nicoz.NZWanderlust.Entities.Post;
import com.nicoz.NZWanderlust.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class NewTicketTravelBuyerRequest {
    private Post post;
    private User user;
    private Double price;
    private String startDate;
    private String endDate;

}
