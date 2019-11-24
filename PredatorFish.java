package uoft.csc207.fishtank;

import android.graphics.Color;

public class PredatorFish extends Fish {

  /** Number of fish consumed by this predator fish */
  private int consumedNum;

  /** Number of fish this fish can consume before it is full */
  private int consuming_limit;

  /**
   * Constructs a new predator fish.
   *
   * @param x the first coordinate.
   * @param y the second coordinate.
   * @param limit the number of Fish this fsh can eat.
   * @param tank the fish tank to which this fish belongs to.
   */
  public PredatorFish(int x, int y, int limit, FishTankManager tank) {
    super(x, y, "><PREDATOR>", tank);
    this.consumedNum = 0;
    this.consuming_limit = limit;
    paintText.setColor(Color.RED);
  }
  /**
   * Checks whether a fish is in the close vicinity of this fish and whether this fish is correctly
   * oriented to consume the other fish.
   *
   * @param TankItem The FishTankItem near this Fish.
   */
  private boolean check_vicinity(FishTankItem TankItem) {
    if (getDirection()) {
      return 0 <= (TankItem.firstCoordinate - this.firstCoordinate)
          && (TankItem.firstCoordinate - this.firstCoordinate) <= 7;
    } else {
      return 0 <= (this.firstCoordinate - TankItem.firstCoordinate)
          && (this.firstCoordinate - TankItem.firstCoordinate) <= 5;
    }
  }

  @Override
  void move(int tankWidth) {
    super.move(tankWidth);
    for (int i = 0; i < myTank.getMyLittleFishes().size(); i++) {
      if ((myTank.getMyLittleFishes().get(i) instanceof Fish)
          && !(myTank.getMyLittleFishes().get(i) instanceof HungryFish)
          && !(myTank.getMyLittleFishes().get(i) instanceof PredatorFish)) {
        if ((myTank.getMyLittleFishes().get(i).secondCoordinate == this.secondCoordinate)
            && (this.check_vicinity(myTank.getMyLittleFishes().get(i)))) {
          if (consumedNum != consuming_limit) {
            myTank.getMyLittleFishes().remove(myTank.getMyLittleFishes().get(i));
            System.out.println("I just ate another fish!");
            System.out.println("I have consumed " + ++this.consumedNum + " fish in total!");
            if (consumedNum == consuming_limit) {
              paintText.setColor(Color.GREEN);
            }
            break;
          } else {
            System.out.println("I am full, I cannot eat more fish!!");
          }
        }
      }
    }
  }
}
