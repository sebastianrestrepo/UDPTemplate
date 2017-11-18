import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ComunicacionEllipse extends Thread {

	private DatagramSocket ds;
	private final static int PUERTO = 5000;
	private InetAddress ip;
	private int mouseX, mouseY;
	
	public ComunicacionEllipse() {
		try {
			ip = InetAddress.getByName("192.168.0.4");
			ds = new DatagramSocket(5000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void run() {
		while(true) {
			try {
				sleep(66);
				recibirMensaje();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void enviarMensaje() {
		try {
			String mensaje = "hola";
			byte [] buffer = new byte[1024];
			buffer = mensaje.getBytes();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ip, PUERTO);
			ds.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void recibirMensaje() {
        try {
            byte [] buffer = new byte [1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            ds.receive(packet);

            byte [] bytes = packet.getData();

            String s = new String(buffer, 0, packet.getLength());
           
            String [] mouse;
            
            mouse = s.split(",");

            System.out.println("[Mensaje recibido] mouseX: " + mouse[0] + ", mouseY: " + mouse[1]);

            mouseX = Integer.parseInt(mouse[0]);
            mouseY = Integer.parseInt(mouse[1]);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
}
