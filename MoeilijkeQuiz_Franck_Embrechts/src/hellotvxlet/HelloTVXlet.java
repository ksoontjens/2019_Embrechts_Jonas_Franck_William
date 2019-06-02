package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;


import org.havi.ui.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import org.havi.ui.event.*;



public class HelloTVXlet implements Xlet, HActionListener {

    private XletContext actueleXletContext;
    private HScene scene;
    
    private HTextButton knop1, knop2, knop3,knop4,titel,score, opties;    
    
    public int scoreNumber = 0;
    
    public byte question = 1;
    public byte answer = 0; 
    public byte confirmationCount = 0;
    public byte rightAnswer;
          
       

    
    public void complete(){
        titel.setTextContent("You completed the quizzzzz!", HState.NORMAL_STATE);         
        resetGame();             
    }   
    
    public void setScore(){
        score.setTextContent("Score: "+String.valueOf(scoreNumber), HState.NORMAL_STATE);                          
        
    }
            
    public void resetGame(){        
        knop1.setTextContent("", HState.NORMAL_STATE);
        knop2.setTextContent("", HState.NORMAL_STATE);
        knop3.setTextContent("", HState.NORMAL_STATE);
        knop4.setTextContent("", HState.NORMAL_STATE);            
        
        setScore();        
    }
            
    public void checkAnswer(){
                     
        switch(question)
        {
            case 1:
                if(answer == 1)
                {
                    scoreNumber++;
                    setScore();
                }
                knop1.setBackground(Color.GREEN);
                knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
                scene.repaint();
                break;
            case 2:
                if(answer == 3)
                {
                    scoreNumber++;
                    setScore();
                }
                knop3.setBackground(Color.green);
                knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
                scene.repaint();
                break;
            case 3:
                if(answer == 4)
                {
                    scoreNumber++;
                    setScore();
                }
                knop4.setBackground(Color.green);
                knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
                scene.repaint();
                break;
            case 4:
                if(answer == 2)
                {
                    scoreNumber++;
                    setScore();
                }
                knop2.setBackground(Color.green);
                knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
                scene.repaint();
                break;
            case 5:
                if(answer == 1)
                {
                    scoreNumber++;
                    setScore();
                }
                knop1.setBackground(Color.green);
                knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
                scene.repaint();
                break;
            default:                
                break;
        }
    }
 
    public void initializeQuestion(){
             
        
        switch(question)
        {
            case 1:
                titel.setTextContent("Hoe lang is de langste beverdam ter wereld?", HState.NORMAL_STATE);
                opties.setTextContent("A. 850m \n B. 33m \n C. 20m \n D. 2348m", HState.NORMAL_STATE);
                rightAnswer = 1;
                break;
            case 2:
                titel.setTextContent("Waarvoor staat 'CC' in een e-mail?", HState.NORMAL_STATE);
                opties.setTextContent("A. Chinese Cylinder \n B. Crafted Copy \n C. Carbon Copy \n D. Clean Class", HState.NORMAL_STATE);
                rightAnswer = 3;
                break;
            case 3:
                titel.setTextContent("Wie heeft het WK van 2014 gewonnen?", HState.NORMAL_STATE);
                opties.setTextContent("A. Argentinië \n B. Brazillië \n C. Vaticaanstad \n D. Duitsland", HState.NORMAL_STATE);
                rightAnswer = 4;
                break;
            case 4:
                titel.setTextContent("Wat is het platste land ter wereld?", HState.NORMAL_STATE);
                opties.setTextContent("A. Senegal \n B. Malediven \n C. Denemarken \n D. Nederland", HState.NORMAL_STATE);
                rightAnswer = 2;
                break;
            case 5:
                titel.setTextContent("Op hoe lang staat het wereldrecord adem inhouden?", HState.NORMAL_STATE);
                opties.setTextContent("A. 22m \n B. 7m32s \n C. 12m \n D. 1u3m", HState.NORMAL_STATE);
                rightAnswer = 1;
                break;
            default: scene.removeAll();
                        
                titel = new HTextButton("Bedankt om te spelen \nJouw score: " + scoreNumber);
                titel.setLocation(20,200);
                titel.setSize(680,160);
                titel.setBackground(Color.pink);
                titel.setBackgroundMode(HVisible.BACKGROUND_FILL);
                scene.add(titel);
                scene.repaint();
                break;
        }
    }
        
