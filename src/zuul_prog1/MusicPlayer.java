package zuul_prog1;

import java.io.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Class to play sounds and music.
 * @author Lucca Willi and see Source
 * @source https://stackoverflow.com/questions/4875080/music-loop-in-java
 */
public class MusicPlayer extends Thread {
 
    private Clip musicPlay;
    
    /**
     * Start to play the musik
     */
    public void run() {
        try {
            startPlayback();
        } catch (Exception ex) {           
            String exc = ex.getMessage();
        }
    }

    /**
     * Loads the musik and plays it in a loop.
     * Has to been enclosed in a try catch.
     */
    public void startPlayback() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if(musicPlay == null){
            AudioInputStream as1 = AudioSystem.getAudioInputStream(getClass().getResource("sounds/fairyland.wav"));
            AudioFormat af = as1.getFormat();
            musicPlay = AudioSystem.getClip();
            DataLine.Info info = new DataLine.Info(Clip.class, af);

            Line line1 = AudioSystem.getLine(info);

            if ( ! line1.isOpen() )
            {
             musicPlay.open(as1);
             musicPlay.loop(Clip.LOOP_CONTINUOUSLY);
             musicPlay.start();
            }
        }
        else{
            if(!musicPlay.isActive()){
                musicPlay.start();
            }
        }        
    }
    
    /**
     * Stops the music loop.
     */
    public void stopPlayback(){
        if(musicPlay != null && musicPlay.isActive()){
            musicPlay.stop();
        }        
    }
}
