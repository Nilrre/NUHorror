package edu.neumont.csc150.d.View;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import edu.neumont.csc150.d.Controller.Control;

//Class for all audio files
public class Audio {
	private Control control;
	
	URL url = Audio.class.getResource("Aftermath.wav");
	AudioClip clip = Applet.newAudioClip(url);
	
	URL url1 = Audio.class.getResource("ThunderDreams.wav");
	AudioClip clip1 = Applet.newAudioClip(url1);
	
	URL url2 = Audio.class.getResource("AwkwardMeeting.wav");
	AudioClip clip2 = Applet.newAudioClip(url2);
	
	URL url3 = Audio.class.getResource("NervousPiano.wav");
	AudioClip clip3 = Applet.newAudioClip(url3);
	
	URL url4 = Audio.class.getResource("ControlledChaos.wav");
	AudioClip clip4 = Applet.newAudioClip(url4);
	
	URL url6 = Audio.class.getResource("Item.wav");
	AudioClip clip6 = Applet.newAudioClip(url6);
	
	
	public void gameMusic(Control c) throws UnsupportedAudioFileException, IOException, InterruptedException {
		control = c;
			clip3.loop();
	}	
	
	public void stopMusic() {
		clip.stop();
		clip1.stop();
		clip2.stop();
		clip3.stop();
		clip4.stop();
	}
	
	//Main menu music
		public void mainMenuMusic() {
			clip.loop();
		}
		
		//Stops Main Menu Music
		public void mainMenuMusicStopped() {
			clip.stop();
		}
	
	//Music during chase sequences
	//May not even use
	public void chaseMusic() {
		
	}
	
	//Sound for item pick up
	public void itemPickUpSound() {
	}
	
	//May not use
	public void walkingSound() {
		
	}
	
	public void lawrenceSound() {
		URL url5 = Audio.class.getResource("Lawrence.wav");
		AudioClip clip5 = Applet.newAudioClip(url5);
		clip5.play();
	}
}
