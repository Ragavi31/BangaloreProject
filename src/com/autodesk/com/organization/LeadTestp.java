 package com.autodesk.com.organization;

import java.io.IOException;

import org.testng.annotations.Test;

import com.autodesk.com.genericlib.BaseLib;
import com.autodesk.com.pageobjects.CalenderPage;
import com.autodesk.com.pageobjects.LeadsPage;

public class LeadTestp extends BaseLib{

	
	LeadsPage lep;
	CalenderPage cp;
	
	@Test
	public void addingActivitHistoryitoCreatedLead() throws IOException {
		
		
		lep = new LeadsPage(driver);
		cp = new CalenderPage(driver);

	    /*navigate to leads page*/
		hp.clickLead();
		
		/*create lead*/
		lep.createlead(flib.getExcelData("Sheet1", 4, 0), flib.getExcelData("Sheet1", 4, 1),
				flib.getExcelData("Sheet1", 4, 2));
		
		/*schedule activity to the lead and display activity history*/
		cp.scheduleActivity();
	   
		
	}

}
