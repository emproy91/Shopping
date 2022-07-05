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
    public void signIn() throws InterruptedException {
        driver.get("https://staging-zapatoca.miaguila.com/registro/?hidecaptcha=true");
        // Open URL.

        //Name//

        driver.findElement(
                        By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[1]/div[1]/input"))
                .sendKeys("Juan");
        // Name field filled.

        //LastName//

        driver.findElement(
                        By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[2]/div[1]/input"))
                .sendKeys("Viafara");
        // Last Name field filled.


        //Document type//
        Select docType = new Select (driver.findElement(By.xpath("//select[1]")));
        docType.selectByIndex(1);

        driver.findElement(
                        By.xpath("//input[@type='number']"))
                .sendKeys("10221114");
        // Document field filled.

        //Email//
        driver.findElement(
                        By.cssSelector("[placeholder='Escribe tu correo electrónico']"))
                .sendKeys("juan@viafara.io");
        // Email field filled.

        //Phone//
        driver.findElement(
                        By.xpath("//input[@type='phone']"))
                .sendKeys("3214567890");
        // Phone field filled.

        //Password//
        WebElement inputPassword = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[8]/div/input"));
        inputPassword.sendKeys("Juanb1");
        // Password typed.

        WebElement inputConfirmPss = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div/div[3]/div[2]/div/div[9]/div/input"));
        inputConfirmPss.sendKeys("Juanb1");
        // Verify password typed.

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,800)");
        // Scroll down to view notice.

        //Politics//
        WebElement notice = driver.findElement(
                By.xpath("//input[@type='checkbox']"));
        Thread.sleep(600);
        notice.click();
        // Politics accepted.

        Thread.sleep(1000);

        //Button create//
        WebElement create = driver.findElement(
                By.xpath("//button[@class='button text-white text-sm rounded-lg uppercase " +
                        "font-semi-bold mt-8 btn-primary-gradient w-full h-11']"));
        create.click();
        // Account created.

        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(2500);

        //Address//
        WebElement city = driver.findElement(
                By.xpath("//input[@class='autocomplete-input']"));
        city.sendKeys("Bogotá");
        driver.findElement(By.xpath("//li[@id='autocomplete-item-0']")).click();
        // City selected.

        //Way//
        Select way = new Select (driver.findElement(By.xpath("//select[1]")));
        way.selectByIndex(1);
        // Way selected
        Thread.sleep(500);
        driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']" +
                        "/div[@class='main-theme bg-default-snow']/div[@class='location z-200']" +
                        "/div[@class='w-full max-w-md']/form[@class='form card bg-white mx-auto px-0 " +
                        "pt-0 pb-8 max-h-screen overflow-auto']/div[@class='form-content flex flex-col " +
                        "items-center justify-center px-4']/div[3]/div[2]/div[1]/div[1]/input[1]"))
                .sendKeys("104");
        Thread.sleep(500);
        driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']" +
                        "/div[@class='main-theme bg-default-snow']/div[@class='location z-200']" +
                        "/div[@class='w-full max-w-md']/form[@class='form card bg-white mx-auto px-0 " +
                        "pt-0 pb-8 max-h-screen overflow-auto']/div[@class='form-content flex flex-col " +
                        "items-center justify-center px-4']/div[@class='w-full mb-4 grid gap-2 grid-cols-2']" +
                        "/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys("152a");
        Thread.sleep(500);
        driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']" +
                        "/div[@class='main-theme bg-default-snow']/div[@class='location z-200']" +
                        "/div[@class='w-full max-w-md']/form[@class='form card bg-white mx-auto px-0 pt-0 " +
                        "pb-8 max-h-screen overflow-auto']/div[@class='form-content flex flex-col items-center " +
                        "justify-center px-4']/div[4]/div[2]/div[1]/div[1]/input[1]"))
                .sendKeys("55");
        Thread.sleep(500);

        //Button search//
        WebElement search = driver.findElement(
                By.xpath("//button[@class='button text-white text-sm rounded-lg uppercase font-semi-bold w-full h-11']"));
        search.click();
        // Play search.

        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@type='string']"))
                .sendKeys("piso 1");

        Thread.sleep(500);
        //Button save//
        WebElement save = driver.findElement(
                By.xpath("//button[@class='button text-white text-sm rounded-lg uppercase font-semi-bold " +
                        "btn-confirm mt-6 w-full mx-auto block px-6 py-3']"));
        save.click();
        //saved

    }

    // contacto.lapatronay@gmail.com  Yoraim4

    @Test
    public void makePurchase(){
        driver.get("https://staging-zapatoca.miaguila.com/registro/?hidecaptcha=true");
        // Open URL.
    }

}
