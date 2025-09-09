package listas.example.Aplicacion;

import java.io.*;
import java.net.*;

import listas.example.Conversiones.*;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket listener = new ServerSocket(3400)) {
            System.out.println("Servidor escuchando en puerto 3400...");

            while (true) {
                Socket socket = listener.accept();
                System.out.println("Cliente conectado.");

                BufferedReader fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter toNetwork = new PrintWriter(socket.getOutputStream(), true);

                String message = fromNetwork.readLine();
                System.out.println("[Servidor] Mensaje recibido: " + message);

                String respuesta = procesarMensaje(message);

                toNetwork.println(respuesta);
                System.out.println("[Servidor] Enviando respuesta: " + respuesta + "\n");

                socket.close();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static String procesarMensaje(String msg) {
        try {
            String[] partes = msg.split(";");
            int opcion = Integer.parseInt(partes[0]);
            String numero = partes[1];
            int ancho = partes.length > 2 ? Integer.parseInt(partes[2]) : 0;

            switch (opcion) {
                case 1:
                    return Decimal_Binario.convertir_Decimal_Binario(Integer.parseInt(numero), ancho);
                case 2:
                    return Binario_Decimal.convertir_Binario_Decimal(numero);
                case 3:
                    return Decimal_Hexadecimal.convertir_decimal_hexadecimal(Integer.parseInt(numero));
                case 4:
                    return Hexadecimal_Decimal.convertir_hexadecimal_decimal(numero);
                case 5:
                    Binario_Hexadecimal BH = new Binario_Hexadecimal();
                    return BH.convertir_Binario_Hexadecimal(numero);
                case 6:
                    Hexadecimal_Binario HB = new Hexadecimal_Binario();
                    return HB.convertir_Hexadecimal_Binario(numero);
                default:
                    return "ERROR: Opción no válida";
            }
        } catch (Exception e) {
            return "ERROR en conversión: " + e.getMessage();
        }
    }
}


