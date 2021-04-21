import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Home {
    String str = "Subash";
    public static void main(String[] args){

            System.setProperty("webdriver.chrome.driver", "src/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.amazon.com/");
            WebElement searchBox = driver.findElement(By.xpath("//input[@id=\'twotabsearchtextbox\']"));
            searchBox.sendKeys("Qa for Beginners");
            searchBox.sendKeys(Keys.ENTER);
            WebElement cart = driver.findElement(By.xpath("//*[contains(text(),'The Way of the Web Tester')]"));
            cart.click();
            WebElement price = driver.findElement(By.xpath("//span[@id='newBuyBoxPrice']"));
            String str1 = price.getText();
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
            driver.findElement(By.xpath("(//a[@href='/gp/cart/view.html/ref=lh_cart'])[1]")).click();
            WebElement checkoutPrice = driver.findElement(By.xpath("(//*[contains(text(),'28.11')])[3]"));
            String str2 = checkoutPrice.getText();
            Assert.assertEquals(str1,str2);
            driver.quit();

        }
    }


