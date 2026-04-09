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

        frame.add(new JLabel("Nombre:"));
        frame.add(txtNombre);
        frame.add(new JLabel("Usuario:"));
        frame.add(txtUsuario);
        frame.add(new JLabel("Clave:"));
        frame.add(txtClave);
        frame.add(new JLabel(""));
        frame.add(btnRegistrar);

        btnRegistrar.addActionListener(e -> registrar());
    }
}
