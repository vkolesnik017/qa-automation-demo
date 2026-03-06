package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;


public class SortTest extends BaseTest {
    InventoryPage inventoryPage = new InventoryPage();

    @Test
    public void testSort() {
        navigate("https://www.saucedemo.com/");
        List<Double> productPrices = new LoginPage()
                .loginAs("standard_user", "secret_sauce")
                .selectSort("Price (low to high)")
                .getPriceList();


     /*   InventoryPage inventoryPage = loginPage.loginAs("standard_user", "secret_sauce");
        inventoryPage.selectSort("Price (low to high)");
        List<Double> productPrices = inventoryPage.getPriceList();*/
        List<Double> newList = inventoryPage.sortList(productPrices);
        assertEquals(productPrices, newList);
        //     Assert.assertTrue(!productPrices.isEmpty());
        assertThat(productPrices).isSorted();
        assertThat(productPrices)
                .isNotEmpty()
                .allMatch(price -> price > 0);
        List<String> title = inventoryPage.hasItemWithNameContains("T-Shirt");
        assertThat(title.size()).isEqualTo(2);
        Double price = inventoryPage.findFirstItemMoreExpensiveThan(30.0);
        assertThat(price > 30).isTrue();
        String containsTitle = inventoryPage.findFirstItemContaining("backpack");

        inventoryPage.addItemToBasket("Labs");

        assertEquals(inventoryPage.getBasketCount(), 1);
        System.out.println();
    }
}
