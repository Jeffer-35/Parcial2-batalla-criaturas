# Aprendizajes, consultas y uso de Inteligencia Artificial

## Aprendizajes
- Una clase abstracta no se puede instanciar; sirve como "molde" para las subclases.
- Los métodos abstractos obligan a cada subclase a escribir su propia versión (`atacar` y `defender`).
- Con el polimorfismo, `simularBatalla` recibe `Criatura` y Java ejecuta el método de la clase real del objeto (Dragon, Mago o Guerrero).
- `protected` permite que las subclases usen `recibirDanio` sin que la salud sea pública.
- Hay que evitar ciclos infinitos: por eso el daño mínimo es 1.
- Flujo de Git: crear ramas, hacer commits, subir con push y unir a `main` con Pull Request.

## Consultas realizadas
- Repasé lo que vimos en clase sobre herencia, clases abstractas y polimorfismo, sobre todo el ejercicio de los ciclistas, que tenía una estructura parecida (clase padre abstracta y varias subclases).
- Consulté cómo funciona la palabra `abstract` en Java y por qué no se puede crear un objeto de una clase abstracta.
- Busqué la diferencia entre `private` y `protected`, porque necesitaba que las subclases pudieran bajarle la salud a la criatura sin que ese atributo quedara público.
- Consulté cómo se crea un Pull Request en GitHub y cómo subir una rama nueva con `git push -u origin`, porque al principio me salía el error de que la rama no tenía "upstream".
- Busqué cómo se hacen pruebas unitarias con JUnit 5 y qué hacen `assertEquals`, `assertTrue` y `assertFalse`.

## Uso de Inteligencia Artificial
- **Herramienta:** Claude (Anthropic).
- **Para qué la usé:** guía paso a paso del flujo de Git (clonar, ramas, commits, push y Pull Request), apoyo en la estructura del proyecto Maven, ideas para la forma de defenderse de cada criatura y ejemplos de pruebas unitarias con JUnit 5.
- **Qué hice yo:** creé el repositorio, organicé las carpetas, revisé y entendí el código, lo ejecuté, corrí las pruebas y subí todo con mis propias ramas y Pull Requests.

### Lo que aprendí al usarla
Usar la IA me sirvió como una guía paso a paso, sobre todo en la parte de Git, que era donde más me enredaba. Tuve varios errores, por ejemplo escribir mal el `git clone`, abrir la carpeta equivocada en VS Code o hacer `git push` sin haber subido la rama, y con eso entendí mejor qué hace cada comando y por qué va en ese orden.

También aprendí que no basta con copiar el código: tuve que revisar cada clase para entender por qué `Criatura` es abstracta, cómo cada criatura se defiende distinto y cómo `simularBatalla` funciona con cualquier criatura gracias al polimorfismo. Además, me di cuenta de que había que poner un daño mínimo de 1 para que la batalla no se quedara en un ciclo infinito.

La IA ayuda mucho a avanzar más rápido, pero hay que entender lo que se hace, porque al final soy yo el que tiene que explicar el código y resolver los errores cuando algo no funciona.