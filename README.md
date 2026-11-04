# Parcial II - Programación II (G412) - Batalla de Criaturas

## Integrante
| Nombre | Usuario GitHub | Ramas |
|---|---|---|
| Jefferson Paredes Espinel | Jeffer-35 | `jefferson`, `jefferson-pruebas` |

## Descripción
Juego de batallas por turnos entre criaturas, hecho en Java con **clases abstractas** y **polimorfismo**.

- `Criatura` (abstracta): atributos `nombre`, `salud`, `fuerza`; métodos abstractos `atacar(Criatura objetivo)` y `defender(int danio)`; método concreto `estaViva()`.
- `Dragon`: ataca con fuego (fuerza × 2). Sus escamas absorben el 25% del daño.
- `Mago`: ataca con hechizos (fuerza). Si el golpe es mayor a 10 usa escudo mágico y recibe la mitad.
- `Guerrero`: ataca con su espada (fuerza). Bloquea 5 puntos de cada golpe.
- `Main`: crea las criaturas y tiene `simularBatalla(Criatura, Criatura)`, que funciona con cualquier criatura gracias al polimorfismo.

En todas las defensas el daño mínimo es 1, para que la batalla siempre termine.

## Estructura
```
src/main/java/com/batalla/   Criatura, Dragon, Mago, Guerrero, Main
src/test/java/com/batalla/   CriaturaTest (pruebas unitarias)
```

## Cómo ejecutar
```
mvn compile
mvn exec:java -Dexec.mainClass=com.batalla.Main
mvn test
```
(También se puede ejecutar `Main.java` con el botón Run de VS Code.)

## Pruebas unitarias (JUnit 5)
| # | Prueba | Qué se comprueba |
|---|---|---|
| 1 | criaturaNuevaEstaViva | Una criatura recién creada está viva |
| 2 | dragonAtacaConDobleFuerza | El dragón hace fuerza × 2 de daño |
| 3 | dragonAbsorbeUnCuartoDelDanio | Las escamas absorben el 25% |
| 4 | magoUsaEscudoConGolpeFuerte | Con daño > 10 el mago recibe la mitad |
| 5 | magoSinEscudoConGolpeDebil | Con daño ≤ 10 el mago recibe el golpe completo |
| 6 | guerreroBloqueaCincoPuntos | El guerrero le resta 5 al golpe |
| 7 | danioMinimoEsUno | Aunque el bloqueo sea mayor, se pierde mínimo 1 |
| 8 | saludNoQuedaNegativa | La salud baja hasta 0 y la criatura queda muerta |
| 9 | batallaTerminaConUnSoloGanador | Al final de la batalla solo queda una criatura viva |

## Flujo de Git
El trabajo se hizo en ramas separadas (`jefferson` y `jefferson-pruebas`) y cada una se integró a `main` por medio de Pull Request. Por indicación del profesor, el proyecto se completó de forma individual porque la compañera no realizó su parte.

Repositorio: https://github.com/Jeffer-35/Parcial2-batalla-criaturas