package application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

/*
	1.	The Main class is an extension of the javafx.application.Application class.
	 	Its start method is overridden and receives a Stage object (a top-level GUI container).
	2.	The root node (in this case, an instance of the javafx.scene.Group class) is created and passed to the scene's constructor, along with the scene's width, height, and fill. 	
	3.	The stage's title, scene and visibility are all set.
	4.	The main method invokes the Application.launch() method.
*/
public class Main extends Application 
{
	private Player player;
 	private FileChooser fileChooser;
	
 	@Override
	//	Set the stage, show the video, display the control bar.
	public void start(Stage primaryStage) 
	{
		//	The player object accepts a path to a media file.
		//	Add the player to the scene. Define the height, width and background color.
		// 	Add the scene to the stage.
		try
		{
			//	Initialize the menu and its components.
			MenuItem openOption = new MenuItem("Open");
			Menu fileTab = new Menu("File");
			MenuBar menuBar = new MenuBar();
					
			fileTab.getItems().add(openOption);
			menuBar.getMenus().add(fileTab);
					
			fileChooser = new FileChooser();
			
			openOption.setOnAction(new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent e)
				{
					player.getMediaPlayer().pause();
					File file = fileChooser.showOpenDialog(primaryStage);
							
					if(file != null)
					{
						try
						{
							player = new Player(file.toURI().toURL().toExternalForm());
							player.setTop(menuBar);
							Scene scene = new Scene(player, 720, 535, Color.BLACK);
							primaryStage.setScene(scene);
						}
						catch(MalformedURLException ex)
						{
							ex.printStackTrace();
						}
					}
				}
			});
			
			player = new Player("file:/Users/KAC/Desktop/Projects/MediaPlayer/media/codestars.mp4");
			//	Add the menu to the media player.
			player.setTop(menuBar);
			Scene scene = new Scene(player, 720, 535, Color.BLACK);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Launches the application.
	public static void main(String[] args) 
	{
		launch(args);
	}
}
