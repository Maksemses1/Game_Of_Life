package GameOfLife;

class Main {
  public static void main(String[] args) {
    Window win;
    int cArgs = args.length;
    if(cArgs > 0){
      System.out.println(args[0]);
      if(args[0].equals("--predictDies")){
        win = new Window(true, 50);
        win.start();
      }
      else{
        System.out.println("Unknow Flag");
      }
    }
    else{
      win = new Window(false, 50);
      win.start();
    }
/*
      long lastTime = System.nanoTime();
      double nsPerTick = 1000000000.0 / 1.0;
      int i = 0;
      while (true) {
        long now = System.nanoTime();
        if (now - lastTime >= nsPerTick) {
          System.out.println(i++);
          lastTime = now;
        }
      }*/
  }
}
