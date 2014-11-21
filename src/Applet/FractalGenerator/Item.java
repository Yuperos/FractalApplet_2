package Applet.FractalGenerator;

public class Item {
   private double angle, length;
   private MyPoint start;


   private MyPoint end;

   Item(){}
   Item(int x, int y, double angle, double length){
      this.setSize(x,y,angle,length);
   }
   Item(MyPoint start, double angle, double length){
      this.start = new MyPoint(start);
      this.setLengthAndAngle(angle,length);
   }


   public double getEndY() {
      return end.getY();
   }

   public double getEndX() {
      return end.getX();
   }

   public MyPoint getEnd() {
      return end;
   }

   public void setLengthAndAngle( double angle, double length ) {
      this.angle=angle;
      this.length=length;
   }

   public void setSides(double width, double height) {
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
      this.setSides(width, height);
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

   //TODO: rename functions with "next"
   public double adjAngleRad(double radians) {
      return this.angle+radians;
   }

   public double adjAngleDeg(double degrees) {
     return this.adjAngleRad(Math.toRadians(degrees));
   }

   public double adjLen(double percent) {
      return this.length * percent / 100.0;
   }

}

