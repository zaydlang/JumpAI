import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;

import java.awt.geom.*;

public class Display extends JPanel implements ActionListener {
   private final Font font         = new Font("Roboto", Font.BOLD, 48);
   private final int width         = 1200;
   private final int height        = 800;
   private final int groundHeightL = 100;
   private final int groundHeightR = 350;
   private final Timer timer       = new Timer(1, this);
   private final Ball machConst = new Ball(0, 0, 0, 0, 30);

   private Physics ph;
   private Ground gr = new Ground(0, height - groundHeightL, width, height - groundHeightR);
   private Ball mach;

   private JLabel genDisplay;

   private int generation = 1;

   public Display() {
      //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
      setSize(new Dimension(width, height)); 
      setPreferredSize(new Dimension(width, height));
      setLayout(null);

      // Create display for Generation Number
      genDisplay = new JLabel("Generation: " + generation);
      genDisplay.setBounds(0, 0, width, height / 8);
      genDisplay.setFont(font);
      genDisplay.setHorizontalTextPosition(JLabel.LEFT);
      add(genDisplay);

      // Set the Physics
      Physics p = new Physics(width, height, gr);
      setPhysics(p);
     
      // Start refresh timer
      timer.start();
      mach = new Ball(machConst);
      setVisible(true); 
   }

   public void paint(Graphics g) {
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, width, height);

      g.setColor(Color.BLACK);
    
      // Draw Generation #
      g.setFont(font);
      g.drawString("Generation: " + generation, 20, 50);

      // Draw Ground
      gr.draw(g);

      // Update all the positions of the objects based on the current physics.
      if (!updatePhysics()) {
         mach = machConst;
         generation++;
         repaint();
         return;
      }

      // Draw Machine
      mach.draw(g, width);

      repaint();
   }
 
   public boolean updatePhysics() {
      return ph.updatePosition(mach);
   }

   public void setPhysics(Physics p) {
      ph = p;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      //this.repaint();
   }

   public static void main(String[] args) {
      Display disp = new Display();

      JFrame frame = new JFrame();
      frame.setTitle("Physics");
      frame.add(disp);
      frame.pack();
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

      //new Display();
   }
}
