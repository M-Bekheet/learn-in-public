
import java.util.ArrayList;

public class ExerciseManagement {
  private ArrayList<Exercise> exercises;

  public ExerciseManagement() {
    exercises = new ArrayList<>();
  }

  public ArrayList<String> exerciseList() {
    ArrayList<String> list = new ArrayList<>();
    for (Exercise ex : exercises) {
      list.add(ex.getName());
    }

    return list;
  }

  public void add(String exercise) {

    exercises.add(new Exercise(exercise));
  }

  public void markAsCompleted(String exercise) {
    for (Exercise ex : exercises) {
      if (ex.getName().equals(exercise)) {
        ex.setCompleted(true);
      }
    }
  }

  public boolean isCompleted(String exercise) {
    for (Exercise ex : exercises) {
      if (ex.getName().equals(exercise))
        return ex.isCompleted();
    }
    return false;
  }

  public void remove(String exercise) {
    for (int i = 0; i < exercises.size(); i++) {
      if (exercises.get(i).getName().equals(exercise))
        exercises.remove(i);
    }

  }

}
