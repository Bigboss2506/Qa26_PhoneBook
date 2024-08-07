package tests;

import manager.DataProviderContact;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{


    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogget()){
            app.getHelperUser().login(new User().setEmail("jeka@gmail.com").setPassword("Bigboss2506$"));
        }

    }

    @Test(dataProvider = "contactSuccess", dataProviderClass = DataProviderContact.class)
    public void addContactSuccessAllFields(Contact contact){
        int i = (int) (System.currentTimeMillis()/1000%3600);


//        Contact contact = Contact.builder()
//                .name("Tony" + i)
//                .lastName("Stark")
//                .phone("3434343"+i)
//                .email("stark" +i+ "@gmail.com")
//                .address("NY")
//                .description("All Fields")
//                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
    //    app.getHelperContact().pause(1500);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test(dataProvider = "contactCSV", dataProviderClass = DataProviderContact.class)
    public void addContactSuccessAllFieldsCSV(Contact contact){
        int i = (int) (System.currentTimeMillis()/1000%3600);

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //    app.getHelperContact().pause(1500);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test(groups = {"smoke", "regress"})
    public void addContactSuccessReqFields(){

        int i = (int) (System.currentTimeMillis()/1000%3600);


        Contact contact = Contact.builder()
                .name("TonyReq")
                .lastName("Stark")
                .phone("34343433334")
                .email("stark@gmail.com")
                .address("NY")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
    //    app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactWrongName(){
        Contact contact = Contact.builder()
                .name("")
                .lastName("Stark")
                .phone("34343436665")
                .email("stark@gmail.com")
                .address("NY")
                .description("Wrong Name")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
    //    app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("")
                .phone("34343436565")
                .email("stark@gmail.com")
                .address("NY")
                .description("Wrong Last Name")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
    //    app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }
    @Test
    public void addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("34343431234")
                .email("stark@gmail.com")
                .address("")
                .description("Wrong Address")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
    //    app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }
    @Test(dataProvider = "contactWrongPhone", dataProviderClass = DataProviderContact.class)
    public void addNewContactWrongPhone(Contact contact){
//        Contact contact = Contact.builder()
//                .name("Tony")
//                .lastName("Stark")
//                .phone("")
//                .email("stark@gmail.com")
//                .address("NY")
//                .description("Wrong Phone")
//                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
    //    app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Phone not valid"));

    }
    @Test
    public void addNewContactWrongEmail(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("34343431233")
                .email("starkgmail.com")
                .address("NY")
                .description("Wrong Email")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
    //    app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid"));

    }
}
