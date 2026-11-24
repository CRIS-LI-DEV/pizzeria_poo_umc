# Sistema de Gestión de Pedidos — Pizzería (Solemne N.º 2)

**Asignatura:** PRE-24067 · Programación Orientada a Objetos  
**Institución:** Universidad Miguel de Cervantes · Segundo Semestre 2026  
**Docente:** Mario Leiva  
**Equipo de Estudiantes:** Cristián Lillo, Diego Becerra, Víctor Torres  

---

## 1. Descripción del Proyecto

Sistema orientado a objetos desarrollado en Java para gestionar el flujo completo de pedidos de una pizzería: registro de clientes y direcciones de despacho, armado polimórfico de órdenes con productos del catálogo (`Pizza`, `PaloDeAjo`, `Bebida`), seguimiento de preparación en cocina, asignación de repartidores, aplicación dinámica de políticas de descuento y emisión de comprobantes de pago (`Boleta`).

En esta versión correspondiente a la **Solemne N.º 2**, se realizó una auditoría y refactorización integral sobre el código base de la Cátedra 4 para asegurar el cumplimiento estricto de los **Capítulos 4, 5, 6 y 7**, además de resolver las observaciones registradas en **GitHub Issues**.

---

## 2. Tabla de Cumplimiento por Capítulo (Capítulos 4 al 7)

