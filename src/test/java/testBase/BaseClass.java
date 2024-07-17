package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;

public class BaseClass {
	public static WebDriver driver;
	public ResourceBundle RB;
	public static Logger logger;
	@BeforeSuite
	public void setUp() {
		RB=ResourceBundle.getBundle("config");
		logger=LogManager.getLogger(this.getClass());
		driver=new ChromeDriver();
		driver.get(RB.getString("baseURL"));
		logger.info("*******Application Opened*********");
		driver.manage().window().maximize();
		logger.info("*******Application Maximized*********");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("*******Apllying implicit wait*********");
	}
	@AfterSuite
	public void close() {
		driver.quit();
	}
	
	public String captureScreenshot() throws IOException {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ss=(TakesScreenshot)driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshots\\"+timestamp+".png";
		Files.copy(source,new File(destination));
		return destination;
	}

}
