package GameOfLife;

import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
    boolean predictDies = false;
    
    GameDrawer drawer;
    GameLogic logic;

    GameField field;

    Canvas (Window window, boolean predictDies, int CELL_SIZE){
        this.predictDies = predictDies;
        init(window, CELL_SIZE);
    }

    void init(Window window, int CELL_SIZE){
        this.field = new GameField(
            (int) (window.getHeight() / CELL_SIZE),
            (int) (window.getWidth() / CELL_SIZE),
            CELL_SIZE);
        this.drawer = new GameDrawer(field);
        this.logic = new GameLogic(field);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawer.drawField(g);
    }


    void keyHandler(int key) {
        if (key == 32) {
            field.setMatrix(logic.nextStep());
            if(predictDies){
                field.setMatrix(logic.predictDies());
            }
            repaint();
        }
    }

    void mouseHandler(int x, int y) {
        int xCoord = (int) (x / field.CELL_SIZE);
        int yCoord = (int) (y / field.CELL_SIZE);

        if(field.getCell(xCoord, yCoord) == 0) field.setCell(xCoord, yCoord, 1);
        else field.setCell(xCoord, yCoord, 0);
        repaint();
    }
}
