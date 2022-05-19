package state;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profile.Profile;

public class SettingsStrategy extends StateStrategy {

	public SettingsStrategy(Profile profile) {
		super(profile);
		// TODO Auto-generated constructor stub
	}
	
	private JLabel messageLabel;

	private JLabel settingsHeaderLabel;
	
	private JPanel optionsPanel;
	
	private JPanel focusSettingPanel;
	private JLabel focusSettingLabel;
	private JComboBox focusSettingBox;
	
	private JPanel languageSettingPanel;
	private JLabel languageSettingLabel;
	private JComboBox languageSettingBox;
	
	private JPanel difficultySettingPanel;
	private JLabel difficultySettingLabel;
	private JComboBox difficultySettingBox;
	
	private JPanel soundSettingPanel;
	private JLabel soundSettingLabel;
	private JComboBox soundSettingBox;
	
	private JButton saveChanges;
	
	
	@Override
	public void setPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(theme.subColor);
		
		messageLabel = new JLabel("");
			messageLabel.setForeground(new Color(10, 153, 0));
			messageLabel.setFont(theme.fontBoldRegSmall);
			messageLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		this.add(messageLabel);
		this.add(createSpaceLabel(0));
		
		//Header
		settingsHeaderLabel = new JLabel(profile.getLanguage().text[9]);
			settingsHeaderLabel.setFont(theme.fontBoldReg);
			settingsHeaderLabel.setForeground(theme.textColor);
			settingsHeaderLabel.setAlignmentX(CENTER_ALIGNMENT);
		this.add(settingsHeaderLabel);
		this.add(createSpaceLabel(0));
		
		optionsPanel = new JPanel();
		optionsPanel.setBackground(theme.subColor);
		optionsPanel.setLayout(new GridLayout(5,1,20,20));
		
		//Settings
		focusSettingPanel = new JPanel();
			focusSettingPanel.setBackground(theme.subColor);
		focusSettingLabel = new JLabel(profile.getLanguage().settingsText[0]);
			focusSettingLabel.setForeground(theme.textColor);
			focusSettingLabel.setFont(theme.fontBoldRegSmall);
		focusSettingBox = new JComboBox();
			focusSettingBox.setFont(theme.fontBoldRegSmall);
			focusSettingBox.addItem(profile.getLanguage().settingsText[4]);
			focusSettingBox.addItem(profile.getLanguage().settingsText[5]);
			focusSettingBox.addItem(profile.getLanguage().settingsText[6]);
			focusSettingBox.addItem(profile.getLanguage().settingsText[7]);
			focusSettingBox.setSelectedIndex(profile.getSettings().getFocusMode());
		focusSettingPanel.add(focusSettingLabel);
		focusSettingPanel.add(focusSettingBox);
		
		languageSettingPanel = new JPanel();
			languageSettingPanel.setBackground(theme.subColor);
		languageSettingLabel = new JLabel(profile.getLanguage().settingsText[1]);
			languageSettingLabel.setForeground(theme.textColor);
			languageSettingLabel.setFont(theme.fontBoldRegSmall);
		languageSettingBox = new JComboBox();
			languageSettingBox.setFont(theme.fontBoldRegSmall);
			languageSettingBox.addItem(profile.getLanguage().settingsText[8]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[9]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[10]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[11]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[12]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[13]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[14]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[15]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[16]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[17]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[18]);
			languageSettingBox.setSelectedIndex(profile.getLanguageIndicator());
		languageSettingPanel.add(languageSettingLabel);
		languageSettingPanel.add(languageSettingBox);
		
		difficultySettingPanel = new JPanel();
			difficultySettingPanel.setBackground(theme.subColor);
		difficultySettingLabel = new JLabel(profile.getLanguage().settingsText[2]);
			difficultySettingLabel.setForeground(theme.textColor);
			difficultySettingLabel.setFont(theme.fontBoldRegSmall);
		difficultySettingBox = new JComboBox();
			difficultySettingBox.setFont(theme.fontBoldRegSmall);
			difficultySettingBox.addItem(profile.getLanguage().settingsText[19]);
			difficultySettingBox.addItem(profile.getLanguage().settingsText[20]);
		difficultySettingPanel.add(difficultySettingLabel);
		difficultySettingPanel.add(difficultySettingBox);
		
		soundSettingPanel = new JPanel();
			soundSettingPanel.setBackground(theme.subColor);
		soundSettingLabel = new JLabel(profile.getLanguage().settingsText[3]);
			soundSettingLabel.setFont(theme.fontBoldRegSmall);
			soundSettingLabel.setForeground(theme.textColor);
		soundSettingBox = new JComboBox();
			soundSettingBox.setFont(theme.fontBoldRegSmall);
			soundSettingBox.addItem(profile.getLanguage().settingsText[23]);
			soundSettingBox.addItem(profile.getLanguage().settingsText[24]);
			soundSettingBox.addItem(profile.getLanguage().settingsText[25]);
		soundSettingPanel.add(soundSettingLabel);
		soundSettingPanel.add(soundSettingBox);
			
		optionsPanel.add(focusSettingPanel);
		optionsPanel.add(languageSettingPanel);
		optionsPanel.add(difficultySettingPanel);
		optionsPanel.add(soundSettingPanel);
		
		this.add(optionsPanel);
		
		saveChanges = new JButton(profile.getLanguage().settingsText[26]);
			saveChanges.setAlignmentX(CENTER_ALIGNMENT);
			saveChanges.setFont(theme.fontBoldRegSmall);
		this.add(saveChanges);
		this.add(createSpaceLabel(1));
	}

	@Override
	public void setActions() {
		saveChanges.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				messageLabel.setText("Changes saved!");
				
				//Update focus mode
				profile.getSettings().setFocusMode(focusSettingBox.getSelectedIndex());
				
				//Update language indicator
				profile.setLanguageStrategy(languageSettingBox.getSelectedIndex());
				
				//Update Difficulty
				profile.getSettings().setDifficulty(difficultySettingBox.getSelectedIndex());
				
				//Update Sounds
				profile.getSettings().setSessionSoundIndicator(soundSettingBox.getSelectedIndex());
				
				//TODO
				//Write the information to the profile's file
			}
			
		});
		
	}

}
