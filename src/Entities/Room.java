package Entities;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int RoomID;
    private boolean isClean;
    private boolean isEmpty;
    private List<Guest> Guests;
    private Folio Folios;

    public Room() {
        Folios = new Folio();//Her room nesnesi newlendiğinde folyo oluşur
        Guests = new ArrayList<Guest>();//Her room nesnesi newlendiğinde müşteri listesi oluşur
    }

    public Room(int roomID, boolean isClean, boolean isEmpty, List<Guest> guests, Folio folios) {
        RoomID = roomID;
        this.isClean = isClean;
        this.isEmpty = isEmpty;
        Guests = guests;
        Folios = folios;
    }

    public Folio getFolios() {
        return Folios;
    }
    public void setFolios(Folio folios) {
        Folios = folios;
    }
    public List<Guest> getGuests() {
        return Guests;
    }
    public void setGuests(List<Guest> guests) {
        Guests = guests;
    }
    public int getRoomID() {
        return RoomID;
    }
    public void setRoomID(int roomID) {
        RoomID = roomID;
    }
    public boolean isClean() {
        return isClean;
    }
    public void setClean(boolean isClean) {
        this.isClean = isClean;
    }
    public boolean isEmpty() {
        return isEmpty;
    }
    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

}
