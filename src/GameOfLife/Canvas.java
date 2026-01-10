package GameOfLife;

import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
    boolean predictDies = false;
    int[][] field;
    
    final int CELL_SIZE = 50;

    Canvas (Window window, boolean predictDies){
        this.predictDies = predictDies;
        init(window);
    }

    void init(Window window){
        int h = (int) (window.getHeight() / CELL_SIZE);
        int w = (int) (window.getWidth() / CELL_SIZE);
        this.field = new int[h][w];
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        drawField(g);
    }

    void drawField(Graphics g) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                if (field[i][j] == 1) {
                    fillRectColored(j, i, new Color(0, 0, 0), g);
                }
                else if(field[i][j] == 2){
                    fillRectColored(j, i, new Color(80, 80, 80), g); 
                } 
                else {
                    drawRectColored(j, i, new Color(0, 0, 0), g);
                }
            }
        }
    }

    void keyHandler(int key) {
        if (key == 32) {
            this.field = nextStep(this.field);
            if(predictDies){
                this.field = predictDies(this.field);
            }
            repaint();
        }
    }

    void mouseHandler(int x, int y) {
        int xCoord = (int) (x / CELL_SIZE);
        int yCoord = (int) (y / CELL_SIZE);

        this.field[yCoord][xCoord] = 1;
        repaint();
    }

    public int[][] nextStep(int[][] currentField) {
        int h = currentField.length;
        int w = currentField[0].length;
        int[][] newField = new int[h][w];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int neighbors = countNeighbors(currentField, x, y);
                int state = currentField[y][x];

                if (state != 0) {
                    if (neighbors == 2 || neighbors == 3)
                        newField[y][x] = 1;
                    else
                        newField[y][x] = 0;
                } else {
                    if (neighbors == 3)
                        newField[y][x] = 1;
                }
            }
        }
        return newField;
    }


   int[][] predictDies(int[][] currentField){
        int h = currentField.length;
        int w = currentField[0].length;
        int[][] newField = currentField;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int neighbors = countNeighbors(currentField, x, y);
                int state = currentField[y][x];

                if (state != 0) {
                    if (neighbors != 2 && neighbors != 3)
                        newField[y][x] += 1;
                        System.out.println("Will die: " + x + " " + y);
                }
            }
        }
        return newField;

    } 

   int countNeighbors(int[][] f, int x, int y) {
        int count = 0;
        int h = f.length;
        int w = f[0].length;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;
                int r = y + i;
                int c = x + j;
                if ((r >= 0 && r < h) && (c >= 0 && c < w)) {
                    if(f[r][c] != 0) count++;
                }
            }
        }
        return count;
    }
    
    void fillRectColored(int x, int y, Color col, Graphics g){
        Color previous = g.getColor();
        g.setColor(col);
        g.fillRect(x*CELL_SIZE, y*CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.setColor(previous);
    }

    void drawRectColored(int x, int y, Color col, Graphics g){
        Color previous = g.getColor();
        g.setColor(col);
        g.drawRect(x*CELL_SIZE, y*CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.setColor(previous);
    }
}
