import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game implements KeyListener {
  private Snake snake;
  private Food food;
  private Graphics graphics;
  private JFrame window;
  private final int width = 30;
  private final int height = 30;
  private final int dimension = 20;

  public Game() {
    window = new JFrame();
    snake = new Snake(width, height, dimension);
    food = new Food(snake.getBody(), width, height);
    graphics = new Graphics(this);
    window.add(graphics);
    window.setTitle("Snake");
    window.setSize(width * dimension + 2, height * dimension + dimension + 4);
    window.setVisible(true);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void start() {
    graphics.state = "RUNNING";
  }

  public void update() {
    if (graphics.state == "RUNNING") {
      if (hasEatenFood()) {
        snake.grow();
        food.randomSpawn(snake.getBody());
      } else if (hasCollidedWithWall() || hasCollidedWithSelf()) {
        graphics.state = "END";
      } else {
        snake.move();
      }
    }
  }

  private boolean hasCollidedWithWall() {
    if (snake.getX() < 0 || snake.getX() >= width * dimension
        || snake.getY() < 0 || snake.getY() >= height * dimension) {
      return true;
    }
    return false;
  }

  private boolean hasEatenFood() {
    if (snake.getX() == food.getX() * dimension && snake.getY() == food.getY() * dimension) {
      return true;
    }
    return false;
  }

  private boolean hasCollidedWithSelf() {
    for (int i = 1; i < snake.getBody().size(); i++) {
      if (snake.getX() == snake.getBody().get(i).x &&
          snake.getY() == snake.getBody().get(i).y) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (graphics.state == "RUNNING") {
      if (keyCode == KeyEvent.VK_W && snake.getMove() != "DOWN") {
        snake.up();
      }
      if (keyCode == KeyEvent.VK_S && snake.getMove() != "UP") {
        snake.down();
      }
      if (keyCode == KeyEvent.VK_A && snake.getMove() != "RIGHT") {
        snake.left();
      }
      if (keyCode == KeyEvent.VK_D && snake.getMove() != "LEFT") {
        snake.right();
      }
    } else {
      this.start();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getDimension() {
    return dimension;
  }

  public Snake getSnake() {
    return snake;
  }

  public void setSnake(Snake snake) {
    this.snake = snake;
  }

  public Food getFood() {
    return food;
  }

  public void setFood(Food food) {
    this.food = food;
  }

  public JFrame getWindow() {
    return window;
  }

  public void setWindow(JFrame window) {
    this.window = window;
  }

}