import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class pingpongpanel extends JPanel{
  //Properties
  int intLeftX = 10;
  int intLeftY = 350;
  int intRightX = 770;
  int intRightY = 350;
  int intBallX = 375;
  int intBallY = 375;
  
  //Methods
  public void paintComponent(Graphics g){
   g.setColor(Color.BLACK);
   g.fillRect(0,0, 800, 800);
   g.setColor(Color.WHITE);
   g.fillRect(intLeftX, intLeftY, 20, 150);
   g.fillRect(intRightX, intRightY, 20, 150);
   g.fillOval(intBallX, intBallY, 50, 50);
   //g.fillRect(800, 0, 800, 40);
   g.setColor(Color.BLACK);
   //g.drawString("P1 Wins: "+intP1Wins, 200, 825);
   //g.drawString("P2 Wins: "+intP2Wins, 550, 825);
  }
  
  //Constructor
  public pingpongpanel(){
   super(); 
  }
}