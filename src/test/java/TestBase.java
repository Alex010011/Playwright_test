public class TestBase {

    public static void main(String[] args)  {


        String loginPage = "https://sender.getpackage.com/login";



        LoginTests.LoginSuccessTest(loginPage);

        LoginTests.LoginNegativeTestWrongLogin(loginPage);

        LoginTests.LoginNegativeTestWrongLoginPassword(loginPage);

        CreateDeliveryTests.addressPackageBefore();

        CreateDeliveryTests.deliveryTelAvivTelAvivSameDay();

        CreateDeliveryTests.deliveryEilatTelAvivOnlyExpress();

        CreateDeliveryTests.deliveryBeforeTime();

        CreateDeliveryTests.deliveryEmptyFields();

        CreateDeliveryTests.deliveryPriceChange();

    }




}



