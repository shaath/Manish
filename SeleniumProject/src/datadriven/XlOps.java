package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import methods.OrgMaster;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlOps {

	public static void main(String[] args) throws IOException, InterruptedException {
		String path = "D:\\ManishRecordings\\Workspace\\SeleniumProject\\src\\testdata\\TestData.xlsx";
		String out = "D:\\ManishRecordings\\Workspace\\SeleniumProject\\src\\results\\EmpRes.xlsx";
		String res = null;
		FileInputStream fi = new FileInputStream(path);

		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sht = wb.getSheet("EmpReg");
//		XSSFRow r = sht.getRow(4);
//		XSSFCell c = r.getCell(0);
		
//		System.out.println(c.getStringCellValue());
		
		int len = sht.getLastRowNum();
		System.out.println(len);
		
		OrgMaster om = new OrgMaster();
		om.orgLaunch(om.url);
		om.orgLogin(om.u, om.p);
		
		for (int i = 1; i <= len; i++) 
		{
			XSSFRow r = sht.getRow(i);
			XSSFCell c1 = r.getCell(0);
			XSSFCell c2 = r.getCell(1);
			XSSFCell c3 = r.getCell(2);
			XSSFCell c4 = r.createCell(3);
			
			String f = c1.getStringCellValue();
			String l = c2.getStringCellValue();
			String eid = c3.getStringCellValue();
			
			System.out.println(f+"---"+l+"---"+eid);
			
			res = om.orgEmpReg(f, l, eid);
			
			c4.setCellValue(res);
		}
		
		FileOutputStream fo = new FileOutputStream(out);
		wb.write(fo);
		fo.close();
		
		om.orgLogout();
		om.orgClose();
		
	}

}
