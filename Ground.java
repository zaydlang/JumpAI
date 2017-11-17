import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;

public class Ground extends Machine {
   private double x1;
   private double x2;
   private double y1;
   private double y2;
   private double yIntercept;

   public Ground(double x1, double y1, double x2, double y2) {
      super((x1 + x2) / 2, (y1 + y2) / 2, 0, 0);
      this.x1 = x1;
      this.x2 = x2;
      this.y1 = y1;
      this.y2 = y2;

      yIntercept = y1 - getSlope() * x1;
   }

   public boolean intersects(Ball other, double width, double height) {
      // return (xToY(other.getX()) < (other.getY()));
      if (getDistance(other, width, height) < other.getRadius()) return true;
      return false;
   }
  //0 700 1200 550
   //public boolean intersects(Machine other) { return false; }

   public double getSlope() {
      return -((y2 - y1) / (x2 - x1));
   }

   public double xToY(double x) {
      return (((y2 - y1) / (x2 - x1)) * (x2 - x)) + yIntercept; 
   }

   public void draw(Graphics g) {
      g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
   }

   public double getX1() {
      return x1;
   } 

   public double getX2() {
      return x2;
   } 

   public double getY1() {
      return y1;
   } 

   public double getY2() {
      return y2;
   } 

   public String getType() {
      return "ground";
   }
   
   public double getDistance(Machine other, double width, double height) {
      /*double gSlope = getSlope();
      double bSlope = -1/gSlope;
      double x = ((-bSlope * other.getX()) + other.getY() - y1) / (gSlope - bSlope);
      double y = xToY(x);
      double d = Math.pow(Math.pow(x - other.getX(), 2) + Math.pow(y - other.getY(), 2), 0.5);
      System.out.println("X: " + x + " Y: " + y + " D: " + d);
      System.out.println("g: " + gSlope + " b: " + bSlope);*/
      double a = -getSlope();
      double b = 1;
      double c = height - y1;
      double d = (Math.abs(a * (width - other.getX()) + b * (height - other.getY()) + c))/(Math.pow(Math.pow(a, 2) + Math.pow(b, 2), 0.5));

      System.out.println(a + " " + b + " " + c + " " + other.getX() + " " + (height - other.getY()) + " " + d);
      return d;
   }
}
