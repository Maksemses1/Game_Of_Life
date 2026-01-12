package GameOfLife;

class Main {

  public static void main(String[] args) {

    boolean predictDies = false;
    int CELL_SIZE = 50;

    Window win;
    int cArgs = args.length;
    if(cArgs > 0){
      for(int i = 0; i < cArgs; i++){
        switch (args[i]) {
          case "--predictDies":
            predictDies = true;
            break;
          case "--cellSize":
            CELL_SIZE = Integer.parseInt(args[i+1]);
            i++;
            break;
          default:
            System.out.println("Unknown parram: " + args[i]);
            break;
        }
      }
    }
    win = new Window(predictDies, CELL_SIZE);
    win.start();
  }
}
