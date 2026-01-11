package GameOfLife;
import java.awt.*;

class GameDrawer{
  GameField field;


  GameDrawer(GameField field){
    this.field = field;
  }
  
  public void drawField(Graphics g) { 
    for (int y = 0; y < field.HEIGHT; y++) { 
      for (int x = 0; x < field.WIDTH; x++) {
        if (field.getCell(x, y) == 1) {
          fillRectColored(x, y, new Color(0, 0, 0), g);
        }
        else if(field.getCell(x, y) == 2){
          fillRectColored(x, y, new Color(80, 80, 80), g); 
        } 
        else {
          drawRectColored(x, y, new Color(0, 0, 0), g);
        }
      }  
    } 
  }

    void fillRectColored(int x, int y, Color col, Graphics g){
        Color previous = g.getColor();
        g.setColor(col);
        g.fillRect(x*field.CELL_SIZE, y*field.CELL_SIZE, field.CELL_SIZE, field.CELL_SIZE);
        g.setColor(previous);
    }

    void drawRectColored(int x, int y, Color col, Graphics g){
        Color previous = g.getColor();
        g.setColor(col);
        g.drawRect(x*field.CELL_SIZE, y*field.CELL_SIZE, field.CELL_SIZE, field.CELL_SIZE);
        g.setColor(previous);
    }
}
