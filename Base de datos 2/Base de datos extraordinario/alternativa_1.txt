use("taller_mecanico")
db.createCollection('taller', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      required: ['_id', 'servicio', 'precio', 'costo'],
      properties: {
        _id: {
          bsonType: 'number',
          description: 'id de la reparacion',
        },
        servicio: {
          bsonType: 'string',
          description: 'Tipo de servicio',
          enum: [
            'reparacion_menor',
            'reparacion_mayor',
            'cambio_de_aceite',
            'afinacion',
            'revision_mecanica',
          ],
        },
        costo: {
          bsonType: 'number',
          description: 'costo de reparacion',
        },
        precio: {
          bsonType: 'number',
          description: 'precio del servicio',
        },
      },
    },
  },
})

servicio = { _id: 1, servicio: 'reparacion_menor', costo: 300, precio: 1000 }
servicio2 = { _id: 2, servicio: 'reparacion_mayor', costo: 1000, precio: 5000 }
servicio3 = { _id: 3, servicio: 'cambio_de_aceite', costo: 500, precio: 2500 }
servicio4 = { _id: 4, servicio: 'afinacion', costo: 3000, precio: 6000 }
servicio5 = { _id: 5, servicio: 'revision_mecanica', costo: 0, precio: 200 }

db.taller.insertOne({
  _id: 1,
  servicio: 'reparacion_menor',
  costo: 300,
  precio: 1000,
})
db.taller.insertOne({
  _id: 2,
  servicio: 'reparacion_mayor',
  costo: 1000,
  precio: 5000,
})
db.taller.insertOne({
  _id: 3,
  servicio: 'cambio_de_aceite',
  costo: 500,
  precio: 2500,
})
db.taller.insertOne({
  _id: 4,
  servicio: 'afinacion',
  costo: 3000,
  precio: 6000,
})
db.taller.insertOne({
  _id: 5,
  servicio: 'revision_mecanica',
  costo: 0,
  precio: 200,
})

db.createCollection('mecanicos', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      required: ['_id', 'nombre', 'especialidad', 'edad', 'sueldo'],
      properties: {
        _id: {
          bsonType: 'number',
          description: 'id del mecanico',
        },
        nombre: {
          bsonType: 'string',
        },
        especialidad: {
          bsonType: 'string',
          description: 'especialidad del mecanico',
        },
        edad: {
          bsonType: 'number',
          description: 'edad del mecanico',
          minimum: 18,
          maximum: 65,
        },
        sueldo: {
          bsonType: 'number',
          description: 'sueldo del mecanico',
          minimum: 1000,
          maximum: 10000,
        },
      },
    },
  },
})

mecanico = { nombre: 'Roberto Carlos Ramos Martinez' }
mecanico2 = { nombre: 'Juan Carlos Medina Rodriguez' }
mecanico3 = { nombre: 'Godofredo Perera Lopes' }

mecanico.servicio = servicio
mecanico.servicio2 = servicio3

mecanico2.servicio = servicio4
mecanico2.servicio2 = servicio5

mecanico3.servicio = servicio2

db.mecanicos.insertOne({
  _id: 1,
  nombre: 'Roberto Carlos Ramos Martinez',
  especialidad: 'mecanico general',
  edad: 20,
  sueldo: 4000,
})
db.mecanicos.insertOne({
  _id: 2,
  nombre: 'Juan Carlos Medina Rodriguez',
  especialidad: 'mecanico electricista',
  edad: 40,
  sueldo: 6000,
})
db.mecanicos.insertOne({
  _id: 3,
  nombre: 'Godofredo Perera Lopes',
  especialidad: 'mecanico especializado',
  edad: 60,
  sueldo: 10000,
})

db.createCollection('domicilio', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      required: ['_id', 'calle', 'numero', 'colonia', 'ciudad', 'estado'],
      properties: {
        _id: {
          bsonType: 'number',
          description: 'id del domicilio del cliente',
        },
        calle: {
          bsonType: 'string',
          description: 'Calle del domicilio',
        },
        numero: {
          bsonType: 'number',
          description: 'Numero del domicilio',
        },
        colonia: {
          bsonType: 'string',
          description: 'Colonia del domicilio',
        },
        ciudad: {
          bsonType: 'string',
          description: 'Ciudad del domicilio',
        },
        estado: {
          bsonType: 'string',
          description: 'Estado del domicilio',
        },
      },
    },
  },
})

