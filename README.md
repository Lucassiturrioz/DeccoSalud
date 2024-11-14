# DeccoSalud API Documentation

![DeccoSalud Logo](https://i.ibb.co/JqXrZmV/Captura.png)

**DeccoSalud** es una extensión de **DeccoColaboración** creada para **RESTcatar** a las personas más vulnerables y brindar una salud social accesible y equitativa para una sociedad mejor. Esta API facilita la gestión de información de los barrios y sus habitantes para ofrecer soluciones de salud social.

---

## Endpoint
**Método:** `POST`  
**URL:** `/pedidos`

---

## Descripción
Este endpoint recibe una lista de personas junto con los barrios en los que residen y devuelve un informe consolidado de barrios. Cada barrio incluirá el número de personas que residen en él y sus nombres.

---

**Body**
El cuerpo del request debe ser un array de objetos JSON, con los siguientes atributos:

nombre (string): El nombre de la persona
barrios (array de strings): Lista de barrios donde reside la persona

**Response**
La respuesta es un array de objetos JSON que contienen la siguiente información:

barrio (string): Nombre del barrio
cantidadPersonas (int): Número de personas en ese barrio
personas (array de strings): Lista de nombres de personas que residen en ese barrio
