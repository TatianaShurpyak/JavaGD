package GoalsList;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import GoalsList.Main.*;
import GoalsList.Main.Goal;

public class GoalsTestsNegative {

    public Goal goal;
    public static ArrayList<Goal> listOfGoals;

    @BeforeTest
    public void setUp () {
        goal = new Goal();
        listOfGoals = new ArrayList<>();
    }

    @Test //giving too short name to Goal
    public void shortNameGoal() {
        GoalsList.Main.createGoal(goal, 5, "Drink", "New goal can be created", false);
        Assert.assertTrue(goal.badNameLength);
    }

    @Test //giving too long name to Goal
    public void longNameGoal() {
        GoalsList.Main.createGoal(goal, 5, "This goal name is supposed to be too long", "New goal can be created", false);
        Assert.assertTrue(goal.badNameLength);
    }

    @Test //giving too short name to Description
    public void shortNameDesc() {
        GoalsList.Main.createGoal(goal, 5, "Goal name", "Too short", false);
        Assert.assertTrue(goal.badDescLength);
    }

    @Test //giving too long name to Description
    public void longNameDesc() {
        GoalsList.Main.createGoal(goal, 5, "Goal name", "Too long description will be this one. Let's make it even more than that, and more and more", false);
        Assert.assertTrue(goal.badDescLength);
    }

    @Test //goal name contains bad characters
    public void badCharactersName() {
        GoalsList.Main.createGoal(goal, 5, "Goal && name", "New goal can be created", false);
        Assert.assertTrue(goal.wrongCharsDetected);
    }

    @Test //setting reached to already reached goal
         public void setReachedToReached() {
        GoalsList.Main.createGoal(goal, 5, "Goal name", "New goal can be created", true);
        GoalsList.Main.setReached(goal, true);
        Assert.assertTrue(goal.isReached);
    }

    @Test //setting Unreached to already Unreached goal
    public void setUnreachedToUnreached() {
        GoalsList.Main.createGoal(goal, 5, "Goal name", "New goal can be created", false);
        GoalsList.Main.setReached(goal, false);
        Assert.assertFalse(goal.isReached);
    }

    @Test //give bad name when editing and check that goal in the list remains the same
    public void setBadNameWhileEditing() {
        GoalsList.Main.createGoal(goal, 5, "Goal name", "New goal can be created", false);
        GoalsList.Main.editGoal(goal, 6, "^%$ bad name", "New description", false);
        Assert.assertTrue(goal.wrongCharsDetected);
        Assert.assertEquals(goal.Name, "Goal name");
        Assert.assertEquals(Main.listOfGoals.get(Main.listOfGoals.size() - 1).Name, "Goal name");
    }

}
