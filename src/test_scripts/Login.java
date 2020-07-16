package test_scripts;

import generic.Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pom.EnterTimeTrack;
import pom.LoginPage;

public class Login extends Generic{
	
	@Test
	public void testLogin() throws InterruptedException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("admin");
		lp.setPassword("manager");
		lp.clickLogin();
		
		Thread.sleep(3000);//use explicit wait
		
		String title = driver.getTitle();
		System.out.println(title);
		
		EnterTimeTrack ep=new EnterTimeTrack(driver);
		ep.clickLogout();
	}

}
