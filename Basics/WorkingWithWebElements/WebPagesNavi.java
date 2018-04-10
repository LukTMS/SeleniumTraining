package WorkingWithWebElements;



import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class WebPagesNavi {

	WebDriver driver;
	String baseURL;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseURL = "http://letskodeit.teachable.com";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		
		//otwieramy stornê
		driver.get(baseURL);
		
		//pobieramy tytu³
		String title = driver.getTitle();
		System.out.println("Title of the page is " + title);
		
		//pobieramy URL
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL of the page is " + currentURL);
		
		//przechodzimy do URL
		String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?reset_purchase_session=1";
		driver.navigate().to(urlToNavigate);
		
		//czekamy 2 sekundy
		Thread.sleep(2000);
		
		//przechodzimy do poprzedniej strony
		driver.navigate().back();
		
		//czekamy 2 sekundy
		Thread.sleep(2000);
		
		//przechodzimy do nastêpnej strony
		driver.navigate().forward();
		
		//czekamy 2 sekundy
		Thread.sleep(2000);
				
		//odœwie¿anie strony
		driver.navigate().refresh();
				
		
	}

}
