package group;

import org.testng.annotations.Test;


public class GroupExecution
{
	@Test(groups= {"smoke"})
	public void createCustomer()
	{
		System.out.println("done creation");
	}

	@Test(groups= {"regression"})
	public void addCustomer()
	{
		System.out.println("done addition");
	}
	@Test(groups= {"smoke"})
	public void editCustomer()
	{
		System.out.println("edited");
	}
	@Test(groups= {"smoke"})
	public void archieveCustomer()
	{
		System.out.println("done archive");
	}
	@Test(groups= {"regression"})
	public void deleteCustomer()
	{
		System.out.println("done deletion");
	}

}
