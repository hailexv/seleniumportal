/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Autotest {
/**
* @param args the command line arguments
*/
 public static void main(String[] args) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException {
     System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
 WebDriver driver = new FirefoxDriver();
 driver.get("http://portal.aait.edu.et");
 
 
 PrintWriter writer = new PrintWriter("report.xls", "UTF-8");
         
 
 driver.findElement(By.name("UserName")).sendKeys("Ate/5001/09");
  driver.findElement(By.name("Password")).sendKeys("");
  driver.findElement(By.className("btn-success")).click();
  
  driver.findElement(By.linkText("Grade & Results")).click();
  
driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");



WebElement simpleTable = driver.findElement(By.tagName("tbody")); 
     
     
     

    // Get all rows 
    List<WebElement> rows = simpleTable.findElements(By.tagName("tr")); 
    
    // Print data from each row 
    for (WebElement row : rows) { 
        List<WebElement> cols = row.findElements(By.tagName("td")); 
        for (WebElement col : cols) {
             System.out.print(col.getText() + "\t"); 
             
             ///
             
            writer.println(col.getText() + "\t");;
             ///
           } System.out.println(); writer.print("\n");
       }
    
    writer.close();
    
    
    
    
  
/*
 
 driver.findElement(By.linkText("Grade & Results")).click();

 driver.findElement(By.className("dropdown-toggle")).click();
  
  List<WebElement> elements = driver.findElements(By.tagName("a"));
    System.out.println("Number of elements:" +elements.size());

    for (int i=0; i<elements.size();i++){
      System.out.println("hyper link text:" + elements.get(i).getText());
    }
  
  
  
*/

//Wait for 5 
Thread.sleep(5);
// Close the driver
driver.quit();
 }
}
