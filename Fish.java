package uoft.csc207.fishtank;

import android.graphics.Color;

/** A fish. */
public class Fish extends FishTankItem {

  /** Indicates whether this fish is moving right. */
  private boolean goingRight;

  /**
   * Constructs a new fish in the specified coordinates(x, y) and in the particular fish tank.
   *
   * @param x the first coordinate.
   * @param y the second coordinate.
   * @param tank the fish tank to which this fish belongs to.
   */
  public Fish(int x, int y, FishTankManager tank) {
    super(x, y, "><>", tank);
    paintText.setColor(Color.CYAN);
    goingRight = true;
  }

  /**
   * Constructs a new fish in the specified coordinates(x, y) and in the particular fish tank.
   *
   * @param x the first coordinate.
   * @param y the second coordinate.
   * @param looks how the fish appears in the fish tank
   * @param tank the fish tank to which this fish belongs to.
   */
  public Fish(int x, int y, String looks, FishTankManager tank) {
    super(x, y, looks, tank);
    paintText.setColor(Color.BLUE);
    goingRight = true;
  }

  /** Return whether this Fish is going right or not. */
  boolean getDirection() {
    return goingRight;
  }

  /** Causes this fish to blow a bubble. */
  private void blowBubble() {
    Bubble b = new Bubble(firstCoordinate, secondCoordinate, myTank);
    System.out.println(secondCoordinate + " " + firstCoordinate);
    myTank.getMyLittleFishes().add(myTank.getMyLittleFishes().indexOf(this), b);
  }

  /** Build and initialize this fish's forward and backward appearances. */
  private String reverseAppearance() {
    if (this instanceof HungryFish) {
      System.out.println("Turning around" + this.appearance);
    }
    StringBuilder reverse = new StringBuilder();
    for (int i = appearance.length() - 1; i >= 0; i--) {
      switch (appearance.charAt(i)) {
        case '>':
          reverse.append('<');
          break;
        case '<':
          reverse.append('>');
          break;
        default:
          reverse.append(appearance.charAt(i));
          break;
      }
    }
    if (this instanceof HungryFish) {
      System.out.println("Turned around" + reverse.toString());
    }
    return reverse.toString();
  }

  /** Turns this fish around, causing it to reverse direction. */
  private void turnAround() {
    goingRight = !goingRight;
    appearance = reverseAppearance();
  }

  /**
   * Causes this item to take its turn in the fish-tank simulation.
   *
   * @param tankWidth the width of the FishTank
   */
  void move(int tankWidth) {
    // Figure out whether whether this fish turn around.
    double d = Math.random();
    if (d < 0.1) {
      turnAround();
    }

    // Move one spot to the right or left in the direction this fish is going. If the fish
    // bump into a wall, turn around.
    if (goingRight) {
      if (firstCoordinate == tankWidth) {
        turnAround();
      } else {
        firstCoordinate += 1;
      }
    } else {
      if (firstCoordinate == 0) {
        turnAround();
      } else {
        firstCoordinate -= 1;
      }
    }

    // Figure out whether this fish blow a bubble.
    double l = Math.random();
    if (l < 0.1) {
      blowBubble();
    }

    // Figure out whether this fish move up or down, or neither.
    double k = Math.random();
    if (k < 0.1) {
      if (secondCoordinate != myTank.getGridHeight()) {
        secondCoordinate += 1;
      }

    } else if (k < 0.2) {
      if (secondCoordinate != 0) {
        secondCoordinate -= 1;
      }
    }
  }
}
