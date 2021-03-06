package testNG;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNGSuite {
	public static WebDriver driver;
	public static String url = "http://orangehrm.qedgetech.com";
	public static String u = "Admin", p = "Qedge123!@#";
	public static String f = "Test12", l = "Automation_Training", eid = "TA97212";
	public static String uname = "ATestAutomation_Training321", ename = "Test12 Automation_Training";
	public static String pwd = "Test@12345678912397256923!", cpwd = "Test@12345678912397256923!";
	public static String expval, actval;
	public static String path = "D:\\ManishRecordings\\Workspace\\SeleniumProject\\src\\properties\\OrgHRM.properties";
	public FileInputStream fi = null;
	public Properties pr = null;
	@BeforeSuite
	public void orgLaunch() throws IOException{
		expval = "LOGIN";
		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		fi = new FileInputStream(path);
		pr = new Properties();
		pr.load(fi);
		
		actval = driver.findElement(By.id(pr.getProperty("login"))).getAttribute("value");
		
		assertEquals(actval, expval,"Launch Failed");		
	}
	
	@BeforeTest
	public void orgLogin(){
		expval = "welcome";
		driver.findElement(By.id(pr.getProperty("username"))).sendKeys(u);
		driver.findElement(By.id(pr.getProperty("password"))).sendKeys(p);
		driver.findElement(By.id(pr.getProperty("login"))).click();
		
		actval = driver.findElement(By.partialLinkText("Welcome")).getAttribute("id");
		assertEquals(actval, expval,"Login Failed");		
	}
	
	@AfterTest
	public void orgLogout() throws InterruptedException{
		Thread.sleep(3000);
		expval = "LOGIN";
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		actval = driver.findElement(By.id("btnLogin")).getAttribute("value");
		assertEquals(actval, expval,"Logout Failed");
	}
	
	@AfterSuite
	public void orgClose(){
		driver.close();
	}
}
