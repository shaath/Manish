package methods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

public class OrgMaster {

	public static WebDriver driver;
	public static String url = "http://orangehrm.qedgetech.com";
	public static String u = "Admin", p = "Qedge123!@#";
	public static String expval, actval;
	public static String path = "D:\\ManishRecordings\\Workspace\\SeleniumProject\\src\\properties\\OrgHRM.properties";
	public FileInputStream fi = null;
	public Properties pr = null;
	//Launch
	public String orgLaunch(String url) throws IOException{
		System.setProperty("webdriver.gecko.driver", "D:\\ManishRecordings/Jars/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		fi = new FileInputStream(path);
		pr = new Properties();
		pr.load(fi);
		
		WebElement login = driver.findElement(By.id(pr.getProperty("login")));
		if (login.isDisplayed()) {
			return "Pass";
		}
		else{
			return "Fail";
		}
	}
	
	//Login
	public String orgLogin(String u, String p){
		driver.findElement(By.id(pr.getProperty("username"))).sendKeys(u);
		driver.findElement(By.id(pr.getProperty("password"))).sendKeys(p);
		driver.findElement(By.id(pr.getProperty("login"))).click();
		
		WebElement welcome = driver.findElement(By.partialLinkText("Welcome"));
		if (welcome.isDisplayed()) {
			return "Pass";
		}
		else{
			return "Fail";
		}
	}
	//Logout
	public String orgLogout() throws InterruptedException
	{
		Thread.sleep(3000);
		expval = "LOGIN";
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		actval = driver.findElement(By.id("btnLogin")).getAttribute("value");
		
		if (expval.equalsIgnoreCase(actval)) {
			return "Pass";
		}
		else{
			return "Fail";
		}
	}
	
	//close
	public void orgClose(){
		driver.close();
	}
	//EmpReg
	public String orgEmpReg(String f, String l, String eid){
		expval = f+" "+l;
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		driver.findElement(By.id("firstName")).sendKeys(f);
		driver.findElement(By.id("lastName")).sendKeys(l);
		driver.findElement(By.id("employeeId")).clear();
		driver.findElement(By.id("employeeId")).sendKeys(eid);
		driver.findElement(By.id("btnSave")).click();
		
		actval = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		if (expval.equalsIgnoreCase(actval)) {
			return "Pass";
		}
		else{
			return "Fail";
		}
	}
	
	//UserReg
	public String orguserReg(String ename, String uname, String pwd, String cpwd) throws InterruptedException{
		expval = uname;
		boolean flag = false;
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		
		driver.findElement(By.id("btnAdd")).click();
		
		driver.findElement(By.id("systemUser_employeeName_empName")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(ename);
		driver.findElement(By.id("systemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("systemUser_password")).sendKeys(pwd);
		Thread.sleep(3000);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(cpwd);
		driver.findElement(By.id("btnSave")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			actval = cols.get(1).getText();
			if (expval.equalsIgnoreCase(actval)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			return "Pass";
		}
		else{
			return "Fail";
		}
	}
}
