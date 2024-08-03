package tests;


import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class LoginTests extends TestBase {


    @BeforeMethod
    public void preCondition(){
        // if SIGN OUT present ---> logout
        if(app.getHelperUser().isLogget()){
            app.getHelperUser().logOut();
            logger.info("Before method logout finish");
        }
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password) {
        logger.info("Start test with name 'Login Success'");
        logger.info("Test data ---> email: " + email+ "& password: " + password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogget());
        logger.info("Assert check is element button 'Sign out' present");

    }




    @Test(dataProvider = "loginModels", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
        logger.info("Test data ---> " + user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogget());
        logger.info("Assert check is element button 'Sign out' present");

    }

    @Test(dataProvider = "loginFile", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDP(User user) {
        logger.info("Test data ---> " + user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
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