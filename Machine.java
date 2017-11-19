import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;

public class Machine {
   private double x;
   private double y;
   private double xVel;
   private double yVel;

   public Machine(double x, double y, double xVel, double yVel) {
      this.x    = x;
      this.y    = y;
      this.xVel = xVel;
      this.yVel = yVel;
   }

   public Machine(Machine o) {
      this.x    = o.getX();
      this.y    = o.getY();
      this.xVel = o.getXVel();
      this.yVel = o.getYVel();
   }

   public double getAngle() {
      double angle = (Math.atan(yVel/xVel));
      if (xVel < 0) angle += 180;
      return angle;
   }

   public String getType() {
       return "machine";
   }

   public double getX() {
      return x;
   }

   public double getY() {
      return y;
   }

   public double getXVel() {
      return xVel;
   }

   public double getYVel() {
      return yVel;
   }
 
   public void setPos(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public void setXVel(double xVel) {
      this.xVel = xVel;
   }

   public void setYVel(double yVel) {
      this.yVel = yVel;
   }

   public void draw(Graphics g) {}
   public void draw(Graphics g, int width) {}
}
