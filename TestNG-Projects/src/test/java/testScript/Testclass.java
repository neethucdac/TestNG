package testScript;

import org.testng.annotations.Test;

public class Testclass extends Base {
@Test(priority =1)
public void sample()
{
	System.out.println("SampleMethod");
}

@Test(priority = 2)
public void display()
{
	System.out.println("DisplayMethod");

}
}
