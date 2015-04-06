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
    Clip bass1, bass2, bass3, drum1, drum2, drum3, sound1, sound2, sound3;
    
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
    }
    
    void loadClips(){
        try{
        bass1 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        bass2 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        bass3 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        drum1 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        drum2 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        drum3 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        sound1 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        sound2 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
        sound3 = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
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
        
            
            
        File drum1File = new File("drum1.wav");
        drum1.open(AudioSystem.getAudioInputStream(drum1File));
            
        File drum2File = new File("drum2.wav");
        drum2.open(AudioSystem.getAudioInputStream(drum2File));
            
        File drum3File = new File("drum3.wav");
        drum3.open(AudioSystem.getAudioInputStream(drum3File));
          
            
            
        File sound1File = new File("sound1.wav");
        sound1.open(AudioSystem.getAudioInputStream(sound1File));
            
        File sound2File = new File("sound2.wav");
        sound2.open(AudioSystem.getAudioInputStream(sound2File));
            
        File sound3File = new File("sound3.wav");
        sound3.open(AudioSystem.getAudioInputStream(sound3File));
            
            
        }
        catch(Exception e){
            System.out.print("error loading audio files");
        }
    }
    
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
        }

        public void keyPressed(KeyEvent k) {}
        public void keyReleased(KeyEvent k) {}

    }

    class updateMusic extends TimerTask {
        public void run() {
            drum1.setFramePosition(0);
            drum2.setFramePosition(0);
            drum3.setFramePosition(0);
            bass1.setFramePosition(0);
            bass2.setFramePosition(0);
            bass3.setFramePosition(0);
            sound1.setFramePosition(0);
            sound2.setFramePosition(0);
            sound3.setFramePosition(0);
            
            //Drums
            if(aPresses>bPresses && aPresses > cPresses){
                drum1.start();
            }
            else if(bPresses > aPresses && bPresses > cPresses){
                drum2.start();
            }
            else{
                drum3.start();
            }
            //Bass
            if(dPresses>ePresses && dPresses > fPresses){
                bass1.start();
            }
            else if(ePresses > dPresses && ePresses > fPresses){
                bass2.start();
            }
            else{
                bass3.start();
            }
            
            //Sound
            if(gPresses>hPresses && gPresses > iPresses){
                sound1.start();
            }
            else if(hPresses > gPresses && hPresses > iPresses){
                sound2.start();
            }
            else{
                sound3.start();
            }
            
            
            
            resetPresses();
        }
        
        
    }

}
