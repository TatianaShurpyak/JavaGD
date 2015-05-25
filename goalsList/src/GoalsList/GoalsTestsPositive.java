package GoalsList;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import GoalsList.Main;
import GoalsList.Main.Goal;

public class GoalsTestsPositive {
    public Goal goal;

    @BeforeTest
    public void setUp () {
        goal = new Goal();
    }

    @Test //create new goal and check that it is added to the list
    public void creatingGoal() {
        GoalsList.Main.createGoal(goal, 1, "First name", "New goal can be created", false);
        Assert.assertEquals(goal.id, 1);
        Assert.assertEquals(goal.Name, "First name");
        Assert.assertEquals(goal.Description, "New goal can be created");
        Assert.assertEquals(goal.isReached, false);

        Assert.assertTrue(GoalsList.Main.listOfGoals.contains(goal));
        Assert.assertEquals(Main.listOfGoals.get(Main.listOfGoals.size() - 1).id, goal.id);
        Assert.assertEquals(Main.listOfGoals.get(Main.listOfGoals.size() - 1).Name, goal.Name);
        Assert.assertEquals(Main.listOfGoals.get(Main.listOfGoals.size() - 1).Description, goal.Description);
        Assert.assertEquals(Main.listOfGoals.get(Main.listOfGoals.size() - 1).isReached, goal.isReached);
    }


    @Test //editing goal and checking that list is updated
    public void editingGoal() {
        GoalsList.Main.editGoal(goal, 6, "New name", "New description", false);
        Assert.assertEquals(goal.id, 6);
        Assert.assertEquals(goal.Name, "New name");
        Assert.assertEquals(goal.Description, "New description");
        Assert.assertEquals(goal.isReached, false);

        Assert.assertTrue(GoalsList.Main.listOfGoals.contains(goal));
        Assert.assertEquals(Main.listOfGoals.get(Main.listOfGoals.size() - 1).id, goal.id);
        Assert.assertEquals(Main.listOfGoals.get(Main.listOfGoals.size() - 1).Name, goal.Name);
        Assert.assertEquals(Main.listOfGoals.get(Main.listOfGoals.size() - 1).Description, goal.Description);
        Assert.assertEquals(Main.listOfGoals.get(Main.listOfGoals.size() - 1).isReached, goal.isReached);

    }

    @Test //setting a goal to reached
    public void settingGoalReached() {
        GoalsList.Main.createGoal(goal, 1, "Drinking", "We are setting goal to reached here", false);
        GoalsList.Main.setReached(goal, true);
        Assert.assertTrue(goal.isReached);
        Assert.assertTrue(Main.listOfGoals.get(Main.listOfGoals.size() - 1).isReached);
    }

    @Test //setting a goal to Unreached
    public void settingGoalUnreached() {
        GoalsList.Main.createGoal(goal, 1, "Drinking", "Make the goal unreached", true);
        GoalsList.Main.setReached(goal, false);
        Assert.assertFalse(goal.isReached);
        Assert.assertFalse(Main.listOfGoals.get(Main.listOfGoals.size() - 1).isReached);
    }
}
