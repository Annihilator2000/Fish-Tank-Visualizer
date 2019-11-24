package uoft.csc207.fishtank;

public class HungryFish extends Fish {

  /**
   * Constructs a new hungry fish.
   *
   * @param x the first coordinate.
   * @param y the second coordinate.
   * @param tank the fish tank to which this fish belongs to.
   */
  public HungryFish(int x, int y, FishTankManager tank) {
    super(x, y, "><MEHUNGRY>", tank);
  }
}
