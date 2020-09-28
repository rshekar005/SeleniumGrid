package BasePackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseTest {
	public WebDriver driver = null;
	
	@BeforeMethod
	@Parameters("browser")
	public void init_remotedriver(String browsername) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		if (browsername.equalsIgnoreCase("chrome")) {
			desiredCapabilities.setPlatform(Platform.ANY);
			desiredCapabilities.setBrowserName(BrowserType.CHROME);
		} else if (browsername.equalsIgnoreCase("firefox")) {
			desiredCapabilities.setPlatform(Platform.ANY);
			desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
		} else if(browsername.equalsIgnoreCase("IE")){
			desiredCapabilities.setPlatform(Platform.ANY);
			desiredCapabilities.setBrowserName(BrowserType.IE);
		} else if(browsername.equalsIgnoreCase("edge")){
			desiredCapabilities.setPlatform(Platform.ANY);
			desiredCapabilities.setBrowserName(BrowserType.EDGE);
		} 
		//For Selenium Grid 3 we need to pass http://localhost:4444/wd/hub as a parameter
		driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown(){
		if(driver!=null){
			driver.close();
		}
	}
}
