package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverEg {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		
		WebElement mh = driver.findElement(By.xpath("//div[@class='nav-line-1-container']/span"));
		Actions act = new Actions(driver);
		
		act.moveToElement(mh).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.id("nav_prefetch_yourorders")).click();

	}

}
