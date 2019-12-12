package application;

import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Imagenes {
	public static final int Altura =110;
	public static final int Ancho =110;
	private  int cont;
	
	public static void Creador_Image(Image[] Im,String[] Ruta) {
		Direcciones(Ruta);
		for (int i=0;i<5;i++) {
			
			 Im[i]=new Image(Ruta[i]); 
		}
	
	}
	public static int Existencia(Button[] basura,String busqueda) {
			int cont=0;
		for (int i=0;i<5;i++) {
			if(basura[i].getId().toString().equals(busqueda)){
			cont++;	
			}
		}
		
		
		
		return cont;
		
		
	}
	public Imagenes(int cont) {
		this.cont=cont;
	}
	
	public static void Creador_ImaView(ImageView[] ImVi) {
		Image[] Im=new Image[5];
		String[] Ruta =new String[5];
		Creador_Image(Im,Ruta);
		for (int i=0;i<5;i++) {
			 ImVi[i]=new ImageView(Im[i]);
			 ImVi[i].setId(Ruta[i]);
			 ImVi[i].setFitHeight(Altura);ImVi[i].setFitWidth(Ancho);
			 
	
		}

	}
	public static void Boton_basura(Button[] basura,ImageView[] ImVi) {
		for (int i=0;i<5;i++) {

			 basura[i] = new Button("",ImVi[i]);
			 basura[i].setId(ImVi[i].getId());
			 basura[i].setContentDisplay(ContentDisplay.TOP);
			 basura[i].setPrefSize(Altura,Ancho);
		}
		
	}
	
	public static void Cambiar_basura(Button[] basura,ImageView[] ImVi) {
		
		for (int i=0;i<5;i++) {
	
			 basura[i] = new Button("",ImVi[i]);
			 basura[i].setId(String.valueOf(i));
			 basura[i].setContentDisplay(ContentDisplay.TOP);
			 basura[i].setPrefSize(Altura,Ancho);
		}
	}
	
	
	
	
	
	
	public static void Direcciones(String[] Ruta) {
		String[] Rutas=new String[5];
		
		Rutas[0]="recursos/vintage-robot (2).png";
		Rutas[1]="recursos/Fo4_baseball.png";
		Rutas[2]="recursos/Camera_fo4.png";
		Rutas[3]="recursos/Carlisle_typewriter.png";
		Rutas[4]="recursos/High_powered_microscope.png";
		for (int i=0;i<5;i++) {
			
			Ruta[i]=Rutas[rng(5)];
		}
		
		
	}
	public static int rng(int dis)
	{
		Random rand = new Random();
		int valor = rand.nextInt(dis);
		System.out.print(valor);
		return valor;
	}


	public static void SetVisibles(Button[] basura) {
		for (int i=0;i<5;i++) {
			basura[i].setVisible(true);
			
		}
		
	}
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
	
}

