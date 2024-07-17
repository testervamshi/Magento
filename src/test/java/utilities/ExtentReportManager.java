package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter sparkreporter;//location,UI of the report
	public ExtentReports extent;//Report details
	public ExtentTest test;//update the result in the report
	
	public void onStart(ITestContext context) {
		//location of report and UI
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReports/"+timestamp+".html");
		sparkreporter.config().setDocumentTitle("Automation Testing");
		sparkreporter.config().setReportName("Registration Test");
		sparkreporter.config().setTheme(Theme.DARK);
		
		//configuration details
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);//attach report
		extent.setSystemInfo("Tester", "Vamshi");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");
	}
	
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test is passed"+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test is failed"+result.getName());
		test.log(Status.FAIL, result.getThrowable());//get the failure exception
		try {
			String imgpath=new BaseClass().captureScreenshot();
			test.addScreenCaptureFromPath(imgpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
				}
	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test is skipped"+result.getName());
		try {
			String imgpath=new BaseClass().captureScreenshot();
			test.addScreenCaptureFromPath(imgpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();//close the report
	}

}
