package day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinsEg3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://primusbank.qedgetech.com/sitemap.html");
		WebElement section = driver.findElement(By.xpath("//table[@id='Table_011']/tbody/tr[2]/td"));
		
		List<WebElement> links =section.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for (int i = 0; i < links.size(); i++) {
			String lname = links.get(i).getText();
			System.out.println(lname);
			
			links.get(i).click();
			Thread.sleep(3000);
			System.out.println(driver.getTitle()+"---"+driver.getCurrentUrl());
			driver.navigate().back();
			Thread.sleep(3000);
			section = driver.findElement(By.xpath("//table[@id='Table_011']/tbody/tr[2]/td"));
			links =section.findElements(By.tagName("a"));
		}
	}
}
