import com.microsoft.playwright.*;

import java.util.ArrayList;

public class LoginTests extends TestBase{

    public static void LoginSuccessTest(String loginPage) {

        try (Playwright playwright = Playwright.create()) {

            Browser chrome = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContextChrome = chrome.newContext();
            Browser firefox = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContextFirefox = firefox.newContext();
            Browser safari = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContextSafari = safari.newContext();

            ArrayList<BrowserContext> brow = new ArrayList<>();
            brow.add(browserContextChrome);
            brow.add(browserContextFirefox);
            brow.add(browserContextSafari);

            for (BrowserContext br : brow) {
                Page page = br.newPage();
                page.navigate(loginPage);
                page.click("//*[contains(text(),'כתובת אימייל וסיסמה')]");
                page.fill("//input[@formcontrolname='userName']", "bunkof33@gmail.com");
                page.fill("//input[@formcontrolname='password']", "Playwright1!");
                page.click(".gp-submit");
                page.isVisible("//gp-sidebar[@class='gp-max-height']//i[@class='material-icons-outlined lng-side'][normalize-space()='login']");//assert
            }
        }
    }


    public static void LoginNegativeTestWrongLogin (String loginPage){

        try (Playwright playwright = Playwright.create()) {
            Browser chrome = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContextChrome = chrome.newContext();
            Browser firefox = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContextFirefox = firefox.newContext();
            Browser safari = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContextSafari = safari.newContext();

            ArrayList<BrowserContext> brow = new ArrayList<>();
            brow.add(browserContextChrome);
            brow.add(browserContextFirefox);
            brow.add(browserContextSafari);

            for (BrowserContext br : brow) {
                Page page  = br.newPage();
                page.navigate(loginPage);
                page.click("//*[contains(text(),'כתובת אימייל וסיסמה')]");
                page.fill("//input[@formcontrolname='userName']","bunkof33@gmail.c");
                page.fill("//input[@formcontrolname='password']", "Playwright1!");
                page.click(".gp-submit");
                page.isVisible("//*[@class='gp-font-16 ng-star-inserted']");//assert
                page.click("//mat-icon[normalize-space()='close']");

            }
        }
    }

    public static void LoginNegativeTestWrongLoginPassword(String loginPage){

        try (Playwright playwright = Playwright.create()) {
            Browser chrome = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContextChrome = chrome.newContext();
            Browser firefox = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContextFirefox = firefox.newContext();
            Browser safari = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContextSafari = safari.newContext();

            ArrayList<BrowserContext> brow = new ArrayList<>();
            brow.add(browserContextChrome);
            brow.add(browserContextFirefox);
            brow.add(browserContextSafari);

            for (BrowserContext br : brow) {
                Page page  = br.newPage();
                page.navigate(loginPage);
                page.click("//*[contains(text(),'כתובת אימייל וסיסמה')]");
                page.fill("//input[@formcontrolname='userName']","bunkof33@gmail.com");
                page.fill("//input[@formcontrolname='password']", "Playwright1");
                page.click(".gp-submit");
                page.isVisible("//*[@class='gp-font-16 ng-star-inserted']");//assert
                page.click("//mat-icon[normalize-space()='close']");}
        }
}
}