| Capítulo | Requisito / Indicador Verificable | Ubicación en el Código (Archivo, Clase y Método) | Evidencia / Cambio respecto de C4 |
| :--- | :--- | :--- | :--- |
| **Cap. 4** | Privacidad estricta de atributos de instancia | Todas las clases (`Pedido.java`, `Cliente.java`, `Bebida.java`, `Boleta.java`, `Direccion.java`, `Persona.java`) | 100% de los atributos de instancia declarados `private`; no existen atributos `public` no constantes. |
| **Cap. 4** | Al menos 5 setters con validaciones de dominio | `Bebida.java` (`setNombre`, `setPrecio`, `setTamanio`), `Persona.java` (`setNombre`, `setTelefono`, `setEmail`), `Direccion.java` (`setCalle`, `setNumero`, `setComuna`) | Se validan referencias `null`, cadenas vacías con `trim().isEmpty()`, presencia de `@` en correos y valores numéricos no negativos. |
| **Cap. 4** | Al menos 3 atributos de instancia `final` | `Boleta.java` (`numeroTransaccion`, `estado`), `DescuentoPorcentaje.java` (`porcentaje`), `Persona.java` (`rut`), `Pedido.java` (`id`, `cliente`) | Se incorporaron 6 atributos `private final` para asegurar la inmutabilidad de datos críticos tras instanciar los objetos. |
| **Cap. 4** | Al menos 2 constantes `private static final` | `Bebida.java` (`NOMBRE_POR_DEFECTO`, `PRECIO_POR_DEFECTO`), `Boleta.java` (`FACTOR_TRANSACCION`, `ESTADO_INICIAL`), `Direccion.java` (`CALLE_POR_DEFECTO`, `COMUNA_POR_DEFECTO`) | Se corrigieron las constantes que en C4 estaban expuestas como `public static final`, restringiéndolas a `private static final`. |
| **Cap. 4** | Protección de getters de objetos mutables | `Pedido.java` → `getItems()` | Retorna `Collections.unmodifiableList(this.items)` evitando que clases externas modifiquen la lista interna sin pasar por `agregarItem()`. |
| **Cap. 5** | Clase abstracta con método abstracto y Javadoc | `Persona.java` → `public abstract class Persona`, método `getTipoPersona()` | Se incorporó documentación Javadoc de dominio fundamentando por qué `Persona` abstrae a `Cliente` y `Repartidor`. |
| **Cap. 5** | Dos interfaces con al menos 2 métodos cada una | `ItemPedido.java` (`getNombre`, `getPrecio`), `Preparable.java` (`avanzarEstado`, `getEstadoPreparacion`), `EstrategiaDescuento.java` (`calcularDescuento`, `getDescripcionDescuento`) | Se agregó el método `getDescripcionDescuento()` a `EstrategiaDescuento` y se estructuró `Preparable` con dos operaciones contractuales. |
| **Cap. 5** | Implementación múltiple de interfaces | `Pizza.java` y `PaloDeAjo.java` (`implements ItemPedido, Preparable`) | Ambas clases cumplen simultáneamente el contrato de producto cobrable (`ItemPedido`) y producto cocinable (`Preparable`). |
| **Cap. 5** | Polimorfismo comprobable en `Main` | `Main.java` → `main(String[] args)` | Invocación de comportamiento mediante referencias declaradas como tipo interfaz (`ItemPedido`, `Preparable`, `EstrategiaDescuento`). |
| **Cap. 6** | Composición (creación interna todo–parte) | `Pedido.java` → `confirmarPago()` instancia `new Boleta(this.id)` | `Pedido` crea y controla internamente el ciclo de vida de su `Boleta`; esta no se recibe desde el exterior ni existe sin el pedido. |
| **Cap. 6** | Agregación (objetos externos por referencia) | `Pedido.java` → `agregarItem(ItemPedido)` y `asignarRepartidor(Repartidor)` | Los productos y el repartidor se instancian externamente y se incorporan por referencia (resuelve **Issue #2**). |
| **Cap. 6** | Asociación (referencia sin relación parte–todo) | `Pedido.java` (`private final Cliente cliente`) y `Cliente.java` (`private Direccion direccion`) | Se reemplazó `String direccion` por el objeto `Direccion` en `Cliente` y se vinculó `Cliente` en el constructor de `Pedido`. |
| **Cap. 6** | Dependencia y comentarios estandarizados | `Pedido.java` → `calcularTotal(EstrategiaDescuento)` | Uso temporal de `EstrategiaDescuento` como parámetro sin atributo; las 4 relaciones incluyen comentarios `// RELACIÓN: ...`. |
| **Cap. 7** | Principio SRP (Responsabilidad Única) | `Boleta.java`, `Pedido.java`, `DescuentoPorcentaje.java`, `SinDescuento.java` | Se aisló la emisión del comprobante en `Boleta` y el cálculo de rebajas en las estrategias, dejando a `Pedido` la gestión de la orden. |
| **Cap. 7** | Principio OCP (Abierto/Cerrado) | `EstrategiaDescuento.java`, `DescuentoPorcentaje.java`, `SinDescuento.java` | Permite incorporar nuevas políticas de descuento creando nuevas implementaciones sin modificar el código de `Pedido`. |
| **Cap. 7** | Principio DIP (Inversión de Dependencias) | `Preparable.java`, `PaloDeAjo.java`, `Pedido.java` | `Pedido` depende de `ItemPedido` y `EstrategiaDescuento`; `PaloDeAjo` depende de `Preparable` en lugar de `Pizza` (**Issue #1**). |

---

## 3. Decisiones de Diseño y Principios SOLID (Capítulo 7)

### 3.1. Principio de Responsabilidad Única (SRP)
* **Decisión:** Separar la generación de comprobantes financieros (`Boleta`) y el cálculo matemático de descuentos (`EstrategiaDescuento`) fuera de la clase `Pedido`.
* **Justificación:** En versiones iniciales, concentrar el armado del carrito, el cálculo de porcentajes y el formato de boleta en una sola clase generaba múltiples motivos de cambio. Con esta separación, cambios en el formato de emisión fiscal solo afectan a `Boleta.java`.

### 3.2. Principio Abierto/Cerrado (OCP)
* **Decisión:** Modelar las políticas de descuento mediante la interfaz `EstrategiaDescuento` con implementaciones intercambiables (`SinDescuento`, `DescuentoPorcentaje`).
* **Justificación:** El método `Pedido.calcularTotal(EstrategiaDescuento)` permanece cerrado a modificaciones estructurales, pero el sistema queda abierto para añadir nuevas promociones (por ejemplo, descuentos por día de la semana o convenios) agregando nuevas clases sin alterar `Pedido`.

### 3.3. Principio de Inversión de Dependencias (DIP)
* **Decisión:** Desacoplar los módulos de alto nivel (`Pedido`) y las clases de catálogo (`PaloDeAjo`) de implementaciones concretas, haciéndolos depender exclusivamente de abstracciones (`ItemPedido`, `EstrategiaDescuento`, `Preparable`).
* **Justificación:** Evita dependencias rígidas entre clases concretas (como ocurría entre `PaloDeAjo` y `Pizza`) y facilita la extensibilidad y prueba unitaria de cada componente.

---

## 4. Resolución de Observaciones en GitHub Issues (Post-C4)

1. **Issue #1 — `PaloDeAjo` acoplado a `Pizza.EstadoPreparacion` (DIP):**
   * **Análisis:** `PaloDeAjo` referenciaba directamente el enum interno `Pizza.EstadoPreparacion`, acoplando dos clases concretas entre sí.
   * **Solución:** Se trasladó el enum `EstadoPreparacion` (`PENDIENTE`, `EN_HORNO`, `LISTO`) desde `Pizza.java` hacia la interfaz `Preparable.java`. Ahora tanto `Pizza` como `PaloDeAjo` implementan `Preparable` y dependen únicamente de esa abstracción.
2. **Issue #2 — Diferenciación entre Asociación y Agregación en `Pedido` (Capítulo 6):**
   * **Análisis:** `Cliente` y `Repartidor` se recibían ambos como `Persona` en el constructor de `Pedido`, ocultando su semántica de negocio.
   * **Solución:** Se tiparon explícitamente como `Cliente` y `Repartidor` y se diferenciaron por ciclo de vida: `Cliente` se exige en el constructor `Pedido(int id, Cliente cliente)` (**Asociación** obligatoria al nacer la orden), mientras que `Repartidor` se incorpora posteriormente en etapa de despacho mediante `asignarRepartidor(Repartidor)` (**Agregación**).

---

## 5. Estructura del Repositorio y Ejecución

### Archivos principales
* **Abstracciones e Interfaces:** `Persona.java`, `ItemPedido.java`, `Preparable.java`, `EstrategiaDescuento.java`
* **Modelos de Dominio:** `Pizza.java`, `PaloDeAjo.java`, `Bebida.java`, `Cliente.java`, `Repartidor.java`, `Direccion.java`, `Boleta.java`
* **Estrategias de Descuento:** `DescuentoPorcentaje.java`, `SinDescuento.java`
* **Núcleo y Ejecución:** `Pedido.java`, `Main.java`
* **Configuración:** `.gitignore` (excluye binarios compilados `*.class`)

### Compilación y ejecución desde terminal
```bash
javac *.java
java Main
```