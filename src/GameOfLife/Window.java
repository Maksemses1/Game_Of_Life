package src.GameOfLife;
import javax.swing.*;

class Window extends JFrame{
  Window(){
    setSize(1200, 900);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    Canvas canvas = new Canvas(this);
    addKeyListener(new Key(canvas));
    addMouseListener(new Mouse(canvas));
    add(canvas);
  }
}

