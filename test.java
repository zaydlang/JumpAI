import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;

public class test {
   private static final int height        = 800;
   private static final int groundHeightL = 100;
   private static final int groundHeightR = 350;

   public static void main(String[] args) {
      Ground gr = new Ground(0, height - groundHeightL, 1200, height - groundHeightR);

      for (int i = 0; i < 1200; i += 10) {
        System.out.println(gr.xToY(i));
      }
   }
}
