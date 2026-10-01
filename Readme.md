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

Proyecto en **Java** que modela la gestión de pedidos de una pizzería aplicando Programación Orientada a Objetos: encapsulamiento, herencia, abstracción, polimorfismo y sobrecarga de métodos y constructores.

---

### 🧬 Jerarquía de Clases (Herencia)

Para organizar el código de esta entrega, diseñamos la siguiente estructura:

* **`Persona` (Clase Padre):** Decidimos que esta sea la clase principal porque todos los usuarios de la pizzería comparten datos básicos. Aquí centralizamos atributos comunes como el RUT, nombre, teléfono y email.
* **`Repartidor` (Clase Hija):** Hereda de `Persona`. Lo hicimos así porque un repartidor tiene los datos personales básicos, pero le agregamos atributos exclusivos de su trabajo, como el vehículo y la patente para hacer los despachos.
* **`Cliente` (Clase Hija):** También hereda de `Persona`. Comparte los datos base del padre, pero le añadimos el atributo propio de `direccion`, que es necesario para saber dónde enviarle su pedido.

### 🍕 Clases del Negocio

Además de la jerarquía de personas, el sistema cuenta con las siguientes clases:

* **`Pizza`:** Representa un producto del menú con su nombre y precio. La mantuvimos como una clase independiente, sin herencia, porque todas las pizzas comparten la misma estructura y solo cambian sus datos. Valida que el nombre no esté vacío y que el precio no sea negativo.
* **`Pedido`:** Es la clase que conecta todo el sistema. Asocia a un `Cliente` y a un `Repartidor`, y guarda las pizzas solicitadas. Decidimos que calcule el total con `total()` y `total(porcentaje)` (sobrecarga de métodos), para poder cobrar con o sin descuento reutilizando la misma lógica.
* **`Main`:** Clase de demostración que crea un cliente, un repartidor y un pedido con varias pizzas, y muestra el resumen y los totales por consola.

---

### 👥 Integrantes

* **CRISTIAN LILLO**
* **DIEGO BECERRA**
* **VICTOR TORRES**

---

<div align="center">
  <sub>Pizzería G3</sub>
</div>