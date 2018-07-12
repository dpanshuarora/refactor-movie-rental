import org.junit.Before;
import org.junit.Test;
import refactoring.Customer;
import refactoring.Movie;
import refactoring.Rental;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer deepanshu;
    private static final double DELTA = 0.10;
    private Movie frozen;
    private Movie savingPrivateRyan;
    private Movie loveSimon;
    private Rental loveSimonRental;
    private Rental savingPrivateRyanRental;
    private Rental frozenRental;

    @Before
    public void setUp() {
        deepanshu = new Customer("Deepanshu");
        frozen = new Movie("Frozen", 2);
        savingPrivateRyan = new Movie("Saving Private Ryan", 0);
        loveSimon = new Movie("Love Simon", 1);

        loveSimonRental = new Rental(loveSimon, 2);
        frozenRental = new Rental(frozen, 3);
        savingPrivateRyanRental = new Rental(savingPrivateRyan, 5);

    }

    @Test
    public void statementForRentalOfTwoMovies() {
        deepanshu.addRental(loveSimonRental);
        deepanshu.addRental(savingPrivateRyanRental);
        assertEquals("Rental record for Deepanshu\n" +
                "\tLove Simon\t6.0\n" +
                "\tSaving Private Ryan\t6.5\n" +
                "Amount owed is 12.5\n" +
                "You earned 3 frequent renter points", deepanshu.statement());
    }

    @Test
    public void statementForRentalOfThreeMovies() {
        deepanshu.addRental(loveSimonRental);
        deepanshu.addRental(frozenRental);
        deepanshu.addRental(savingPrivateRyanRental);
        System.out.print(deepanshu.statement());
        assertEquals("Rental record for Deepanshu\n" +
                "\tLove Simon\t6.0\n" +
                "\tFrozen\t1.5\n" +
                "\tSaving Private Ryan\t6.5\n" +
                "Amount owed is 14.0\n" +
                "You earned 4 frequent renter points", deepanshu.statement());
    }
}