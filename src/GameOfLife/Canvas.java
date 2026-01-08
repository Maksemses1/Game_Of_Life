package src.GameOfLife;

import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
    int[][] field; 

    final int CELL_SIZE = 50;

    Canvas(Window window) {
        int h = (int)(window.getHeight() / CELL_SIZE);
        int w = (int)(window.getWidth() / CELL_SIZE);
        this.field = new int[h][w];
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        drawField(g);
    }

    void drawField(Graphics g) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                
                if (field[i][j] == 1) {
                    g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                } else {
                    g.drawRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

    void keyHandler(int key) {
        if (key == 32) {  
            this.field = nextStep(this.field);
            
            repaint(); 
        }
    }

    void mouseHandler(int x, int y){
      int xCoord = (int)(x/CELL_SIZE);
      int yCoord = (int)(y/CELL_SIZE);

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

                if (state == 1) {
                    if (neighbors == 2 || neighbors == 3) newField[y][x] = 1;
                    else newField[y][x] = 0;
                } else {
                    if (neighbors == 3) newField[y][x] = 1;
                }
            }
        }
        return newField;
    }

    public int countNeighbors(int[][] f, int x, int y) {
        int count = 0;
        int h = f.length;
        int w = f[0].length;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = y + i;
                int c = x + j;
                if ((r >= 0 && r < h) && (c >= 0 && c < w)) {
                    count += f[r][c];
                }
            }
        }
        return count;
    }
}
