import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class pingpong implements ActionListener, KeyListener, MouseMotionListener{
  //properties
  pingpongpanel thePanel;
  JFrame theFrame;
  Timer theTimer;
  
  boolean blnup1 = false;
  boolean blndown1 = false;
  boolean blnup2 = false;
  boolean blndown2 = false;
  
  JLabel p1;
  JLabel p2;
  
  int intP1Wins = 0;
  int intP2Wins = 0;
  
  int intRandX = (int)(Math.random()*7 + 4);
  int intRandY = (int)(Math.random()*7 + 4);
  
  //Methods
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == theTimer){
      thePanel.intBallX += intRandX;
      thePanel.intBallY += intRandY;
      
      if(blnup1){
        thePanel.intLeftY -= 8;
      }
      if(blndown1){
        thePanel.intLeftY += 8;
      }
      
      if(blnup2){
        thePanel.intRightY -= 8;
      }
      if(blndown2){
        thePanel.intRightY += 8;
      }
      
      if(thePanel.intBallY >= 750 || thePanel.intBallY <= 0){
        intRandY = (-1) * intRandY;
      }
      
      if(thePanel.intBallX <= -50){
        thePanel.intBallX = 375;
        thePanel.intBallY = 375;
        intP2Wins++;
        thePanel.repaint();
        try{
        Thread.sleep(1000);
        }catch(InterruptedException e){
        } 
      }
      if(thePanel.intBallX >= 800){
        thePanel.intBallX = 375;
        thePanel.intBallY = 375;
        intP1Wins++;
        thePanel.repaint();
        try{
        Thread.sleep(1000);
        }catch(InterruptedException e){
        } 
      }
      
      if(thePanel.intBallX >= 720 && thePanel.intBallY >= (thePanel.intRightY - 30) && thePanel.intBallY <= (thePanel.intRightY + 150) && thePanel.intBallX <= 790){
        intRandX = (-1) * intRandX;
      }
      if(thePanel.intBallX <= 30 && thePanel.intBallY >= (thePanel.intLeftY - 30) && thePanel.intBallY <= (thePanel.intLeftY + 150) && thePanel.intBallX >= 10){
        intRandX = (-1) * intRandX;
      }
      
      p1.setText("P1 Wins: "+intP1Wins);
        p2.setText("P2 Wins: "+intP2Wins);
      thePanel.repaint(); 
    }
    
  }
  public void keyReleased(KeyEvent evt){
    //Player 1
    if(evt.getKeyChar() == 'w'){
      blnup1 = false;
    }
    if(evt.getKeyChar() == 's'){
      blndown1 = false;
    }
    //Player 2
    if(evt.getKeyCode() == 38){
      blnup2 = false;
    }
    if(evt.getKeyCode() == 40){
      blndown2 = false;
    }
  }
  public void keyPressed(KeyEvent evt){
    //Player 1
    if(evt.getKeyChar() == 'w'){
      blnup1 = true;
    }
    if(evt.getKeyChar() == 's'){
      blndown1 = true;
    }
    //Player 2
    if(evt.getKeyCode() == 38){
      blnup2 = true;
    }
    if(evt.getKeyCode() == 40){
      blndown2 = true;
    }
  }
  public void keyTyped(KeyEvent evt){
    
  }

  public void mouseMoved(MouseEvent evt){
  }
  public void mouseDragged(MouseEvent evt){
  }
  
  //Constructor
  public pingpong(){
    thePanel = new pingpongpanel();
    thePanel.setPreferredSize(new Dimension(800, 840));
    thePanel.setLayout(null);
    thePanel.addMouseMotionListener(this);
    
    p1 = new JLabel("P1 Wins: ");
    p1.setSize(100, 40);
    p1.setLocation(200, 800);
    thePanel.add(p1);
    
    p2 = new JLabel("P2 Wins: ");
    p2.setSize(100,40);
    p2.setLocation(550,800);
    thePanel.add(p2);
    
    theFrame = new JFrame("Ping Pong Game");
    theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theFrame.setContentPane(thePanel);
    theFrame.pack();
    theFrame.setVisible(true);
    theFrame.addKeyListener(this);
    theTimer = new Timer(1000/60,this);
    theTimer.start();
  }
  
  //Main method
  public static void main(String[] args){
    new pingpong();
  }
}