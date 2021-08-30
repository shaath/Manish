package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_DropEg2 {

	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
//		FirefoxDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\ManishRecordings\\Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("//div[@class='view-source']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		
		Actions act = new Actions(driver);
		
		Thread.sleep(5000);
		act.dragAndDropBy(drag, 387, 226).build().perform();

	}

}
