package com.batalla;

/**
 * Clase principal: crea las criaturas y simula las batallas.
 */
public class Main {

    public static void main(String[] args) {

        // POLIMORFISMO: todas las variables son de tipo Criatura,
        // pero cada una guarda un objeto de una subclase diferente.
        Criatura[][] batallas = {
            { new Dragon("Smaug", 120, 15, "rojas"), new Mago("Merlin", 100, 18, "Bola de fuego") },
            { new Guerrero("Aquiles", 110, 20, "espada"), new Dragon("Drogon", 120, 14, "negras") },
            { new Mago("Gandalf", 100, 17, "Rayo de luz"), new Guerrero("Leonidas", 115, 19, "espada") }
        };

        // Se recorre cada pareja y se simula su batalla
        for (int i = 0; i < batallas.length; i++) {
            System.out.println("\n========== BATALLA " + (i + 1) + " ==========");
            simularBatalla(batallas[i][0], batallas[i][1]);
        }
    }

    /**
     * Simula una batalla por turnos entre dos criaturas cualquiera.
     * Recibe parámetros de tipo Criatura (polimorfismo), así sirve para
     * dragones, magos, guerreros o cualquier criatura nueva que se cree.
     * La batalla sigue hasta que una de las dos se quede sin salud.
     */
    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println(criatura1 + "  VS  " + criatura2);

        int ronda = 1;
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("\n--- Ronda " + ronda + " ---");

            // Turno de la criatura 1: Java ejecuta el atacar() de su clase real
            criatura1.atacar(criatura2);
            mostrarSalud(criatura1, criatura2);

            // Si la criatura 2 ya murió, no puede contraatacar
            if (!criatura2.estaViva()) {
                break;
            }

            // Turno de la criatura 2
            criatura2.atacar(criatura1);
            mostrarSalud(criatura1, criatura2);

            ronda++;
        }

        // Resultado final de la batalla
        Criatura ganador = criatura1.estaViva() ? criatura1 : criatura2;
        Criatura perdedor = criatura1.estaViva() ? criatura2 : criatura1;
        System.out.println("\nRESULTADO: " + ganador.getNombre() + " gana con "
                + ganador.getSalud() + " de salud. " + perdedor.getNombre() + " fue derrotado.");
    }

    /**
     * Muestra la salud actual de las dos criaturas después de cada ataque.
     */
    private static void mostrarSalud(Criatura c1, Criatura c2) {
        System.out.println("   Salud -> " + c1.getNombre() + ": " + c1.getSalud()
                + " | " + c2.getNombre() + ": " + c2.getSalud());
    }
}