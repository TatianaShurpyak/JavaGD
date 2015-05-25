package GoalsList;

import java.util.ArrayList;

public class Main {

    public static class Goal {
        int id;
        String Name;
        String Description;
        boolean isReached;
        boolean badNameLength = false;
        boolean wrongCharsDetected = false;
        boolean badDescLength = false;

        public void Goal() {}
    }

    public static class User {
        String FirstName;
        String LastName;
        String NickName;
        String PhoneNumber;

        public void User() {}
    }

    public static ArrayList<Goal> listOfGoals = new ArrayList<>();

    public static void createUser(User user, String FirstName, String LastName, String NickName, String PhoneNumber) {
        user.FirstName = FirstName;
        user.LastName = LastName;
        user.NickName = NickName;
        user.PhoneNumber = PhoneNumber;
    }

    public static void createGoal(Goal goal, int id, String Name, String Description, boolean isReached) {

        goal.id = id;
        goal.isReached = isReached;

        try {
            // validate Name length
            if (Name.length() > 20 || Name.length() < 6) throw new WrongGoalNameLengthException();

            // validate Name characters
            String invalidCharacters = "!@#$%^&*(){}”|?><:?’ ";
            for (int i = 0; i < invalidCharacters.length()-1; i++) {
                if (Name.contains(invalidCharacters.substring(i, i + 1)))
                    throw new InvalidCharactersInGoalNameException();
            }

            goal.Name = Name;

            // validate Description length
            if (Description.length() > 50 || Description.length() < 10)
                throw new WrongGoalDescriptionLengthException();

            goal.Description = Description;

            addGoal(listOfGoals, goal);

        } catch (WrongGoalNameLengthException e) {
            goal.badNameLength = true;
            System.out.println("Goal name length is not valid. Must be from 6 to 20.");
        } catch (InvalidCharactersInGoalNameException e) {
            goal.wrongCharsDetected = true;
            System.out.println("Goal name contains invalid characters. Must not contact any of !@#$%^&*(){}”|?><:?’");
        } catch (WrongGoalDescriptionLengthException e) {
            goal.badDescLength = true;
            System.out.println("Goal description length is not valid. Must be from 10 to 50.");
        }

    }

    public static void editUserPhoneNumber (User user, String string) {
        user.PhoneNumber = string;
    }
    public static void editUserNickName (User user, String string) {
        user.NickName = string;
    }

    public static void addGoal (ArrayList<Goal> listOfGoals, Goal goal) {
        listOfGoals.add(goal);
    }

    public static void editGoal (Goal goal, int id, String name, String Description, boolean isReached) {
        createGoal(goal, id, name, Description, isReached);
        listOfGoals.remove(goal);
        listOfGoals.add(goal);
    }

    public static void setReached (Goal goal, boolean isReached) {
        listOfGoals.remove(goal);
        goal.isReached = isReached;
        listOfGoals.add(goal);
    }

    static class WrongGoalNameLengthException extends Exception {
    }
    static class InvalidCharactersInGoalNameException extends Exception {
    }
    static class WrongGoalDescriptionLengthException extends Exception {
    }


}


