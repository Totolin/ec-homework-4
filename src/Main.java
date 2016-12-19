import auction.Auction;
import company.Company;
import company.Item;
import company.Offer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();

        Item itemPeanuts = new Item("Peanuts");
        itemPeanuts.addBuyer(new Offer(new Company("ASD",500),10,15));
        itemPeanuts.addBuyer(new Offer(new Company("ASD",500),16,2));
        itemPeanuts.addBuyer(new Offer(new Company("ASD",500),23,7));
        itemPeanuts.addSeller(new Offer(new Company("ASD",500),15,5));
        itemPeanuts.addSeller(new Offer(new Company("ASD",500),15,7));
        itemPeanuts.addSeller(new Offer(new Company("ASD",500),15,9));

        items.add(itemPeanuts);

        Auction auction = new Auction(items);
        auction.start();
    }
}
