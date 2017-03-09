package edu.neumont.csc150.d.View;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

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
	
	public AudioClip gameMusic(Control c) {
		control = c;
		AudioClip temp = null;
		if (control.isFloor1()) {
			clip1.stop();
			clip2.stop();
			clip4.stop();
			clip3.loop();
			temp = clip3;
		}
		
		if (control.isFloor2()) {
			clip1.loop();
			clip2.stop();
			clip3.stop();
			clip4.stop();
			temp = clip1;
		}
		
		if (control.isFloor3()) {
			clip1.stop();
			clip2.loop();
			clip3.stop();
			clip4.stop();
			temp = clip2;
		}
		
		if (control.isBasement()) {
			clip1.stop();
			clip2.stop();
			clip3.stop();
			clip4.loop();
			temp = clip4;
		}
		return temp;
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
}