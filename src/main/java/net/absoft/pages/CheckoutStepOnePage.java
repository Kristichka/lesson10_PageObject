package net.absoft.pages;

import io.qameta.allure.Step;
import net.absoft.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BaseStorePage {

    @FindBy(name = "firstName")
    private WebElement firstNameInputField;
    @FindBy(name = "lastName")
    private WebElement lastNameInputField;
    @FindBy(name = "postalCode")
    private WebElement postalCodeInputField;
    @FindBy(name = "continue")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling in User information")
    public CheckoutStepOnePage fillCheckoutCustomerInformation(User customer) {
        firstNameInputField.sendKeys(customer.getFirstName());
        lastNameInputField.sendKeys(customer.getLastName());
        postalCodeInputField.sendKeys(customer.getPostalCode());
        return this;
    }

    @Step("Opening checkout step two page")
    public CheckoutStepTwoPage clickContinueButton() {
        continueButton.click();
        return new CheckoutStepTwoPage(driver);
    }
}
