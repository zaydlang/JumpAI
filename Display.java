import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;

public class Display extends JFrame implements ActionListener {
   private final Font font         = new Font("Roboto", Font.BOLD, 48);
   private final int width         = 1200;
   private final int height        = 800;
   private final int groundHeightL = 100;
   private final int groundHeightR = 350;
   private final Timer timer       = new Timer(1, this);

   private Physics ph;

   private Ball mach = new Ball(600, 300, 0, 0, 30);
   private Ground gr = new Ground(0, height - groundHeightL, width, height - groundHeightR);

   public Display() {
      setSize(width, height);
      setLayout(null); 

      // Create display for Generation Number
      JLabel genDisplay = new JLabel("Generation: ");
      genDisplay.setBounds(0, 0, width, height / 8);
      genDisplay.setFont(font);
      genDisplay.setHorizontalTextPosition(JLabel.LEFT);
      add(genDisplay);

      // Set the Physics
      Physics p = new Physics(width, height, gr);
      setPhysics(p);
     
      // Start refresh timer
      timer.start();

      setVisible(true); 
   }

   public void paint(Graphics g) {
      super.paint(g);

      // Draw Ground
      gr.draw(g);

      // Update all the positions of the objects based on the current physics.
      updatePhysics();

      // Draw Machine
      mach.draw(g, width);
   }
 
   public void updatePhysics() {
      ph.updatePosition(mach);
   }

   public void setPhysics(Physics p) {
      ph = p;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      this.repaint();
   }

   public static void main(String[] args) {
      new Display();
   }
}
