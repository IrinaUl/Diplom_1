package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    private static final float PRICE_BUN = 100F;
    private static final float PRICE_INGREDIENT = 100F;
    private static final float PRICE_INGREDIENT_FIRST = 200F;
    private static final float TOTAL_PRICE = PRICE_BUN * 2 + PRICE_INGREDIENT + PRICE_INGREDIENT_FIRST;

    private static final String NAME_BUN = "black bun";
    private static final String NAME_INGREDIENT = "hot sauce";
    private static final String NAME_INGREDIENT_FIRST = "dinosaur";

    private static final IngredientType TYPE_INGREDIENT = IngredientType.SAUCE;
    private static final IngredientType TYPE_INGREDIENT_FIRST = IngredientType.FILLING;

    private static final String RECEIPT = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", NAME_BUN, TYPE_INGREDIENT.toString().toLowerCase(), NAME_INGREDIENT, TYPE_INGREDIENT_FIRST.toString().toLowerCase(), NAME_INGREDIENT_FIRST, NAME_BUN, TOTAL_PRICE);

    Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient ingredientFirst;

    @Mock
    private Ingredient ingredientSecond;

    @Before
    public void startUp() {
        burger = new Burger();
    }

    @Test
    public void checkAddIngredient() {
        int numIngredients = burger.ingredients.size();

        burger.addIngredient(ingredient);
        Assert.assertEquals("Количество ингредиентов не совпадает", numIngredients + 1, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        int numIngredients = burger.ingredients.size();

        burger.removeIngredient(0);
        Assert.assertEquals("Количество ингредиентов не совпадает", numIngredients - 1, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);

        burger.moveIngredient(2, 0);
        Assert.assertEquals("Ингредиент не на своем месте", 0, burger.ingredients.indexOf(ingredientSecond));
    }

    @Test
    public void checkPriceBurger() {
        Mockito.when(bun.getPrice()).thenReturn(PRICE_BUN);
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_INGREDIENT);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(PRICE_INGREDIENT_FIRST);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientFirst);
        Assert.assertEquals("Цены не совпадают", TOTAL_PRICE, burger.getPrice(), 0);
    }

    @Test
    public void checkReceiptBurger() {
        Mockito.when(bun.getPrice()).thenReturn(PRICE_BUN);
        Mockito.when(bun.getName()).thenReturn(NAME_BUN);

        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_INGREDIENT);
        Mockito.when(ingredient.getType()).thenReturn(TYPE_INGREDIENT);
        Mockito.when(ingredient.getName()).thenReturn(NAME_INGREDIENT);

        Mockito.when(ingredientFirst.getPrice()).thenReturn(PRICE_INGREDIENT_FIRST);
        Mockito.when(ingredientFirst.getType()).thenReturn(TYPE_INGREDIENT_FIRST);
        Mockito.when(ingredientFirst.getName()).thenReturn(NAME_INGREDIENT_FIRST);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientFirst);
        Assert.assertEquals("Рецепты не совпадают", RECEIPT, burger.getReceipt());
    }
}
