import javax.swing.*;

public class VentanaSaludo {
    private final JFrame frame = new JFrame("Casino Black Cat - Menú Principal");

    public VentanaSaludo() {
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centra la ventana

        JLabel mensaje = new JLabel("Has ingresado exitosamente al sistema!", SwingConstants.CENTER);
        frame.add(mensaje);
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
