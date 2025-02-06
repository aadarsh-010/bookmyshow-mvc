package database;
import database.MovieTable;
import database.SeatTable;
import database.ShowTable;
import database.TheatreTable;
import database.UserTable;

public class DatabaseCollection {
    private static DatabaseCollection d1;
    public  BookingTable BookingTable;
    public MovieTable MovieTable;
    public ScreenTable ScreenTable;
    public SeatTable SeatTable;
    public ShowTable ShowTable;
    public TheatreTable TheatreTable;
    public UserTable UserTable;

    private DatabaseCollection() {
        this.BookingTable = new BookingTable();
        this.MovieTable = new MovieTable();
        this.ScreenTable = new ScreenTable();
        this.SeatTable = new SeatTable();
        this.TheatreTable= new TheatreTable();
        this.ShowTable = new ShowTable();
        this.UserTable = new UserTable();

    }

    public static DatabaseCollection instance(){
        if(d1==null) d1= new DatabaseCollection();
        return d1;
    }


}
