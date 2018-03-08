
package fr.earthfight.launcher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.theshark34.openlauncherlib.launcher.util.UsernameSaver;
import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.Swinger.textured.STexturedButton;
import fr.theshark34.swinger.Swinger.event.SwingerEventListener;

@SuppressWarnings("serial")
public class LauncherPanel extends JPanel implements SwingerEventListener {
	
	private Image background = Swinger.getResource("background.png");
	
	private UsernameSaver saver = new UsernameSaver(Launcher.EF_INFOS);
	
	private JTextField usernameField = new JTextField(saver.getUsername(""));
	private JPasswordField passwordField = new JPasswordField();

	private STexturedButton playButton = new StexturedButton(Swinger.getResource("play.png"));
	private STexturedButton quitButton = new StexturedButton(Swinger.getResource("quit.png"));
	private STexturedButton hideButton = new StexturedButton(Swinger.getResource("hide.png"));

	
	public LauncherPanel() {
		this.setLayout(null);
		
		usernameField.setForeground(Color.WHITE);
		usernameField.setFont(usernameField.getFont().deriveFont(20F));
		usernameField.setCaretColor(Color.WHITE);
		usernameField.setBorder(null);
		usernameField.setOpaque(false);
		usernameField.setBounds(11, 11, 11, 11);
		this.add(usernameField);

		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(passwordField.getFont());
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setOpaque(false);
		passwordField.setBounds(11, 21, 11, 21);
		this.add(passwordField);

		playButton.setBounds(200, 200);
		playButton.addEventListener(this);
		this.add(playButton);

		quitButton.setBounds(971, 19);
		quitButton.addEventListener(this);
		this.add(quitButton);

		hideButton.setBounds(971, 30);
		hideButton.addEventListener(this);
		this.add(hideButton);
	}

	@Overide
	public void onEvent (SwingerEvent e) {
		if (e.getSource() ==playButton) {
			System.out.printIn ("ALlal");
		} else if (e.getSource() == quitButton) {
			System.exit(0);
		} else if (e.getSource() == hideButton) {
			LauncherFrame.getInstance().setState(JFrame.ICONIFIED) ;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
