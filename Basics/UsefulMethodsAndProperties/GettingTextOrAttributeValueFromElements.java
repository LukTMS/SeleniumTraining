/**
 * 
 */
package UsefulMethodsAndProperties;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class GettingTextOrAttributeValueFromElements {

	WebDriver driver;
	String baseURL;
	
	@BeforeAll
	static void beforeSetUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	void test() {
		driver.get(baseURL);
		
		WebElement buttonElement = driver.findElement(By.id("opentab"));
		WebElement valueElement = driver.findElement(By.id("name"));
		
		//pobieranie tekstu
		String elementText;
		elementText = buttonElement.getText();
		System.out.println("Text on the button element is " + elementText);
		
		
		//pobieranie value
		String attributeValue;
		attributeValue = valueElement.getAttribute("class");
		System.out.println("Value of the class attribute is " + attributeValue);
		
		
	}

}