domicilio = {
  _id: 1,
  calle: 'Av.La Torre',
  numero: 2721,
  colonia: 'Privadas La torre',
  ciudad: 'Saltillo',
  estado: 'Coahuila',
}
db.domicilio.insertOne(domicilio)
domicilio2 = {
  _id: 2,
  calle: 'numero 13',
  numero: 174,
  colonia: 'Mirasierra',
  ciudad: 'Saltillo',
  estado: 'Coahuila',
}
db.domicilio.insertOne(domicilio2)
domicilio3 = {
  _id: 3,
  calle: 'Eucalipto',
  numero: 349,
  colonia: 'Zaragoza',
  ciudad: 'Saltillo',
  estado: 'Coahuila',
}
db.domicilio.insertOne(domicilio3)
domicilio4 = {
  _id: 4,
  calle: 'Fco. Villa',
  numero: 1017,
  colonia: '23 de mayo',
  ciudad: 'Saltillo',
  estado: 'Coahuila',
}
db.domicilio.insertOne(domicilio4)
domicilio5 = {
  _id: 5,
  calle: 'Halita',
  numero: 1000,
  colonia: 'Diaz Ordaz',
  ciudad: 'Saltillo',
  estado: 'Coahuila',
}
db.domicilio.insertOne(domicilio5)

db.createCollection('automovil_cliente', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      required: [
        '_id',
        'marca',
        'modelo',
        'color',
        'num_cilindros',
        'observaciones',
      ],
      properties: {
        _id: {
          bsonType: 'number',
          description: 'id del automovil',
        },
        marca: {
          bsonType: 'string',
          description: 'Marca del automovil',
        },
        modelo: {
          bsonType: 'string',
          description: 'Modelo del automovil',
        },
        color: {
          bsonType: 'string',
          description: 'Color del automovil',
        },
        num_cilindros: {
          bsonType: 'number',
          description: 'Numero de cilindros del automovil',
          minimum: 0,
          maximum: 12,
        },
        observaciones: {
          bsonType: 'string',
          description: 'Observaciones',
        },
      },
    },
  },
})
automovil1 = {
  _id: 1,
  marca: 'Subaru',
  modelo: 'TX35',
  color: 'Gris',
  num_cilindros: 4,
  observaciones: 'El auto estaba en malas condiciones',
}
db.automovil_cliente.insertOne(automovil1)
automovil2 = {
  _id: 2,
  marca: 'Mazda',
  modelo: 'MIN89',
  color: 'Azul',
  num_cilindros: 6,
  observaciones: 'Auto con leves talladuras en la parte derecha',
}
db.automovil_cliente.insertOne(automovil2)
automovil3 = {
  _id: 3,
  marca: 'Chevrolet',
  modelo: 'NxNOP',
  color: 'Amarillo',
  num_cilindros: 8,
  observaciones: 'Auto sin ningun danio aparente',
}
db.automovil_cliente.insertOne(automovil3)
automovil4 = {
  _id: 4,
  marca: 'Ford',
  modelo: 'F350',
  color: 'Verde',
  num_cilindros: 12,
  observaciones: 'Auto en buen estado',
}
db.automovil_cliente.insertOne(automovil4)
automovil5 = {
  _id: 5,
  marca: 'Nissan',
  modelo: 'TSURU',
  color: 'Blanco',
  num_cilindros: 6,
  observaciones: 'El auto estaba en muy malas condiciones',
}
db.automovil_cliente.insertOne(automovil5)
automovil6 = {
  _id: 6,
  marca: 'Ford',
  modelo: 'Figo',
  color: 'negro',
  num_cilindros: 3,
  observaciones: 'Esta a punto de implosionar',
}
db.automovil_cliente.insertOne(automovil6)
automovil7 = {
  _id: 7,
  marca: 'Chevrolet',
  modelo: 'Chevy',
  color: 'azul',
  num_cilindros: 4,
  observaciones: 'Necesita un cambio urgente de aceite',
}
db.automovil_cliente.insertOne(automovil7)
automovil8 = {
  _id: 8,
  marca: 'Tesla',
  modelo: 'ModelS',
  color: 'Blanco',
  num_cilindros: 2,
  observaciones: 'Perfectas condiciones',
}
db.automovil_cliente.insertOne(automovil8)

