import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateDeliveryTests extends TestBase{

    public static Page preConditionDelivery(String brow, Playwright playwright){
        String url = "https://sender.getpackage.com/login";


        if(brow == "chrom"){
            BrowserContext browserContext = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
       Page page = preconditionLogin(browserContext);
        return page;}

        else if (brow == "firefox"){
                BrowserContext browserContext = playwright.firefox().
                    launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
               Page page = preconditionLogin(browserContext);
        return page;}

                BrowserContext browserContext = playwright.webkit()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
        Page page = preconditionLogin(browserContext);
    return page;}

    public static Page preconditionLogin(BrowserContext browserContext){
        Page page = browserContext.newPage();
        page.navigate("https://sender.getpackage.com/login");
        page.click("//*[contains(text(),'כתובת אימייל וסיסמה')]");
        page.fill("//input[@formcontrolname='userName']", "bunkof33@gmail.com");
        page.fill("//input[@formcontrolname='password']", "Playwright1!");
        page.click(".gp-submit");
        page.isVisible("//gp-sidebar[@class='gp-max-height']//i[@class='material-icons-outlined lng-side'][normalize-space()='login']");
        page.click("//mat-icon[normalize-space()='add']");
        return page;
    }

    public static void addressPackageBefore() {

        try (Playwright playwright = Playwright.create()){
        String[] brows = {"chrom","firefox","safari"};
        for (String b:brows){
        Page page = preConditionDelivery(b,playwright);
        page.fill("//input[@id='mat-input-8']","Tel Aviv");
        page.click("//input[@id='mat-input-9']");
            pause(500);
        page.click("//input[@id='mat-input-8']");
            pause(500);
            page.keyboard().press("ArrowDown");
            page.keyboard().press("Enter");
        page.fill("//input[@id='mat-input-0']","Tel Aviv");
        page.click("//input[@id='mat-input-1']");
            pause(500);
        page.click("//input[@id='mat-input-0']");
            pause(500);
            page.keyboard().press("ArrowDown");
            page.keyboard().press("Enter");
            page.isDisabled("//*[text()='בחרו סוג שירות ']");
            page.click("//span[contains(text(),'קטן')]");
            page.isVisible("//*[text()='בחרו סוג שירות ']");

            page.close();

        }
    }

    }

    public static void deliveryTelAvivTelAvivSameDay(){
        try (Playwright playwright = Playwright.create()){
            String[] brows = {"chrom","firefox","safari"};
            for (String b:brows){
                Page page = preConditionDelivery(b,playwright);
                page.fill("//input[@id='mat-input-8']","Tel Aviv");
                page.click("//input[@id='mat-input-9']");
                pause(500);
                page.click("//input[@id='mat-input-8']");
                pause(500);
                page.keyboard().press("ArrowDown");
                page.keyboard().press("Enter");
                page.fill("//input[@id='mat-input-0']","Tel Aviv");
                page.click("//input[@id='mat-input-1']");
                pause(500);
                page.click("//input[@id='mat-input-0']");
                pause(500);
                page.keyboard().press("ArrowDown");
                page.keyboard().press("Enter");

                page.click("//span[contains(text(),'קטן')]");

                page.click("//b[contains(text(),'אקספרס')]");

                page.close();

            }
        }



    }


    public static void deliveryEilatTelAvivOnlyExpress(){
        try (Playwright playwright = Playwright.create()){
            String[] brows = {"chrom","firefox","safari"};
            for (String b:brows){
                Page page = preConditionDelivery(b,playwright);
                page.fill("//input[@id='mat-input-8']","eilat");
                page.click("//input[@id='mat-input-9']");
                pause(700);
                page.click("//input[@id='mat-input-8']");
                pause(500);
                page.keyboard().press("ArrowDown");
                page.keyboard().press("Enter");
                page.fill("//input[@id='mat-input-0']","Tel Aviv");
                page.click("//input[@id='mat-input-1']");
                pause(500);
                page.click("//input[@id='mat-input-0']");
                pause(500);
                page.keyboard().press("ArrowDown");
                page.keyboard().press("Enter");

                page.click("//span[contains(text(),'קטן')]");
                page.isHidden("// b[contains(text(),'מהיום להיום')]");
                page.click("//b[contains(text(),'אקספרס')]");

                page.close();

            }
        }
    }
    public static void deliveryBeforeTime(){
        try (Playwright playwright = Playwright.create()){
            String[] brows = {"chrom","firefox","safari"};
            for (String b:brows){
                Page page = preConditionDelivery(b,playwright);
                page.fill("//input[@id='mat-input-8']","Tel Aviv");
                page.click("//input[@id='mat-input-9']");
                pause(500);
                page.click("//input[@id='mat-input-8']");
                pause(500);
                page.keyboard().press("ArrowDown");
                page.keyboard().press("Enter");
                page.fill("//input[@id='mat-input-0']","Rishon");
                page.click("//input[@id='mat-input-1']");
                pause(500);
                page.click("//input[@id='mat-input-0']");
                pause(500);
                page.keyboard().press("ArrowDown");
                page.keyboard().press("Enter");

                page.click("//span[contains(text(),'קטן')]");

                page.click("// b[contains(text(),'מהיום להיום')]");

                page.locator("//*[text()='14:00-18:00']").isVisible();

            }
        }



    }

    public static void deliveryEmptyFields(){
        try (Playwright playwright = Playwright.create()){
            String[] brows = {"chrom","firefox","safari"};
            for (String b:brows){
                Page page = preConditionDelivery(b,playwright);
                page.fill("//input[@id='mat-input-8']","Tel Aviv");
                page.click("//input[@id='mat-input-9']");
                pause(500);
                page.click("//input[@id='mat-input-8']");
                pause(500);
                page.keyboard().press("ArrowDown");
                page.keyboard().press("Enter");
                page.fill("//input[@id='mat-input-0']","Rishon");
                page.click("//input[@id='mat-input-1']");
                pause(500);
                page.click("//input[@id='mat-input-0']");
                pause(500);
                page.keyboard().press("ArrowDown");
                page.keyboard().press("Enter");

                page.click("//span[contains(text(),'קטן')]");
                page.click("// b[contains(text(),'מהיום להיום')]");
                page.click("//span[contains(text(),'לסיכום והזמנה')]");

                page.locator("//div[@class='gp-font-weight-normal gp-font-30']").isVisible();
            }
        }



    }

    public static void deliveryPriceChange(){
        try (Playwright playwright = Playwright.create()){
            String[] brows = {"chrom","firefox","safari"};
            for (String b:brows){
                Page page = preConditionDelivery(b,playwright);
                page.fill("//input[@id='mat-input-8']","Tel Aviv");
                page.click("//input[@id='mat-input-9']");
                pause(600);
                page.click("//input[@id='mat-input-8']");
                pause(500);
                page.keyboard().press("ArrowDown");
                page.keyboard().press("Enter");
                page.fill("//input[@id='mat-input-0']","Rishon");
                page.click("//input[@id='mat-input-1']");
                pause(500);
                page.click("//input[@id='mat-input-0']");
                pause(500);
                page.keyboard().press("ArrowDown");
                page.keyboard().press("Enter");

                page.click("//span[contains(text(),'קטן')]");


                page.click("// b[contains(text(),'מהיום להיום')]");
                Locator priceBefore = page.locator("//*[text()=' ₪30.00 ']");
                page.click("//b[contains(text(),'אקספרס')]");
                Locator priceAfter = page.locator("//*[text()='  ₪94.44 ']");
               if(priceBefore!=priceAfter){
                   System.out.println("The test success: the price is changeable");
               } else System.out.println("The test fault");
            }
        }



    }

    public static void pause(int millis){

           try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


