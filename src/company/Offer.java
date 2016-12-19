package company;

/**
 * Created by ctotolin on 19-Dec-16.
 */
public class Offer {

    private Company company;
    private int quantity;
    private int price;
    private int satisfied = 0;

    public Offer (Company company, int quantity, int price) {
        this.company = company;
        this.quantity = quantity;
        this.price = price;
        this.satisfied = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void subQuantity(int q) {
        this.quantity -= q;
    }

    public Company getCompany() {
        return company;
    }

    public void satisfy (Offer offer) {
        System.out.println("Satisfying current offer with " + offer.toString());
        int q = Math.min(this.getQuantity(), offer.getQuantity());
        offer.subQuantity(q);
        this.subQuantity(q);
    }

    public boolean isSatisfied() {
        return satisfied >= quantity;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
