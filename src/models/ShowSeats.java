package models;

import models.ScreenSeat;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowSeats extends ScreenSeat {
    private String id;
    HashMap<enums.SeatType,Integer> PricePerSeatType;
    private ArrayList<String> showSeatsRef;

}
