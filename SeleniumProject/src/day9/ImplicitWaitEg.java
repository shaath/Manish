package day9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWaitEg {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://demo.automationtesting.in/Loader.html");
		
//		driver.manage().timeouts().implicitlyWait(360, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 360);
		
		
		driver.findElement(By.id("loader")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-dialog']//button[text()='Save changes']"))).click();
		
		

	}

}
