/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul_prog1;

import junit.framework.TestCase;

/**
 *
 * @author Lucca
 */
public class MusicPlayerTest extends TestCase {
    
    public MusicPlayerTest(String testName) {
        super(testName);
    }

    /**
     * Test of run method, of class MusicPlayer.
     */
    public void testRun() {
        System.out.println("run");
        MusicPlayer instance = new MusicPlayer();
        instance.run();
    }

    /**
     * Test of startPlayback method, of class MusicPlayer.
     * @throws java.lang.Exception
     */
    public void testStartPlayback() throws Exception {
        System.out.println("startPlayback");
        MusicPlayer instance = new MusicPlayer();
        instance.startPlayback();
    }

    /**
     * Test of stopPlayback method, of class MusicPlayer.
     */
    public void testStopPlayback() {
        System.out.println("stopPlayback");
        MusicPlayer instance = new MusicPlayer();
        instance.stopPlayback();
    }
    
}
