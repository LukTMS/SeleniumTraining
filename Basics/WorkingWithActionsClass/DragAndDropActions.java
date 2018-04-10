package WorkingWithActionsClass;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://jqueryui.com/droppable/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testDragAndDrop() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		//trzeba przejœæ do IFrame
		driver.switchTo().frame(0);

		WebElement fromElement = driver.findElement(By.id("draggable"));
		WebElement toElement = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		// Drag and drop, build and perform
		action.dragAndDrop(fromElement, toElement).build().perform();
		
		// Click and hold, move to element, release, build and perform
		//action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
		
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}