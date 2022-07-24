package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class imdbPage {
WebDriver driver = null;
	
	public imdbPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='suggestion-search']")
	public WebElement searchInputField;
	
	@FindBy(id="suggestion-search-button")
	public WebElement searchButton;
	
	@FindBy(xpath="//td[@class='result_text']//a")
	public static WebElement movieLink;
	
	@FindBy(xpath="//h1[@data-testid='hero-title-block__title']")
	public static WebElement headingName;

	@FindBy(xpath="(//li[@data-testid='title-details-releasedate']//a)[1]")
	public static WebElement releaseDate;
	
	@FindBy(xpath="(//li[@data-testid='title-details-releasedate']//a)[2]")
	public static WebElement releaseDateValue;
	
	@FindBy(xpath="//li[@data-testid='title-details-origin']//span")
	public static WebElement countryofOrigin;
	
	@FindBy(xpath="//li[@data-testid='title-details-origin']//div//ul//li//a")
	public static WebElement countryofOriginValue;
	
//	@FindBy(xpath="//td[@class='release-date-item__country-name']//a[contains(text(),'India')]//parent::td//following::td[1]")
//	public static WebElement countryofOriginChange;
}
