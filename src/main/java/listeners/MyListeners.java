package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import generic.BaseClass;

public class MyListeners implements ITestListener  {
	public void onTestFailure(ITestResult result) {
		String scriptname = result.getMethod().getMethodName();
		BaseClass.utils.capturescreenshot(scriptname);
	}

}
