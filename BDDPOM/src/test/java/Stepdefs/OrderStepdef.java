package Stepdefs;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ItemPage;

import org.testng.Assert;



public class OrderStepdef extends TestBase{
	
	HomePage homePage;
	ItemPage itemPage;
	
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

	@Then("Item should be added to cart")
	public void item_should_be_added_to_cart() {
	    
	}

}
