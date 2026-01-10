package GameOfLife;

import javax.swing.*;

class Window extends JFrame {

  Window(boolean predictDies) {
    setSize(1200, 900);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Canvas canvas = new Canvas(this, predictDies);
    addKeyListener(new Key(canvas));
    addMouseListener(new Mouse(canvas));
    add(canvas);
  }

  void start() {
    setVisible(true);
  }
}
