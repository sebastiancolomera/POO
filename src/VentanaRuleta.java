import javax.swing.*;
import java.awt.*;

public class VentanaRuleta {
    private final JFrame frame = new JFrame("Ruleta - Casino Black Cat");
    private final Ruleta ruleta;
    private final JLabel lblNumero = new JLabel("Número: -");
    private final JLabel lblResultado = new JLabel("Resultado: -");
    private final JLabel lblBalance = new JLabel("Balance: 0");
    private final JTextField txtMonto = new JTextField();
    private final JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"ROJO", "NEGRO", "PAR", "IMPAR"});
    private final JButton btnJugar = new JButton("Girar Ruleta");
    private final JButton btnVolver = new JButton("Volver");

    public VentanaRuleta(Ruleta ruleta) {
        this.ruleta = ruleta;
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(7, 2, 5, 5));

        frame.add(new JLabel("Tipo de apuesta:"));
        frame.add(cmbTipo);
        frame.add(new JLabel("Monto:"));
        frame.add(txtMonto);
        frame.add(btnJugar);
        frame.add(btnVolver);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));
        frame.add(new JLabel("Número obtenido:"));
        frame.add(lblNumero);
        frame.add(new JLabel("Resultado:"));
        frame.add(lblResultado);
        frame.add(new JLabel(""));
        frame.add(lblBalance);

        btnJugar.addActionListener(e -> jugar());
        btnVolver.addActionListener(e -> volver());
    }

    private void jugar() {
        try {
            int monto = Integer.parseInt(txtMonto.getText());
            String tipoStr = (String) cmbTipo.getSelectedItem();
            char tipo = tipoStr.charAt(0);

            int numero = ruleta.girarRuleta();
            boolean gano = ruleta.evaluarResultado(numero, tipo);

            ruleta.registrarResultado(numero, monto, gano);

            lblNumero.setText("Número: " + numero);
            lblResultado.setText(gano ? "¡Ganaste!" : "Perdiste");
            lblBalance.setText("Balance: " + ruleta.getBalance());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volver() {
        frame.dispose();
        new VentanaSaludo(ruleta).mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}