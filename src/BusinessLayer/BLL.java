package BusinessLayer;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import DataAccessLayer.DataAccess;
import Entities.Folio;
import Entities.Guest;

public class BLL {

    DataAccess DAL;
    public BLL() {
        super();
        DAL = new DataAccess();
    }

    public int AddGuestToRoom(String TC,String Name,String Surname,LocalDate CheckIn,LocalDate CheckOut,int RoomId ){
        Guest newGuest = new Guest();
        if(CheckTcNo(TC)==1){
            newGuest.setTC(TC);
            newGuest.setName(Name);
            newGuest.setSurname(Surname);
            newGuest.setCheckIn(CheckIn);
            newGuest.setCheckOut(CheckOut);

            DAL.AddGuestToRoom(newGuest, RoomId);
            return 1;
        }
        return -1;
        
    }

    public int RemoveGuestFromRoom(String GuestTC,int RoomId ){
        if(CheckTcNo(GuestTC)==1){
        DAL.RemoveGuestFromRoom(GuestTC, RoomId);
        return 1;
        }
        return -1;
        
    }

    public int CheckDaysOfGuest(String GuestTc,int RoomId){
        if(CheckTcNo(GuestTc)==1){
            DAL.CheckDaysOfGuest(GuestTc, RoomId);
            return 1;
        }
        return -1;
        
    }

    public int ControlCheckOutDate(String GuestTc,int RoomId){
        if(CheckTcNo(GuestTc)==1){
            DAL.ControlCheckOutDate(GuestTc, RoomId);
            return 1;
        }
        return -1;
    }

    public int CheckTcNo(String Tc){
        if(Tc.length()==11){
            return 1;//Tc doğru kodu
        }
        return -1;//Tc yanlış kodu
    }
    
    public List<Guest> GetGuestListByRoom(int RoomId)
    {
        return DAL.GetGuestListByRoom(RoomId);

    }

    public void AddProductToFolio(int roomId,String productName,int productPrice){
        HashMap<String,Integer> products = new HashMap<String,Integer>();
        products.put(productName, productPrice);
        DAL.AddProductToFolio(roomId, products);
    }

    public Folio GetAllFolio(int RoomId)
    {
        return DAL.GetAllFolio(RoomId);
    }

    public void DeleteProductFromFolio(int roomId,String productName)
    {
        DAL.DeleteProductFromFolio(roomId, productName);
    }

}
