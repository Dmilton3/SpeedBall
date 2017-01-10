//import java.applet.Applet;
//import java.applet.AudioClip;
import java.io.*;
import javax.sound.sampled.*;
/**
 * Created by Dewey Milton on 3/18/2016.
 * Sound class to play Buzzer sound when goal achieved
 */
public class Sound {


    private Clip clip;

    /*
     playBuzzer
     sounds buzzer
     */
    public void playBuzzer()
    {
        try
        {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File("C:\\Users\\ASUS\\Desktop\\JavaClass\\Pong\\Res\\buzzer.wav").getAbsoluteFile());
          //  AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File("C:\\buzzer.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        }
        catch (Exception exception)
        {
            System.out.println("Sorry the program failed to load your audio file.");
        }

    }
}
