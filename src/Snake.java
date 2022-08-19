import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
  private ArrayList<Rectangle> body;
  private int width = Game.width;
  private int height = Game.height;
  private int dimension = Game.dimension;
  private String move; // NOTHING, UP, DOWN, LEFT, RIGHT

  public Snake() {
    body = new ArrayList<>();
    Rectangle newRectangle = new Rectangle(Game.dimension, Game.dimension);
    newRectangle.setLocation(Game.width / 2 * Game.dimension, Game.height / 2 * Game.dimension);
    body.add(newRectangle);
    newRectangle = new Rectangle(dimension, dimension);
    newRectangle.setLocation((width / 2 - 1) * dimension, (height / 2) * dimension);
    body.add(newRectangle);
    newRectangle = new Rectangle(dimension, dimension);
    newRectangle.setLocation((width / 2 - 2) * dimension, (height / 2) * dimension);
    body.add(newRectangle);
    move = "NOTHING";
  }

  public void move() {
    if (move != "NOTHING") {
      Rectangle firstRectangle = body.get(0);
      Rectangle newRectangle = new Rectangle(Game.dimension, Game.dimension);
      if (move == "UP") {
        newRectangle.setLocation(firstRectangle.x, firstRectangle.y - Game.dimension);
      } else if (move == "DOWN") {
        newRectangle.setLocation(firstRectangle.x, firstRectangle.y + Game.dimension);
      } else if (move == "LEFT") {
        newRectangle.setLocation(firstRectangle.x - Game.dimension, firstRectangle.y);
      } else {
        newRectangle.setLocation(firstRectangle.x + Game.dimension, firstRectangle.y);
      }
      body.add(0, newRectangle);
      body.remove(body.size() - 1);
    }
  }

  public void grow() {
    Rectangle firstRectangle = body.get(0);
    Rectangle newRectangle = new Rectangle(Game.dimension, Game.dimension);
    if (move == "UP") {
      newRectangle.setLocation(firstRectangle.x, firstRectangle.y - Game.dimension);
    } else if (move == "DOWN") {
      newRectangle.setLocation(firstRectangle.x, firstRectangle.y + Game.dimension);
    } else if (move == "LEFT") {
      newRectangle.setLocation(firstRectangle.x - Game.dimension, firstRectangle.y);
    } else {
      newRectangle.setLocation(firstRectangle.x + Game.dimension, firstRectangle.y);
    }
    body.add(0, newRectangle);
  }

  public ArrayList<Rectangle> getBody() {
    return body;
  }

  public void setBody(ArrayList<Rectangle> body) {
    this.body = body;
  }

  public int getX() {
    return body.get(0).x;
  }

  public int getY() {
    return body.get(0).y;
  }

  public String getMove() {
    return move;
  }

  public void up() {
    move = "UP";
  }

  public void down() {
    move = "DOWN";
  }

  public void left() {
    move = "LEFT";
  }

  public void right() {
    move = "RIGHT";
  }
}