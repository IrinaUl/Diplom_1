package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTests {
    private final String name;
    private final float price;

    public BunTests (String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameter() {
        return Arrays.asList(new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"test", -5.5},
                {"test", 0},
                {"", 0},
                {null, 0},
        });
    }

    @Test
    public void checkNameBun() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Ошибка названия булочки", name, bun.getName());
    }

    @Test
    public void checkPriceBun() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Ошибка цены булочки", price, bun.getPrice(), 0);
    }
}

