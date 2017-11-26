/*
 * Source https://stackoverflow.com/questions/4875080/music-loop-in-java
 */
package zuul_prog1;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * class to play sounds and musik 
 */
public class MusicPlayer extends Thread {
 
    private Clip spiel;
    
    /**
     * start to play the musik
     */
    public void run() {
        try {
            startPlayback();
        } catch (Exception ex) {           
            String exc = ex.getMessage();
        }
    }

    /**
     * loads the musik and plays it in a loop
     */
    public void startPlayback() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if(spiel == null){
            AudioInputStream as1 = AudioSystem.getAudioInputStream(getClass().getResource("sounds/fairyland.wav"));
            AudioFormat af = as1.getFormat();
            spiel = AudioSystem.getClip();
            DataLine.Info info = new DataLine.Info(Clip.class, af);

            Line line1 = AudioSystem.getLine(info);

            if ( ! line1.isOpen() )
            {
             spiel.open(as1);
             spiel.loop(Clip.LOOP_CONTINUOUSLY);
             spiel.start();
            }
        }
        else{
            if(!spiel.isActive()){
                spiel.start();
            }
        }        
    }
    
    /**
     * stops the musik loop
     */
    public void stopPlayback(){
        if(spiel != null && spiel.isActive()){
            spiel.stop();
        }        
    }
}
