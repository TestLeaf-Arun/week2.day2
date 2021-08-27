package week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ButtonPage {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//	Click button to travel to Home page
		driver.findElement(By.id("home")).click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
						
	//	Find position of button (x,y)
		WebElement button1 = driver.findElement(By.id("position"));
		Point location = button1.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("Coordinates of the Button (x,y): " + x+","+y);		
		
	//	Find button color - Light Green
		String buttonColor = driver.findElement(By.id("color")).getAttribute("style");				
		System.out.println("Color of the Button is " + buttonColor);
		
	//	Find the Height and Width
		WebElement button2 = driver.findElement(By.id("size"));
		int buttonHeight = button2.getSize().getHeight();
		System.out.println("Height of the Button is " + buttonHeight);
		int buttonWidth = button2.getSize().getWidth();
		System.out.println("Width of the Button is " + buttonWidth);
	}
}