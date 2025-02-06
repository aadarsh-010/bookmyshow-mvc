package org.example.view;

import org.example.models.user.Creator;
import org.example.models.user.Customer;
import org.example.models.user.User;
import org.example.services.UserService;

import java.util.List;

public class UserDetail {

    public List<String> getOwnedTheatres(String userid) {
       return UserService.usv().getOwnedTheatres(userid);

    }

    public List<String> getBookings(String userid) {
        return UserService.usv().getBookings(userid);

    }
}
