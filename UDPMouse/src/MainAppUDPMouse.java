import processing.core.*;

public class MainAppUDPMouse extends PApplet {

	private ComunicacionEllipse c;
	
	public static void main(String[] args) {
		PApplet.main("MainAppUDPMouse");
	}
	
	public void settings(){
		size(400, 400);
	}
	
	public void setup(){
		c = new ComunicacionEllipse();
		background(255);
		c.start();
		//ellipse(width / 2, height / 2, 50, 50);
	}
	
	@Override
	public void draw() {
		background(255);
		fill(0);
		//ellipse(width / 2, height / 2, 50, 50);
		//c.recibirMensaje();
		text(mouseX + ", " + mouseY, mouseX, mouseY);
		c.enviarMensaje(mouseX, mouseY);
		System.out.println("Mensaje enviado :)");
	}
	
}
