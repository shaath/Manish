package day5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownEg {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://primusbank.qedgetech.com/");
		
		WebElement city = driver.findElement(By.id("drlist"));
		
		Select s = new Select(city);
		
//		s.selectByIndex(7);
//		Thread.sleep(5000);
//		s.selectByValue("Ameerpet");
//		Thread.sleep(5000);
//		s.selectByVisibleText("Select a Branch");

		List<WebElement> dropItems = s.getOptions();
		System.out.println(dropItems.size());
		
		for (int i = 0; i < dropItems.size(); i++) {
			s.selectByIndex(i);
			String dName = dropItems.get(i).getText();
			System.out.println(dName);
		}
	}

}
