package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class C_PIM {
	@FindBy(xpath = "//a[contains(text(),'Add Employee')]")
	private WebElement btn_AddEmp;

	public void click_addemp() {
		this.btn_AddEmp.click();
	}

	public C_PIM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
