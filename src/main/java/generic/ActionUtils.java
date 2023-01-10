package generic;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionUtils {

	public WebDriver driver;

	public ActionUtils(WebDriver driver) {
		this.driver = driver;
	}

	public static String getdata(String excelpath, String name, int r, int c) {
		try {
			FileInputStream f = new FileInputStream(excelpath);
			Workbook book = WorkbookFactory.create(f);
			String d = book.getSheet(name).getRow(r).getCell(c).getStringCellValue();
			return d;
		} catch (Exception e) {
			return null;
		}
	}

	public void validatetitle(String exptitle) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs(exptitle));
			System.out.println("pass");

		} catch (Exception e) {
			System.out.println("fail");
			Assert.fail();
		}
	}

	public void validateelement(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("pass");

		} catch (Exception e) {
			System.out.println("fail");
			Assert.fail();
		}
	}

	public void capturescreenshot(String scriptname) {
		TakesScreenshot j = (TakesScreenshot) driver;
		File src = j.getScreenshotAs(OutputType.FILE);
		File dest = new File(BaseClass.userDir + "\\screenshots\\" + scriptname + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {

		}
	}
}
