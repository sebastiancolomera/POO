import javax.swing.*;
import java.awt.*;

public class VentanaRegistro {
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JTextField txtNombre = new JTextField();
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnRegistrar = new JButton("Registrar");

    public VentanaRegistro() {
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 5, 5));
        agregarComponentes();
        btnRegistrar.addActionListener(e -> registrar());
    }

    private void agregarComponentes() {
        frame.add(new JLabel("Nombre:"));
        frame.add(txtNombre);
        frame.add(new JLabel("Usuario:"));
        frame.add(txtUsuario);
        frame.add(new JLabel("Clave:"));
        frame.add(txtClave);
        frame.add(new JLabel(""));
        frame.add(btnRegistrar);
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void registrar() {
        String n = txtNombre.getText().trim();
        String u = txtUsuario.getText().trim();
        String c = new String(txtClave.getPassword()).trim();

        if (validarCampos(n, u, c)) {
            procesarGuardado(n, u, c);
        }
    }

    private boolean validarCampos(String n, String u, String c) {
        if (n.isEmpty() || u.isEmpty() || c.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void procesarGuardado(String n, String u, String c) {
        //Agregar a la lista dinámica de la ventana de Login
        VentanaLogin.USUARIOS.add(new Usuario(u, c, n));
        JOptionPane.showMessageDialog(frame, "Registro exitoso! Ahora puedes iniciar sesión.");
        frame.dispose();
        new VentanaLogin().mostrarVentana();
    }
}