package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTests {
    private static final float DELTA = 0;

    private final String name;
    private final float price;
    private final IngredientType type;
    private Ingredient ingredient;

    public IngredientTests(IngredientType type, String name, float price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameter() {
        return Arrays.asList(new Object[][] {
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {null, null, 0},
                {IngredientType.FILLING, "", 0},
                {IngredientType.SAUCE, "", -5},
                {IngredientType.SAUCE, "test", 5.5f},
                {IngredientType.FILLING, "test", -5.5f},
        });
    }

    @Before
    public void startUp() {
       ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkNameIngredient() {
        Assert.assertEquals("Названия ингредиентов не совпадают", name, ingredient.getName());
    }

    @Test
    public void checkPriceIngredient() {
        Assert.assertEquals("Цены не совпадают", price, ingredient.getPrice(), DELTA);
    }

    @Test
    public void checkTypeIngredient() {
        Assert.assertEquals("Неизвестный ингредиент", type, ingredient.getType());
    }
}
