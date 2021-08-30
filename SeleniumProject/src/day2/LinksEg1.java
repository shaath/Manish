package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinksEg1 {

	public static void main(String[] args) throws InterruptedException {
		int count = 0;
		
		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://google.com/");
		
		Thread.sleep(5000);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("The number of links in Google page is: "+ links.size());
		
		for (int i = 0; i < links.size(); i++) 
		{
			String lname = links.get(i).getText();
			if (!lname.equalsIgnoreCase(""))
			{
				System.out.println(lname);
				count++;
			}
		}
		System.out.println("The number of visible links are : "+count);
		System.out.println("The number of invisible links are : "+(links.size() - count));
	}

}
