/**
 * Nerd 03/04/2017
 * Deep Patel
 * DisplayState class that handles drawing and updating of scene/display.
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.sound.sampled.*;

public class DisplayState extends JPanel {
	private static DisplayState instance = null;
	private DisplayStatus currentDisplayStatus;
	private GameState gameCanvas;
	private ArrayList<Menu> menus = new ArrayList<Menu>();
	private Clip backgroundMusicClip;

	private DisplayState() {
		currentDisplayStatus = DisplayStatus.STARTMENU;
		gameCanvas = GameState.getInstance();
		setupMenus();

		this.setBackground(Color.black);
		this.setPreferredSize(NerdGame.windowSize);
		this.setSize(NerdGame.windowSize);

		FlowLayout layout = (FlowLayout)getLayout();
		layout.setVgap(0);

		backgroundMusicClip = ClipLoader.loadClip("./resources/music/backgroundMusic.wav");
		setBackgroundMusicVolume(0.25f);
	}
	
	private void setupMenus() {
		menus.add(new MainMenu());
		menus.add(new PauseMenu());
		menus.add(new VictoryMenu());
		menus.add(new LoseMenu());
	}

	public static synchronized DisplayState getInstance() {
		if (instance == null) {
			instance = new DisplayState();
		}
		return instance;
	}

	public void startBackgroundMusic() {
		try {
			backgroundMusicClip.start();
		} catch (Exception e) {
			backgroundMusicClip = ClipLoader.loadClip("./resources/music/backgroundMusic.wav");
			setBackgroundMusicVolume(0.25f);
			backgroundMusicClip.start();
		}
	}

	public void setBackgroundMusicVolume(float newVolume) {
		try {
			FloatControl gainControl = (FloatControl)backgroundMusicClip.getControl(FloatControl.Type.MASTER_GAIN);
			float range = gainControl.getMaximum() - gainControl.getMinimum() / 2;
			float gain = (range * newVolume) + gainControl.getMinimum() / 2;
			gainControl.shift(gainControl.getValue(), gain, 3000);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void stopBackgroundMusic() {
		try {
			backgroundMusicClip.stop();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public DisplayStatus getCurrentDisplayStatus() {
		return currentDisplayStatus;
	}

	public void setCurrentDisplayStatus(DisplayStatus newDisplayStatus) {
		currentDisplayStatus = newDisplayStatus;
		clear(Color.black);
	}

	public void updateCurrentDisplayStatus() {
		switch (currentDisplayStatus) {
			case STARTMENU:
				menus.get(0).update();
				break;
			case INGAME:
				gameCanvas.update();
				break;
			case PAUSEMENU:
				menus.get(1).update();
				break;
			case VICTORYMENU:
				menus.get(2).update();
				break;
			case LOSEMENU:
				menus.get(3).update();
				break;
			case CLOSE:
				break;
			default:
				break;
		}
	}

	public void drawCurrentDisplayStatus() {
		switch (currentDisplayStatus) {
			case STARTMENU:
				menus.get(0).draw();
				break;
			case INGAME:
				gameCanvas.draw();
				break;
			case PAUSEMENU:
				menus.get(1).draw();
				break;
			case VICTORYMENU:
				menus.get(2).draw();
				break;
			case LOSEMENU:
				menus.get(3).draw();
				break;
			case CLOSE:
				break;
			default:
				break;
		}
	}

	private void clear(Color color) {
		Graphics g = getGraphics();
		Dimension canvasSize = getSize();
		if (g != null) {
			g.setColor(color);
			g.fillRect(0, 0, (int)canvasSize.getWidth(), (int)canvasSize.getHeight());
		}
	}
}