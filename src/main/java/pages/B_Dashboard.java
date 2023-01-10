package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class B_Dashboard {
	@FindBy(xpath="(//li)[2]")
	private WebElement link_PIM;

	public void click_pim() {
		this.link_PIM.click();
	}

	public B_Dashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
