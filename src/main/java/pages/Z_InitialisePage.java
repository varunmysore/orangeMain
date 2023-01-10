package pages;

import org.openqa.selenium.WebDriver;

public class Z_InitialisePage {

	public A_LoginPage login;
	public B_Dashboard dashboard;
	public C_PIM pim;
	public D_AddEmployee addemp;

	public Z_InitialisePage(WebDriver driver) {
		this.login     = new A_LoginPage(driver);
		this.dashboard = new B_Dashboard(driver);
		this.pim       = new C_PIM(driver);
		this.addemp    = new D_AddEmployee(driver);
	}
}
