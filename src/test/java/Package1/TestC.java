package Package1;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import BasePackage.BaseTest;

public class TestC extends BaseTest{
	@Test
	public void testC() throws InterruptedException, MalformedURLException{
		System.out.println("Test C Started");
		driver.get("https://www.seleniumhq.org");
		System.out.println("Title is "+driver.getTitle());
		Thread.sleep(3000);
		System.out.println("Test C Ended");
	}

}
