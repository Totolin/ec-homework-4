package company;

/**
 * Created by ctotolin on 19-Dec-16.
 */
public class Company {


    private String name;
    private int budget;

    public Company(String name, int budget){
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }
}
