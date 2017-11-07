import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.Ellipse2D.Double;

import java.lang.Math.*;

public class Physics {
   private final double gravity      = 0.001;
   private final double staticF      = 0.5;
   private final double dynamicF     = 0.3;
   private final double restitution  = 0.7;
   
   private int width;
   private int height;
   private int groundHeight;

   private Ground gr;

   public Physics(int width, int height, Ground g) {
      this.width = width;
      this.height = height;
      this.gr = g;
   }

   public void updatePosition(Ball m) {
      double x    = m.getX();
      double y    = m.getY();
      double xVel = m.getXVel();
      double yVel = m.getYVel();

      if (x > width) {
         x = width;
         xVel *= dynamicF * (restitution - 1) * yVel;
      }

      if (x < 0) { 
         x = 0;
         xVel *= dynamicF * (restitution - 1) * yVel;
      }

      // Update Machine
      m.setXVel(xVel);
      m.setYVel(yVel);

      // Convert velocities to positions
      velToPos(x, y, xVel, yVel, m);

      //System.out.println(gr.xToY(m.getX()));

      if (gr.intersects(m)) {
         //System.out.println(m.getX() + ", " + m.getY());
         double angleOfCollision = m.getAngle();
         double angleOfGround = -Math.toDegrees(Math.atan(gr.getSlope()));
         double newAngle = 180 + (2 * angleOfGround) - angleOfCollision;

         //System.out.println(angleOfCollision + ", " + angleOfGround  + " => " + newAngle);

         //System.out.print(y);
         y = gr.xToY(x);
         //System.out.println(" -> " + y);

         if (xVel > 0) {
            xVel += dynamicF * (restitution - 1) * yVel;
            if (xVel < 0) xVel = 0;
         } else if (xVel < 0) {
	    xVel += dynamicF * (restitution - 1) * yVel;
            if (xVel >= 0) xVel = 0;
         }

         yVel *= -restitution;

         double totalVel = Math.pow(Math.pow(yVel, 2) + Math.pow(xVel, 2), 0.5);
         yVel = totalVel * Math.sin(newAngle);
         xVel = totalVel * Math.cos(newAngle);
      } else {
         yVel -= gravity;
      }

      // Update Machine
      m.setXVel(xVel);
      m.setYVel(yVel);

      // Convert velocities to positions
      velToPos(x, y, xVel, yVel, m);
   } 

   // Converts velocities to positions
   // First Index: X
   // Second Index: Y
   public void velToPos(double x, double y, double xVel, double yVel, Machine m) {
      x -= xVel;
      y -= yVel;
      //System.out.println(y);
      m.setPos(x, y);
   }
}