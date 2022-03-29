package group2;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TigerCenterTest {
	
	private static WebDriver driver;
	private static String baseUrl;

    @BeforeClass
    public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver"); // can be replaced with Firefox driver
		driver = new ChromeDriver(); // can be replaced with Firefox
		baseUrl = "https://"; // TARGET URL
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @AfterClass
    public static void tearDown() {
    	driver.quit();
    }
    
    @Test
    public void testClassSearchButton() throws Exception {
    	driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");
    	WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
    	assertEquals("Class Search", classButton.getText());
    	classButton.click();
    } 

}
