package modelo;

import java.util.Random;

public class Ruleta {
    private static final int MAX_HISTORIAL = 100;
    private final int[] historialNumeros = new int[MAX_HISTORIAL];
    private final int[] historialApuestas = new int[MAX_HISTORIAL];
    private final boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    private int historialSize = 0;
    private int balance = 0;
    private final Random rng = new Random();
    private final int[] numerosRojos = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};

    public Ruleta() {
        this.balance = 0;
    }

    public Ruleta(int saldoInicial) {
        this.balance = saldoInicial;
    }

    public int getBalance() {
        return balance;
    }

    public void depositar(int monto) {
        if (monto > 0) {
            balance += monto;
        }
    }

    public int getHistorialSize() {
        return historialSize;
    }

    public int[] getHistorialNumeros() {
        return historialNumeros;
    }

    public int[] getHistorialApuestas() {
        return historialApuestas;
    }

    public boolean[] getHistorialAciertos() {
        return historialAciertos;
    }

    public int girarRuleta() {
        return rng.nextInt(37);
    }

    public boolean esRojo(int n) {
        for (int rojo : numerosRojos) {
            if (n == rojo) {
                return true;
            }
        }
        return false;
    }

    public boolean evaluarResultado(int numero, TipoApuesta tipo) {
        if (numero == 0) {
            return false;
        }
        if (tipo == TipoApuesta.ROJO) {
            return esRojo(numero);
        }
        if (tipo == TipoApuesta.NEGRO) {
            return !esRojo(numero);
        }
        if (tipo == TipoApuesta.PAR) {
            return numero % 2 == 0;
        }
        if (tipo == TipoApuesta.IMPAR) {
            return numero % 2 != 0;
        }
        return false;
    }

    public void registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;
            balance += acierto ? apuesta : -apuesta;
            historialSize++;
        }
    }

    public String getEstadisticas() {
        int apostado = 0, aciertos = 0;
        for (int i = 0; i < historialSize; i++) {
            apostado += historialApuestas[i];
            if (historialAciertos[i]) {
                aciertos++;
            }
        }
        double porcentaje = (historialSize == 0) ? 0 : (aciertos * 100.0) / historialSize;
        return "Rondas: " + historialSize + "\nTotal Apostado: " + apostado
                + "\nAciertos: " + aciertos + "\nBalance: " + balance
                + "\nPorcentaje: " + String.format("%.1f", porcentaje) + "%";
    }
}