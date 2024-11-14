# DeccoSalud API Documentation

![DeccoSalud Logo](https://i.ibb.co/JqXrZmV/Captura.png) 

**DeccoSalud** es una extensión de **DeccoColaboración** creada para **RESTcatar** a las personas más vulnerables y brindar una salud social accesible y equitativa para una sociedad mejor. Esta API facilita la gestión de información de los barrios y sus habitantes para ofrecer soluciones de salud social.

---

## Endpoint
**Método:** `POST`  
**URL:** `/pedidos`

---

## Descripción

Este endpoint recibe una lista de personas en situación vulnerable, donde cada persona ha consumido un alimento en diversos lugares. El sistema devuelve la cantidad de personas que consumieron en cada ciudad y sus nombres correspondientes.

---

**Body**
El cuerpo del request debe ser un array de objetos JSON, con los siguientes atributos:

_nombre (string)_: El nombre y apellido de la persona      

_barrios (array de strings)_: Lista de barrios donde consumio


**Response**
La respuesta es un array de objetos JSON que contienen la siguiente información:

_barrio (string):_ Nombre del barrio

_cantidadPersonas (int):_ cantidad de personas que consumieron

_personas (array de strings):_ Lista de nombre y apellido de personas que consumieron 

# Ejemplo

# Envio
```json
[
  {
    "barrio": "Almagro",
    "cantidadPersonas": 2,
    "personas": ["Lucas Iturrioz", "Pepito Luis"]
  },
  {
    "barrio": "Belgrano",
    "cantidadPersonas": 1,
    "personas": ["Pepito Luis"]
  },
  {
    "barrio": "Palermo",
    "cantidadPersonas": 1,
    "personas": ["Lucas Iturrioz"]
  }
]

```

# Respuesta de la API

```json
[
  {
    "barrio": "almagro",
    "cantidadPersonas": 2,
    "personas": [
      "lucas iturrioz",
      "pepito luis"
    ]
  },
  {
    "barrio": "belgrano",
    "cantidadPersonas": 1,
    "personas": [
      "pepito luis"
    ]
  },
  {
    "barrio": "palermo",
    "cantidadPersonas": 1,
    "personas": [
      "lucas iturrioz"
    ]
  }
]
```

