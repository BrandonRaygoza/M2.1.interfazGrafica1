package application;

import static java.lang.System.exit;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
//import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Interfaz {

	public static Scene JuegoScreen;
	public static Scene MenuScreen;
	public static Scene ScoreScreen;

	public static AudioClip music;
	
	
	public static Parent Scores(Stage primaryStage) 
	{
		Pane root = new Pane();
		root.setPrefSize(1024,768);
		
		Image arena= new Image("recursos/pasto.jpg");
        ImageView img = new ImageView(arena);
        img.setFitWidth(1024);
        img.setFitHeight(768);
		
    	MenuItem back = new MenuItem("ATRAS");
    	back.setTranslateY(730);
    	back.setOnMouseReleased(e ->{
    	primaryStage.setScene(MenuScreen);});
       
    	 root.getChildren().addAll(img, back);
        return root;
		
	}
	public static Parent Juego(Stage primaryStage) 
	{
		int cont=0;
		
		ImageView[]ImVi=new ImageView[5];
		Imagenes.Creador_ImaView(ImVi);
		Button[] basura =new Button[5];
		Button Reset =new Button();
		Reset=new Button("reset");
			
		Imagenes.Boton_basura(basura,ImVi);
		HBox Contenedor = new HBox();
		
		int x=Wcore.rng(5);
		ImVi[x].setX(250);
		ImVi[x].setY(470);
		basura[0].setVisible(true);
		//basura[0].getId()
		Text bote=new Text("Presiona"+ImVi[x].getId());
		bote.setX(250);
		bote.setY(470);
		
		Text ganaste=new Text("Ganaste");
		ganaste.setX(250);
		ganaste.setY(500);
		ganaste.setVisible(false);
		
		
		cont=Imagenes.Existencia(basura,ImVi[x].getId());
		Imagenes contador=new Imagenes(cont);
		
		  basura[0].setOnMouseClicked(e ->{	
				basura[0].setVisible(false);
				System.out.print(basura[0].getId());
				if (basura[0].getId().toString().equals(ImVi[x].getId())){
					contador.setCont(Wcore.dec(contador.getCont()));
				}
				System.out.print(contador.getCont());
				if(contador.getCont()==0) {
					ganaste.setVisible(true);
			bote.setVisible(false);
			Contenedor.setVisible(false);
			}
				
				});
		  basura[1].setOnMouseClicked(e ->{	
				basura[1].setVisible(false);
				System.out.print(basura[1].getId());
				if (basura[1].getId().toString().equals(ImVi[x].getId())){
					contador.setCont(Wcore.dec(contador.getCont()));
					System.out.print(contador.getCont());
				}
				if(contador.getCont()==0) {
					ganaste.setVisible(true);
					bote.setVisible(false);
					Contenedor.setVisible(false);
			}
				});
		  basura[2].setOnMouseClicked(e ->{	
				basura[2].setVisible(false);
				System.out.print(basura[2].getId());
				if (basura[2].getId().toString().equals(ImVi[x].getId())){
					contador.setCont(Wcore.dec(contador.getCont()));
					System.out.print(contador.getCont());
				}
				if(contador.getCont()==0) {
					ganaste.setVisible(true);
			bote.setVisible(false);
			Contenedor.setVisible(false);
			}
				});
		  basura[3].setOnMouseClicked(e ->{		
				basura[3].setVisible(false);
				System.out.print(basura[3].getId());
				if (basura[3].getId().toString().equals(ImVi[x].getId())){
					contador.setCont(Wcore.dec(contador.getCont()));
					System.out.print(contador.getCont());
				}
				if(contador.getCont()==0) {
					ganaste.setVisible(true);
			bote.setVisible(false);
			Contenedor.setVisible(false);
			}
				});
		  basura[4].setOnMouseClicked(e ->{	
				basura[4].setVisible(false);
				System.out.print(basura[4].getId());
				if (basura[4].getId().toString().equals(ImVi[x].getId())){
					contador.setCont(Wcore.dec(contador.getCont()));
					System.out.print(contador.getCont());
				}
				if(contador.getCont()==0) {
						ganaste.setVisible(true);
				bote.setVisible(false);
				Contenedor.setVisible(false);
				}
			
				});
		  Reset.setOnMouseClicked(e ->{					
				for (int i=0;i<5;i++) {
					basura[i].setVisible(true);	
					JuegoScreen = new Scene(Juego(primaryStage));
				}
				});
		
		
		Contenedor.setLayoutX(190);Contenedor.setLayoutY(65);
		Contenedor.getChildren().addAll(basura);
       
     
      
		Pane root = new Pane();
		root.setPrefSize(1024,768);
		
		Image arena= new Image("recursos/pasto.jpg");
        ImageView img = new ImageView(arena);
        img.setFitWidth(1024);
        img.setFitHeight(768);
        
    	 MenuItem back = new MenuItem("ATRAS");
    	 back.setTranslateY(730);
    	 back.setOnMouseClicked(e ->{ 
    		// Imagenes.SetVisibles(basura);
    		// Contenedor.setVisible(true);
    		 Imagenes.Cambiar_basura(basura, ImVi);
    		 primaryStage.setScene(MenuScreen);
    		
    	});
    	 root.getChildren().addAll(img,back,ImVi[x],Contenedor,Reset,bote,ganaste);
    	 
        return root;
	}
	
	
	public static Parent Menu(Stage primaryStage)
	{
		Pane root = new Pane();
		root.setPrefSize(1024,768);
		Image menu= new Image("recursos/fondo1.jpg");
		ImageView img = new ImageView(menu);	
		
		Titulo tittle = new Titulo ("GARBAGE RECYCLER",500);
		tittle.setTranslateX(500);
		tittle.setTranslateY(200);
	
		MenuItem solo = new MenuItem("JUGAR");
		solo.setOnMouseReleased (e ->{
			JuegoScreen = new Scene(Juego(primaryStage));
			primaryStage.setScene(JuegoScreen);});
		
		MenuItem puntajes = new MenuItem("PUNTAJES");
		puntajes.setOnMouseReleased (e ->{
			
			
		primaryStage.setScene(ScoreScreen);});
		
		MenuItem salir = new MenuItem("SALIR");
		salir.setOnMouseReleased(e -> exit(0));
		
		MenuBox vboxTittle = new MenuBox(solo,puntajes,salir);
		vboxTittle.setTranslateX(70);
		vboxTittle.setTranslateY(300);
		root.getChildren().addAll(img,tittle,vboxTittle);
		
	    return root;

}
	
	public void iniciaInterfaz(Stage primaryStage)  {
		JuegoScreen = new Scene(Juego(primaryStage));
		MenuScreen = new Scene(Menu(primaryStage));
		ScoreScreen = new Scene(Scores(primaryStage));
		primaryStage.setTitle("Scrap Boy");
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(MenuScreen);
		primaryStage.show();
		
	//	SelectMusic selectMusic = new SelectMusic();
		//selectMusic.seleccionM();
		//music.setCycleCount(AudioClip.INDEFINITE);
		//music.play();
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
				exit(0);
			}
		});
	}
}
