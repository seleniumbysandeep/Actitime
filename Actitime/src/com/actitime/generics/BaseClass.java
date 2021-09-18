package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pom.Homepage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void login() {
		Reporter.log("login",true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/");
		LoginPage l=new LoginPage(driver);
		l.setLogin("admin", "manager");
	}
	@AfterMethod
	public void logout() {
		Reporter.log("logout",true);
		Homepage h=new Homepage(driver);
		h.setLogout();
	}
	@BeforeClass
	public void openBrowser() {
		Reporter.log("openBrowser",true);
		driver=new ChromeDriver();
	}
	@AfterClass
	public void closeBrowser() {
		Reporter.log("closeBrowser",true);
		driver.close();
	}

}
