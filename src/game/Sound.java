package game;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.prefs.BackingStoreException;


public class Sound {

    private Clip clip;

    public Sound(String s) {
        try {
            AudioInputStream ais =
                    AudioSystem.getAudioInputStream(new File(s).getAbsoluteFile());
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void play() {
        if(clip == null) {
            System.out.println("Clip is null");
            return;
        }

        stop();
        clip.setFramePosition(0);
        clip.start();

    }

    public void stop() {
        if(clip.isRunning())
            clip.stop();
    }

    public void close() {
        stop();
        clip.close();
    }



}
