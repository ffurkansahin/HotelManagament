package DataAccessLayer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Entities.AppUser;
import Entities.Folio;
import Entities.Guest;
import Entities.Room;

public class DataAccess {
    List<AppUser> appUsers = new ArrayList<AppUser>();//Kullanıcı listesini oluşturur
    List<Room> rooms = new ArrayList<Room>();//Room listesi oluşturur


    //Kullanıcı listesine kullanıcı ekler
    public int AddUser(AppUser appUserAdd) {
        boolean checkAdd = appUsers.add(appUserAdd);
        if (checkAdd == true) {
            return 1;
        } else
            return -1;
    }

    //Kullanıcı listesindeki kullanıcıları kontrol eder
    public int CheckUserForLogin(String userName, String password) {

        return appUsers.contains(new AppUser(userName,password, null,...)) ? 1 : -1;
     
    }

    //Tüm kullancıların listesini getirir
    public List<AppUser> GetAllAppUser() {
        return Collections.unmodifiable(appUsers);
    }

    //Kullanıcıyı günceller
    public int UpdateUser(String username, String password, String newPassword,  name, surname) {
        AppUser newValue = new AppUser(username, password, String name, surnam);

        int i = appUsers.indexOf(newInfo);
        if(i==-1) return -1;

        appUsers.remove(i);
        newValue.setPassWord(newPassword);
        appUsers.add(i,newValue);
        
        AppUser current =  appUsers.get(i);
        current.setName(name)
        current.setSurname(surna);
        return 1;
    }

    //Tüm odaların listesini getirir
    public List<Room> GetAllRooms() {
        return rooms;
    }

    //Yeni oda oluşturur
    public int CreateRoom(Room roomCreate) {

        boolean checkRoom = rooms.add(roomCreate);
        if (checkRoom) return 1;
        return -1;
    }

    //ID bilgisine göre oda bilgisi getirir
    public Room GetRoomByID(int id) {
        for (Room room : rooms) {
            if (room.getRoomID() == id) {
                return room;
            }
        }
        return null;
    }

    //Odaya misafir ekler(CheckIn)
    public int AddGuestToRoom(Guest guestAdd, int roomId) {
        Room room = GetRoomByID(roomId);

        List<Guest> listRoomGuest = room.getGuests();

        boolean checkResult = listRoomGuest.add(guestAdd);

        if (checkResult == true) {
            return 1;
        } else {
            return -1;
        }

    }

    //Misafir çıkışı sağlar(CheckOut)
    public int RemoveGuestFromRoom(String GuestTC, int roomId) {
        List<Guest> roomGuestsList = GetGuestListByRoom(roomId);
        boolean checkResult = false;
        for (Guest guest : roomGuestsList) {
            if (guest.getTC() == GuestTC) {
                checkResult = roomGuestsList.remove(guest);
                // this throws ConcurrentModification Excapton, enhanced for is readonly: instead Iterator 
            }
        }
        if (checkResult) {
            return 1;//Başarılı sonuç kodu
        }
        return -1;//Başarsızın sonuç kodu
    }

    //Misafirin kaç gün kaldığını kontrol eder
    public int CheckDaysOfGuest(String GuestTc, int roomId) {
        Room room = GetRoomByID(roomId);
        List<Guest> guestsList = room.getGuests();
        for (Guest guest : guestsList) {
            if (guest.getTC() == GuestTc)//Mevcut misafir listesi içinde döner ve Tc değerine göre misafiri getirir
            {
                LocalDate checkInDate = guest.getCheckIn();//Müşteri giirş tarihini alır
                LocalDate now = LocalDate.now();//Şu anki zamanın gün ay yıl şeklinde alır
                long StayedDays = ChronoUnit.DAYS.between(checkInDate, now);//Şu anki zamanla giriş zamanı arasındaki farkı gün olarak alır ve gün değerini döndürür
                return (int) StayedDays;
            }
        }
        return -1;//Başarısız hata kodu döndürür

    }

    //Misafirin çıkış tarihini kontrol eder
    public int ControlCheckOutDate(String GuestTc, int RoomId) {
        List<Guest> guests = GetGuestListByRoom(RoomId);
        LocalDate guestCheckOutDate = LocalDate.now();
        for (Guest guest : guests) {
            if (guest.getTC() == GuestTc) {
                guestCheckOutDate = guest.getCheckOut();
            }
        }

        return (int) ChronoUnit.DAYS.between(LocalDate.now(), guestCheckOutDate);// Çıkış tarihine kaç gün kaldığını gösterir

    }

    //Odaya göre misafir listesini getirir
    public List<Guest> GetGuestListByRoom(int roomId) {
        Room room = GetRoomByID(roomId);
        return room.getGuests();
    }

    //Folyoya ürün ekler
    public void AddProductToFolio(int roomId, String productName, Double price) {
        Room room = GetRoomByID(roomId);
        Folio roomFolio = room.getFolios();
        HashMap<String, Double> productsMap = roomFolio.getProducts();
        productsMap.put(productName, price);

    }

    //Folyoyu getirir
    public Folio GetAllFolio(int roomId) {
        Room room = GetRoomByID(roomId);
        return room.getFolios();
    }

    //Folyodan ürün silme
    public void DeleteProductFromFolio(int roomId, String productName) {
        Room room = GetRoomByID(roomId);
        Folio roomFolio = room.getFolios();

        HashMap<String, Double> products = roomFolio.getProducts();
        products.remove(productName);

    }


}
