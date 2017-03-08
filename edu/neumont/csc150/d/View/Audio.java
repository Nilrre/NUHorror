package edu.neumont.csc150.d.View;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

//Class for all audio files
public class Audio {
	
	//Main menu music
	public void mainMenuMusic() {
		URL url = Audio.class.getResource("Aftermath.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.loop();
	}
	
	public void mainMenuMusicStopped() {
		URL url = Audio.class.getResource("Aftermath.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.stop();
	}
	
	//Classroom Music
	public void roomMusic() {
		URL url = Audio.class.getResource("ThunderDreams.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.loop();
	}
	
	//Commons music
	public void commonsMusic() {
		URL url = Audio.class.getResource("AwkwardMeeting.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.loop();
	}
	
	//Basement Music
	public void basementMusic() {
		URL url = Audio.class.getResource("NervousPiano.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.loop();
	}
	
	//Final boss battle music
	public void bossBattleMusic() {
		URL url = Audio.class.getResource("ControlledChaos.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.loop();
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
