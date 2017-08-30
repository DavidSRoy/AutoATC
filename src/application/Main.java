package application;
	
import application.aircraft.B74;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;


public class Main extends Application {
	
	private final ATCRunner runner;
	private final ATCMechanism mechanism;
	private final IRealWorldSimulator atc;
	private final Thread runnerThread;
	private  Canvas canvas;
	
	public Main() {
		super();
		
		this.mechanism = new ATCMechanism();
		this.atc = new ATCSimulator();
		this.runner = new ATCRunner(this.mechanism,this.atc, this);
		this.runnerThread = new Thread(this.runner);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
//		try {
		B74 jumbo = new B74("JUMB0");
		
		

		Text speed = new Text(String.valueOf(jumbo.getSpeed()));
		Text heading = new Text(String.valueOf(jumbo.getHeading()));
		
		Text flt = new Text(ATCSimulator.callsigns());
		Text flt2 = new Text(ATCSimulator.callsigns());
		Text flt3 = new Text(ATCSimulator.callsigns());
		Text flt4 = new Text(ATCSimulator.callsigns());
		
		//String.valueOf(jumbo.getSpeed())
		/*GridPane grid = new GridPane();
		grid.add(speed, 0, 1);*/
		
		this.canvas = new Canvas(400,400);
		this.runnerThread.start();
		
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		
		int rowCount = 0;
		
		grid.add(heading, 0, rowCount++, 2, 1);
		grid.add(speed, 0, rowCount++, 2, 1);
		grid.add(flt, rowCount++, 2);
		grid.add(flt2, rowCount++, 2);
		grid.add(flt3, rowCount++, 3);
		grid.add(flt4, rowCount++, 3);
		grid.add(this.canvas, 2, 0, 2, rowCount);
		
		
		/*BorderPane root = new BorderPane();
		root.setPadding(new Insets(70));
		VBox paneCenter = new VBox();
		root.setCenter(paneCenter);
		paneCenter.getChildren().add(speed);
		paneCenter.getChildren().add(heading);
		paneCenter.getChildren().add(canvas);*/
		
		
		
		Scene scene = new Scene(grid ,800,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
		primaryStage.setTitle("AutoATC");		
		primaryStage.setScene(scene);
		primaryStage.show();
			
		/*} catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
	}
	
	public void refresh() {
		this.atc.draw(canvas);
	}
	
	public void stop() throws Exception {
		this.runner.stop();
		this.runnerThread.join(500);
	}
	
	
			
}
