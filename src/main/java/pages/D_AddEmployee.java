package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class D_AddEmployee {
	@FindBy(name = "firstName")
	private WebElement tb_firstname;

	@FindBy(name = "middleName")
	private WebElement tb_middlename;

	@FindBy(name = "lastName")
	private WebElement tb_lastname;

	@FindBy(className = "oxd-switch-wrapper")
	private WebElement btn_createLogin;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement tb_username;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	private WebElement tb_password;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[5]")
	private WebElement tb_confirmpassword;
	
	@FindBy(xpath="(//button)[4]")
	private   WebElement btn_save;

	public void adduser_mtd(String fn,String mn,String ln,String un,String pwd,String pwd2) {
		this.tb_firstname.sendKeys(fn);
		this.tb_middlename.sendKeys(mn);
		this.tb_lastname.sendKeys(ln);

		this.btn_createLogin.click();
		this.tb_username.sendKeys(un);
		this.tb_password.sendKeys(pwd);
		this.tb_confirmpassword.sendKeys(pwd2);
		this.btn_save.submit();
		
	}
		public D_AddEmployee(WebDriver driver){
			PageFactory.initElements(driver, this);
		}

	}

