package BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CukesTest {
	WebDriver driver;
	
	@Before
	public void launchBrowser() throws InterruptedException {
    	String projectPath = System.getProperty("user.dir");
		System.out.println("project path:" +projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/files/chromedriver/chromedriver.exe");
    }
    
}
