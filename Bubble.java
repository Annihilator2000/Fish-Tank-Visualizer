package uoft.csc207.fishtank;

import android.graphics.Color;

/** A bubble. */
public class Bubble extends FishTankItem {

  /** Constructs a new bubble at the specified cursor location (x, y) and in specified fish tank. */
  public Bubble(int x, int y, FishTankManager tank) {
    super(x, y, ".", tank);
    paintText.setColor(Color.LTGRAY);
  }

  /** Causes this item to take its turn in the fish-tank simulation, moving straight up. */
  private void grow() {

    // Figure out whether to grow, if at all.
    double shift = Math.random();
    // Occasionally change a . to a o or a o to a O
    if (shift < 0.05) {
      // If the appearance is a ., change it to an o
      if (appearance.equals(".")) {
        appearance = "o";
      }
      // If the appearance is an o, change it to a O
      else if (appearance.equals("o")) {
        appearance = "O";
      }
    }
  }

  @Override
  void move() {
    if (secondCoordinate <= 0) {
      myTank.getMyLittleFishes().remove(this);
    } else {
      double shift = Math.random();
      if (shift < 0.33) { // float straight up by one.
        secondCoordinate--;
      } else if (shift < 0.66) { // float straight up and move right if not at the edge of screen.
        if (firstCoordinate != myTank.getGridWidth()) {
          firstCoordinate++; // move right by one.
        }
        secondCoordinate--;
      } else {
        if (firstCoordinate != 0) { // float straight up and move left if not at the edge of screen.
          firstCoordinate--; // move left by one.
        }
        secondCoordinate--;
      }
      this.grow();
    }
  }
}
