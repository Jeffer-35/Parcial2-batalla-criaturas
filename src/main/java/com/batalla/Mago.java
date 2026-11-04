package com.batalla;

/**
 * El mago ataca con hechizos usando su fuerza normal.
 * Se defiende con un escudo mágico que solo se activa con golpes fuertes.
 */
public class Mago extends Criatura {

    // Atributo propio del mago (según el diagrama UML)
    private String hechizos;

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    /**
     * Ataque del mago: lanza su hechizo y hace daño igual a su fuerza.
     */
    @Override
    public void atacar(Criatura objetivo) {
        int danio = getFuerza();
        System.out.println(getNombre() + " lanza el hechizo " + hechizos + " contra "
                + objetivo.getNombre() + " (ataque de " + danio + ")");
        objetivo.defender(danio);
    }

    /**
     * Defensa del mago: si el golpe es mayor a 10, activa el escudo
     * mágico y solo recibe la mitad. Si es 10 o menos, lo recibe completo.
     */
    @Override
    public void defender(int danio) {
        int danioFinal;
        if (danio > 10) {
            danioFinal = Math.max(1, danio / 2);
            System.out.print("   " + getNombre() + " activa su escudo magico");
        } else {
            danioFinal = Math.max(1, danio);
            System.out.print("   " + getNombre() + " no alcanza a usar el escudo");
        }
        recibirDanio(danioFinal);
        System.out.println(" y pierde " + danioFinal + " de salud");
    }

    public String getHechizos() {
        return hechizos;
    }
}