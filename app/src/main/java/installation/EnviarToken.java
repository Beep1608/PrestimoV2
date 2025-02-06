package installation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EnviarToken {
    // Ruta del servidor
    private final String ruta = "localhost"; 
        /**
         * Envia el token proporcionado al servidor y obtiene la respuesta
         * (aceptado o rechazado).
         * 
         * @param token el token a enviar al servidor.
         */
    public void enviarToken(String token) {
         
        try (Socket socket = new Socket(ruta, 5000);
             DataInputStream din = new DataInputStream(socket.getInputStream());
             DataOutputStream dout = new DataOutputStream(socket.getOutputStream())) {

            dout.writeUTF(token);
            String respuesta = din.readUTF();

            if ("true".equals(respuesta)) {
                System.out.println("Token aceptado");
                
            } else {
                System.out.println("Token rechazado");
            }

        } catch (IOException e) {
            System.err.println("Error al comunicarse con el servidor: " + e.getMessage());
        }
    }
}
