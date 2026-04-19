import javax.swing.*;

public class VentanaSaludo {
    private final JFrame frame = new JFrame("Casino Black Cat - Menú Principal");
    private final JButton btnJugar = new JButton("Jugar Ruleta");
    private final JButton btnHistorial = new JButton("Ver Historial");
    private final JButton btnLogout = new JButton("Logout");
    private final Ruleta ruleta = new Ruleta();

    public VentanaSaludo() {
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        JLabel mensaje = new JLabel("Bienvenido al Casino Black Cat", SwingConstants.CENTER);
        JPanel panelBotones = new JPanel(new java.awt.GridLayout(3, 1, 10, 10));

        panelBotones.add(btnJugar);
        panelBotones.add(btnHistorial);
        panelBotones.add(btnLogout);

        frame.add(mensaje, BorderLayout.NORTH);
        frame.add(panelBotones, BorderLayout.CENTER);

        btnJugar.addActionListener(e -> abrirRuleta());
        btnHistorial.addActionListener(e -> verHistorial());
        btnLogout.addActionListener(e -> logout());
    }

    private void abrirRuleta() {
        frame.dispose();
        new VentanaRuleta().mostrarVentana();
    }

    private void verHistorial() {
        String stats = ruleta.getEstadisticas();
        JOptionPane.showMessageDialog(frame, stats, "Estadísticas", JOptionPane.INFORMATION_MESSAGE);
    }

    private void logout() {
        frame.dispose();
        new VentanaLogin().mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}