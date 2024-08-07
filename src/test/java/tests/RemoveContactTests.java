package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{


    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogget()){
            app.getHelperUser().login(new User().setEmail("jeka@gmail.com").setPassword("Bigboss2506$"));
        }

        app.getHelperContact().provideContacts();

    }


    @Test(groups = {"smoke"})
    public void removeFirstContact(){
        Assert.assertEquals(app.getHelperContact().removeOneContact(), 1);

    }
    @Test
    public void removeAllContacts(){
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperUser().isNoContactsDisplayed());


    }
}
