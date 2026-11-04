package com.batalla;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias del juego de batallas.
 * Cada prueba revisa una regla de ataque, defensa o de la batalla.
 */
public class CriaturaTest {

    // Caso 1: una criatura recién creada está viva
    @Test
    void criaturaNuevaEstaViva() {
        Criatura guerrero = new Guerrero("Aquiles", 100, 20, "espada");
        assertTrue(guerrero.estaViva());
    }

    // Caso 2: el dragón ataca con fuerza * 2 (10 * 2 = 20, el guerrero bloquea 5 -> pierde 15)
    @Test
    void dragonAtacaConDobleFuerza() {
        Criatura dragon = new Dragon("Smaug", 100, 10, "rojas");
        Criatura guerrero = new Guerrero("Aquiles", 100, 20, "espada");
        dragon.atacar(guerrero);
        assertEquals(85, guerrero.getSalud());
    }

    // Caso 3: las escamas del dragón absorben el 25% (20 de daño -> pierde 15)
    @Test
    void dragonAbsorbeUnCuartoDelDanio() {
        Criatura dragon = new Dragon("Smaug", 100, 10, "rojas");
        dragon.defender(20);
        assertEquals(85, dragon.getSalud());
    }

    // Caso 4: el mago usa escudo si el daño es mayor a 10 (20 -> pierde 10)
    @Test
    void magoUsaEscudoConGolpeFuerte() {
        Criatura mago = new Mago("Merlin", 100, 18, "Bola de fuego");
        mago.defender(20);
        assertEquals(90, mago.getSalud());
    }

    // Caso 5: el mago NO usa escudo si el daño es 10 o menos (10 -> pierde 10)
    @Test
    void magoSinEscudoConGolpeDebil() {
        Criatura mago = new Mago("Merlin", 100, 18, "Bola de fuego");
        mago.defender(10);
        assertEquals(90, mago.getSalud());
    }

    // Caso 6: el guerrero bloquea 5 puntos (ataque del mago de 8 -> pierde 3)
    @Test
    void guerreroBloqueaCincoPuntos() {
        Criatura mago = new Mago("Merlin", 100, 8, "Bola de fuego");
        Criatura guerrero = new Guerrero("Aquiles", 50, 20, "espada");
        mago.atacar(guerrero);
        assertEquals(47, guerrero.getSalud());
    }

    // Caso 7: aunque el bloqueo sea mayor que el golpe, siempre pierde mínimo 1
    @Test
    void danioMinimoEsUno() {
        Criatura guerrero = new Guerrero("Aquiles", 50, 20, "espada");
        guerrero.defender(3);
        assertEquals(49, guerrero.getSalud());
    }

    // Caso 8: la salud nunca queda negativa y la criatura queda muerta
    @Test
    void saludNoQuedaNegativa() {
        Criatura guerrero = new Guerrero("Aquiles", 5, 20, "espada");
        guerrero.defender(100);
        assertEquals(0, guerrero.getSalud());
        assertFalse(guerrero.estaViva());
    }

    // Caso 9: al terminar la batalla queda exactamente una criatura viva
    @Test
    void batallaTerminaConUnSoloGanador() {
        Criatura dragon = new Dragon("Smaug", 120, 15, "rojas");
        Criatura mago = new Mago("Merlin", 100, 18, "Bola de fuego");
        Main.simularBatalla(dragon, mago);
        assertTrue(dragon.estaViva() ^ mago.estaViva());
    }
}