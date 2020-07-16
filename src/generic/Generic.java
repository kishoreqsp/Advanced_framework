package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Generic {
	
public WebDriver driver;

static
{
	System.setProperty("webdriver.gecko.driver","./softwares1/geckodriver.exe");
}

	@BeforeMethod
	public void openAppln()
	{
			  driver=new FirefoxDriver();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  driver.get("http://localhost/login.do;jsessionid=47usrlkvquhbv");
		  
	}
	@AfterMethod
	public void closeAppln( ITestResult res ) throws Exception
	{
		 int status = res.getStatus();
		 System.out.println(status);
		 
		 String tcname = res.getName();
		System.out.println(tcname);
		
		if(status==2)
		{
			Generic_Screenshots.photo(driver,tcname);
		}
		
		driver.quit();
	}
}









