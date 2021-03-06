package methods;

import java.io.IOException;

public class OrgHRMSuite {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Login
		OrgMaster om = new OrgMaster();
		
		String res = om.orgLaunch(om.url);
		System.out.println("Application Launch "+res);
		
		res = om.orgLogin(om.u, om.p);
		System.out.println("Application Login "+res);
		
		res = om.orgLogout();
		System.out.println("Application Logout "+res);
		
		om.orgClose();
		System.out.println("Application closed successfully");
		
		//EmpReg
		
		res = om.orgLaunch(om.url);
		System.out.println("Application Launch "+res);
		
		res = om.orgLogin(om.u, om.p);
		System.out.println("Application Login "+res);
		
		res = om.orgEmpReg("Automation", "Test2", "AT0102");
		System.out.println("Employee registration "+res);
		
		res = om.orgLogout();
		System.out.println("Application Logout "+res);
		
		om.orgClose();
		System.out.println("Application closed successfully");

		//UserReg
		
		res = om.orgLaunch(om.url);
		System.out.println("Application Launch "+res);
		
		res = om.orgLogin(om.u, om.p);
		System.out.println("Application Login "+res);
		
		om.orguserReg("Automation Test2", "AutomationTest2", "Test@12345678912397256923!", "Test@12345678912397256923!");
		System.out.println("User Registration "+res);
		
		res = om.orgLogout();
		System.out.println("Application Logout "+res);
		
		om.orgClose();
		System.out.println("Application closed successfully");
		
		//UserLogin
		res = om.orgLaunch(om.url);
		System.out.println("Application Launch "+res);
		
		res = om.orgLogin("AutomationTest2", "Test@12345678912397256923!");
		System.out.println("Application Login "+res);
		
		res = om.orgLogout();
		System.out.println("Application Logout "+res);
		
		om.orgClose();
		System.out.println("Application closed successfully");
	}

}
