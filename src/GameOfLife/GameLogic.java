package GameOfLife;

class GameLogic{
    GameField field;

    GameLogic(GameField field){
        this.field = field;
    }

  public int[][] nextStep() {
    int[][] newField = new int[field.HEIGHT][field.WIDTH];

      for (int y = 0; y < field.HEIGHT; y++) {
          for (int x = 0; x < field.WIDTH; x++) {
              int neighbors = countNeighbors(x, y);
              int state = field.getCell(x, y);

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


  public int[][] predictDies(){
      int[][] newField = field.getMatrix();

      for (int y = 0; y < field.HEIGHT; y++) {
          for (int x = 0; x < field.WIDTH; x++) {
              int neighbors = countNeighbors(x, y);
              int state = field.getCell(x, y);

              if (state != 0) {
                  if (neighbors != 2 && neighbors != 3)
                      newField[y][x] += 1;
              }
          }
      }
      return newField;

  } 

  int countNeighbors(int x, int y) {
      int count = 0;
      for (int i = -1; i <= 1; i++) {
          for (int j = -1; j <= 1; j++) {
              if (i == 0 && j == 0)
                  continue;
              int r = y + i;
              int c = x + j;
              if ((r >= 0 && r < field.HEIGHT) && (c >= 0 && c < field.WIDTH)) {
                  if(field.getCell(c, r) != 0) count++;
              }
          }
      }
      return count;
  }
}
