<!-- HEADER ANIMADO -->
<div align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0d1117&height=220&section=header&text=PIZZER%C3%8DA%20G3&fontSize=60&fontColor=00ff00&animation=fadeIn" width="100%" />

  <a href="https://git.io/typing-svg">
    <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=18&pause=1000&color=00FF00&center=true&vCenter=true&width=500&lines=PIZZER%C3%8DA+G3;JAVA+POO;GRUPO+3" alt="Typing SVG" />
  </a>

  <br><br>

  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/POO-Encapsulamiento-00ff00?style=for-the-badge&logoColor=white&labelColor=0d1117" alt="POO" />
</div>

<br>

---

### 📌 Descripción

Proyecto en **Java** que modela la gestión de pedidos de una pizzería aplicando Programación Orientada a Objetos: encapsulamiento, herencia, abstracción, interfaces, polimorfismo y sobrecarga de constructores y métodos.

---

### 🆕 Cambios de esta entrega

* **`Persona` ahora es abstracta**, con el método abstracto `getTipoPersona()` que cada subclase debe implementar.
* **Nuevas interfaces `Preparable` y `Personalizable`**, implementadas por `Pizza`.
* **`Pizza` fue ampliada:** ahora tiene tamaño, ingredientes, tiempo de cocción y un estado de preparación (enum `EstadoPreparacion`).
* **`Repartidor` ahora lleva un contador de entregas** (`pedidosEntregados`).
* **`Cliente` incorpora `realizarPedido()`** y constructores sobrecargados.
* **`Pedido` ahora tiene un identificador único** (`idPedido`), un límite de pizzas y validaciones en sus setters.
* **Todas las clases validan sus datos** y usan valores por defecto cuando reciben datos nulos o vacíos.
* **`Main` ahora prueba el flujo completo:** `Pizza` y sus interfaces, y un `Pedido` con `Cliente`, `Repartidor` y pizzas.

---

### 🧬 Jerarquía de Clases (Herencia)

* **`Persona` (Clase Padre, abstracta):** Centraliza los datos que comparten todos los usuarios de la pizzería: RUT, nombre, teléfono y email.
  * El `rut` es `final`: se asigna una sola vez al crear el objeto y no tiene setter.
  * Define constantes por defecto (`RUT_POR_DEFECTO`, `NOMBRE_POR_DEFECTO`, `NO_REGISTRADO`).
  * Tiene **cuatro constructores** (completo, sin email, solo RUT y nombre, y vacío). Los tres secundarios reutilizan al principal con `this(...)`, que concentra la validación.
  * Los setters aplican `trim()` y usan el valor por defecto si el dato es nulo o vacío. `setEmail` además exige que contenga `@`.
  * Incluye `mostrarContacto()` y `tieneTelefonoValido()` (teléfono registrado y con al menos 8 caracteres).
  * **¿Por qué es abstracta y no concreta?** Porque en la pizzería no existe una "persona genérica": siempre se trata de un `Cliente` o de un `Repartidor`, así que instanciar `Persona` directamente no tendría sentido. Además, el método abstracto `getTipoPersona()` obliga a cada subclase a identificarse a sí misma (devuelve "Cliente" o "Repartidor"), evitando que alguien olvide definirlo.
* **`Repartidor` (Clase Hija):** Hereda de `Persona` y agrega los atributos propios de su trabajo.
  * Atributos nuevos: `vehiculo`, `patente` y `pedidosEntregados`.
  * Tiene dos constructores: vacío y completo.
  * La patente se guarda en mayúsculas y `vehiculo` y `patente` caen a "No especificado" y "S/P" si llegan vacíos.
  * `registrarEntrega()` suma una entrega al contador. `pedidosEntregados` no tiene setter, por lo que solo se modifica con este método.
  * Sobrescribe `getTipoPersona()`, `mostrarContacto()` y `toString()`.
* **`Cliente` (Clase Hija):** Hereda de `Persona` y añade el atributo `direccion`, necesario para saber dónde enviar el pedido.
  * Tiene tres constructores: vacío, completo y uno sin dirección que reutiliza al completo.
  * `setDireccion` valida que no sea nula ni vacía; si lo es, queda como "Sin dirección registrada".
  * `realizarPedido()` muestra la dirección de envío del cliente.
  * Sobrescribe `getTipoPersona()`, `mostrarContacto()` y `toString()`.

