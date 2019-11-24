package uoft.csc207.fishtank;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

public class FishTankManager {

  /** All the locations where a fish can be. */
  private List<FishTankItem> myLittleFishes;
  /** The width of myLittleFishes. */
  private int gridWidth;
  /** The height of myLittleFishes. */
  private int gridHeight;

  /**
   * The fish tank manager on a screen with height rows and width columns.
   *
   * @param height the depth of the fish tank
   * @param width the width of the fish tank
   */
  public FishTankManager(int height, int width) {
    gridHeight = height;
    gridWidth = width;
    myLittleFishes = new ArrayList<>();
  }
  /** Return the width of a row of locations. */
  int getGridWidth() {
    return gridWidth;
  }

  /** Return the height of a column of locations. */
  int getGridHeight() {
    return gridHeight;
  }

  /** Return the List containing the FishTankItems in this fish tank. */
  List<FishTankItem> getMyLittleFishes() {
    return myLittleFishes;
  }
  /**
   * Draw the FishTankItems in this fish tank onto the canvas.
   *
   * @param canvas the graphics context in which to draw the items in this fish tank.
   */
  void draw(Canvas canvas) {
    for (int i = 0; i < this.myLittleFishes.size(); i++) {
      this.myLittleFishes.get(i).draw(canvas);
    }
  }

  /** Update the coordinates of the FishTankItems in this fish tank by moving them. */
  void update() {
    for (int i = 0; i < this.myLittleFishes.size(); i++) {
      if (this.myLittleFishes.get(i) instanceof HungryFish) {
        ((HungryFish) this.myLittleFishes.get(i)).move(getGridWidth() - 7);
      } else if (this.myLittleFishes.get(i) instanceof PredatorFish) {
        ((PredatorFish) this.myLittleFishes.get(i)).move(getGridWidth() - 7);
      } else if (this.myLittleFishes.get(i) instanceof Fish) {
        ((Fish) this.myLittleFishes.get(i)).move(getGridWidth() - 1);
      } else {
        this.myLittleFishes.get(i).move();
      }
    }
  }

  /** Create or add new FishTankItems in this fish tank. */
  void createTankItems() {
    this.myLittleFishes.add(new Fish(28, 18, this));
    this.myLittleFishes.add(new Fish(10, 27, this));
    this.myLittleFishes.add(new Fish(17, 14, this));
    this.myLittleFishes.add(new Fish(15, 28, this));
    this.myLittleFishes.add(new Fish(30, 33, this));
    this.myLittleFishes.add(new Fish(16, 5, this));
    this.myLittleFishes.add(new Fish(16, 12, this));
    this.myLittleFishes.add(new Fish(16, 18, this));
    this.myLittleFishes.add(new Fish(23, 18, this));
    this.myLittleFishes.add(new Fish(6, 12, this));
    this.myLittleFishes.add(new HungryFish(10, 20, this));
    this.myLittleFishes.add(new PredatorFish(5, 18, 5, this));
    this.myLittleFishes.add(new Seaweed(9, 33, 4));
    this.myLittleFishes.add(new Seaweed(6, 24, 13));
    this.myLittleFishes.add(new Seaweed(12, 42, 15));
    this.myLittleFishes.add(new Seaweed(5, 13, 20));
  }
}
