package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
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

    //todo Дописать метод
    @Test
    public void checkPriceBurger() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientFirst);

        Assert.assertEquals("Цена должна совпадать", , );
    }


}
