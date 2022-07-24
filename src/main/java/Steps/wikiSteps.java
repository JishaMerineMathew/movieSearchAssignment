package Steps;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Page.*;
import Steps.*;
import BaseTest.CukesTest;
import io.cucumber.*;


public class wikiSteps{
	
	static String wikiReleaseDate="";

	static String wikiOriginCountry="";
	
	static WebDriver driver = new ChromeDriver();
	
	static wikiPage wikiPageObject = new wikiPage(driver);  
	
	public static void openWikiPage() throws InterruptedException {
		try {
			System.out.println("Opening the WikiPedia Page..!!!");
			driver.get("https://en.wikipedia.org/wiki/Main_Page");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
			Thread.sleep(4000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchWikiPage(String movieName) throws InterruptedException {
		try {
			wikiPageObject.searchInputField.click();
			wikiPageObject.searchInputField.sendKeys(movieName);
			wikiPageObject.searchButton.click();
			Thread.sleep(4000);
			System.out.println("Movie Name:" +wikiPageObject.headingName.getText());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void extractWikiInfo() throws InterruptedException {
		try {
			wikiReleaseDate = wikiPageObject.releaseDateValue.getText();
//			System.out.println("Wikipedia Release Date:" +wikiReleaseDate);
			wikiOriginCountry = wikiPageObject.countryofOriginValue.getText();
//			System.out.println("Wikipedia Country of Origin:" +wikiOriginCountry);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
