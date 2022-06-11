package com.demoblaze.step_definitions;

import com.demoblaze.pages.PlaceOrderPage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class PurchaseSteps {

    ProductPage productPage = new ProductPage();
    PlaceOrderPage placeOrder = new PlaceOrderPage();
    int expectedPurchaseAmount;

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("User adds {string} from {string}")
    public void user_adds_from(String product, String category) {
        productPage.navigateTo(product,category);
        productPage.addToCart();
        productPage.home.click();
    }


    @And("User navigates to cart and removes {string}")
    public void userNavigatesToCartAndRemoves(String product) {
        productPage.cart.click();
        productPage.deleteProduct(product);

    }

    @And("User clicks on place order")
    public void userClicksOnPlaceOrder() {
        productPage.cart.click();
        expectedPurchaseAmount = Integer.parseInt(productPage.totalPrice.getText());

        productPage.placeOrder.click();
    }

    @And("User fills the form for order and clicks on purchase button")
    public void userFillsTheFormForOrderAndClicksOnPurchaseButton() {
        placeOrder.fillForm();
      }

    @Then("Order ID and order amount should be as expected")
    public void orderIDAndOrderAmountShouldBeAsExpected() {

//        BrowserUtils.sleep(1);

        String orderDetailsText = placeOrder.orderDetails.getText();
        System.out.println("orderDetailsText = " + orderDetailsText);

        String orderId = orderDetailsText.split("\n")[0];
        System.out.println("orderId = " + orderId);

        int actualPurchaseAmount = Integer.parseInt(orderDetailsText.split("\n")[1].split(" ")[1]);
        System.out.println("actualPurchaseAmount = " + actualPurchaseAmount);

        Assert.assertEquals("Price is NOT as expected",expectedPurchaseAmount,actualPurchaseAmount);

    }


}
