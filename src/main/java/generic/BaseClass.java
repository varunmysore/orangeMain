package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static final String userDir = System.getProperty("user.dir");
	public static final String chromekey = "webdriver.chrome.driver";
	public static final String chromevalue = userDir + "\\drivers\\chromedriver.exe";
	public static final String geckokey = "webdriver.gecko.driver";
	public static final String geckovalue = userDir + "\\drivers\\geckodriver.exe";
	public static final String excelpath = userDir + "\\data\\actidata.xlsm";
	public WebDriver driver;
	public static Properties p;
	public static ActionUtils utils;

	@BeforeClass
	public void setPath() {
		try {
			FileInputStream f = new FileInputStream(userDir + "\\data\\demo.properties");
			p = new Properties();
			p.load(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.setProperty(chromekey, chromevalue);
		System.setProperty(geckokey, geckovalue);
	}

	@Parameters("BrowserName")
	@BeforeMethod()
	public void launchbrowser(String bn) {
		if (bn.equals("chrome"))
			driver = new ChromeDriver();
		if (bn.equals("firefox"))
			driver = new FirefoxDriver();

		utils = new ActionUtils(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(p.getProperty("url"));

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();

	}

	@AfterSuite
	public void killtask() {
		try {
			Runtime.getRuntime().exec("taskKill/IM chromedriver.exe/f");
			Runtime.getRuntime().exec("taskKill/IM geckodriver.exe/f");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
