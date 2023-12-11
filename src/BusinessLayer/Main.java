package BusinessLayer;

import Entities.AppUser;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BLL bll = new BLL();

        bll.AddUser("guest", "deneme123", "guest", "guest");
        System.out.println(bll.AddUser("guest", "deneme123", "guest", "guest"));
        List<AppUser> test = bll.GetAllAppUser();
        System.out.println(bll.GetAllAppUser());
        System.out.println(bll.UpdateUser("guest", "deneme123", "test", "guest", "guest"));

        for (int i = 1; i <= 10; i++) {
            bll.CreateRoom(i);
        }
        System.out.println(bll.GetRoomByID(5).isClean());
        ;
        bll.AddGuestToRoom("12346578911", "guestname1", "guestsurnema1", LocalDate.of(2022, 12, 7), LocalDate.of(2023, 12, 9), 5);
        System.out.println(bll.GetRoomByID(5).getGuests());
        System.out.println(bll.ControlCheckOutDate("12346578911", 5));
        bll.AddGuestToRoom("11111111111", "guest", "guest", LocalDate.of(2022, 12, 7), LocalDate.of(2023, 12, 9), 5);
        System.out.println(bll.GetGuestListByRoom(5));
        bll.AddProductToFolio(5, "Doritos", 15);
        var c = bll.GetRoomByID(5).getFolios();
        System.out.println(c);
        bll.AddProductToFolio(5, "dondurma", 159);
//
        System.out.println(bll.GetAllFolio(5));

        bll.DeleteProductFromFolio(5, "Doritos");
        System.out.println(bll.GetAllFolio(5));

    }
}
