package Problem2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Lisa Ramel
 * Date: 2021-04-16
 * Time: 08:48
 * Project: ProgrammingTest
 * Copywrite: MIT
 */
public class FindWeb {

    public void getHttps(String URL, String driverDirectory){

        // Set up where chromedriver is installed
        System.setProperty("webdriver.chrome.driver", driverDirectory);

        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        // Finds all <a>href tags in a list
        List<WebElement> findAllLinks = driver.findElements(By.tagName("a"));

        // Prints out each web address in the list
        for(WebElement we : findAllLinks){
                System.out.println(we.getAttribute("href"));
        }

        driver.quit();

    }

    public static void main(String[] args) {

        FindWeb fw = new FindWeb();
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("What webpage would you like to scan?");
            String input = scan.nextLine();

            if(input == ""){
                System.exit(0);
            }

            fw.getHttps(input, "/Users/Lisa/Desktop/Java/WebSelenium/chromedriver");
            System.out.println();
        }

    }
}
