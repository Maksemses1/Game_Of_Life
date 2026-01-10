package GameOfLife;

class Main {
  public static void main(String[] args) {
    Window win;
    int cArgs = args.length;
    if(cArgs > 0){
      System.out.println(args[0]);
      if(args[0].equals("--predictDies")){
        win = new Window(true);
        win.start();
      }
      else{
        System.out.println("Unknow Flag");
      }
    }
    else{
      win = new Window(false);
      win.start();
    }
  }
}
