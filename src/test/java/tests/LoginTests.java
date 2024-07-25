package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @BeforeMethod
    public void preCondition(){
        // if SIGN OUT present ---> logout
        if(app.getHelperUser().isLogget()){
            app.getHelperUser().logOut();
            logger.info("Before method logout finish");
        }
    }

    @Test
    public void loginSuccess() {
        logger.info("Start test with name 'Login Success'");
        logger.info("Test data ---> email: 'mara@gmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com", "Mmar123456$");
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogget());
        logger.info("Assert check is element button 'Sign out' present");

    }
    @Test
    public void loginSuccessModel() {
        logger.info("Test data ---> email: 'mara@gmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com", "Mmar123456$");
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogget());
        logger.info("Assert check is element button 'Sign out' present");

    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test data ---> email: 'maragmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maragmail.com", "Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");


    }

    @Test
    public void loginWrongPassword(){
        logger.info("Test data ---> email: 'mara@gmail.com' & password: 'Mmar123'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com", "Mmar123");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");


    }
    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data ---> email: 'bubu@gmail.com' & password: 'Bubu123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("bubu@gmail.com", "Bubu123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }
}