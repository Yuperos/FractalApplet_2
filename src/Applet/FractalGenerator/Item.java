package Applet.FractalGenerator;

public class Item {
   private double angle, length;
   private MyPoint start, end;

   Item(){}

   public void setLengthAndAngle(double width, double height) {
      this.length=Math.hypot(Math.abs(width), Math.abs(height));
      this.angle=Math.atan2(height, width);
   }

   public void setEnd(double x, double y){
      end.setX(x);
      end.setY(y);
   }

   public void setSize(int x, int y, int width, int height) {
      this.start.setX(x);
      this.start.setY(y);
      this.setEnd(x + width, y + height);
      this.setLengthAndAngle(width, height);
   }

   public void setSize(int x, int y, double angle, double length) {
      this.start.setX(x);
      this.start.setY(y);
      this.angle=angle;
      this.length=length;
      this.setEnd(x + Math.sin(angle) * length, y + Math.cos(angle) * length);
   }

   public MyPoint getPointOnTheLine(double length){
      if (this.length > length)
         return new MyPoint(Math.cos(this.angle)*length, Math.sin(this.angle)*length);
      return null;
   }

   public double getNextAngleRadians(double radians) {
      return this.angle+radians;
   }

   public double getNextAngleDegrees(double degrees) {
     return this.getNextAngleRadians(Math.toRadians(degrees));
   }

   public double getNextLength(Double percent) {
      return this.length*percent / 100.0;
   }
}
