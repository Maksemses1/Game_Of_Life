package src.GameOfLife;
import java.awt.event.*;

class Mouse extends MouseAdapter{
  Canvas canvas;

  Mouse(Canvas canvas){
    this.canvas = canvas;
  }

  public void mousePressed(MouseEvent e){
    canvas.mouseHandler(e.getX(), e.getY());
  }
}
