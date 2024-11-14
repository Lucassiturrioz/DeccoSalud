# DeccoSalud API Documentation

<center> ![DeccoSalud Logo](https://i.ibb.co/JqXrZmV/Captura.png) </center>

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

_nombre (string)_: El nombre de la persona
_barrios (array de strings)_: Lista de barrios donde reside la persona

**Response**
La respuesta es un array de objetos JSON que contienen la siguiente información:

_barrio (string):_ Nombre del barrio
_cantidadPersonas (int):_ Número de personas en ese barrio
_personas (array de strings):_ Lista de nombres de personas que residen en ese barrio
