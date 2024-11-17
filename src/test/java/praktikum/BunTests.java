package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTests {
    private final String name;
    private final float price;
    private Bun bun;

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameter() {
        return Arrays.asList(new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"test", -5},
                {"test", 0},
                {"test", 5.5f},
                {"", -5.5f},
                {"", 0},
                {null, 0},
        });
    }

    @Before
    public void startUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void checkNameBun() {
        Assert.assertEquals("Ошибка названия булочки", name, bun.getName());
    }

    @Test
    public void checkPriceBun() {
        Assert.assertEquals("Ошибка цены булочки", price, bun.getPrice(), 0);
    }
}

