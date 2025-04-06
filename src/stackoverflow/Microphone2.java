package stackoverflow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Timer;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Microphone2 extends Thread implements ActionListener {
    
    ObjectOutputStream Object_Output_Stream = null;
    boolean continueLoop = true;
    TargetDataLine targetDataLine;
    byte tempBuffer[] = new byte[384] ;
    float[] samples = new float[384 / 2];
    float lastPeak = 0f;
    JFrame frame = new JFrame("Remote Admin");
    JPanel panel = new JPanel();
    JComboBox combo1 = new JComboBox();
    JButton button = new JButton("Soundoptionen");
    Timer caretaker2 = new Timer();
//    LevelMeter meter = new LevelMeter();
    DataLine.Info dataLineInfo;
    int n = 0;
 
    Line.Info targetDLInfo = new Line.Info(TargetDataLine.class);
 
    public Microphone2(ObjectOutputStream oos) {
        Object_Output_Stream = oos;
 
        if (AudioSystem.isLineSupported(targetDLInfo)) {
            try {
                dataLineInfo = new DataLine.Info( TargetDataLine.class , getAudioFormat() ) ;
                targetDataLine = (TargetDataLine)AudioSystem.getLine( dataLineInfo  ) ;
                targetDataLine.open( getAudioFormat() );
                targetDataLine.start();
 
                drawGUI();
            }
            catch(Exception e )
            {
                System.out.println(" not correct " ) ;
                System.exit(0) ;
            }
        }
 
        start();      
    }
 
    public void run(){
 
        while(continueLoop){
 
            n = targetDataLine.read(tempBuffer, 0, tempBuffer.length);
 
            updateMeter();
 
            try {
                Object_Output_Stream.writeObject(tempBuffer);
                Object_Output_Stream.reset();
 
            } catch (IOException ex) {
                ex.printStackTrace();
                continueLoop = false;
            }
        }
 
    }
 
    public static AudioFormat getAudioFormat(){
        float sampleRate = 22050.0F;
        //8000,11025,16000,22050,44100
        int sampleSizeInBits = 16;
        //8,16
        int channels = 1;
        //1,2
        boolean signed = true;
        //true,false
        boolean bigEndian = false;
        //true,false
        return new AudioFormat( sampleRate, sampleSizeInBits, channels, signed, bigEndian );
        //return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 8000.0F, 8, 1, 1, 8000.0F, false);
    }
 
    private void drawGUI() throws LineUnavailableException {
 
        Mixer.Info[] mixerInfo;
        mixerInfo = AudioSystem.getMixerInfo();
 
        for(int cnt = 0; cnt < mixerInfo.length; cnt++) {
                Mixer currentMixer = AudioSystem.getMixer(mixerInfo[cnt]);
 
                if( currentMixer.isLineSupported(targetDLInfo) ) {
                    combo1.addItem(mixerInfo[cnt].getName());
                }
            }
 
        frame.add(panel);
        button.addActionListener(this);
        combo1.addActionListener(this);
        panel.add(button);
        panel.add(combo1);
        frame.setBounds(200,200,400,200);
        frame.setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            try {
                startAudioConfigTool();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(e.getSource() == combo1){
            System.out.println("Gewählter Input: " + combo1.getSelectedItem());
 
            Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
 
            for(int cnt = 0; cnt < mixerInfo.length; cnt++) {
                Mixer currentMixer = AudioSystem.getMixer(mixerInfo[cnt]);
 
                if( mixerInfo[cnt].getName() ==  combo1.getSelectedItem().toString()) {
                    System.out.println("Gewählter Input gefunden");
 
                    if (targetDataLine.isRunning()) {
                        targetDataLine.stop();
                    }
 
                    targetDataLine.flush();
 
                    if (targetDataLine.isOpen()) {
                        targetDataLine.close();
                    }
 
                    dataLineInfo = new DataLine.Info( TargetDataLine.class , getAudioFormat() ) ;
                    try {
                        targetDataLine = (TargetDataLine) currentMixer.getLine(dataLineInfo) ;
                        targetDataLine.open(getAudioFormat());
                        targetDataLine.start();
                        targetDataLine.read(tempBuffer, 0, tempBuffer.length);
 
                    } catch (LineUnavailableException e1) {
                        e1.printStackTrace();
                    }
                }}
        }
    }
 
    public static boolean startAudioConfigTool() throws IOException {
        String os = System.getProperty("os.name", "<unk>");
 
        if (os.startsWith("Mac OS X")) {
            Runtime.getRuntime().exec("open /System/Library/PreferencePanes/Sound.prefPane/");
            return true;
        }
 
        if (os.startsWith("Windows XP")) {
            Runtime.getRuntime().exec("control mmsys.cpl,,1");
            return true;
        }
 
        if (os.startsWith("Windows 7")) {
            Runtime.getRuntime().exec("control mmsys.cpl,,1");
            return true;
        }
 
        if (os.startsWith("Linux")) {
            Runtime.getRuntime().exec("/usr/bin/gnome-volume-control");
            return true;
        }
 
        return false;
    }
 
 
    void updateMeter(){
// convert bytes to samples here
        for(int i = 0, s = 0; i < n;) {
            int sample = 0;
 
            sample |= tempBuffer[i++] & 0xFF; // (reverse these two lines
            sample |= tempBuffer[i++] << 8;   //  if the format is big endian)
 
            // normalize to range of +/-1.0f
            samples[s++] = sample / 32768f;
        }
 
        float rms = 0f;
        float peak = 0f;
        for(float sample : samples) {
 
            float abs = Math.abs(sample);
            if(abs > peak) {
                peak = abs;
            }
 
            rms += sample * sample;
        }
 
        rms = (float)Math.sqrt(rms / samples.length);
 
        if(lastPeak > peak) {
            peak = lastPeak * 0.875f;
        }
 
        lastPeak = peak;
 
        setMeterOnEDT(rms, peak);
    }
 
    void setMeterOnEDT(final float rms, final float peak) {
//        meter.setAmplitude(rms);
//        meter.setPeak(peak);
    }
}