cliente = {
	_id: 1,
	nombre_cliente: 'Andres Manuel Lopes Obrador',
	telefono: 446767890954,
	correo: 'amlorules78_uwu@hotmail.com',
	numero_servicios: 4,
  }
  cliente.domicilio = domicilio
  cliente.automovil = automovil1
  cliente.servicio = servicio5
  cliente.servicio2 = servicio3
  cliente.servicio3 = servicio2
  cliente.servicio4 = servicio3
  db.cliente.insertOne(cliente)
  
  cliente2 = {
	_id: 2,
	nombre_cliente: 'Juan Antonio C',
	telefono: 1234567890,
	correo: 'tucosmopolis@hotmail.com',
	numero_servicios: 3,
  }
  cliente2.domicilio = domicilio2
  cliente2.automovil = automovil2
  cliente2.servicio = servicio2
  cliente2.servicio2 = servicio4
  cliente2.servicio3 = servicio5
  db.cliente.insertOne(cliente2)
  
  cliente3 = {
	_id: 3,
	nombre_cliente: 'Alejandro Moderno Hernandez',
	telefono: 8445553523,
	correo: 'juanpazurita.png@yahoo.com',
	numero_servicios: 8,
  }
  cliente3.domicilio = domicilio3
  cliente3.automovil = automovil3
  cliente3.servicio = servicio
  cliente3.servicio2 = servicio4
  cliente3.servicio3 = servicio5
  cliente3.servicio4 = servicio2
  cliente3.automovil2 = automovil4
  cliente3.servicio5 = servicio2
  cliente3.servicio6 = servicio3
  cliente3.servicio7 = servicio5
  cliente3.servicio8 = servicio3
  db.cliente.insertOne(cliente3)
  
  cliente4 = {
	_id: 4,
	nombre_cliente: 'Enrrique Peña Nieto',
	telefono: 8976384756,
	correo: 'unonomenoscomo5@hotmail.com',
	numero_servicios: 8,
  }
  cliente4.domicilio = domicilio4
  cliente4.automovil = automovil5
  cliente4.servicio = servicio2
  cliente4.servicio2 = servicio3
  cliente4.servicio3 = servicio5
  cliente4.servicio4 = servicio3
  cliente4.automovil2 = automovil6
  cliente4.servicio5 = servicio
  cliente4.servicio6 = servicio3
  cliente4.servicio7 = servicio4
  cliente4.servicio8 = servicio4
  db.cliente.insertOne(cliente4)
  
  cliente5 = {
	_id: 5,
	nombre_cliente: 'Maria Antonieta de las Nieves',
	telefono: 8971238974,
	correo: 'enriquecegoviano@gmail.com',
	numero_servicios: 7,
  }
  cliente5.domicilio = domicilio5
  cliente5.automovil = automovil7
  cliente5.servicio = servicio2
  cliente5.servicio2 = servicio4
  cliente5.servicio3 = servicio5
  cliente5.servicio4 = servicio5
  cliente5.automovil2 = automovil8
  cliente5.servicio5 = servicio
  cliente5.servicio6 = servicio3
  cliente5.servicio7 = servicio5
  db.cliente.insertOne(cliente5)

db.createCollection('trabajo', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      required: [
        '_id',
        'nombre_mecanico',
        'fecha_entrada',
        'fecha_final',
        'observaciones_trabajo',
        'servicio_utilizado',
        'nombre_cliente',
        'automovil',
      ],
      properties: {
        _id: {
          bsonType: 'number',
          description: 'id del trabajo',
        },
        fecha_entrada: {
          bsonType: 'date',
        },
        fecha_final: {
          bsonType: 'date',
        },
        observaciones_trabajo: {
          bsonType: 'string',
          description: 'las observaciones del mecanico',
        },
        nombre_mecanico: {
          bsonType: 'string',
          description: 'nombre del mecanico',
        },
        servicio_utilizado: {
          bsonType: 'object',
          description: 'el numero de servicio que se utilizo',
        },
        nombre_cliente: {
          bsonType: 'string',
          description: 'nombre del cliente',
        },
        automovil: {
          bsonType: 'object',
          description: 'automovil con el que se trabajo',
        },
      },
    },
  },
})

