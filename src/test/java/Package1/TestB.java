package Package1;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import BasePackage.BaseTest;

public class TestB extends BaseTest{
	
	@Test
	public void testB() throws InterruptedException, MalformedURLException{
		System.out.println("Test B Started");
		driver.get("https://www.facebook.com");
		System.out.println("Title is "+driver.getTitle());
		Thread.sleep(3000);
		System.out.println("Test B Ended");
	}

}
