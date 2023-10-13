package ticTacToe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Grid {
  private Role[] grid;
  private Role role;
  private Label header;
  private Role winner;

  public Grid(Label header) {
    grid = new Role[9];
    role = Role.X;
    this.header = header;
  }

  public GridPane getView() {
    GridPane grid = new GridPane();
    for (int x = 0; x < 3; x++) {
      for (int y = 0; y < 3; y++) {
        Button btn = getButton(x, y);
        grid.add(btn, x, y);
      }
    }

    return grid;
  }

  private Button getButton(int x, int y) {
    Button btn = new Button(" ");
    btn.setFont(Font.font("Monospaced", 40));

    btn.setOnAction(e -> {
      if (winner != null)
        return;

      String btnText = btn.getText().trim();
      if (btnText.isEmpty()) {
        btn.setText(role.name());
        int gridIndex = x * 3 + y;
        grid[gridIndex] = role;

        boolean isWinner = checkWinner(role);
        if (isWinner) {
          System.out.println(role + " is winner");
          winner = role;
        }
        role = role == Role.X ? Role.O : Role.X;
        updateHeader();
      }
    });
    return btn;
  }

  private void updateHeader() {
    String text = "Turn: " + role;

    if (winner != null) {
      text = "The end!";
    } else {
      // check that all buttons are reserved
      boolean allReserved = true;
      for (Role role : grid) {
        if (role == null) {
          allReserved = false;
          break;
        }
      }
      if (allReserved)
        text = "The end!";
    }

    header.setText(text);
  }

  private boolean checkWinner(Role role) {
    /*
     * Grid:
     ** 0 1 2
     ** 3 4 5
     ** 6 7 8
     */

    String[] winningCases = {
        "012", "345", "678", // rows
        "036", "147", "358", // columns
        "048", "246" // diagonals
    };
    for (int i = 0; i < winningCases.length; i++) {
      String indexes = winningCases[i];
      int firstIndex = Integer.valueOf(indexes.split("")[0]);
      int secondIndex = Integer.valueOf(indexes.split("")[1]);
      int thirdIndex = Integer.valueOf(indexes.split("")[2]);

      boolean isWinner = grid[firstIndex] == role && grid[secondIndex] == role && grid[thirdIndex] == role;
      if (isWinner)
        return true;
    }

    return false;
  }

}