trabajo = {
  _id: 1,
  fecha_entrada: new Date('2020,03,11'),
  fecha_final: new Date('2020,03,30'),
  observaciones_trabajo: 'Revisión mecánica completada',
}
trabajo.nombre_mecanico = mecanico2.nombre
trabajo.servicio_utilizado = servicio5
trabajo.nombre_cliente = cliente.nombre_cliente
trabajo.automovil = automovil1
db.trabajo.insertOne(trabajo)

trabajo2 = {
  _id: 2,
  fecha_entrada: new Date('2020,03,11'),
  fecha_final: new Date('2020,03,30'),
  observaciones_trabajo: 'Cambio de aceite exitoso',
}
trabajo2.nombre_mecanico = mecanico.nombre
trabajo2.servicio_utilizado = servicio3
trabajo2.nombre_cliente = cliente.nombre_cliente
trabajo2.automovil = automovil1
db.trabajo.insertOne(trabajo2)

trabajo3 = {
  _id: 3,
  fecha_entrada: new Date('2020,03,11'),
  fecha_final: new Date('2020,03,30'),
  observaciones_trabajo: 'Todo funcionando correctamente',
}
trabajo3.nombre_mecanico = mecanico3.nombre
trabajo3.servicio_utilizado = servicio2
trabajo3.nombre_cliente = cliente.nombre_cliente
trabajo3.automovil = automovil1
db.trabajo.insertOne(trabajo3)

trabajo4 = {
  _id: 4,
  fecha_entrada: new Date('2020,03,11'),
  fecha_final: new Date('2020,03,30'),
  observaciones_trabajo: 'Se realizo un nuevo cambio de aceite',
}
trabajo4.nombre_mecanico = mecanico.nombre
trabajo4.servicio_utilizado = servicio3
trabajo4.nombre_cliente = cliente.nombre_cliente
trabajo4.automovil = automovil1
db.trabajo.insertOne(trabajo4)

trabajo5 = {
  _id: 5,
  fecha_entrada: new Date('2020,08,05'),
  fecha_final: new Date('2020,08,10'),
  observaciones_trabajo: 'Motor funcionando correctamente',
}
trabajo5.nombre_mecanico = mecanico3.nombre
trabajo5.servicio_utilizado = servicio2
trabajo5.nombre_cliente = cliente2.nombre_cliente
trabajo5.automovil = automovil2
db.trabajo.insertOne(trabajo5)

trabajo6 = {
  _id: 6,
  fecha_entrada: new Date('2020,08,05'),
  fecha_final: new Date('2020,08,10'),
  observaciones_trabajo: 'Afinación exitosa',
}
trabajo6.nombre_mecanico = mecanico2.nombre
trabajo6.servicio_utilizado = servicio4
trabajo6.nombre_cliente = cliente2.nombre_cliente
trabajo6.automovil = automovil2
db.trabajo.insertOne(trabajo6)

trabajo7 = {
  _id: 7,
  fecha_entrada: new Date('2020,08,05'),
  fecha_final: new Date('2020,08,10'),
  observaciones_trabajo: 'No tenía fallos',
}
trabajo7.nombre_mecanico = mecanico2.nombre
trabajo7.servicio_utilizado = servicio5
trabajo7.nombre_cliente = cliente2.nombre_cliente
trabajo7.automovil = automovil2
db.trabajo.insertOne(trabajo7)

trabajo8 = {
  _id: 8,
  fecha_entrada: new Date('2020,12,15'),
  fecha_final: new Date('2020,12,23'),
  observaciones_trabajo: 'Trabajo sencillo realizado',
}
trabajo8.nombre_mecanico = mecanico.nombre
trabajo8.servicio_utilizado = servicio
trabajo8.nombre_cliente = cliente3.nombre_cliente
trabajo8.automovil = automovil3
db.trabajo.insertOne(trabajo8)

trabajo9 = {
  _id: 9,
  fecha_entrada: new Date('2020,12,15'),
  fecha_final: new Date('2020,12,23'),
  observaciones_trabajo: 'Afinación realizada',
}
trabajo9.nombre_mecanico = mecanico3.nombre
trabajo9.servicio_utilizado = servicio4
trabajo9.nombre_cliente = cliente3.nombre_cliente
trabajo9.automovil = automovil3
db.trabajo.insertOne(trabajo9)

