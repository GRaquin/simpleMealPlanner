package services;

import systemAccess.PersistenceBoundary;
import presentation.UserInterfaceBoundary;

import java.io.*;

public class MealPlannerHelper implements Serializable {


  private static final long serialVersionUID = 1L;
  private PersistenceBoundary persistenceBoundary;
  private UserInterfaceBoundary userInterfaceBoundary;
  private MealListHelper mealListHelper;
  /* startUp method
	 
	 creates PersistenceBoundary object persistenceBoundary
	 creates UserInterfaceBoundary object userInterfaceBoundary
	 creates MealListHelper object mealListHelper
	 calls main.java.presentation.Main Menu method
	 
	 This method is called by the main method.
	*/

  public void startUp() {
    persistenceBoundary = new PersistenceBoundary();
    userInterfaceBoundary = new UserInterfaceBoundary();
    mealListHelper = new MealListHelper();

    persistenceBoundary.load(mealListHelper);

    mainMenu();
  }
	
	 
	 /* main.java.presentation.Main Menu
		Acts as the core operations loop. Also acts as handler for unexpected errors. An error logging method will be added in the
		next version.
		
		This method is called by MealPlannerHelper's startUp method only. Once a function, like creating a meal or a meal plan, is done
		the user should return to this loop on its own.
	 */

  private void mainMenu() {
    boolean loop = true;
    while (loop) {
      int input = userInterfaceBoundary.displayMainMenu();
      switch (input) {
        case 1:
          userInterfaceBoundary.createMeal(mealListHelper);
          persistenceBoundary.save(mealListHelper);
          break;
        case 2:
          userInterfaceBoundary.displayMealList(mealListHelper);
          break;
        case 3:
          userInterfaceBoundary.deleteMeal(mealListHelper);
          persistenceBoundary.save(mealListHelper);
          break;
        case 4:
          userInterfaceBoundary.editMeal(mealListHelper);
          persistenceBoundary.save(mealListHelper);
          break;
        case 5:
          userInterfaceBoundary.mealPlan(mealListHelper);
          break;
        case 0:
          loop = false;
          break;
        default:
          userInterfaceBoundary.genericMessage(input + " is an invalid choice. Try again.");
          break;
      }
    }
  }


}
