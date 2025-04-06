package stackoverflow;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Port;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoopSound
{

    public static void main(String[] args) throws Exception
    {
//        URL url = new URL("http://download.wavetlan.com/SVV/Media/HTTP/WAV/Media-Convert/Media-Convert_test5_PCM_Stereo_VBR_8SS_44100Hz.wav");
//        Clip clip = AudioSystem.getClip();
//        // getAudioInputStream() also accepts a File or InputStream
//        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
//        clip.open(ais);
//        clip.loop(Clip.LOOP_CONTINUOUSLY);
//        SwingUtilities.invokeLater(new Runnable()
//        {
//            public void run()
//            {
//                // A GUI element to prevent the Clip's daemon Thread
//                // from terminating at the end of the main()
//                JOptionPane.showMessageDialog(null, "Close to exit!");
//            }
//        });
        
        Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
        System.out.println("Mixers obtained: " + mixerInfo.length);
        System.out.println("==================");
        for(int i = 0; i < mixerInfo.length; i++)
        {
            System.out.println(mixerInfo[i].getName());
            System.out.println(mixerInfo[i].getDescription());
            System.out.println(mixerInfo[i].getVendor());
            System.out.println(mixerInfo[i].getVersion());
//            System.out.println(mixerInfo[i].toString());
            System.out.println("==================");
        }
    }
}