import java.util.Random;

public class Ruleta {
    private static final int MAX_HISTORIAL = 100;
    private final int[] historialNumeros = new int[MAX_HISTORIAL];
    private final int[] historialApuestas = new int[MAX_HISTORIAL];
    private final boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    private int historialSize = 0;
    private final Random rng = new Random();
    private final int[] numerosRojos = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};

    public Ruleta() {}

    public int getHistorialSize() { return historialSize; }
    public int[] getHistorialNumeros() { return historialNumeros; }
    public int[] getHistorialApuestas() { return historialApuestas; }
    public boolean[] getHistorialAciertos() { return historialAciertos; }

    public int girarRuleta() { return rng.nextInt(37); }

    public boolean esRojo(int n) {
        for (int rojo : numerosRojos) {
            if (n == rojo) { return true; }
        }
        return false;
    }

    public boolean evaluarResultado(int numero, char tipo) {
        if (numero == 0) return false;
        if (tipo == 'R') return esRojo(numero);
        if (tipo == 'N') return !esRojo(numero);
        if (tipo == 'P') return numero % 2 == 0;
        if (tipo == 'I') return numero % 2 != 0;
        return false;
    }

    public void registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;
            historialSize++;
        }
    }
}