package scripts;

import org.testng.annotations.Test;

import generic.BaseClass;
import pages.Z_InitialisePage;

public class Test1 extends BaseClass{
	@Test
	public void login_Test() throws Exception {
		Z_InitialisePage pages = new Z_InitialisePage(driver);
		pages.login.login_mtd(p.getProperty("username"),p.getProperty("password"));
		Thread.sleep(2000);

	}

}
