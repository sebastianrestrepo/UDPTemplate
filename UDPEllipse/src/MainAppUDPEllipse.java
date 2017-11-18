import processing.core.PApplet;

public class MainAppUDPEllipse extends PApplet {

	private ComunicacionEllipse c;
	
	public static void main(String[] args) {
		PApplet.main("MainAppUDPEllipse");
	}
	
	public void settings(){
		size(400, 400);
	}
	
	
	public void setup(){
		c = new ComunicacionEllipse();
		c.start();
	}
	
	public void draw() {
		background(255);
		/*
		if (dist(mouseX, mouseY, width / 2, height / 2) < 50) {
			c.enviarMensaje();
			System.out.println("Mensaje enviado :)");
		}*/
		noStroke();
		fill(13, 221, 255);
		ellipse(c.getMouseX(), c.getMouseY(), 50, 50);
		
	}
	
}