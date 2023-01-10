package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_LoginPage {
	@FindBy(name="username")
	private WebElement tb_username;
	
	@FindBy(name="password")
	private WebElement tb_password;
	
	@FindBy(xpath="//button")
	private WebElement btn_login;
	
	public void login_mtd(String un, String pwd) {
		this.tb_username.sendKeys(un);
		this.tb_password.sendKeys(pwd);
		this.btn_login.click();
	}
	
	public A_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

}