trabajo10 = {
  _id: 10,
  fecha_entrada: new Date('2020,12,15'),
  fecha_final: new Date('2020,12,23'),
  observaciones_trabajo: 'Revisión correcta',
}
trabajo10.nombre_mecanico = mecanico2.nombre
trabajo10.servicio_utilizado = servicio5
trabajo10.nombre_cliente = cliente3.nombre_cliente
trabajo10.automovil = automovil3
db.trabajo.insertOne(trabajo10)

trabajo11 = {
  _id: 11,
  fecha_entrada: new Date('2020,12,15'),
  fecha_final: new Date('2020,12,23'),
  observaciones_trabajo: 'Reparación mayor exitosa',
}
trabajo11.nombre_mecanico = mecanico3.nombre
trabajo11.servicio_utilizado = servicio2
trabajo11.nombre_cliente = cliente3.nombre_cliente
trabajo11.automovil = automovil3
db.trabajo.insertOne(trabajo11)

trabajo12 = {
  _id: 12,
  fecha_entrada: new Date('2021,02,01'),
  fecha_final: new Date('2021,02,14'),
  observaciones_trabajo: 'Reparación mayor exitosa',
}
trabajo12.nombre_mecanico = mecanico3.nombre
trabajo12.servicio_utilizado = servicio2
trabajo12.nombre_cliente = cliente3.nombre_cliente
trabajo12.automovil = automovil4
db.trabajo.insertOne(trabajo12)

trabajo13 = {
  _id: 13,
  fecha_entrada: new Date('2021,02,01'),
  fecha_final: new Date('2021,02,14'),
  observaciones_trabajo: 'Cambio de aceite realizado',
}
trabajo13.nombre_mecanico = mecanico.nombre
trabajo13.servicio_utilizado = servicio3
trabajo13.nombre_cliente = cliente3.nombre_cliente
trabajo13.automovil = automovil4
db.trabajo.insertOne(trabajo13)

trabajo14 = {
  _id: 14,
  fecha_entrada: new Date('2021,02,01'),
  fecha_final: new Date('2021,02,14'),
  observaciones_trabajo: 'Se arreglo falla del clima',
}
trabajo14.nombre_mecanico = mecanico2.nombre
trabajo14.servicio_utilizado = servicio5
trabajo14.nombre_cliente = cliente3.nombre_cliente
trabajo14.automovil = automovil4
db.trabajo.insertOne(trabajo14)

trabajo15 = {
  _id: 15,
  fecha_entrada: new Date('2021,02,01'),
  fecha_final: new Date('2021,02,14'),
  observaciones_trabajo:
    'Fallo el anterior cambio de aceite y se le realizo uno nuevo',
}
trabajo15.nombre_mecanico = mecanico.nombre
trabajo15.servicio_utilizado = servicio3
trabajo15.nombre_cliente = cliente3.nombre_cliente
trabajo15.automovil = automovil4
db.trabajo.insertOne(trabajo15)

trabajo16 = {
  _id: 16,
  fecha_entrada: new Date('2021,09,30'),
  fecha_final: new Date('2021,10,06'),
  observaciones_trabajo: 'Reparación mayor exitosa',
}
trabajo16.nombre_mecanico = mecanico3.nombre
trabajo16.servicio_utilizado = servicio2
trabajo16.nombre_cliente = cliente4.nombre_cliente
trabajo16.automovil = automovil5
db.trabajo.insertOne(trabajo16)

trabajo17 = {
  _id: 17,
  fecha_entrada: new Date('2021,09,30'),
  fecha_final: new Date('2021,10,06'),
  observaciones_trabajo: 'Cambio de aceite realizado',
}
trabajo17.nombre_mecanico = mecanico.nombre
trabajo17.servicio_utilizado = servicio3
trabajo17.nombre_cliente = cliente4.nombre_cliente
trabajo17.automovil = automovil5
db.trabajo.insertOne(trabajo17)

trabajo18 = {
  _id: 18,
  fecha_entrada: new Date('2021,09,30'),
  fecha_final: new Date('2021,10,06'),
  observaciones_trabajo: 'No hubo fallos',
}
trabajo18.nombre_mecanico = mecanico2.nombre
trabajo18.servicio_utilizado = servicio5
trabajo18.nombre_cliente = cliente4.nombre_cliente
trabajo18.automovil = automovil5
db.trabajo.insertOne(trabajo18)

