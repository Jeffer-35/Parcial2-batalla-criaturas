package com.batalla;

/**
 * Clase abstracta que representa a cualquier criatura del juego.
 * No se puede crear un objeto "Criatura" directamente, solo de sus
 * clases hijas (Dragon, Mago y Guerrero).
 */
public abstract class Criatura {

    // Atributos privados (encapsulamiento): se consultan con los getters
    private String nombre;
    private int salud;
    private int fuerza;

    /**
     * Constructor que usan las subclases con super(...).
     */
    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    /**
     * Método abstracto: cada criatura ataca de una forma distinta,
     * por eso cada subclase lo implementa a su manera.
     */
    public abstract void atacar(Criatura objetivo);

    /**
     * Método abstracto: cada criatura se defiende de una forma distinta.
     * El danio que llega es la fuerza del atacante (o el doble si es dragón).
     */
    public abstract void defender(int danio);

    /**
     * Método concreto: funciona igual para todas las criaturas.
     * Una criatura está viva mientras su salud sea mayor que 0.
     */
    public boolean estaViva() {
        return salud > 0;
    }

    /**
     * Le resta salud a la criatura. Es protected para que solo las
     * subclases lo usen dentro de defender(). La salud nunca queda negativa.
     */
    protected void recibirDanio(int danio) {
        salud = salud - danio;
        if (salud < 0) {
            salud = 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    @Override
    public String toString() {
        return nombre + " (salud: " + salud + ", fuerza: " + fuerza + ")";
    }
}