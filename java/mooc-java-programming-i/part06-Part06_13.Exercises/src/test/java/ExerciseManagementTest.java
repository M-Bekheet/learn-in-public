
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class ExerciseManagementTest {
  ExerciseManagement management;

  @Before
  public void initialize() {
    management = new ExerciseManagement();
  }

  @Test
  public void exerciseListEmptyAtBeginning() {
    assertEquals(0, management.exerciseList().size());
  }

  @Test
  public void addingExerciseGrowsListByOne() {
    management.add("Write a test");
    assertEquals(1, management.exerciseList().size());
  }

  @Test
  public void addedExerciseInList() {
    management.add("Mock Data");
    assertTrue(management.exerciseList().contains("Mock Data"));
  }

  @Test
  public void exerciseCanBeMarkedAsCompleted() {
    management.add("New exercise");
    management.markAsCompleted("New exercise");
    assertTrue(management.isCompleted("New exercise"));
  }

  @Test
  public void ifNotMarkedCompletedIsNotCompleted() {
    String exercise = "New Exercise";
    management.add(exercise);
    management.markAsCompleted(exercise);
    assertFalse(management.isCompleted("Other exercise"));
  }

  @Test
  public void exerciseCanBeDeleted() {
    management.add("Play at the Gym");
    management.add("Play Soccer");
    management.add("Do Jogging");

    management.remove("Play Soccer");
    assertFalse(management.exerciseList().contains("Play Soccer"));

  }

  @Test
  public void exerciseSizeCorrectAfterRemoval() {
    management.add("Play at the Gym");
    management.add("Play Soccer");
    management.add("Do Jogging");

    management.remove("Play Soccer");
    assertEquals(2, management.exerciseList().size());

  }

}
