# Registro de depuración del proyecto de POO

**Proyecto:** Sistema de Gestión de Pedidos - Pizzería
**Equipo de Estudiantes:** Cristián Lillo, Diego Becerra, Víctor Torres
**Repositorio:** [Enlace a tu repositorio de GitHub]

## Episodio de depuración 1

1. **Problema detectado**
- **¿Qué comportamiento se esperaba?** Que la clase `Pedido` pudiera recibir cualquier producto del menú (`Pizza`, `Bebida`, `PaloDeAjo`) usando la interfaz `ItemPedido`, y que el cálculo de los descuentos funcionara de forma ordenada.
- **¿Qué ocurrió realmente?** Al cambiar el sistema de un arreglo fijo de pizzas (`Pizza[]`) a una lista abierta (`List<ItemPedido>`), el código dejó de compilar porque se seguían llamando métodos antiguos como `agregarPizza` y faltaba conectar correctamente las clases de descuento.

**2. Cómo se detectó**
- Se identificó al compilar el proyecto y ejecutar las pruebas en la clase `Main`.

**3. Decisión técnica adoptada**
- Actualizamos `Pedido` para que trabaje con una lista genérica de productos (`ArrayList<ItemPedido>`) y estructuramos el cálculo de totales separando las reglas en clases independientes (`SinDescuento` y `DescuentoPorcentaje`) que implementan una interfaz en común (`EstrategiaDescuento`). Esto nos permite delegar el cálculo del total de forma polimórfica y evitar llenar la clase principal de condicionales.

**4. Modificación realizada**
- **`Pedido.java`**: Cambiamos el arreglo de pizzas por una lista de ítems generales y ajustamos el método del total para que reciba la interfaz de descuento.
- **`Main.java`**: Actualizamos las llamadas de prueba para usar el nuevo método `agregarItem()` con distintos productos y pasar las clases de descuento correspondientes.

**5. Verificación del resultado**
- Se recompiló el proyecto y se ejecutó el `Main`. El programa corrió de manera exitosa, calculando correctamente los totales con y sin descuento, sin arrojar errores de compilación.

**6. Evidencia del cambio en GitHub**
- Enlace al commit: [Enlace al commit de GitHub]
- Integrante(s) que participaron: Cristián Lillo, Diego Becerra, Víctor Torres