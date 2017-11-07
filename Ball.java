import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;

public class Ball extends Machine {
   private double radius;

   public Ball(double x, double y, double xVel, double yVel, double radius) {
      super(x, y, xVel, yVel);
      this.radius = radius;
   }

   public void draw(Graphics g, int width) {
      g.drawOval((width - (int)getX()), (int)getY() - ((int)radius * 2), (int)radius * 2, (int)radius * 2);
   }

   public double getRadius() {
      return radius;
   }

   public String getType() {
       return "ball";
   }
}
