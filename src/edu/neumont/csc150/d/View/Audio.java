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
	
		//Lawrences button sound
		public void lawrenceSound() {
		URL url5 = Audio.class.getResource("Lawrence.wav");
		AudioClip clip5 = Applet.newAudioClip(url5);
		clip5.play();
		}
	
		//Errlins button sound
		public void errlinSound() {
		URL url7 = Audio.class.getResource("Errlin.wav");
		AudioClip clip7 = Applet.newAudioClip(url7);
		clip7.play();
		}
	
		//David's button sound
		public void davidSound() {
		URL url8 = Audio.class.getResource("David.wav");
		AudioClip clip8 = Applet.newAudioClip(url8);
		clip8.play();
		}
		
		public void death() {
			URL url9 = Audio.class.getResource("Death.wav");
			AudioClip clip9 = Applet.newAudioClip(url9);
			clip9.play();
		}
		
		public void lawDialogue(int num) {
			if(num == 0){
				URL url10 = Audio.class.getResource("LawD1.wav");
				AudioClip clip10 = Applet.newAudioClip(url10);
				clip10.play();
			}else if(num == 1){
				URL url10 = Audio.class.getResource("LawD2.wav");
				AudioClip clip10 = Applet.newAudioClip(url10);
				clip10.play();
			}else if(num == 2){
				URL url10 = Audio.class.getResource("LawD3.wav");
				AudioClip clip10 = Applet.newAudioClip(url10);
				clip10.play();
			}else if(num == 3){
				URL url10 = Audio.class.getResource("LawD4.wav");
				AudioClip clip10 = Applet.newAudioClip(url10);
				clip10.play();
			}else if(num == 4){
				URL url10 = Audio.class.getResource("LawD5.wav");
				AudioClip clip10 = Applet.newAudioClip(url10);
				clip10.play();
			}else if(num == 5){
				URL url10 = Audio.class.getResource("LawD6.wav");
				AudioClip clip10 = Applet.newAudioClip(url10);
				clip10.play();
			}else if(num == 6){
				URL url10 = Audio.class.getResource("LawD7.wav");
				AudioClip clip10 = Applet.newAudioClip(url10);
				clip10.play();
			}else if(num == 7){
				URL url10 = Audio.class.getResource("LawD8.wav");
				AudioClip clip10 = Applet.newAudioClip(url10);
				clip10.play();
			}
		}
		
		public void daveDialogue(int num) {
			if(num == 0){
				URL url11 = Audio.class.getResource("Dave1.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 1){
				URL url11 = Audio.class.getResource("Dave2.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 2){
				URL url11 = Audio.class.getResource("Dave3.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 3){
				URL url11 = Audio.class.getResource("Dave4.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 4){
				URL url11 = Audio.class.getResource("Dave5.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 5){
				URL url11 = Audio.class.getResource("Dave6.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 6){
				URL url11 = Audio.class.getResource("Dave7.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 7){
				URL url11 = Audio.class.getResource("Dave8.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}
		}
		
		public void earlDialogue(int num) {
			if(num == 0){
				URL url11 = Audio.class.getResource("Earl1.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 1){
				URL url11 = Audio.class.getResource("Earl2.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 2){
				URL url11 = Audio.class.getResource("Earl3.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 3){
				URL url11 = Audio.class.getResource("Earl4.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 4){
				URL url11 = Audio.class.getResource("Earl5.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 5){
				URL url11 = Audio.class.getResource("Earl6.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 6){
				URL url11 = Audio.class.getResource("Earl7.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}else if(num == 7){
				URL url11 = Audio.class.getResource("Earl8.wav");
				AudioClip clip11 = Applet.newAudioClip(url11);
				clip11.play();
			}
		}
}
