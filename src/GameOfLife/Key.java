package GameOfLife;

import java.awt.event.*;

class Key extends KeyAdapter {
  Canvas canvas;

  Key(Canvas canvas) {
    this.canvas = canvas;
  }

  public void keyPressed(KeyEvent e) {
    canvas.keyHandler(e.getKeyCode());
  }
}
