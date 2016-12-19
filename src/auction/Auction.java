package auction;

import company.Item;
import company.Offer;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ctotolin on 19-Dec-16.
 */
public class Auction {


    private final List<Item> items;

    public Auction(List<Item> items) {
        this.items = items;
    }

    public void start() {
        System.out.println("Running auction");
        // Run auction for each item
        for (Item item : items){
            System.out.println("Running b2b for item : " + item.getName());
            // Calculate a mean of offer
            int totalSum = 0;
            int offers = 0;

            for (Offer offer : item.getBuyers()) {
                offers ++;
                totalSum += offer.getPrice();
            }

            for (Offer offer : item.getSellers()) {
                offers ++;
                totalSum += offer.getPrice();
            }

            // Calculate average
            int average = totalSum / offers;

            System.out.println("Average sell/buy price is : " + average);

            // Get all valid buyers and sellers
            item.recalculate(average);

            // Order seller offers by price
            (item.getSellers()).sort(Comparator.comparingInt(Offer::getPrice));

            // Satisfy all buyers
            for (Offer offer : item.getBuyers()) {
                System.out.println("--> Satisfying buyer offer : " + offer.toString());
                while (!offer.isSatisfied() && item.getSellers().size() > 0) {
                    offer.satisfy(item.getSellers().get(0));
                    if (item.getSellers().get(0).isSatisfied()) {
                        System.out.println("Seller offer is satisfied : " + item.getSellers().get(0).toString());
                        item.getSellers().remove(0);
                    }
                }
            }
        }
    }
}
