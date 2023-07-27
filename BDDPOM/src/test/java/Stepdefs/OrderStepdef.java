package Stepdefs;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ItemPage;
import pages.ShoppingCart;
import pages.CheckOutPage;

public class OrderStepdef extends TestBase{
	
	HomePage homePage;
	ItemPage itemPage;
	ShoppingCart cartPage;
	CheckOutPage checkOutPage;
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		initialize();
	   
	}

	@When("User search an Item {string}")
	public void user_search_an_item(String strItem) {
		
		homePage = new HomePage();
		homePage.searchItem(strItem);
	    
	}

	@Then("Item must be listed")
	public void item_must_be_listed() {
		itemPage = new ItemPage();
		Assert.assertTrue(itemPage.isItemlisted());
	    
	}
	
	@When("User Add item")
	public void user_add_item() {
		itemPage.viewItemDetail();
		itemPage.addItem();
		 
	}


	@Given("Item should be added to cart")
	public void item_should_be_added_to_cart() {
		cartPage = new ShoppingCart();
		Assert.assertTrue(cartPage.isItemAdded());
	}

	@When("User do the checkout")
	public void user_do_the_checkout() {
		cartPage.checkout();;
	}

	@Then("Should display checkout page")
	public void should_display_checkout_page() {
		checkOutPage = new CheckOutPage();
		Assert.assertTrue(checkOutPage.isCheckoutPage());
	}
	@AfterAll
	public static void teardown() {
	driver.close();

}
}
