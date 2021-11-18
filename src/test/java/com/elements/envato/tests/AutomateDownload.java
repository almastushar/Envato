package com.elements.envato.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.com.elements.envato.EnvatoDownloadGraphgicDesign;
import pages.com.elements.envato.EnvatoSignInPage;

public class AutomateDownload {
	String downloadFilepath = "/Users/User/Downloads/Envato/";

    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    public HashMap<String, Object> getChromePrefs() {
    	chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
		return chromePrefs;
	}
   
    ChromeOptions options = new ChromeOptions();
    public ChromeOptions getOptions() {
    	options.setExperimentalOption("prefs", chromePrefs);
	       options.addArguments("--test-type");
	       options.addArguments("--disable-extensions"); //to disable browser extension popup
	       options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	};
	WebDriver driver = new ChromeDriver(options);
	WebDriverWait wait = new WebDriverWait(driver,2);
	  

	EnvatoSignInPage signIn = new EnvatoSignInPage(driver);
	EnvatoDownloadGraphgicDesign graphicDesign = new EnvatoDownloadGraphgicDesign(driver);

	String baseUrl = "https://elements.envato.com/sign-in";
	String page31 = "https://elements.envato.com/graphic-templates/ux-and-ui-kits/pg-31";
	String userName = "almas1993";
	String password = "Afia@2006";

	@BeforeClass
	public void BeforeTest() throws IOException	{
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test(priority = 1)
	public void signInToWebPage() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='signInUsername']"))));
		//Thread.sleep(10000);
		signIn.EnterUserName(userName);
		signIn.EnterPassword(password);
		signIn.ClickSignInBtn();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void downloadGraphicDesignKit() throws InterruptedException {
		driver.get(page31);
		for (int i = 1; i <=48; i++) {
			graphicDesign.ClickDownloadIcon(i);
			graphicDesign.ClickDownloadWithoutLicBtn();
			Thread.sleep(5000);
			if(i == 10 && i == 20 && i == 30 && i == 40)
			{
				Thread.sleep(3000);
			}
		}
	}

	//@AfterClass
	public void AfterTest() {
		driver.close();
	}

}
