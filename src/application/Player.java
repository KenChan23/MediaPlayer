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
	private Pane mediaPane;
	private MediaBar mediaBar;
	
	public Player(String file)
	{
		//	Use File constructor to enable relative paths.
		media = new Media(file);
		player = new MediaPlayer(media);
		view = new MediaView(player);
		mediaPane = new Pane();
		
		//	Add the view to the pane.
		mediaPane.getChildren().add(view);
		//	Add the pane to the border pane.
		setCenter(mediaPane);
		
		//	Add the media bar to the media player.
		mediaBar = new MediaBar(player);
		setBottom(mediaBar);
		mediaBar.setStyle("-fx-background-color: #BFC2C7");
		
		player.play();
	}
	
	public MediaPlayer getMediaPlayer()
	{
		return player;
	}
}
