package me.logx.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class ChromeSimple01 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Develop/Chrome/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://mail.163.com/");

		WebElement id = driver.findElement(By.id("idInput"));
		id.sendKeys("logx0208");

		WebElement pwd = driver.findElement(By.id("pwdInput"));
		pwd.sendKeys("aw2330821");

		pwd.submit();

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
//				return !justification.getAttribute("class").contains("x-form-invalid-field");
				return true;
			}
		});

		driver.quit();
	}
}
