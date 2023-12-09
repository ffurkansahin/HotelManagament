package BusinessLayer;

import DataAccessLayer.DataAccess;
import Entities.AppUser;
import Entities.Folio;
import Entities.Guest;
import Entities.Room;

import java.util.ArrayList;
import java.util.List;

public class Business {

    private DataAccess DL = new DataAccess();
    private List<AppUser> appUsers = new ArrayList<>(DL.GetAllAppUser());

    public int AddUser(String userName, String password, String name, String surname) {
        for (var user : appUsers) {
            if (user.getUsername().equals(userName)) {
                return -1;//Kullanıcı zaten önceden eklenmiş
            }
        }
        DL.AddUser(new AppUser(userName, password, name, surname));
        return 1;
    }

    public int CheckUserForLogin(String userName, String password) {
        AppUser tmpUser = new AppUser(userName, password);
        return -1;
    }


    public List<AppUser> GetAllAppUser() {
        return DL.GetAllAppUser();
    }

    public int UpdateUser(String userName, String password, String name, String surname) {
        AppUser tmpUser = new AppUser(userName, password, name, surname);
        return DL.UpdateUser(tmpUser);

    }

    public List<Room> GetAllRooms() {
        return DL.GetAllRooms();
    }

    public void CreateRoom(int roomID, boolean isClean, boolean isEmpty, List<Guest> guests, Folio folios) {
        Room tmpRoom = new Room(roomID, isClean, isEmpty, guests, folios);
        DL.CreateRoom(tmpRoom);
    }

    public void GetRoomByID(int id) {
        DL.GetRoomByID(id);
    }


}
