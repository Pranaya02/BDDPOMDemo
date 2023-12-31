package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ItemPage extends TestBase  {

	@FindBy (css = "ul li.preview")
	WebElement itemIcon;
	
	@FindBy(css = "div.detail-wrapper � button.call-to-action")
	WebElement addItemBtn;
	
	//@FindBy(css = "div.preview-details")
	
	
	
	public ItemPage () {

		PageFactory.initElements(driver, this);
	}
	
	public boolean isItemlisted() {
		return itemIcon.isDisplayed();
	}
		

	
	public void viewItemDetail(){
         itemIcon. click();
		}
	
	public void addItem() {
         addItemBtn.click();
}
	}

