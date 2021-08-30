package day7;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleWindowhandlingEg {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://gmail.com");
		
		String gmail = driver.getWindowHandle();
//		System.out.println(gmail);
		
		driver.findElement(By.linkText("Privacy")).click();
//		driver.findElement(By.linkText("Help")).click();
		Set<String> s = driver.getWindowHandles();
		
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			System.out.println(wid);
			
			driver.switchTo().window(wid);
			Thread.sleep(3000);
			try{
				driver.findElement(By.linkText("Terms of Service")).click();
				Thread.sleep(3000);
				System.out.println(driver.getTitle()+"----"+driver.getCurrentUrl());
			}
			catch(Exception e){
				System.out.println("The expected link is not available in "+driver.getTitle()+" page");
			}
			
		}
		
		
//		driver.findElement(By.linkText("Terms of Service")).click();

	}

}
