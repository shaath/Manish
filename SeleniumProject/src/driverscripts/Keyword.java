package driverscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import methods.OrgHRMSuite;
import methods.OrgMaster;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Keyword {

	public static void main(String[] args) throws IOException, InterruptedException {
		OrgMaster om = new OrgMaster();
		String res = null;
		String path = "D:\\ManishRecordings\\Workspace\\SeleniumProject\\src\\testdata\\Keyword.xlsx";
		String outPath = "D:\\ManishRecordings\\Workspace\\SeleniumProject\\src\\results\\keyres2.xlsx";
		FileInputStream fi = new FileInputStream(path);
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet TcSht = wb.getSheet("Testcase");
		XSSFSheet TsSht = wb.getSheet("Teststeps");
		XSSFSheet TdSht = wb.getSheet("TestData");
		
		int TcRc = TcSht.getLastRowNum();
		int TsRc = TsSht.getLastRowNum();
		
		for (int i = 1; i <= TcRc; i++) {
			TcSht.getRow(i).createCell(3);
			String exe = TcSht.getRow(i).getCell(2).getStringCellValue();
			
			if (exe.equalsIgnoreCase("Y")) {
				String TcId = TcSht.getRow(i).getCell(0).getStringCellValue();
				
				for (int j = 1; j <= TsRc; j++) {
					String TsTcId = TsSht.getRow(j).getCell(0).getStringCellValue();
					
					if (TcId.equalsIgnoreCase(TsTcId)) {
						String key = TsSht.getRow(j).getCell(3).getStringCellValue();
						
						switch (key) {
						case "Launch":
							String url = TdSht.getRow(1).getCell(0).getStringCellValue();
							res = om.orgLaunch(url);
							break;
						case "login":
							String u = TdSht.getRow(1).getCell(1).getStringCellValue();
							String p = TdSht.getRow(1).getCell(2).getStringCellValue();
							res = om.orgLogin(u, p);
							break;
						case "logout":
							res = om.orgLogout();
							om.orgClose();
							break;
						case "Empreg":
							String f = TdSht.getRow(1).getCell(3).getStringCellValue();
							String l = TdSht.getRow(1).getCell(4).getStringCellValue();
							String eid = TdSht.getRow(1).getCell(5).getStringCellValue();
							res = om.orgEmpReg(f, l, eid);
							break;
						case "Usereg":
							String ename = TdSht.getRow(1).getCell(6).getStringCellValue();
							String uname = TdSht.getRow(1).getCell(7).getStringCellValue();
							String pwd = TdSht.getRow(1).getCell(8).getStringCellValue();
							String cpwd = TdSht.getRow(1).getCell(9).getStringCellValue();
							om.orguserReg(ename, uname, pwd, cpwd);
							break;
						case "Ulogin":
							String un =  TdSht.getRow(1).getCell(7).getStringCellValue();
							String pswd =  TdSht.getRow(1).getCell(8).getStringCellValue();
							res = om.orgLogin(un, pswd);
							break;
						default:
							System.out.println("Select a proper keyword");
							break;
						}
						
						TsSht.getRow(j).createCell(4).setCellValue(res);
						
						if (!TcSht.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("Fail")) {
							TcSht.getRow(i).getCell(3).setCellValue(res);
						}
					}
				}
			}
			else{
				TcSht.getRow(i).getCell(3).setCellValue("BLOCKED");
			}
		}
		FileOutputStream fo = new FileOutputStream(outPath);
		wb.write(fo);
		wb.close();
		
	}

}
