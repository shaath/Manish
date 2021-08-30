package day1;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunchEg {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://google.com");

	}

}
