package dev.selenium.hello;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedditDemo {
    public static void main(String[] args) {
    	
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);        
		
		driver.get("https://www.reddit.com/");
        
        driver.findElement(By.xpath("//a[text()='Log In']")).click();
        
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        
        driver.switchTo().frame(iframe);
        
        driver.findElement(By.id("loginUsername")).sendKeys("xxx");
        driver.findElement(By.id("loginPassword")).sendKeys("xxxxx");
        
        driver.findElement(By.xpath("//button[normalize-space(text()='Log In')]")).click();
        
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
