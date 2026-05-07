package vista;

import javax.swing.*;
import java.awt.*;
import modelo.TipoApuesta;
import controlador.RuletaController;

public class VentanaRuleta {
    private final JFrame frame = new JFrame("Ruleta - Casino Black Cat");
    private final RuletaController ruletaController;
    private final JLabel lblNumero = new JLabel("Número: -");
    private final JLabel lblResultado = new JLabel("Resultado: -");
    private final JLabel lblBalance = new JLabel("Balance: 0");
    private final JTextField txtMonto = new JTextField();
    private final JComboBox<TipoApuesta> cmbTipo = new JComboBox<>(TipoApuesta.values());
    private final JButton btnJugar = new JButton("Girar Ruleta");
    private final JButton btnVolver = new JButton("Volver");

    public VentanaRuleta(RuletaController ruletaController) {
        this.ruletaController = ruletaController;
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
            TipoApuesta tipo = (TipoApuesta) cmbTipo.getSelectedItem();

            int numero = ruletaController.getRuleta().girarRuleta();
            boolean gano = ruletaController.getRuleta().evaluarResultado(numero, tipo);

            ruletaController.jugar(monto, tipo);

            lblNumero.setText("Número: " + numero);
            lblResultado.setText(gano ? "¡Ganaste!" : "Perdiste");
            lblBalance.setText("Balance: " + ruletaController.getBalance());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volver() {
        frame.dispose();
        new VentanaSaludo(ruletaController).mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}