import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
  private ArrayList<Rectangle> body;
  private int gameDimension;
  private String move; // NOTHING, UP, DOWN, LEFT, RIGHT

  public Snake(int gameWidth, int gameHeight, int gameDimension) {
    this.gameDimension = gameDimension;
    body = new ArrayList<>();
    Rectangle newRectangle = new Rectangle(gameDimension, gameDimension);
    newRectangle.setLocation(gameWidth / 2 * gameDimension, gameHeight / 2 * gameDimension);
    body.add(newRectangle);
    newRectangle = new Rectangle(gameDimension, gameDimension);
    newRectangle.setLocation((gameWidth / 2 - 1) * gameDimension, (gameHeight / 2) * gameDimension);
    body.add(newRectangle);
    newRectangle = new Rectangle(gameDimension, gameDimension);
    newRectangle.setLocation((gameWidth / 2 - 2) * gameDimension, (gameHeight / 2) * gameDimension);
    body.add(newRectangle);
    move = "NOTHING";
  }

  public void move() {
    if (move != "NOTHING") {
      Rectangle firstRectangle = body.get(0);
      Rectangle newRectangle = new Rectangle(gameDimension, gameDimension);
      if (move == "UP") {
        newRectangle.setLocation(firstRectangle.x, firstRectangle.y - gameDimension);
      } else if (move == "DOWN") {
        newRectangle.setLocation(firstRectangle.x, firstRectangle.y + gameDimension);
      } else if (move == "LEFT") {
        newRectangle.setLocation(firstRectangle.x - gameDimension, firstRectangle.y);
      } else {
        newRectangle.setLocation(firstRectangle.x + gameDimension, firstRectangle.y);
      }
      body.add(0, newRectangle);
      body.remove(body.size() - 1);
    }
  }

  public void grow() {
    Rectangle firstRectangle = body.get(0);
    Rectangle newRectangle = new Rectangle(gameDimension, gameDimension);
    if (move == "UP") {
      newRectangle.setLocation(firstRectangle.x, firstRectangle.y - gameDimension);
    } else if (move == "DOWN") {
      newRectangle.setLocation(firstRectangle.x, firstRectangle.y + gameDimension);
    } else if (move == "LEFT") {
      newRectangle.setLocation(firstRectangle.x - gameDimension, firstRectangle.y);
    } else {
      newRectangle.setLocation(firstRectangle.x + gameDimension, firstRectangle.y);
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