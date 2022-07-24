package Steps;

import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import Page.imdbPage;
import junit.framework.Assert;

public class imdbSteps extends wikiSteps{
	
	
	static String imdbReleaseDate="";

	static String imdbOriginCountry="";
	
	static imdbPage imdbPageObject = new imdbPage(driver);  

	public static void openImdbPage() {
		try {
				System.out.println("Opening the IMDB Page..!!!");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get("https://www.imdb.com/");
				Thread.sleep(4000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public static void searchImdbPage(String movieName) throws InterruptedException {
		try {
			imdbPageObject.searchInputField.click();
			imdbPageObject.searchInputField.sendKeys(movieName);
			imdbPageObject.searchButton.click();
			Thread.sleep(4000);
			imdbPageObject.movieLink.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Movie Name:" +imdbPageObject.headingName.getText());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void extractImdbInfo() {
		try {
			imdbReleaseDate = imdbPageObject.releaseDateValue.getText();
//			System.out.println("Imdb Release Date:" +imdbReleaseDate);
			imdbOriginCountry = imdbPageObject.countryofOriginValue.getText();
//			System.out.println("Imdb Country of Origin:" +imdbOriginCountry);
			Thread.sleep(4000);
			if(imdbReleaseDate.contains(imdbOriginCountry)) {
				System.out.println("Release date is of the Origin Country..!!");
			}
			else {
				imdbPageObject.releaseDateValue.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				imdbReleaseDate = driver.findElement(By.xpath("//td[@class='release-date-item__country-name']//a[contains(text(),'"+imdbOriginCountry+"')]//parent::td//following::td[1]")).getText();
				System.out.println("Imdb Release Date changed wrt Country of Origin:" +imdbReleaseDate);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void compareExtractedInfo() {
		try {
			System.out.println("wikiReleaseDate :"+wikiReleaseDate);
			System.out.println("imdbReleaseDate :"+imdbReleaseDate);
			System.out.println("wikiOriginCountry :"+wikiOriginCountry);
			System.out.println("imdbOriginCountry :"+imdbOriginCountry);
			
			assertTrue((wikiReleaseDate.trim().equalsIgnoreCase(imdbReleaseDate.trim()))&&(wikiOriginCountry.trim().equalsIgnoreCase(imdbOriginCountry.trim())));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
