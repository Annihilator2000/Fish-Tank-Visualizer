package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;

public class Seaweed extends FishTankItem {
  /** The number of weed segments. */
  private int weedLength;

  /** Indicates whether the bottom segment is leaning right. */
  private boolean leanRight;

  /**
   * Constructs a new seaweed item at the specified cursor location (x,y),l segments tall.
   *
   * @param x the x coordinate of the bubble's cursor location.
   * @param y the y coordinate of the bubble's cursor location.
   * @param len the number of segments this seaweed is tall.
   */
  public Seaweed(int len, int x, int y) {
    super(x, y);
    this.weedLength = len;
    paintText.setColor(Color.GREEN);
  }

  @Override
  void draw(Canvas canvas) {

    // Decide which way does the first segment lean.
    boolean lR = leanRight;

    for (int i = 0;
        i < weedLength;
        i++) { // Draw a "/" seaweed segment: even numbered and leaning to the right.
      if (i % 2 == 0) {
        if (lR) {
          // Draw the string "/" if its leaning right.
          drawString(canvas, "/", -i + firstCoordinate, secondCoordinate);
        } else {
          // Draw the string "\" if its leaning left.
          drawString(canvas, "\\", -i + firstCoordinate, secondCoordinate);
        }
      } else {
        if (lR) { // Draw a "\" seaweed segment: odd numbered and leaning to the left.
          // Draw the string "\" if its leaning right.
          drawString(canvas, "\\", -i + firstCoordinate, secondCoordinate);
        } else {
          // Draw the string "/" if its leaning right.
          drawString(canvas, "/", -i + firstCoordinate, secondCoordinate);
        }
      }
    }
  }

  @Override
  void move() {
    leanRight = !leanRight;
  }
}
