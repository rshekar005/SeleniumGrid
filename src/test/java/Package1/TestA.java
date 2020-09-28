package Package1;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import BasePackage.BaseTest;

public class TestA extends BaseTest {

	@Test
	public void testA() throws InterruptedException, MalformedURLException{
		System.out.println("Test A Started");
		driver.get("https://www.google.com");
		System.out.println("Title is "+driver.getTitle());
		Thread.sleep(3000);
		System.out.println("Test A Ended");
	}
}
