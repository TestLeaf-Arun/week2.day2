package week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class RedBus {
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	//  Enter the Source place	
		WebElement from = driver.findElement(By.id("src"));
		from.sendKeys("Chennai");
		Thread.sleep(2000);
		from.sendKeys(Keys.DOWN);
		from.sendKeys(Keys.ENTER);
		
	//  Enter the Destination place	
		WebElement to = driver.findElement(By.id("dest"));
		to.sendKeys("Bangalore");
		Thread.sleep(2000);
		to.sendKeys(Keys.DOWN);
		to.sendKeys(Keys.ENTER);
		
	//  Select the Date and Click the Search Bus button
		driver.findElement(By.xpath("//td[@class='current day']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(2000);
		
	//  Close the Safety Popup using X button
		driver.findElement(By.xpath("//i[@class='icon icon-close c-fs']")).click();
		Thread.sleep(2000);
		
	// 	Close the Important Tip Popup using X button
		driver.findElement(By.xpath("//i[@class='icon-close coach-close']")).click();		
		Thread.sleep(2000);
		
	//  Close the Introducing Popup using X button
		driver.findElement(By.xpath("//i[@class='icon icon-right']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
		Thread.sleep(2000);
		
	//  Print the number of search results	[Get the value]
		String text1 = driver.findElement(By.className("f-bold busFound")).getText();
		System.out.println("Number of buses from Chennai to Bangalore: " + text1);
		Thread.sleep(2000);
		
	//  Choose only Sleeper bus
		driver.findElement(By.xpath("(//div[@class='details']//ul[3]//label)[3]")).click();
		Thread.sleep(2000);
		
	//	Print the number of Sleeper bus search results  [Get the value]
		String text2 = driver.findElement(By.className("f-bold busFound")).getText();
		System.out.println("Number of Sleeper buses: "+ text2);
		Thread.sleep(2000);
		
	//  Deselect the Sleeper bus & select the AC bus alone
		driver.findElement(By.xpath("(//div[@class='details']//ul[3]//label)[3]")).click();
		driver.findElement(By.xpath("(//div[@class='details']//ul[3]//label)[5]")).click();
		Thread.sleep(2000);
				
	//  Print the number of AC bus search results  [Get the value]
		String text3 = driver.findElement(By.className("f-bold busFound")).getText();
		System.out.println("Number of AC buses: "+ text3);
		Thread.sleep(2000);
	
	//  Choose also Non AC bus
		driver.findElement(By.xpath("(//div[@class='details']//ul[3]//label)[7]")).click();
		Thread.sleep(2000);
		
	//  Print the number of Non AC bus search results  [Get the value]
		String text4 = driver.findElement(By.className("f-bold busFound")).getText();
		System.out.println("Number of AC buses: "+ text4);
	}
}