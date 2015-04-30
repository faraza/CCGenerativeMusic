/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.File;

/**
 *
 * @author farazabidi
 */
public class MusicFromKeyPresses extends JFrame {


    
    
    
    
    public static void main(String[] args) {
        MusicFromKeyPresses myMusic = new MusicFromKeyPresses();
    }

    Timer timer;
    MusicPanel p;

    /*Hardwiring in instrument clips and keypresses is definitely not the most elegant way to do this
    But it's the easiest :P
     
     I'm assuming 3 drum, 3 bass, and 3 sound. Should be very easy to change this, though.
     Can only play one from each category at a time.
    */
    
    int aPresses, bPresses, cPresses, dPresses, ePresses, fPresses, gPresses, hPresses, iPresses;
    Clip bass1, bass2, bass3, bass4, bass5, bass6, bass7, bass8, bass9, drum1, drum2, drum3, drum4, drum5, drum6, drum7, drum8, drum9, sound1, sound2, sound3, sound4, sound5, sound6, sound7, sound8, sound9;
    int loopCount;
    int platterNum;
    
    MusicFromKeyPresses() {

        timer = new Timer();
        loadClips();
        timer.schedule(new updateMusic(), 0, 4372); //runs every 4.372 seconds
        p = new MusicPanel();
        
        //Just some JFrame crap
        setContentPane(p);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(50, 100);
        setSize(1000, 700);
        setVisible(true);
        loopCount = 0;
        platterNum = 0;
    }
    
    void loadClips(){
        try{
        bass1 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        bass2 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        bass3 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        bass4 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        bass5 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        bass6 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        bass7 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        bass8 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        bass9 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        drum1 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        drum2 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        drum3 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            drum4 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            drum5 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            drum6 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            drum7 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            drum8 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            drum9 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        sound1 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        sound2 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        sound3 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            sound4 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            sound5 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            sound6 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            sound7 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            sound8 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            sound9 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        }
        catch(Exception e){
            System.out.print("error initializing clips");
        }

        try{
        File bass1File = new File("bass1.wav");
        bass1.open(AudioSystem.getAudioInputStream(bass1File));
            
        File bass2File = new File("bass2.wav");
        bass2.open(AudioSystem.getAudioInputStream(bass2File));
        
        File bass3File = new File("bass3.wav");
        bass3.open(AudioSystem.getAudioInputStream(bass3File));
            
            File bass4File = new File("bass4.wav");
            bass4.open(AudioSystem.getAudioInputStream(bass4File));
            
            File bass5File = new File("bass5.wav");
            bass5.open(AudioSystem.getAudioInputStream(bass5File));
            
            File bass6File = new File("bass6.wav");
            bass6.open(AudioSystem.getAudioInputStream(bass6File));
            
            File bass7File = new File("bass7.wav");
            bass7.open(AudioSystem.getAudioInputStream(bass7File));
            
            File bass8File = new File("bass8.wav");
            bass8.open(AudioSystem.getAudioInputStream(bass8File));
            
            File bass9File = new File("bass9.wav");
            bass9.open(AudioSystem.getAudioInputStream(bass9File));
        
            
            
        File drum1File = new File("drum1.wav");
        drum1.open(AudioSystem.getAudioInputStream(drum1File));
            
        File drum2File = new File("drum2.wav");
        drum2.open(AudioSystem.getAudioInputStream(drum2File));
            
        File drum3File = new File("drum3.wav");
        drum3.open(AudioSystem.getAudioInputStream(drum3File));
            
            File drum4File = new File("drum4.wav");
            drum4.open(AudioSystem.getAudioInputStream(drum4File));
            
            File drum5File = new File("drum5.wav");
            drum5.open(AudioSystem.getAudioInputStream(drum5File));
            
            File drum6File = new File("drum6.wav");
            drum6.open(AudioSystem.getAudioInputStream(drum6File));
            
            File drum7File = new File("drum7.wav");
            drum7.open(AudioSystem.getAudioInputStream(drum7File));
            
            File drum8File = new File("drum8.wav");
            drum8.open(AudioSystem.getAudioInputStream(drum8File));
            
            File drum9File = new File("drum9.wav");
            drum9.open(AudioSystem.getAudioInputStream(drum9File));
            
            
          
            
            
        File sound1File = new File("sound1.wav");
        sound1.open(AudioSystem.getAudioInputStream(sound1File));
            
        File sound2File = new File("sound2.wav");
        sound2.open(AudioSystem.getAudioInputStream(sound2File));
            
        File sound3File = new File("sound3.wav");
        sound3.open(AudioSystem.getAudioInputStream(sound3File));
            
           File sound4File = new File("sound4.wav");
            sound4.open(AudioSystem.getAudioInputStream(sound4File));
            
            File sound5File = new File("sound5.wav");
            sound5.open(AudioSystem.getAudioInputStream(sound5File));
            
            File sound6File = new File("sound6.wav");
            sound6.open(AudioSystem.getAudioInputStream(sound6File));
            
            File sound7File = new File("sound7.wav");
            sound7.open(AudioSystem.getAudioInputStream(sound7File));
            
            File sound8File = new File("sound8.wav");
            sound8.open(AudioSystem.getAudioInputStream(sound8File));
            
            File sound9File = new File("sound9.wav");
            sound9.open(AudioSystem.getAudioInputStream(sound9File));
            
            
        }
        catch(Exception e){
            System.out.print("error loading audio files");
        }
    }
    
