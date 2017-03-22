/**
 * Nerd 03/22/2017
 * Deep Patel
 * ClipLoader class that handles loading sound clips.
 */

import javax.sound.sampled.*;
import java.io.File;

public class ClipLoader
{
  public static Clip loadClip(String path){
    try {
		File soundFile = new File(path);
		AudioInputStream soundAudioStream = AudioSystem.getAudioInputStream(soundFile);
		AudioFormat soundFormat = soundAudioStream.getFormat();
		DataLine.Info soundInfo = new DataLine.Info(Clip.class, soundFormat);
		Clip soundClip = (Clip)AudioSystem.getLine(soundInfo);
		soundClip.open(soundAudioStream);
		return soundClip;
	} catch (Exception e) {
		System.out.println(e.toString());
		return null;
	}
  }
} 