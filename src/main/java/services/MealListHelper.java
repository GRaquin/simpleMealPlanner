package services;

import entity.Meal;
import systemAccess.Exception.DuplicateMealException;
import systemAccess.Exception.MealExceptionFactory;

import java.io.Serializable;
import java.util.ArrayList;

/* MealListHelper Class
 This class is where the list of meals is stored as well as the methods that access that list.
 */
public class MealListHelper implements Serializable {

  private static final long serialVersionUID = 1L;

  // Create Meal List array list: mealList
  private ArrayList<Meal> myMealList = new ArrayList<>();

	/* Create New Meal
   Checks to see if the meal name is already taken. If it hasn't the meal is added to myMealList.
	 
	 This method is called by:
	 		??? (Might be broken right now)
	 */

  public void createNewMeal(Meal m) {
    //While the method would work fine if it just adds the meal to myMealList calling checkDuplicateName() again makes the method more robust.
    boolean duplicate = checkDuplicateName(m.getName());
    if (duplicate) {
      // Should'nt append, but you know, Murphy's law
      MealExceptionFactory.createDuplicateMealException(m.getName());
    } else {
      myMealList.add(m);
    }
  }
	
	/* CheckDuplicateName
	 Checks to see if a name is already taken in myMealList. If there is a duplicate it returns a true value and lets the calling
	 method decide what to do from there.
	 
	 This method is called by:
	 		UserInterfaceBoundary's createNewMeal
	 		MealListHelper's createMealName
	 */

  public Boolean checkDuplicateName(String name) {
    Boolean duplicate = false;
    for (Meal meal : myMealList) {
      if (meal.getName().equals(name)) {
        duplicate = true;
        break;
      }
    }
    return duplicate;
  }
	
  public int getMyMealListSize() {
    return myMealList.size();
  }

  /* getMyMealListNames
   Creates a new array list called names. It then copies the name from each meal in myMealList and puts the names in names array list.
   Finally it returns the names array list.

   This method is called by:
       UserInterfaceBoundary displayMealList
   */
  public ArrayList<String> getMyMealListNames() {
    ArrayList<String> names = new ArrayList<>();
    for (Meal meal : myMealList) {
      names.add(meal.getName());
    }
    return names;
  }
	
	/* deleteMeal
	 Removes a meal from myMealList using the index location passed to it.
	 Also throws an error if the method doesn't work. The most likely cause of such an event is that the index provided is not in range.
	 
	 This method is called by:
	 		UserInterfaceBoundary's deleteMeal
	*/

  public void deleteMeal(int index) {
    try {
      myMealList.remove(index);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
	
	/* Set Meal Name 
	This method uses an index parameter provided by a previous method to select a meal and set it's name.
	Also throws an error if the method doesn't work. The most likely cause of such an event is that the index provided is not in range.
	
	This method is called by:
		UserInterface's editMeal
	 */

  public void setMealName(int index, String name) {
    try {
      myMealList.get(index).setName(name);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
	
	/* Get Meal Name
	This method gets a meal's name using the index provided.
	
	Calling methods should always check to make sure the index they are providing is not out of bounds, 
	but this method will return "OutOfBoundsError" if it doesn't work.
	
	This method is called by:
		UserInterfaceBoundary's deleteMeal
		""'s editMeal
	 */

  public String getMealName(int index) {
    try {
      return myMealList.get(index).getName();
    } catch (Exception ex) {
      String error = "OutOfBoundsError";
      ex.printStackTrace();
      return error;
    }
  }
	
	/* Get Meal List
	 Returns a copy of myMealList.
	 
	 This method is called by:
	 	PersistenceBoundary's save
	 */

  public ArrayList<Meal> getMealList() {
    return myMealList;
  }

  /* load Meal List
   Takes a list of meals provided and puts it into the myMealList variable.

   This method is called by:
     PersistenceBoundary's load
   */
  public void loadMealList(ArrayList<Meal> loadTemp) {
    myMealList = loadTemp;
  }

  /* Create Meal Plan
  Creates an array list of meal names drawn from mealList. It uses mealAmount to determine how big this array list should be.
  It then passes the array list back.

   This method is called by:
     UserInterfaceBoundary's mealPlan
   */
  public ArrayList<String> createMealPlan(int mealAmount) {

    // Initialisation des variables
    ArrayList<String> meals = new ArrayList<>();
    String name = getMeal();

    while (meals.size() < mealAmount) {
      if (!meals.contains(name)) {
        meals.add(name);
      }
      name = getMeal();
    }
    return meals;
  }

  private String getMeal() {
    int index = (int) (Math.random() * myMealList.size());
    Meal m = myMealList.get(index);
    return m.getName();
  }
}
