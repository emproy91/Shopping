package testsZ;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Market extends BaseTestSuit {

    /**
     * Negative test
     */
    @Test
    public void signInNegative() throws InterruptedException {
        driver.get("https://staging-zapatoca.miaguila.com/registro/?hidecaptcha=true");
        // Open URL.

        //Name//

        driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[1]/div[1]/input"))
                .click();
        // Click on element wished.
        driver.findElement(
                By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[3]/div[2]/h6[1]"))
                .click();

        WebElement modalN = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[1]/div[2]"));
        // Element to make actions advance created.

        Assert.assertTrue(modalN.getText().contains("Requerido"));
        // Verify content of element.

        //LastName//

        driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[2]/div[1]/input"))
                .click();
        // Click on element wished.

        driver.findElement(
                        By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[3]/div[2]/h6[1]"))
                .click();

        WebElement modalLN = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[2]/div[2]"));

        Assert.assertTrue(modalLN.getText().contains("Requerido"));
        // Verify content of element.

        //Document type//
        Select docType = new Select (driver.findElement(By.xpath("//select[1]")));
        docType.selectByIndex(1);

        System.out.println("The NIT option should put another list for verification code.");
        // Click on element wished from drop list.

        //Email//
        driver.findElement(
                        By.cssSelector("[placeholder='Escribe tu correo electrónico']"))
                .sendKeys(".");
        // Click on element wished.

        WebElement modalEm = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[6]/div[2]"));

        Assert.assertTrue(modalEm.getText().contains("válido"));
        // Verify content of element.
        Thread.sleep(2000);

        //Password//
        WebElement inputPassword = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[8]/div/input"));
        inputPassword.sendKeys("Wololo");
        // Wrong password typed.

        WebElement modalPss = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[8]/div[2]"));

        Assert.assertTrue(modalPss.getText().contains("6 a 15"));
        // Verify content modal.

        WebElement inputConfirmPss = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[9]/div/input"));
        inputConfirmPss.sendKeys("Wol");

        WebElement modalCPss = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[9]/div[2]"));

        Assert.assertTrue(modalCPss.getText().contains("coinciden"));
        // Verify content modal.

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");
        // Scroll down to view notice.

        WebElement notice = driver.findElement(
                By.xpath("//input[@type='checkbox']"));
        Thread.sleep(2000);
        notice.click();

    }


    @Test
    public void makePurchase(){
        driver.get("https://staging-zapatoca.miaguila.com/registro/?hidecaptcha=true");
        // Open URL.
    }

}
