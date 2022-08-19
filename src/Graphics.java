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

  public Graphics(Game g) {
    timer.start();
    state = "START";
    game = g;
    snake = g.getSnake();
    food = g.getFood();
    this.addKeyListener(g);
    this.setFocusable(true);
    this.setFocusTraversalKeysEnabled(false);
  }

  public void paintComponent(java.awt.Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.black);
    g2d.fillRect(0, 0, Game.width * Game.dimension + 5, Game.height * Game.dimension + 5);
    if (state == "START") {
      g2d.setColor(Color.white);
      g2d.drawString("Press Any Key", Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);
    } else if (state == "RUNNING") {
      g2d.setColor(Color.red);
      g2d.fillRect(food.getX() * Game.dimension, food.getY() * Game.dimension, Game.dimension, Game.dimension);
      g2d.setColor(Color.green);
      for (Rectangle r : snake.getBody()) {
        g2d.fill(r);
      }
    } else {
      g2d.setColor(Color.white);
      g2d.drawString("Your Score: " + (snake.getBody().size() - 3), Game.width / 2 * Game.dimension - 40,
          Game.height / 2 * Game.dimension - 20);
    }
  }

  // runs at intervals determined by timer
  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
    game.update();
  }

}