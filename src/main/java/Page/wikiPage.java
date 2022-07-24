package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class wikiPage {
	
	WebDriver driver = null;
	
	public wikiPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='searchInput']")
	public WebElement searchInputField;
	
	@FindBy(id="searchButton")
	public WebElement searchButton;
	
	@FindBy(xpath="//h1[@id='firstHeading']/i")
	public static WebElement headingName;

	@FindBy(xpath="//div[text()='Release date']")
	public static WebElement releaseDate;
	
	@FindBy(xpath="//div[text()='Release date']//parent::th//following::td[1]")
	public static WebElement releaseDateValue;
	
	@FindBy(xpath="//th[text()='Country']")
	public static WebElement countryofOrigin;
	
	@FindBy(xpath="//th[text()='Country']//parent::th//following::td[1]")
	public static WebElement countryofOriginValue;
}
