package com.batalla;

/**
 * El guerrero ataca con su arma (espada) usando su fuerza normal.
 * Se defiende bloqueando con el arma, lo que le quita 5 puntos al golpe.
 */
public class Guerrero extends Criatura {

    // Atributo propio del guerrero (según el diagrama UML)
    private String arma;

    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    /**
     * Ataque del guerrero: golpea con su arma, daño igual a su fuerza.
     */
    @Override
    public void atacar(Criatura objetivo) {
        int danio = getFuerza();
        System.out.println(getNombre() + " ataca con su " + arma + " a "
                + objetivo.getNombre() + " (ataque de " + danio + ")");
        objetivo.defender(danio);
    }

    /**
     * Defensa del guerrero: bloquea 5 puntos del golpe.
     * Siempre recibe mínimo 1 para que la batalla no quede infinita.
     */
    @Override
    public void defender(int danio) {
        int danioFinal = Math.max(1, danio - 5);
        recibirDanio(danioFinal);
        System.out.println("   " + getNombre() + " bloquea con su " + arma
                + " y pierde " + danioFinal + " de salud");
    }

    public String getArma() {
        return arma;
    }
}