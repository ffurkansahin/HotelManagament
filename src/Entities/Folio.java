package Entities;

import java.util.HashMap;


public class Folio {

    private HashMap<String,Integer> Products;
    private double Balance;
    public Folio() {
        Products = new HashMap<String,Integer>();
    }
    
    public HashMap<String, Integer> getProducts() {
        return Products;
    }
    public void setProducts(HashMap<String, Integer> products) {
        Products = products;
    }
    public double getBalance() {
        return Balance;
    }
    public void setBalance(double balance) {
        Balance = balance;
    }

}
