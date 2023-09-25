package com.nicoz.NZWanderlust;

import com.nicoz.NZWanderlust.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewReputationScoreRequest {
    private User user;
    private Long score;
}
