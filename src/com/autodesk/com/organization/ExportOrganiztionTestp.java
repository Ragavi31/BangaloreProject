package com.autodesk.com.organization;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.autodesk.com.genericlib.BaseLib;
import com.autodesk.com.pageobjects.OrganisationPage;

public class ExportOrganiztionTestp extends BaseLib
{
	
	OrganisationPage op;
	@Test
	public void organization() throws IOException {
		
		op=new OrganisationPage(driver);
		
		/* navigate to organization page*/
		hp.clickOrganization();
		
			
		/*export organizations */
		op.exportOrganisation();
		
		/*verifying errorMsg */
		Assert.assertEquals(op.getErrorMsgToverify().getText(),
				"You haven't used the search. All the records will be Exported from Organizations");
		Reporter.log("ErrorMessage verified", true);
	}


}
