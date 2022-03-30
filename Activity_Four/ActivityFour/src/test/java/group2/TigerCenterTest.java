package group2;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
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
		synchronized(driver) {
			driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");

			driver.wait(1000);

			WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
			assertEquals("Class Search", classButton.getText());
			classButton.click();

			driver.wait(1000);

			WebElement termSelect = driver.findElement(By.cssSelector("select[name=\"termSelector\"]"));
			termSelect.click();

			driver.wait(1000);

			WebElement springOption = driver.findElement(By.cssSelector("option[value=\"1: 0\"]"));
			springOption.click();

			driver.wait(1000);

			WebElement searchInput = driver.findElement(By.cssSelector("input[type=\"search\"]"));
			searchInput.clear();
			searchInput.sendKeys("SWEN 352");

			driver.wait(1000);

			WebElement searchButton = driver.findElement(By.cssSelector("button[class*=\"classSearchSearchButton\"]"));
			searchButton.click();

			driver.wait(3000);

			List<WebElement> searchResults = driver.findElements(By.cssSelector("app-class-search-row"));

			String temp = "";
			for (WebElement searchResult : searchResults) {
				for (WebElement colElement: searchResult.findElements(By.cssSelector("div[class=\"col-xs-2\""))) {
					for (WebElement textElement: colElement.findElements(By.className("classSearchBasicResultsText"))) {
						temp = temp + textElement.getText() + "\t";
					}
				}
				temp = temp + "\n";
			}

			System.out.println(temp);
			driver.wait(3000);
		}
    }

	@Test
    public void testClassSearchButton2() throws Exception {
		synchronized(driver) {
			driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");

			driver.wait(1000);

			WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
			assertEquals("Class Search", classButton.getText());
			classButton.click();

			driver.wait(1000);

			WebElement termSelect = driver.findElement(By.cssSelector("select[name=\"termSelector\"]"));
			termSelect.click();

			driver.wait(1000);

			WebElement springOption = driver.findElement(By.cssSelector("option[value=\"1: 0\"]"));
			springOption.click();

			driver.wait(1000);

			WebElement searchInput = driver.findElement(By.cssSelector("input[type=\"search\"]"));
			searchInput.clear();
			searchInput.sendKeys("HSPT 162");

			driver.wait(1000);

			WebElement searchButton = driver.findElement(By.cssSelector("button[class*=\"classSearchSearchButton\"]"));
			searchButton.click();

			driver.wait(3000);

			List<WebElement> searchResults = driver.findElements(By.cssSelector("app-class-search-row"));

			String temp = "";
			for (WebElement searchResult : searchResults) {
				for (WebElement colElement: searchResult.findElements(By.cssSelector("div[class=\"col-xs-2\""))) {
					for (WebElement textElement: colElement.findElements(By.className("classSearchBasicResultsText"))) {
						temp = temp + textElement.getText() + "\t";
					}
				}
				temp = temp + "\n";
			}

			System.out.println(temp);
			driver.wait(3000);
		}
    }

	@Test
    public void testClassSearchButton3() throws Exception {
		synchronized(driver) {
			driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");

			driver.wait(1000);

			WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
			assertEquals("Class Search", classButton.getText());
			classButton.click();

			driver.wait(1000);

			WebElement termSelect = driver.findElement(By.cssSelector("select[name=\"termSelector\"]"));
			termSelect.click();

			driver.wait(1000);

			WebElement springOption = driver.findElement(By.cssSelector("option[value=\"1: 0\"]"));
			springOption.click();

			driver.wait(1000);

			WebElement searchInput = driver.findElement(By.cssSelector("input[type=\"search\"]"));
			searchInput.clear();
			searchInput.sendKeys("FNRT 485");

			driver.wait(1000);

			WebElement searchButton = driver.findElement(By.cssSelector("button[class*=\"classSearchSearchButton\"]"));
			searchButton.click();

			driver.wait(3000);

			List<WebElement> searchResults = driver.findElements(By.cssSelector("app-class-search-row"));

			String temp = "";
			for (WebElement searchResult : searchResults) {
				for (WebElement colElement: searchResult.findElements(By.cssSelector("div[class=\"col-xs-2\""))) {
					for (WebElement textElement: colElement.findElements(By.className("classSearchBasicResultsText"))) {
						temp = temp + textElement.getText() + "\t";
					}
				}
				temp = temp + "\n";
			}

			System.out.println(temp);
			driver.wait(3000);
		}
    } 

}
