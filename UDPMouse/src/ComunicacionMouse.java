import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ComunicacionMouse extends Thread {

	private DatagramSocket ds;
	private final static int PUERTO = 5000;
	private InetAddress ip; 
	
	public ComunicacionMouse() {
		try {
			ip = InetAddress.getByName("192.168.0.4");
			ds = new DatagramSocket();
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
	
	public void enviarMensaje(int mouseX, int mouseY) {
		try {
			String mensaje = mouseX +"," + mouseY;
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

            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
}