    /*void randomizeClips(){
        //if duplicated clips ends up being a problem, we can deal with that with an arraylist or something
        
        try{

            
            //Change all the 5's to however many number of clips there are
            int randomBassNum1 = (int)((5*(Math.random()))+1);
            File bass1File = new File("bass"+randomBassNum1+".wav"); //bass1 through bass10
            bass1.close();
            bass1.open(AudioSystem.getAudioInputStream(bass1File));
            
            int randomBassNum2 = (int)((5*(Math.random()))+1);
            File bass2File = new File("bass"+randomBassNum2+".wav"); //bass1 through bass10
            bass2.close();
            bass2.open(AudioSystem.getAudioInputStream(bass2File));
            
            int randomBassNum3 = (int)((5*(Math.random()))+1);
            File bass3File = new File("bass"+randomBassNum3+".wav"); //bass1 through bass10
            bass3.close();
            bass3.open(AudioSystem.getAudioInputStream(bass3File));
            
            
            int randomDrumNum1 = (int)((5*(Math.random()))+1);
            File drum1File = new File("drum"+randomDrumNum1+".wav");
            drum1.close();
            drum1.open(AudioSystem.getAudioInputStream(drum1File));
            
            int randomDrumNum2 = (int)((5*(Math.random()))+1);
            File drum2File = new File("drum"+randomDrumNum2+".wav");
            drum2.close();
            drum2.open(AudioSystem.getAudioInputStream(drum2File));
            
            int randomDrumNum3 = (int)((5*(Math.random()))+1);
            File drum3File = new File("drum"+randomDrumNum3+".wav");
            drum3.close();
            drum3.open(AudioSystem.getAudioInputStream(drum3File));
            
            int randomSoundNum1 = (int)((5*(Math.random()))+1);
            File sound1File = new File("sound"+randomSoundNum1+".wav");
            sound1.close();
            sound1.open(AudioSystem.getAudioInputStream(sound1File));
            
            int randomSoundNum2 = (int)((5*(Math.random()))+1);
            File sound2File = new File("sound"+randomSoundNum2+".wav");
            sound2.close();
            sound2.open(AudioSystem.getAudioInputStream(sound2File));
            
            int randomSoundNum3 = (int)((5*(Math.random()))+1);
            File sound3File = new File("sound"+randomSoundNum3+".wav");
            sound3.close();
            sound3.open(AudioSystem.getAudioInputStream(sound3File));
            System.out.print("next set");
            
            
        }
        catch(Exception e){
            System.out.print("error randomizing audio files");
        }
        
    }*/
    
    void resetPresses(){
        aPresses = 0;
        bPresses = 0;
        cPresses = 0;
        dPresses = 0;
        ePresses = 0;
        fPresses = 0;
        gPresses = 0;
        hPresses = 0;
        iPresses = 0;
    }

    class MusicPanel extends JPanel implements KeyListener {
        
