# Registro de depuración del proyecto de POO

**Proyecto:** Sistema de Gestión de Pedidos - Pizzería
**Equipo de Estudiantes:** Cristián Lillo, Diego Becerra, Víctor Torres
**Repositorio:** [Enlace a tu repositorio de GitHub]

## Episodio de depuración 1

1. **Problema detectado**
- **¿Qué comportamiento se esperaba?** Se esperaba que la clase `Pedido` pudiera almacenar y gestionar de forma polimórfica múltiples tipos de productos del menú (`Pizza`, `Bebida`, `PaloDeAjo`) a través de la interfaz común `ItemPedido`, manteniendo además el cálculo de totales desacoplado mediante el Patrón Strategy para los descuentos.
- **¿Qué ocurrió realmente?** Al intentar migrar la estructura interna de almacenamiento de un arreglo estricto de pizzas (`Pizza[]`) a una lista dinámica (`List<ItemPedido>`), la clase `Main` y la clase `Pedido` sufrieron errores de compilación por incompatibilidad de tipos y llamadas a métodos obsoletos (`agregarPizza`, `cuantasPizzasLleva`), sumado a que el método de cálculo de totales requería la correcta inyección de la interfaz de descuento.

**2. Cómo se detectó**
- Se identificó mediante el análisis estático del código y las pruebas de compilación al integrar los nuevos productos del menú junto con los principios SOLID (SRP, OCP, DIP).

**3. Decisión técnica adoptada**
- Refactorizar la clase `Pedido` para reemplazar el arreglo por un `ArrayList<ItemPedido>`, actualizando los métodos de adición (`agregarItem`) y conteo (`cantidadItems`). Asimismo, integrar la interfaz `EstrategiaDescuento` junto con sus clases concretas (`SinDescuento`, `DescuentoPorcentaje`) para cumplir con el principio Abierto/Cerrado (OCP), y actualizar la clase `Main` para reflejar estas nuevas firmas polimórficas.

**4. Modificación realizada**
- **`Pedido.java`**: Se cambió el atributo `Pizza[] pizzas` por `List<ItemPedido> items` y se ajustó el método `total(EstrategiaDescuento estrategia)` para delegar el cálculo de rebajas.
- **`Main.java`**: Se actualizaron las llamadas de prueba para utilizar `agregarItem()` con diferentes implementaciones de `ItemPedido` (`Pizza`, `Bebida`, `PaloDeAjo`) y se incorporó el paso de estrategias de descuento.

**5. Verificación del resultado**
- Se recompiló el proyecto y se ejecutó la clase `Main`. La aplicación procesó satisfactoriamente el polimorfismo de los ítems, calculó de forma correcta los totales aplicando la estrategia de descuento y finalizó sin errores de compilación ni excepciones.

**6. Evidencia del cambio en GitHub**
- Enlace al commit, pull request o cambio identificable: [Enlace al commit de GitHub]
- Integrante(s) que participaron: Cristián Lillo, Diego Becerra, Víctor Torres