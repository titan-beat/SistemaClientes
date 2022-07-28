package utilidades;

public class Utilidad {
    public static void limpiarConsola() {
        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }
    }
    public static void esperar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
    public static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}

