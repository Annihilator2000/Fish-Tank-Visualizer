package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/** A fishTankItem. */
public class FishTankItem {
  /** Indicates the fish tank in which this fish swims. */
  FishTankManager myTank;

  /** This fish tank item's first coordinate. */
  int firstCoordinate;

  /** This fish tank item's second coordinate. */
  int secondCoordinate;

  /** How this FishTankItem appears on the screen. */
  String appearance;

  Paint paintText;

  /**
   * Constructs a new FishTankItem.
   *
   * @param x the first coordinate.
   * @param y the second coordinate.
   */
  public FishTankItem(int x, int y) {
    this.firstCoordinate = x;
    this.secondCoordinate = y;
    paintText = new Paint();
    paintText.setTextSize(36);
    paintText.setTypeface(Typeface.DEFAULT_BOLD);
  }

  /**
   * Constructs a new FishTankItem.
   *
   * @param x the first coordinate.
   * @param y the second coordinate.
   * @param looks how the fish appears in the fish tank
   * @param tank the fish tank to which this fish belongs to.
   */
  public FishTankItem(int x, int y, String looks, FishTankManager tank) {
    this.firstCoordinate = x;
    this.secondCoordinate = y;
    this.appearance = looks;
    this.myTank = tank;
    paintText = new Paint();
    paintText.setTextSize(36);
    paintText.setTypeface(Typeface.DEFAULT_BOLD);
  }

  /**
   * Draws the given string in the given graphics context at the given cursor location.
   *
   * @param canvas the canvas on which to draw this item.
   * @param s the string to draw.
   * @param x the x-coordinate of the string's cursor location.
   * @param y the y-coordinate of the string's cursor location.
   */
  void drawString(Canvas canvas, String s, int y, int x) {
    canvas.drawText(s, x * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
  }

  /**
   * Draws this fish tank item.
   *
   * @param canvas the canvas on which to draw this item.
   */
  void draw(Canvas canvas) {
    drawString(canvas, appearance, secondCoordinate, firstCoordinate);
  }

  /** Causes this item to take its turn in the fish-tank simulation. */
  void move() {}
}
