package scripts;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import dataproviders.StoreData;
import generic.BaseClass;
import pages.Z_InitialisePage;

public class Test2 extends BaseClass {
	
	ExtentReports report;
	
	@BeforeMethod
	public void addEmployee() {
		String paths = userDir + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(paths);
		reporter.config().setReportName("extent report of orange HRM");
		reporter.config().setDocumentTitle("OrangeHRM report");

	    report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("windows10", "4GB RAM");
		report.setSystemInfo("createdBy", "Tester");
	}

	@Test(dataProviderClass = StoreData.class, dataProvider = "objData")
	public void addEmp(String fn, String mn, String ln, String un, String pwd, String pwd2) {
		
		
		ExtentTest etest = report.createTest("TestMethod started");
		Z_InitialisePage pages = new Z_InitialisePage(driver);
		etest.info("login page");
		pages.login.login_mtd(p.getProperty("username"), p.getProperty("password"));
		etest.info("dashboard page");
		pages.dashboard.click_pim();
		etest.info("PIM page");
		pages.pim.click_addemp();
		etest.info("adduser page");
		pages.addemp.adduser_mtd(fn, mn, ln, un, pwd, pwd2);
		report.flush();
	}
}
