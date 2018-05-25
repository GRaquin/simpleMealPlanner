package systemAccess.Exception;

public class MealExceptionFactory {

  public static void createDuplicateMealException(String mealName) throws DuplicateMealException {
    String errorMessage = "The meal called " + mealName + " already exists, please choose another name";
    throw new DuplicateMealException(errorMessage);
  }
}
