package company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ctotolin on 19-Dec-16.
 */
public class Item {

    private String name;
    private List<Offer> buyers;
    private List<Offer> sellers;

    public Item(String name) {
        this.name = name;
        this.buyers = new ArrayList<>();
        this.sellers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBuyer(Offer buyer){
        this.buyers.add(buyer);
    }

    public void addSeller(Offer seller){
        this.sellers.add(seller);
    }

    public List<Offer> getBuyers(){
        return this.buyers;
    }

    public List<Offer> getSellers(){
        return this.sellers;
    }

    public void recalculate(int average) {
        buyers.removeIf(offer -> offer.getPrice() > average);
        sellers.removeIf(offer -> offer.getPrice() > average);
    }
}