    public void actionPerformed (ActionEvent e){           
        
        if(e.getActionCommand()== "knop1Selected"){
            answer = 1;
            selectionHandler();
        }
        if(e.getActionCommand()== "knop2Selected"){
            answer = 2;
            selectionHandler();           
        }
        
        if(e.getActionCommand()== "knop3Selected"){
            answer = 3;
            selectionHandler();          
        }
        
        if(e.getActionCommand()== "knop4Selected"){
            answer = 4;
            selectionHandler();         
        }
        
    }
    
    public void selectionHandler()
    {
            if (confirmationCount == 0)
            {
                confirmationCount = 1;
                checkAnswer();
            }
            else 
            {
                question++;
                confirmationCount = 0;
                
                knop1.setBackground(Color.DARK_GRAY);
                knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
                
                knop2.setBackground(Color.DARK_GRAY);
                knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
                
                knop3.setBackground(Color.DARK_GRAY);
                knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
                
                knop4.setBackground(Color.DARK_GRAY);
                knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
                
                initializeQuestion();               
            }
    }
    
    public void initXlet(XletContext context) throws XletStateChangeException {
        System.out.println("Xlet Initialiseren");
        this.actueleXletContext = context;
        
        HSceneTemplate sceneTemplate= new HSceneTemplate();
        // SCHERM = 720 x 576      
        
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension (1.0f, 1.0f), HSceneTemplate.REQUIRED );
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint (0.0f, 0.0f), HSceneTemplate.REQUIRED );
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
            //kollom1
            knop1 = new HTextButton("A");
            knop1.setLocation(20,350);
            knop1.setSize(150,150);                        
            knop1.setBackground(Color.DARK_GRAY);
            knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);      
        
            knop2 = new HTextButton("B");
            knop2.setLocation(170,350);
            knop2.setSize(150,150);
            knop2.setBackground(Color.DARK_GRAY);
            knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
           //kollom2
            knop3 = new HTextButton("C");
            knop3.setLocation(320,350);
            knop3.setSize(150,150);
            knop3.setBackground(Color.DARK_GRAY);
            knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            knop4 = new HTextButton("D");
            knop4.setLocation(470,350);
            knop4.setSize(150,150);
            knop4.setBackground(Color.DARK_GRAY);
            knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
           
            // titel
            titel = new HTextButton("Vraag 1");
            titel.setLocation(20,20);
            titel.setSize(680,80);
            titel.setBackground(Color.pink);
            titel.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            //scores
            score = new HTextButton("Score:");
            score.setLocation(468,100);
            score.setSize(230,50);
            score.setBackground(Color.pink);
            score.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            //opties
            opties = new HTextButton("Vraag 1");
            opties.setLocation(20,100);
            opties.setSize(448,250);
            opties.setBackground(Color.pink);
            opties.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
        knop1. setFocusTraversal ( null , null, knop4 , knop2 ) ; // op , neer , links ,rechts
        knop2. setFocusTraversal (null, null , knop1 , knop3 ) ; // op , neer , links ,rechts        
        knop3. setFocusTraversal ( null , null, knop2 , knop4 ) ; // op , neer , links ,rechts
        knop4. setFocusTraversal ( null , null, knop3 , knop1 ) ; // op , neer , links ,rechts
    
      knop1.setActionCommand("knop1Selected");      
      knop2.setActionCommand("knop2Selected");
      knop3.setActionCommand("knop3Selected");
      knop4.setActionCommand("knop4Selected");
      
      
      knop1.addHActionListener(this);
      knop2.addHActionListener(this);
      knop3.addHActionListener(this);
      knop4.addHActionListener(this);
      
      
      scene.add(knop1);
      scene.add(knop2);
      scene.add(knop3);
      scene.add(knop4);
      scene.add(titel);
      scene.add(score);     
      scene.add(opties); 
      
      knop1.requestFocus();  
      initializeQuestion();
      setScore();
      
    }    
    
    public void startXlet() throws XletStateChangeException {
        System.out.println("Xlet starten");
        
        scene.validate();
        scene.setVisible(true);        
        
        
    }
    
    public void pauseXlet() {
       
    }    
     public void destroyXlet(boolean unconditional) throws XletStateChangeException {
     
    }
     
}