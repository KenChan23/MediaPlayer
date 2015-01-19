package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
	@Override
	//	Set the stage, show the video, display the control bar.
	public void start(Stage primaryStage) 
	{
		//	The player object accepts a path to a media file.
		//	Add the player to the scene. Define the height, width and background color.
		// 	Add the scene to the stage.
		try
		{
			Player player = new Player("media/codestars.mp4");
			Scene scene = new Scene(player, 720, 510, Color.BLACK);
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
