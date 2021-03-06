package testNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmpRegTC_TestNG extends TestNGSuite{

	@Test(dataProvider = "data")
	public void orgEmpReg(String f, String l, String eid){
		expval = f+" "+l;
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		driver.findElement(By.id("firstName")).sendKeys(f);
		driver.findElement(By.id("lastName")).sendKeys(l);
		driver.findElement(By.id("employeeId")).clear();
		driver.findElement(By.id("employeeId")).sendKeys(eid);
		driver.findElement(By.id("btnSave")).click();
		
		actval = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		assertEquals(actval, expval,"Employee registration Failed");	
	}
	
	@DataProvider
	public Object[][] data(){
		Object[][] testdata = new Object[3][3];
		
		testdata[0][0] = "Test1";
		testdata[0][1] = "Auto1";
		testdata[0][2] = "TA9876";
		
		testdata[1][0] = "Test2";
		testdata[1][1] = "Auto2";
		testdata[1][2] = "TA9843";
		
		testdata[2][0] = "Test3";
		testdata[2][1] = "Auto3";
		testdata[2][2] = "TA9326";
		
		return testdata;
	}
}
