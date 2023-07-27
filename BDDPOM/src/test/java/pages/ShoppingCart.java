package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ShoppingCart extends TestBase {
	
	@FindBy(css = "div.cart › button. call-to-action")
	WebElement chkoutBtn;
	WebElement totalAmt;
	
	public ShoppingCart() {
	     PageFactory. initElements(driver, this);
	     
	}   
	
	public boolean isItemAdded(){
		String strAmt = totalAmt.getText ();
		double dblAmt = Double.parseDouble (strAmt);
		if(dblAmt > 0) {
		return true;
		}
		else 
			return false;
	}
	public void checkout () {
	chkoutBtn.click () ;
	
	}
	//applyCoupon ()
	//emptyCart()

}
