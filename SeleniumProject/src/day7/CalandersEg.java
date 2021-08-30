package day7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalandersEg {

	public static void main(String[] args) throws InterruptedException {
		
		String date = "10/March/2022";
		String[] split = date.split("/");
		String day = split[0];
		String month = split[1];
		String year = split[2];
		System.out.println(day+"--"+month+"--"+year);
		
		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://www.cleartrip.com/");
		Thread.sleep(3000);
		try {
			driver.findElement(By.className("closeit")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.findElement(By.xpath("(//div[@id='root']//button/div)[4]")).click();
		Thread.sleep(5000);
		
		//Select month year
		
		String month_year = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
//		System.out.println(month_year);
		while(!month_year.equals(month+" "+year)){
//			System.out.println(month+" "+year+"------"+ month_year);
			driver.findElement(By.xpath("//*[name()='svg' and @data-testid='rightArrow']")).click();
			month_year = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
		}
		
		List<WebElement> day_list = driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1]/div/div"));
		System.out.println(day_list.size());
		for (int i = 0; i < day_list.size(); i++) {
			String day_cal = day_list.get(i).getAttribute("aria-label");
			System.out.println(day_cal);
			String exp_day = " "+day+" ";    
			
			if (day_cal != null && day_cal.contains(exp_day)) {
				day_list.get(i).click();
				break;
			}
		}
	}

}
