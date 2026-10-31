package com.batalla;

/**
 * El dragón es la criatura con el ataque más fuerte (fuerza * 2).
 * Se defiende con sus escamas, que absorben el 25% del daño.
 */
public class Dragon extends Criatura {

    // Atributo propio del dragón (según el diagrama UML)
    private String escamas;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    /**
     * Ataque del dragón: lanza fuego y hace el doble de su fuerza.
     */
    @Override
    public void atacar(Criatura objetivo) {
        int danio = getFuerza() * 2;
        System.out.println(getNombre() + " lanza fuego contra " + objetivo.getNombre()
                + " (ataque de " + danio + ")");
        objetivo.defender(danio);
    }

    /**
     * Defensa del dragón: las escamas absorben la cuarta parte del golpe.
     * Siempre recibe mínimo 1 para que la batalla no quede infinita.
     */
    @Override
    public void defender(int danio) {
        int absorbido = danio / 4;
        int danioFinal = Math.max(1, danio - absorbido);
        recibirDanio(danioFinal);
        System.out.println("   " + getNombre() + " se cubre con sus escamas " + escamas
                + ", absorbe " + absorbido + " y pierde " + danioFinal + " de salud");
    }

    public String getEscamas() {
        return escamas;
    }
}