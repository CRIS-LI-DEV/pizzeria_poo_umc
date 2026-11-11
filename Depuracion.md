# Registro de depuración del proyecto de POO

**Proyecto:** Sistema de Gestión de Pedidos - Pizzería
**Equipo de Estudiantes:** Cristián Lillo, Diego Becerra, Víctor Torres
**Repositorio:** [Enlace a tu repositorio de GitHub]

## Episodio de depuración 1

1. **Problema detectado**
- **¿Qué comportamiento se esperaba?** Que la clase `Pedido` pudiera recibir cualquier producto del menú (`Pizza`, `Bebida`, `PaloDeAjo`) usando la interfaz `ItemPedido`, y que el cálculo de los descuentos funcionara de forma ordenada sin acoplar las reglas de negocio a la clase principal.
- **¿Qué ocurrió realmente?** Al cambiar el sistema de un arreglo fijo de pizzas (`Pizza[]`) a una lista abierta (`List<ItemPedido>`), el código dejó de compilar porque se seguían llamando métodos antiguos como `agregarPizza` y faltaba conectar correctamente las clases de descuento bajo principios de diseño orientados a objetos.

**2. Cómo se detectó**
- Se identificó al compilar el proyecto y ejecutar las pruebas en la clase `Main` al validar el cumplimiento de los principios SOLID.

**3. Decisión técnica adoptada**
- **Principio de Responsabilidad Única (SRP):** Se separó la lógica de cálculo de los descuentos sacándola del `Pedido` y delegándola en clases independientes (`SinDescuento` y `DescuentoPorcentaje`).
- **Principio Abierto/Cerrado (OCP):** Se estructuró el diseño mediante la interfaz `EstrategiaDescuento`, permitiendo agregar nuevas reglas de rebajas en el futuro sin necesidad de modificar el código existente en la clase `Pedido`.
- **Principio de Inversión de Dependencias (DIP):** Tanto el carrito de compras como las pruebas dependen de abstracciones e interfaces (`ItemPedido`, `EstrategiaDescuento`, `Persona`) y no de implementaciones concretas. Además, se actualizó `Pedido` para trabajar con una lista genérica (`ArrayList<ItemPedido>`).

**4. Modificación realizada**
- **`Pedido.java`**: Se cambió el arreglo de pizzas por una lista de ítems generales y se ajustó el método del total para que reciba la interfaz de descuento por inyección de dependencias.
- **`Main.java`**: Se actualizaron las llamadas de prueba para utilizar el nuevo método `agregarItem()` con distintos productos y pasar las clases de descuento correspondientes.

**5. Verificación del resultado**
- Se recompiló el proyecto y se ejecutó el `Main`. El programa corrió de manera exitosa, calculando correctamente los totales con y sin descuento mediante polimorfismo, sin arrojar errores de compilación y cumpliendo con los estándares de diseño.

**6. Evidencia del cambio en GitHub**
- Enlace al commit: [Enlace al commit de GitHub]
- Integrante(s) que participaron: Cristián Lillo, Diego Becerra, Víctor Torres