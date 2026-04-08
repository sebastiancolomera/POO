import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de la ventana de Login del Casino Black Cat.
 * Permite imgresar las credenciales para acceder al sistema.
 */

public class VentanaLogin {
    // === Lista dinamica de usuarios ===
    public static final List<Usuario> USUARIOS = new ArrayList<>();

    // === UI ===
    private final JFrame frame            = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario       = new JLabel("Usuario:");
    private final JTextField txtUsuario   = new JTextField();
    private final JLabel lblClave         = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar     = new JButton("Ingresar:");

    /**
     * Constructor que inicializa la ventana de Login.
     * Configura el tamaño, los componentes y los eventos.
     */
    public VentanaLogin() {
        //Inicializar usuarios harcodeados
        USUARIOS.add(new Usuario("admin", "DD777", "Don Donnie"));
        USUARIOS.add(new Usuario("jugador1","1234","Gato Ludopata"));

        configurarVentana();
    }
    private void configurarVentana() {
        frame.setSize(300,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.GridLayout(3,2,5,5)); //3 filas y 2 columnas

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(new JLabel("")); //Espacio para alinear el boton
        frame.add(btnIngresar);
    }

    /**
     * Muestra la ventana en pantalla.
     * Debe centrarla y hacerla visible.
     */
    public void mostrarVentana() {
        frame.setLocationRelativeTo(null); //Centra la ventana
        frame.setVisible(true);
    }

    /**
     * Maneja el evento de login al presionar el botón.
     * Debe validar credenciales y abrir la siguiente ventana o mostrar error.
     */
    private void login() {
        // TODO: implementar lógica de login
    }

    /**
     * Valida las credenciales del usuario contra el arreglo hardcoded.
     *
     * @param u nombre de usuario ingresado
     * @param p clave ingresada
     * @return el nombre del usuario si es válido, o cadena vacía si no coincide
     */
    private String validarCredenciales(String u, String p) {
        // Recorremos la lista dinámica de usuarios
        for (Usuario usuario : USUARIOS) {
            // Usamos el metodo de la clase Usuario para verificar
            if (usuario.validarCredenciales(u, p)) {
                // Si coincide, retornamos el nombre del jugador
                return usuario.getNombre();
            }
        }
        // Si el ciclo termina y no encontro a nadie, retorna texto vacio
        return "";
    }

    /**
     * Abre la ventana de registro para crear un nuevo usuario.
     * Debe cerrar la ventana actual e invocar a VentanaRegistro.
     */
    void abrirRegistro() {
        // TODO: abrir ventana de registro y cerrar login
    }
}