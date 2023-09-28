package ExtraConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class CalenderPopup {

	public static void main(String[] args) throws InterruptedException {
		
		String month = "December";
		String date = "5";
		String year = "2024";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name=\"notification-frame-317744c7\"]")));
		driver.findElement(By.xpath("//a[@id=\"webklipper-publisher-widget-container-notification-close-div\"]")).click();

		Thread.sleep(2000);
		
		new Actions(driver).moveByOffset(1300, 0).click().perform();
		
		driver.findElement(By.xpath("//label[@for=\"departure\"]")).click();
		
		for(;;) {
			
		try {	
			//date
			driver.findElement(By.xpath("//div[text()='"+month+" "+year+"']/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()='"+date+"']")).click();	
			break;
		}
		
		catch (Exception e) {
			//next
			driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();		
			}
		
		}
	}
}
