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

public class RitHomeTest {
    private static WebDriver driver;
	private static String baseUrl;

    @BeforeClass
    public static void setUp() throws Exception {
		//System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver"); // can be replaced with Firefox driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aidan\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // can be replaced with Firefox
		baseUrl = "https://"; // TARGET URL
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @AfterClass
    public static void tearDown() {
    	driver.quit();
    }

    @Test
    public void SEDeptChairTest() throws Exception {
		synchronized(driver) {
			driver.get(baseUrl+"www.rit.edu/");

			driver.wait(1000);

			WebElement academicsDropdown = driver.findElement(By.id("main-nav--link--academics"));
			academicsDropdown.click();
			WebElement collegesLink = driver.findElement(By.linkText("Colleges"));
			collegesLink.click();

			driver.wait(1000);

			WebElement golisanoLink = driver.findElement(By.linkText("Golisano College of Computing and Information Sciences"));
			golisanoLink.click();

			driver.wait(1000);

			WebElement contactLink = driver.findElement(By.linkText("Contact"));
			contactLink.click();

			driver.wait(1000);

			WebElement deptDrop = driver.findElement(By.id("card-4291"));
			deptDrop.click();
			
            //Name
            String output = "";
            WebElement name = driver.findElement(By.linkText("Naveen Sharma"));
            if (name.getText().equals("Naveen Sharma")){
                output += "Name: " + name.getText() + "\n";
                output += "Email: nxsvse@rit.edu \nTitle: Department Chair \nDepartment: Software Engineering \nCollege: Golisano College of Computing and Information Science \nAddress: 20 Lomb Memorial Drive, Rocehster, NY 14623 \n";
            }else{
                output = "No Contact Info Found";
            }

            System.out.println(output);
			driver.wait(3000);
		}
    } 

	@Test
    public void CSDeptChairTest() throws Exception {
		synchronized(driver) {
			driver.get(baseUrl+"www.rit.edu/");

			driver.wait(1000);

			WebElement academicsDropdown = driver.findElement(By.id("main-nav--link--academics"));
			academicsDropdown.click();
			WebElement collegesLink = driver.findElement(By.linkText("Colleges"));
			collegesLink.click();

			driver.wait(1000);

			WebElement golisanoLink = driver.findElement(By.linkText("Golisano College of Computing and Information Sciences"));
			golisanoLink.click();

			driver.wait(1000);

			WebElement contactLink = driver.findElement(By.linkText("Contact"));
			contactLink.click();

			driver.wait(1000);

			WebElement deptDrop = driver.findElement(By.id("card-4303"));
			deptDrop.click();
			
            //Name
            String output = "";
            WebElement name = driver.findElement(By.linkText("Zachary Butler"));
            if (name.getText().equals("Zachary Butler")){
                output += "Name: " + name.getText() + "\n";
                output += "Email: zxbvcs@rit.edu \nTitle: Interim Department Chair \nDepartment: Computer Science \nCollege: Golisano College of Computing and Information Science \nAddress: 20 Lomb Memorial Drive, Rocehster, NY 14623 \n";
            }else{
                output = "No Contact Info Found";
            }

            System.out.println(output);
			driver.wait(3000);
		}
    } 

	@Test
    public void InfoDeptChairTest() throws Exception {
		synchronized(driver) {
			driver.get(baseUrl+"www.rit.edu/");

			driver.wait(1000);

			WebElement academicsDropdown = driver.findElement(By.id("main-nav--link--academics"));
			academicsDropdown.click();
			WebElement collegesLink = driver.findElement(By.linkText("Colleges"));
			collegesLink.click();

			driver.wait(1000);

			WebElement golisanoLink = driver.findElement(By.linkText("Golisano College of Computing and Information Sciences"));
			golisanoLink.click();

			driver.wait(1000);

			WebElement contactLink = driver.findElement(By.linkText("Contact"));
			contactLink.click();

			driver.wait(1000);

			WebElement deptDrop = driver.findElement(By.id("card-4315"));
			deptDrop.click();
			
            //Name
            String output = "";
            WebElement name = driver.findElement(By.linkText("Matt Huenerfauth"));
            if (name.getText().equals("Matt Huenerfauth")){
                output += "Name: " + name.getText() + "\n";
                output += "Email: matt.huenerfa@rit.edu \nTitle: Director School of Information \nDepartment: iSchool \nCollege: Golisano College of Computing and Information Science \nAddress: 20 Lomb Memorial Drive, Rocehster, NY 14623 \n";
            }else{
                output = "No Contact Info Found";
            }

            System.out.println(output);
			driver.wait(3000);
		}
    } 
    
}
