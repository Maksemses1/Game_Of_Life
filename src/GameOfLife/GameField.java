package GameOfLife;

class GameField{
  
  final int HEIGHT;
  final int WIDTH;
  final int CELL_SIZE;

  private int[][] field;

  GameField(int fieldHeight, int fieldWidth, int CELL_SIZE){
    this.HEIGHT = fieldHeight;
    this.WIDTH = fieldWidth;
    this.CELL_SIZE = CELL_SIZE;
    this.field = new int[fieldHeight][fieldWidth];
  }

  public int getCell(int x, int y){
    return field[y][x];
  }

  public void setCell(int x, int y, int value){
    field[y][x] = value;
  }

  public void setMatrix(int[][] matrix){
    this.field = matrix;
  }

  public int[][] getMatrix(){
    return field;
  }
}
