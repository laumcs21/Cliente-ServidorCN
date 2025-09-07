package listas.example.Aplicacion;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class Cliente extends JFrame {
    private JTextArea pantalla;
    private JTextField txtOpcion, txtNumero, txtAncho;
    private JButton btnEnviar;

    public Cliente() {
        setTitle("Cliente Conversor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pantalla = new JTextArea();
        pantalla.setEditable(false);
        pantalla.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(pantalla);

        JPanel panelEntrada = new JPanel(new GridLayout(4, 2, 5, 5));
        panelEntrada.add(new JLabel("Opción (1-6):"));
        txtOpcion = new JTextField();
        panelEntrada.add(txtOpcion);

        panelEntrada.add(new JLabel("Número:"));
        txtNumero = new JTextField();
        panelEntrada.add(txtNumero);

        panelEntrada.add(new JLabel("Longitud/Ancho (si aplica):"));
        txtAncho = new JTextField();
        panelEntrada.add(txtAncho);

        btnEnviar = new JButton("Enviar");
        panelEntrada.add(new JLabel());
        panelEntrada.add(btnEnviar);

        add(scroll, BorderLayout.CENTER);
        add(panelEntrada, BorderLayout.SOUTH);

        mostrarMenu();

        btnEnviar.addActionListener(e -> procesarEnvio());
    }

    private void mostrarMenu() {
        pantalla.append("=== Cliente Conversor ===\n");
        pantalla.append("1. Convertir Decimal a Binario\n");
        pantalla.append("2. Convertir Binario a Decimal\n");
        pantalla.append("3. Convertir Decimal a Hexadecimal\n");
        pantalla.append("4. Convertir Hexadecimal a Decimal\n");
        pantalla.append("5. Convertir Binario a Hexadecimal\n");
        pantalla.append("6. Convertir Hexadecimal a Binario\n");
        pantalla.append("=========================\n");
    }

    private void procesarEnvio() {
        try {
            String opcion = txtOpcion.getText().trim();
            String numero = txtNumero.getText().trim();
            String ancho = txtAncho.getText().trim();

            if (opcion.isEmpty() || numero.isEmpty()) {
                pantalla.append("Debe ingresar opción y número.\n");
                return;
            }

            String mensaje = opcion + ";" + numero;
            if (!ancho.isEmpty()) {
                mensaje += ";" + ancho;
            }

            pantalla.append("[Cliente] Enviando mensaje \"" + mensaje + "\\n\" al servidor\n");

            try (Socket socket = new Socket("localhost", 3400);
                 PrintWriter toNetwork = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                toNetwork.println(mensaje);
                String respuesta = fromNetwork.readLine();

                pantalla.append("[Servidor] Respuesta: " + respuesta + "\\n\n");
            }

        } catch (Exception ex) {
            pantalla.append("Error: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Cliente().setVisible(true));
    }
}

