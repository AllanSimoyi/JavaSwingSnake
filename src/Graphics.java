import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics extends JPanel implements ActionListener {
  // create timer to update ui at regular intervals
  private Timer timer = new Timer(100, this);
  private Snake snake;
  private Food food;
  private Game game;
  public String state;

  public Graphics(Game game) {
    timer.start();
    state = "START";
    this.game = game;
    snake = this.game.getSnake();
    food = this.game.getFood();
    this.addKeyListener(this.game);
    this.setFocusable(true);
    this.setFocusTraversalKeysEnabled(false);
  }

  public void paintComponent(java.awt.Graphics graphics) {
    super.paintComponent(graphics);
    Graphics2D g2d = (Graphics2D) graphics;
    g2d.setColor(Color.black);
    g2d.fillRect(0, 0, this.game.getWidth() * this.game.getDimension() + 5,
        this.game.getHeight() * this.game.getDimension() + 5);
    if (state == "START") {
      g2d.setColor(Color.white);
      g2d.drawString("Press Any Key", this.game.getWidth() / 2 * this.game.getDimension() - 40,
          this.game.getHeight() / 2 * this.game.getDimension() - 20);
    } else if (state == "RUNNING") {
      g2d.setColor(Color.red);
      g2d.fillRect(food.getX() * this.game.getDimension(), food.getY() * this.game.getDimension(),
          this.game.getDimension(), this.game.getDimension());
      g2d.setColor(Color.green);
      for (Rectangle rectangle : snake.getBody()) {
        g2d.fill(rectangle);
      }
    } else {
      g2d.setColor(Color.white);
      g2d.drawString("Your Score: " + (snake.getBody().size() - 3),
          this.game.getWidth() / 2 * this.game.getDimension() - 40,
          this.game.getHeight() / 2 * this.game.getDimension() - 20);
    }
  }

  // runs at intervals determined by timer
  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
    game.update();
  }

}