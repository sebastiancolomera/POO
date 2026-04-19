package controlador;

import modelo.Resultado;
import modelo.TipoApuesta;

public class ResultadoController {
    private Resultado ultimoResultado;

    public ResultadoController() {
        this.ultimoResultado = null;
    }

    public void registrarResultado(int numero, int apuesta, boolean acierto, TipoApuesta tipo) {
        this.ultimoResultado = new Resultado(numero, apuesta, acierto, tipo);
    }

    public Resultado getUltimoResultado() {
        return ultimoResultado;
    }

    public String getMensaje(boolean gano, int monto) {
        if (gano) {
            return "¡Ganaste " + monto + " fichas!";
        } else {
            return "Perdiste " + monto + " fichas.";
        }
    }
}