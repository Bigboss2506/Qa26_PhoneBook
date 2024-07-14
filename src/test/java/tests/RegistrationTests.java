package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class RegistrationTests  extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogget()){
            app.getHelperUser().logOut();
        }

}

        @Test
    public void registrationSuccess(){
        //jek?@gmail.com
        //Bigboss123456$
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().setEmail("jek" + i + "@gmail.com").setPassword("Bigboss123456$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogget());
        Assert.assertTrue(app.getHelperUser().isNoContactsDisplayed());
    }

    @Test(description = "Bug report #23456 Fixed")
    public void registrationWrongEmail(){

        User user = new User().setEmail("jekgmail.com").setPassword("Bigboss123456$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }

    @Test
    public void registrationWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().setEmail("jek@gmail.com").setPassword("Big123");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }

    @Test
    public void registrationExistsUser(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().setEmail("mara@gmail.com").setPassword("Mmar123456$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));

    }














}