trabajo19 = {
  _id: 19,
  fecha_entrada: new Date('2021,09,30'),
  fecha_final: new Date('2021,10,06'),
  observaciones_trabajo: 'Cambio de aceite exitoso',
}
trabajo19.nombre_mecanico = mecanico.nombre
trabajo19.servicio_utilizado = servicio3
trabajo19.nombre_cliente = cliente4.nombre_cliente
trabajo19.automovil = automovil5
db.trabajo.insertOne(trabajo19)

trabajo20 = {
  _id: 20,
  fecha_entrada: new Date('2021,10,06'),
  fecha_final: new Date('2021,10,16'),
  observaciones_trabajo: 'Cambio de pastillas de freno',
}
trabajo20.nombre_mecanico = mecanico.nombre
trabajo20.servicio_utilizado = servicio
trabajo20.nombre_cliente = cliente4.nombre_cliente
trabajo20.automovil = automovil6
db.trabajo.insertOne(trabajo20)

trabajo21 = {
  _id: 21,
  fecha_entrada: new Date('2021,10,06'),
  fecha_final: new Date('2021,10,16'),
  observaciones_trabajo: 'Cambio de aceite de rutina',
}
trabajo21.nombre_mecanico = mecanico.nombre
trabajo21.servicio_utilizado = servicio3
trabajo21.nombre_cliente = cliente4.nombre_cliente
trabajo21.automovil = automovil6
db.trabajo.insertOne(trabajo21)

trabajo22 = {
  _id: 22,
  fecha_entrada: new Date('2021,10,06'),
  fecha_final: new Date('2021,10,16'),
  observaciones_trabajo: 'Afinación realizada',
}
trabajo22.nombre_mecanico = mecanico2.nombre
trabajo22.servicio_utilizado = servicio4
trabajo22.nombre_cliente = cliente4.nombre_cliente
trabajo22.automovil = automovil6
db.trabajo.insertOne(trabajo22)

trabajo23 = {
  _id: 23,
  fecha_entrada: new Date('2021,10,06'),
  fecha_final: new Date('2021,10,16'),
  observaciones_trabajo: 'Afinación anterior fallida, se hizo una nueva',
}
trabajo23.nombre_mecanico = mecanico2.nombre
trabajo23.servicio_utilizado = servicio4
trabajo23.nombre_cliente = cliente4.nombre_cliente
trabajo23.automovil = automovil6
db.trabajo.insertOne(trabajo23)

trabajo24 = {
  _id: 24,
  fecha_entrada: new Date('2021,10,25'),
  fecha_final: new Date('2021,10,31'),
  observaciones_trabajo: 'Fallo en la correa de distribución',
}
trabajo24.nombre_mecanico = mecanico3.nombre
trabajo24.servicio_utilizado = servicio2
trabajo24.nombre_cliente = cliente5.nombre_cliente
trabajo24.automovil = automovil7
db.trabajo.insertOne(trabajo24)

trabajo25 = {
  _id: 25,
  fecha_entrada: new Date('2021,10,25'),
  fecha_final: new Date('2021,10,31'),
  observaciones_trabajo: 'Afinación correcta',
}
trabajo25.nombre_mecanico = mecanico2.nombre
trabajo25.servicio_utilizado = servicio4
trabajo25.nombre_cliente = cliente5.nombre_cliente
trabajo25.automovil = automovil7
db.trabajo.insertOne(trabajo25)

trabajo26 = {
  _id: 26,
  fecha_entrada: new Date('2021,10,25'),
  fecha_final: new Date('2021,10,31'),
  observaciones_trabajo: 'Chequeo de rutina exitoso',
}
trabajo26.nombre_mecanico = mecanico2.nombre
trabajo26.servicio_utilizado = servicio5
trabajo26.nombre_cliente = cliente5.nombre_cliente
trabajo26.automovil = automovil7
db.trabajo.insertOne(trabajo26)

trabajo27 = {
  _id: 27,
  fecha_entrada: new Date('2021,10,25'),
  fecha_final: new Date('2021,10,31'),
  observaciones_trabajo: 'Chequeo completo debido a un sonido raro',
}
trabajo27.nombre_mecanico = mecanico2.nombre
trabajo27.servicio_utilizado = servicio5
trabajo27.nombre_cliente = cliente5.nombre_cliente
trabajo27.automovil = automovil7
db.trabajo.insertOne(trabajo27)

