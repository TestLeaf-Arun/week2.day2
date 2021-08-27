package week2.day2;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class HyperLinkPage {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	//	Go to Home Page	
		driver.findElement(By.xpath("//a[@link='blue']")).click();
		String str = (driver.getTitle());
		System.out.println("1st Hyperlink: " + str);
		driver.navigate().back();
		
	//	Find where am supposed to go without clicking me?	
		String control = driver.findElement(By.xpath("//a[@href='Button.html']")).getAttribute("href");
		System.out.println("Without clicking, this goes to the link " + control);
		
	//	Verify am I broken?
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains ("HTTP Status")) {
			System.out.println("Broken Link");
		} else
		System.out.println("Not Broken Link");
		driver.navigate().back();
			
	//	Go to Home Page (Interact with same link name)			
		driver.findElement(By.xpath("//div[@class='example'][4]//following::a")).click();
		String str1 = (driver.getTitle());
		System.out.println("4th Hyperlink: " + str1);
		if (str1.equals(str)) {
			System.out.println("1st and 4th Hyperlinks are same links");
		} else
			System.out.println("1st and 4th Hyperlinks are different links");
		driver.navigate().back();
		
	//	How many links are available in this page?
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links in this page are: " + links.size());
	}
}