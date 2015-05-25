package GoalsList;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import GoalsList.Main.User;
import GoalsList.Main.Goal;

public class UserTestsPositive {

    public User user;

    @BeforeTest
    public void setUp () {
        user = new User();
    }

    @Test //creating user
    public void creatingUser() {
        Main.createUser(user, "Vasiliy", "Petrov", "Vaska", "958-658-8565");
        Assert.assertEquals(user.FirstName, "Vasiliy");
        Assert.assertEquals(user.LastName, "Petrov");
        Assert.assertEquals(user.NickName, "Vaska");
        Assert.assertEquals(user.PhoneNumber, "958-658-8565");
    }

    @Test //editing user phone number
    public void editUserPhoneNumber() {
        Main.editUserPhoneNumber(user, "118-338-8468");
        Assert.assertEquals(user.PhoneNumber, "118-338-8468");
    }

    @Test //editing user nickname number
    public void editUserNickName() {
        Main.editUserNickName(user, "Vasenka");
        Assert.assertEquals(user.NickName, "Vasenka");
    }
}
