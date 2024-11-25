package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DatabaseTests {
    Database database;

    @Before
    public void startUp() {
        database = new Database();
    }

    @Test
    public void checkAvailableBuns() {
        List<Bun> buns = database.availableBuns();
        Assert.assertNotNull(buns);
    }

    @Test
    public void checkAvailableIngredients() {
        List<Ingredient> ingredient = database.availableIngredients();
        Assert.assertNotNull(ingredient);
    }
}
