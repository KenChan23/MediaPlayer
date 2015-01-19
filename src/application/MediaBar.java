package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

//	Extend horizontal box to contruct control bar.
public class MediaBar extends HBox
{
	private Slider timeSlider;
	private Slider volumeSlider;
	
	//	For pausing and playing the video.
	private Button videoButton;
	
	private Label volumeLabel;
	private MediaPlayer player;
	
	private void initializeGUIComponents()
	{
		this.timeSlider = new Slider();
		this.volumeSlider = new Slider();
		this.videoButton = new Button("||");
		this.volumeLabel = new Label("Volume: ");
	}
	
	public MediaBar(MediaPlayer player)
	{
		initializeGUIComponents();
		
		this.player = player;
		
		setAlignment(Pos.CENTER);
		setPadding(new Insets(10, 10, 10, 10));
		
		//	Establish the dimensions of the volume bar.
		volumeSlider.setPrefWidth(70);
		volumeSlider.setMinWidth(30);
		volumeSlider.setValue(100);
		
		HBox.setHgrow(timeSlider, Priority.ALWAYS);
		
		videoButton.setPrefWidth(30);
		
		getChildren().add(videoButton);
		getChildren().add(timeSlider);
		getChildren().add(volumeLabel);
		getChildren().add(volumeSlider);
	}
}
