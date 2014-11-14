package Applet.FractalGenerator;

public class MyPoint {
   private double x, y;

   MyPoint(){}
   MyPoint(double x, double y){ this.setX(x); this.setY(y); }
   MyPoint(MyPoint myPoint){ this.setX(myPoint.getX()); this.setY(myPoint.getY());  }

   public void setX(double x) {
      this.x=x;
   }
   public void setY(double y) {
      this.y=y;
   }
   public double getX() {
      return x;
   }
   public double getY() {
      return y;
   }


}
