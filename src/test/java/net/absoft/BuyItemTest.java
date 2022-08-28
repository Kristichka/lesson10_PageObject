package net.absoft;

import io.qameta.allure.Description;
import net.absoft.data.Account;
import net.absoft.data.User;
import net.absoft.pages.*;
import net.absoft.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BuyItemTest extends BaseTest {
    private final String ITEM = "Sauce Labs Backpack";

    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {
        new LoginPage(driver)
                .login(Account.STANDARD_USER)
                .shouldSeePrimaryHeader();
        inventoryPage = new InventoryPage(driver);
    }

    @Description("Test successful checkout")
    @Test
    public void testSuccessfulCheckout() {
        inventoryPage
                .addItemToCart(ITEM)
                .openCart()
                .clickCheckoutButton()
                .fillCheckoutCustomerInformation(User.DATA_USER)
                .clickContinueButton()
                .clickContinueButton()
                .checkCheckoutIsSuccessful();
    }
}