        MusicPanel(){
            setFocusable(true);
            addKeyListener(this);
        }

        
        //TODO: display the currently playing soundclip
        public void paintComponent(Graphics g){
            setBackground(Color.BLACK);
            
        }
        public void keyTyped(KeyEvent k) {
            if(k.getKeyChar()== 'a')
                aPresses++;
            else if (k.getKeyChar() == 'b')
                bPresses++;
            else if (k.getKeyChar() == 'c')
                cPresses++;
            else if (k.getKeyChar() == 'd')
                dPresses++;
            else if (k.getKeyChar() == 'e')
                ePresses++;
            else if (k.getKeyChar() == 'f')
                fPresses++;
            else if (k.getKeyChar() == 'g')
                gPresses++;
            else if (k.getKeyChar() == 'h')
                hPresses++;
            else if (k.getKeyChar() == 'i')
                iPresses++;
            else if (k.getKeyChar() == 'w'){ //THIS WILL BE THE BLINK KEY
                if (platterNum == 2)
                    platterNum = 0;
                else platterNum++;
                System.out.println("Platter Num: " +platterNum);
            }
        }

        public void keyPressed(KeyEvent k) {}
        public void keyReleased(KeyEvent k) {}

    }

    class updateMusic extends TimerTask {
        public void run() {
            loopCount++;
            //if(loopCount%6 == 0) //TO CHANGE randomization TIME INTERVAL: change this number. IT will change every 5 seconds * whatever this number is
              //  randomizeClips();
            
            
            drum1.setFramePosition(0);
            drum2.setFramePosition(0);
            drum3.setFramePosition(0);
            drum4.setFramePosition(0);
            drum5.setFramePosition(0);
            drum6.setFramePosition(0);
            drum7.setFramePosition(0);
            drum8.setFramePosition(0);
            drum9.setFramePosition(0);
            bass1.setFramePosition(0);
            bass2.setFramePosition(0);
            bass3.setFramePosition(0);
            bass4.setFramePosition(0);
            bass5.setFramePosition(0);
            bass6.setFramePosition(0);
            bass7.setFramePosition(0);
            bass8.setFramePosition(0);
            bass9.setFramePosition(0);
            sound1.setFramePosition(0);
            sound2.setFramePosition(0);
            sound3.setFramePosition(0);
            sound4.setFramePosition(0);
            sound5.setFramePosition(0);
            sound6.setFramePosition(0);
            sound7.setFramePosition(0);
            sound8.setFramePosition(0);
            sound9.setFramePosition(0);
            
            //Drums
            if(aPresses>bPresses && aPresses > cPresses){
                if(platterNum == 0)
                    drum1.start();
                else if (platterNum == 1)
                    drum4.start();
                else if (platterNum == 2)
                    drum7.start();
            }
            else if(bPresses > aPresses && bPresses > cPresses){
                if(platterNum == 0)
                    drum2.start();
                else if (platterNum == 1)
                    drum5.start();
                else if (platterNum == 2)
                    drum8.start();
            }
            else{
                if(platterNum == 0)
                    drum3.start();
                else if (platterNum == 1)
                    drum6.start();
                else if (platterNum == 2)
                    drum9.start();
            }
            //Bass
            if(dPresses>ePresses && dPresses > fPresses){
                if(platterNum == 0)
                    bass1.start();
                else if (platterNum == 1)
                    bass4.start();
                else if (platterNum == 2)
                    bass7.start();
            }
            else if(ePresses > dPresses && ePresses > fPresses){
                if(platterNum == 0)
                    bass2.start();
                else if (platterNum == 1)
                    bass5.start();
                else if (platterNum == 2)
                    bass8.start();
            }
            else{
                if(platterNum == 0)
                    bass3.start();
                else if (platterNum == 1)
                    bass6.start();
                else if (platterNum == 2)
                    bass9.start();
            }
            
            //Sound
            if(gPresses>hPresses && gPresses > iPresses){
                if(platterNum == 0)
                    sound1.start();
                else if (platterNum == 1)
                    sound4.start();
                else if (platterNum == 2)
                    sound7.start();
            }
            else if(hPresses > gPresses && hPresses > iPresses){
                if(platterNum == 0)
                    sound2.start();
                else if (platterNum == 1)
                    sound5.start();
                else if (platterNum == 2)
                    sound8.start();
            }
            else{
                if(platterNum == 0)
                    sound3.start();
                else if (platterNum == 1)
                    sound6.start();
                else if (platterNum == 2)
                    sound9.start();
            }
            
            
            
            resetPresses();
        }
        
        
    }

}