### 🔌 Interfaces

* **`Preparable`:** Define el ciclo de preparación de un producto: `iniciarPreparacion()`, `terminarPreparacion()`, `estaListo()` y `getTiempoCoccion()`.
* **`Personalizable`:** Define cómo se modifica un producto: `agregarIngrediente()`, `quitarIngrediente()`, `cambiarTamanio()` y `getIngredientes()`.

Usamos interfaces porque describen **capacidades** que no dependen de una jerarquía de clases, y permiten usar una pizza a través de cualquiera de ellas (polimorfismo).

### 🍕 Clases del Negocio

* **`Pizza`:** Representa un producto del menú. No hereda de ninguna clase, pero implementa `Preparable` y `Personalizable`.
  * Atributos: `nombre`, `precio`, `tamanio`, `tiempoCoccionMinutos`, `estado` e `ingredientes`.
  * El enum interno `EstadoPreparacion` tiene tres valores: `PENDIENTE`, `EN_PREPARACION` y `LISTO`. Toda pizza parte en `PENDIENTE`.
  * Valores por defecto: nombre "Pizza Personalizada", tamaño "Mediana", precio 0 y 15 minutos de cocción.
  * Tiene tres constructores encadenados con `this(...)`: principal (nombre, precio, tiempo), uno con tiempo estándar y uno vacío.
  * `setNombre` y `setPrecio` validan que el nombre no esté vacío y que el precio no sea negativo.
  * `getIngredientes()` devuelve una lista no modificable (`Collections.unmodifiableList`), para que nadie la altere desde afuera.
  * `tamanio` y `estado` no tienen setter: solo cambian con `cambiarTamanio()` y los métodos de preparación.
* **`Pedido`:** Es la clase que conecta todo el sistema. Asocia a un `Cliente`, un `Repartidor` y las pizzas solicitadas.
  * `idPedido` es `final`: se asigna al crear el pedido y no cambia.
  * Las pizzas se guardan en un arreglo con límite de `MAX_PIZZAS = 100`.
  * `agregarPizza()` devuelve `true` o `false` y rechaza pizzas nulas o cuando se alcanzó el límite.
  * Si la dirección llega vacía, el pedido queda como "Retiro en local".
  * `total()` y `total(porcentaje)` (sobrecarga de métodos) permiten cobrar con o sin descuento, reutilizando la misma lógica. El porcentaje debe estar entre 0 y 100.
  * `setCliente`, `setRepartidor` y `setDireccion` rechazan valores nulos o vacíos y conservan el valor anterior.
  * `mostrarDetalle()` imprime el resumen del pedido.
* **`Main`:** Clase de demostración dividida en dos partes.
  * `probarPizzaEInterfaces()`: crea dos pizzas con distintos constructores, prueba `Personalizable` (cambio de tamaño y manejo de ingredientes) y `Preparable` (ciclo de preparación), y demuestra el polimorfismo usando una pizza a través de ambas interfaces.
  * `probarFlujoDePedido()`: crea un `Cliente` y un `Repartidor`, los recorre como `Persona[]` (polimorfismo con la clase abstracta), arma un `Pedido` con dos pizzas, prueba los totales con y sin descuento, las validaciones de los setters y termina con `realizarPedido()` y `registrarEntrega()`.

---

### ⚠️ Limitaciones conocidas

* `Persona` solo valida que el RUT no venga vacío, no su formato.
* `terminarPreparacion()` no verifica que la pizza haya pasado antes por `EN_PREPARACION`.
* `quitarIngrediente()` elimina solo la primera coincidencia y distingue mayúsculas de minúsculas.
* El constructor de `Pedido` no valida cliente ni repartidor nulos (los setters sí).
* `Pedido` usa un arreglo fijo de 100 posiciones y `mostrarDetalle()` muestra el total sin decimales.

---

### 👥 Integrantes

* **CRISTIAN LILLO**
* **DIEGO BECERRA**
* **VICTOR TORRES**

---

<div align="center">
  <sub>Pizzería G3</sub>
</div>