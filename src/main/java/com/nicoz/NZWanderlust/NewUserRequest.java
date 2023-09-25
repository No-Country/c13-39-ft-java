package com.nicoz.NZWanderlust;

import lombok.Data;

@Data
public class NewUserRequest {
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String address;
    private String phoneNumber;
}
