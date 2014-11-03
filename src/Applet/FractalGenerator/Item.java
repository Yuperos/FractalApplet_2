package Applet.FractalGenerator;

import java.lang.*;

class MyPoint {
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

public class Item {
   private double angle, length;
   private MyPoint start, end;

   Item(){}

   public void setLengthAndAngle(double width, double height) {
      this.length=Math.hypot(Math.abs(width), Math.abs(height));
      this.angle=Math.atan2(height, width);
   }

   public void setEnd(double x, double y){
      end.setY(x);
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

   public double getNewAngleRadians(double radians) {
      return this.angle+radians;
   }

   public double getNewAngleDegrees(double degrees) {
     return this.getNewAngleRadians(Math.toRadians(degrees));
   }

   public double getNewLength(Double percent) {
      return this.length*percent / 100.0;
   }
}
