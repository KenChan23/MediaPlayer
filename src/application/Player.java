package application;

import java.io.File;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

//	Extend BorderPane, which has regions.
public class Player extends BorderPane
{
	private Media media;
	private MediaPlayer player;
	private MediaView view;
	Pane mediaPane;
	
	public Player(String file)
	{
		//	Use File contructor to enable relative paths.
		media = new Media(new File(file).toURI().toString());
		player = new MediaPlayer(media);
		view = new MediaView(player);
		mediaPane = new Pane();
		
		//	Add the view to the pane.
		mediaPane.getChildren().add(view);
		//	Add the pane to the border pane.
		setCenter(mediaPane);
		
		player.play();
	}
}
