package controlador;

import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class SessionController {
    private static SessionController instancia;
    private Usuario usuarioActual;
    private final List<Usuario> usuarios;

    private SessionController() {
        this.usuarios = new ArrayList<>();
        inicializarUsuarios();
    }

    public static SessionController getInstancia() {
        if (instancia == null) {
            instancia = new SessionController();
        }
        return instancia;
    }

    private void inicializarUsuarios() {
        usuarios.add(new Usuario("admin", "DD777", "Don Donnie"));
        usuarios.add(new Usuario("jugador1", "1234", "Gato Ludopata"));
    }

    public Usuario login(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.validarCredenciales(username, password)) {
                this.usuarioActual = usuario;
                return usuario;
            }
        }
        return null;
    }

    public void registro(String username, String password, String nombre) {
        Usuario nuevo = new Usuario(username, password, nombre);
        usuarios.add(nuevo);
        this.usuarioActual = nuevo;
    }

    public void logout() {
        this.usuarioActual = null;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public boolean isLoggedIn() {
        return usuarioActual != null;
    }
}