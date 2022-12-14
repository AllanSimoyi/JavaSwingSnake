import java.awt.Rectangle;
import java.util.ArrayList;

public class Food {
  private int x;
  private int y;
  private int gameWidth;
  private int gameHeight;

  public Food(ArrayList<Rectangle> currentSnakePosition, int gameWidth, int gameHeight) {
    this.gameWidth = gameWidth;
    this.gameHeight = gameHeight;
    this.randomSpawn(currentSnakePosition);
  }

  public void randomSpawn(ArrayList<Rectangle> currentSnakePosition) {
    boolean onSnake = true;
    while (onSnake) {
      onSnake = false;
      x = (int) (Math.random() * gameWidth - 1);
      y = (int) (Math.random() * gameHeight - 1);
      for (Rectangle r : currentSnakePosition) {
        if (r.x == x && r.y == y) {
          onSnake = true;
        }
      }
    }
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
}