trabajo28 = {
  _id: 28,
  fecha_entrada: new Date('2021,11,05'),
  fecha_final: new Date('2021,11,11'),
  observaciones_trabajo: 'Cambio de intermitentes',
}
trabajo28.nombre_mecanico = mecanico.nombre
trabajo28.servicio_utilizado = servicio
trabajo28.nombre_cliente = cliente5.nombre_cliente
trabajo28.automovil = automovil8
db.trabajo.insertOne(trabajo28)

trabajo29 = {
  _id: 29,
  fecha_entrada: new Date('2021,11,05'),
  fecha_final: new Date('2021,11,11'),
  observaciones_trabajo: 'Cambio de aceite completo',
}
trabajo29.nombre_mecanico = mecanico.nombre
trabajo29.servicio_utilizado = servicio3
trabajo29.nombre_cliente = cliente5.nombre_cliente
trabajo29.automovil = automovil8
db.trabajo.insertOne(trabajo29)

trabajo30 = {
  _id: 30,
  fecha_entrada: new Date('2021,11,05'),
  fecha_final: new Date('2021,11,11'),
  observaciones_trabajo: 'Revisión completa exitosa',
}
trabajo30.nombre_mecanico = mecanico2.nombre
trabajo30.servicio_utilizado = servicio5
trabajo30.nombre_cliente = cliente5.nombre_cliente
trabajo30.automovil = automovil8
db.trabajo.insertOne(trabajo30)


/*Lista de clientes de mayor a menor*/
db.cliente.find({}, { numero_servicios: 1, nombre_cliente: 1 }).sort({ numero_servicios: -1 }).pretty()
db.cliente.find({}, { numero_servicios: 1, _id: 0 }).sort({ numero_servicios: -1 }).pretty()

/*total de servicios realizados por cliente */
db.cliente.aggregate({
  $group: {
    _id: '',
    total_de_servicios: {
      $sum: '$numero_servicios',
    },
  },
})

/**Inciso D */
db.cliente.find({}, { nombre_cliente:1, automovil:1,automovil2:1 })
/**Inciso E */
db.trabajo.find({},{automovil:1,servicio_utilizado:1})

/*Cliente con mayor numero de servicios  Inciso F*/

db.cliente.aggregate({
	$group: {
	  _id: '',
	  'numero maximo de servicios': {
		$max: '$numero_servicios',
	  },
	},
  })


db.cliente.find({}, { numero_servicios: 1, nombre_cliente: 1 }).sort({ numero_servicios: -1 }).limit(-1)
db.cliente.find({}, { numero_servicios: 1, nombre_cliente: 1 }).sort({ numero_servicios: -1 }).limit(-1).map((u) => 'cliente con mayor numero de servicios : ' + u.nombre_cliente)

/*Cliente con menor numero de servicios Inciso G */

db.cliente.aggregate({
	$group: {
	  _id: '',
	  'numero maximo de servicios': {
		$min: '$numero_servicios',
	  },
	},
  })
db.cliente.find({}, { numero_servicios: 1, nombre_cliente: 1 }).sort({ numero_servicios: 1 }).limit(-1)
db.cliente.find({}, { numero_servicios: 1, nombre_cliente: 1 }).sort({ numero_servicios: 1 }).limit(-1).map((u) => 'cliente con menor numero de servicios : ' + u.nombre_cliente)

/*Total de la utilidad de los servicios Inciso H*/  
  db.trabajo.aggregate({
	$project: {
	  utilidad: {
		$add: [
		  {
			$subtract: [
			  '$servicio_utilizado.precio',
			  '$servicio_utilizado.costo',
			],
		  },
		],
	  },
	},
  })
  
  db.trabajo.aggregate([
	{
	  $project: {
		utilidad: {
		  $add: [
			{
			  $subtract: [
				'$servicio_utilizado.precio',
				'$servicio_utilizado.costo',
			  ],
			},
		  ],
		},
	  },
	},
	{$out:"utilidad"},
  ])
  
  db.utilidad.aggregate({
	$group: {
	  _id: '',
	  utilidad_total: {
		$sum: '$utilidad',
	  },
	},
  })