package WaitTypes;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

class ExplicitWait {

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
		
		//czekanie niejawne
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	void test() {
		driver.get(baseURL);
		
		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
		
		//czekanie jawne
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		
		emailField.sendKeys("Test text");
		
		
	}

	
}
