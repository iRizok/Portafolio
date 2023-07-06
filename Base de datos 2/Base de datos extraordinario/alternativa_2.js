//Creacion de la base de datos "taller_mecanico" en la que almacenaremos nuestros esquemas
use ("taller_mecanico_2")

//Creacion del esquema de la coleccion "taller_consulta"
db.createCollection("taller_consulta", 
{
    validator:{
        $jsonSchema: {
            bsonType: "object",
            required: ["_id","servicio","precio","costo"],
            properties: {
				_id: {
					bsonType: "number",
					description: "id del alumno"
				},
                servicio: {
                    bsonType: "string",
                    description:"Tipo de servicio",
                    enum:["reparacion_menor","reparacion_mayor","cambio_de_aceite","afinacion","revision_mecanica"]
                },
                costo: {
                    bsonType: "number",
                    description: "Costo de la reparacion"
                },
                precio: {
                    bsonType: "number",
                    description: "precio del servicio"
                }
                
            }
        }
    }
}
)

//Inserción de datos en la colección "taller_consulta"
db.taller_consulta.insertMany([
    { _id: 1, servicio: 'reparacion_menor', costo: 300, precio: 1000 },
    { _id: 2, servicio: 'reparacion_mayor', costo: 1000, precio: 5000 },
    { _id: 3, servicio: 'cambio_de_aceite', costo: 500, precio: 2500 },
    { _id: 4, servicio: 'afinacion', costo: 3000, precio: 6000 },
    { _id: 5, servicio: 'revision_mecanica', costo: 0, precio: 200 },
]
)

//Creacion del esquema de la coleccion "mecanicos_consulta"
db.createCollection('mecanicos_consulta', {
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
}
)

// b) Inserción de datos en la colección "mecanicos_consulta"
db.mecanicos_consulta.insertMany(
    [
        {_id: 1, nombre: "Roberto Carlos Ramos Martinez", especialidad: "mecanico general", edad: 20, sueldo: 4000},
        {_id: 2,nombre: 'Juan Carlos Medina Rodriguez',especialidad: 'mecanico electricista',edad: 40,sueldo: 6000},
        {_id: 3, nombre: 'Godofredo Perera Lopes', especialidad: 'mecanico especializado', edad: 60, sueldo: 10000}
    ]
)

//Creacion del esquema de la coleccion "domicilio_consulta"
db.createCollection("domicilio_consulta",
{
    validator:{
        $jsonSchema: {
            bsonType: "object",
            required: ["_id","calle","numero","colonia", "ciudad", "estado"],
            properties: {
				_id: {
					bsonType: "number",
					description: "id del domicilio del cliente"
				},
                calle: {
                    bsonType: "string",
                    description:"Calle del domicilio"
                },
                numero: {
                    bsonType: "number",
                    description: "Numero del domicilio"
                },
                colonia: {
                    bsonType: "string",
                    description: "Colonia del domicilio"
                },
                ciudad: {
                    bsonType: "string",
                    description: "Ciudad del domicilio"
                },
                estado: {
                    bsonType: "string",
                    description: "Estado del domicilio"
                }
            }
        }
    }  
}
)

//Inserción de datos en la colección "domicilios_consulta"
db.domicilio_consulta.insertMany(
    [
        {_id:1,calle:"Av.La Torre",numero:2721,colonia:"Privadas La torre",ciudad:"Saltillo",estado:"Coahuila"},
        {_id:2,calle:"numero 13",numero:174,colonia:"Mirasierra",ciudad:"Saltillo",estado:"Coahuila"},
        {_id:3,calle:"Eucalipto",numero:349,colonia:"Zaragoza",ciudad:"Saltillo",estado:"Coahuila"},
        {_id:4,calle:"Fco. Villa",numero:1017,colonia:"23 de mayo",ciudad:"Saltillo",estado:"Coahuila"},
        {_id:5,calle:"Halita",numero:1000,colonia:"Diaz Ordaz",ciudad:"Saltillo",estado:"Coahuila"}
    ]
)

//Creacion del esquema de la coleccion "automovil_cliente_consulta"
db.createCollection("automovil_cliente_consulta",
{
    validator:{
        $jsonSchema: {
            bsonType: "object",
            required: ["_id","idS","marca","modelo", "color", "num_cilindros", "observaciones"],
            properties: {
				_id: {
					bsonType: "number",
					description: "id del automovil"
				},
                idS: {
                    bsonType: "array",
                    description: "id que referencia los servicio realizados en el automovil"
                },
                marca: {
                    bsonType: "string",
                    description: "Marca del automovil"
                },
                modelo: {
                    bsonType: "string",
                    description: "Modelo del automovil"
                },
                color: {
                    bsonType: "string",
                    description: "Color del automovil"
                },
                num_cilindros: {
                    bsonType: "number",
                    description: "Numero de cilindros del automovil",
                    minimum: 0,
                    maximum: 12
                },
                observaciones: {
                    bsonType: "string",
                    description: "Observaciones"
                }
            }
        }
    }      
})

//Inserción de datos en la colección "automovil_cliente_consulta"
db.automovil_cliente_consulta.insertMany(
    [
        {_id: 1, idS: [5,3,2,3], marca: "Subaru", modelo: "TX35", color: "Gris", num_cilindros: 4, observaciones: "El auto estaba en malas condiciones"},
        {_id: 2, idS: [2,4,5], marca: "Mazda", modelo: "MIN89", color: "Azul", num_cilindros: 6, observaciones: "Auto con leves talladuras en la parte derecha"},
        {_id: 3, idS: [1,4,5,2], marca: "Chevrolet", modelo: "NxNOP", color: "Amarillo", num_cilindros: 8, observaciones: "Auto sin ningun danio aparente"},
        {_id: 4, idS: [2,3,5,3], marca: "Ford", modelo: "F350", color: "Verde", num_cilindros: 12, observaciones: "Auto en buen estado"},
        {_id: 5, idS: [2,3,5,3,1], marca: "Nissan", modelo: "TSURU", color: "Blanco", num_cilindros: 6, observaciones: "El auto estaba en muy malas condiciones"},
        {_id: 6, idS: [3,4,4,2,5], marca: "Ford", modelo: "FIGO", color: "Negro", num_cilindros: 3, observaciones: "Esta a punto de implosionar"},
        {_id: 7, idS: [4,5,1], marca: "Chevrolet", modelo: "CHEVY", color: "Azul", num_cilindros: 4, observaciones: "Necesita un cambio urgente de aceite"},
        {_id: 8, idS: [3,5], marca: "Tesla", modelo: "MODELS", color: "Blanco", num_cilindros: 2, observaciones: "En perfectas condiciones"},
    ]
)

//Creacion del esquema de la coleccion "cliente_consulta"
db.createCollection("cliente_consulta",
{
    validator:{
        $jsonSchema: {
            bsonType: "object",
            required: ["_id","idA","idD","idS","nombre_cliente","telefono","correo"],
            properties: {
				_id: {
					bsonType: "number",
					description: "id del cliente"
				},
                idA:{
					bsonType: "array",
					description: "id que referencia el automovil del cliente"                    
                },
                idD: {
					bsonType: "number",
					description: "id que referencia el domicilio del cliente"
                },
                idS: {
                    bsonType: "array",
                    description: "id que referencia el servicio realizado en el auto del cliente"
                },
                nombre_cliente: {
                    bsonType: "string",
                    description: "Nombre del cliente"
                },
                telefono: {
                    bsonType: "number",
                    description: "Telefono del cliente"
                },
                correo: {
                    bsonType: "string",
                    description: "Correo del cliente"
                }
            }
        }
    }      
}
)

// a) Inserción de datos en la colección "cliente_consulta"
db.cliente_consulta.insertMany(
    [
        {_id: 1, idA: [1], idD: 1, idS: [5,3,2,3], nombre_cliente: "Andres Manuel Lopez Obrador", telefono: 4467678909, correo: "amlorules78_uwu@hotmail.com"},
        {_id: 2, idA: [2], idD: 2, idS: [2,4,5], nombre_cliente: "Juan Antonio C", telefono: 1234567890, correo: "tucosmopolis@hotmail.com"},
        {_id: 3, idA: [3,4], idD: 3, idS: [1,4,5,2,2,3,5,3], nombre_cliente: "Alejandro Moderno Hernandez", telefono: 8445553523, correo: "juanpazurita.png@yahoo.com"},
        {_id: 4, idA: [5,6], idD: 4, idS: [2,3,5,3,1,3,4,4,2,5], nombre_cliente: "Enrique Penia Nieto", telefono: 8976384756, correo: "unonomenoscomo5@hotmail.com"},
        {_id: 5, idA: [7,8], idD: 5, idS: [4,5,1,3,5], nombre_cliente: "Maria Antonieta de las Nieves", telefono: 8971238974, correo: "enriquecegoviano@gmail.com"}
    ]
)

//Creacion del esquema de la coleccion "trabajo_consulta"
db.createCollection('trabajo_consulta', {
    validator: {
    $jsonSchema: {
        bsonType: 'object',
        required: ['_id','idM','fecha_entrada','fecha_final', 'observaciones_trabajo','idS','idC','idA'],
        properties: {
            _id: {
                bsonType: "number",
                description: 'id del trabajo',
            },
            idM: {
                bsonType: "number",
                description: 'id que referencia al mecanico que realizo el trabajo'
            },
            fecha_entrada: {
                bsonType: 'date'
            },
            fecha_final: {
                bsonType: 'date'
            },
            observaciones_trabajo: {
                bsonType: 'string',
                description: 'las observaciones del mecanico',
            },
            idS: {
                bsonType: "number",
                description: 'id que referencia al servicio(s) realizado por el mecanico'
            },
            idC: {
                bsonType: "number",
                description: 'id que referencia al cliente'
            },
            idA: {
                bsonType: "number",
                description: 'id que referencia al auto del cliente al que se le realizo el trabajo'
            }
        },
    },
    },
}
)

// c) Inserción de datos en la colección "trabajo_consulta"
db.trabajo_consulta.insertMany(
    [
        { _id: 1,fecha_entrada: new Date('2020,03,11'), fecha_final: new Date('2020,03,30'), observaciones_trabajo: 'Revisión mecánica completada', idM: 2, idS: 5, idC: 1, idA: 1},
        { _id: 2,fecha_entrada: new Date('2020,03,11'), fecha_final: new Date('2020,03,30'), observaciones_trabajo: 'Cambio de aceite exitoso', idM: 1, idS: 3, idC: 1, idA: 1},
        { _id: 3,fecha_entrada: new Date('2020,03,11'), fecha_final: new Date('2020,03,30'), observaciones_trabajo: 'Todo funcionando correctamente', idM: 3, idS: 2, idC: 1, idA: 1},
        { _id: 4,fecha_entrada: new Date('2020,03,11'), fecha_final: new Date('2020,03,30'), observaciones_trabajo: 'Se realizo un nuevo cambio de aceite', idM: 1, idS: 3, idC: 1, idA: 1},
        { _id: 5,fecha_entrada: new Date('2020,08,05'), fecha_final: new Date('2020,08,10'), observaciones_trabajo: 'Motor funcionando correctamente', idM: 3, idS: 2, idC: 2, idA: 2},
        { _id: 6,fecha_entrada: new Date('2020,08,05'), fecha_final: new Date('2020,08,10'), observaciones_trabajo: 'Afinación exitosa', idM: 2, idS: 4, idC: 2, idA: 2},
        { _id: 7,fecha_entrada: new Date('2020,08,05'), fecha_final: new Date('2020,08,10'), observaciones_trabajo: 'No tenía fallos', idM: 2, idS: 5, idC: 2, idA: 2},
        { _id: 8,fecha_entrada: new Date('2020,12,15'), fecha_final: new Date('2020,12,23'), observaciones_trabajo: 'Trabajo sencillo realizado', idM: 1, idS: 1, idC: 3, idA: 3},
        { _id: 9,fecha_entrada: new Date('2020,12,15'), fecha_final: new Date('2020,12,23'), observaciones_trabajo: 'Afinación realizada', idM: 3, idS: 4, idC: 3, idA: 3},
        { _id: 10,fecha_entrada: new Date('2020,12,15'), fecha_final: new Date('2020,12,23'), observaciones_trabajo: 'Revisión correcta', idM: 2, idS: 5, idC: 3, idA: 3},
        { _id: 11,fecha_entrada: new Date('2020,12,15'), fecha_final: new Date('2020,12,23'), observaciones_trabajo: 'Reparación mayor exitosa', idM: 3, idS: 2, idC: 3, idA: 3},
        { _id: 12,fecha_entrada: new Date('2021,02,01'), fecha_final: new Date('2021,02,14'), observaciones_trabajo: 'Reparación mayor exitosa', idM: 3, idS: 2, idC: 3, idA: 4},
        { _id: 13,fecha_entrada: new Date('2021,02,01'), fecha_final: new Date('2021,02,14'), observaciones_trabajo: 'Cambio de aceite realizado', idM: 1, idS: 3, idC: 3, idA: 4},
        { _id: 14,fecha_entrada: new Date('2021,02,01'), fecha_final: new Date('2021,02,14'), observaciones_trabajo: 'Se arreglo falla del clima', idM: 2, idS: 5, idC: 3, idA: 4},
        { _id: 15,fecha_entrada: new Date('2021,02,01'), fecha_final: new Date('2021,02,14'), observaciones_trabajo: 'Fallo el anterior cambio de aceite y se le realizo uno nuevo', idM: 1, idS: 3, idC: 3, idA: 4},
        { _id: 16,fecha_entrada: new Date('2021,09,30'), fecha_final: new Date('2021,10,06'), observaciones_trabajo: 'Reparación mayor exitosa', idM: 3, idS: 2, idC: 4, idA: 5},
        { _id: 17,fecha_entrada: new Date('2021,09,30'), fecha_final: new Date('2021,10,06'), observaciones_trabajo: 'Cambio de aceite realizado', idM: 1, idS: 3, idC: 4, idA: 5},
        { _id: 18,fecha_entrada: new Date('2021,09,30'), fecha_final: new Date('2021,10,06'), observaciones_trabajo: 'No hubo fallos', idM: 2, idS: 5, idC: 4, idA: 5},
        { _id: 19,fecha_entrada: new Date('2021,09,30'), fecha_final: new Date('2021,10,06'), observaciones_trabajo: 'Cambio de aceite exitoso', idM: 1, idS: 3, idC: 4, idA: 5},
        { _id: 20,fecha_entrada: new Date('2021,09,30'), fecha_final: new Date('2021,10,06'), observaciones_trabajo: 'Cambio de pastillas de freno', idM: 1, idS: 1, idC: 4, idA: 5},
        { _id: 21,fecha_entrada: new Date('2021,10,06'), fecha_final: new Date('2021,10,16'), observaciones_trabajo: 'Cambio de aceite de rutina', idM: 1, idS: 3, idC: 4, idA: 6},
        { _id: 22,fecha_entrada: new Date('2021,10,06'), fecha_final: new Date('2021,10,16'), observaciones_trabajo: 'Afinación realizada', idM: 2, idS: 4, idC: 4, idA: 6},
        { _id: 23,fecha_entrada: new Date('2021,10,06'), fecha_final: new Date('2021,10,16'), observaciones_trabajo: 'Afinación anterior fallida, se hizo una nueva', idM: 2, idS: 4, idC: 4, idA: 6},
        { _id: 24,fecha_entrada: new Date('2021,10,06'), fecha_final: new Date('2021,10,16'), observaciones_trabajo: 'Fallo en la correa de distribución', idM: 3, idS: 2, idC: 5, idA: 6},
        { _id: 25,fecha_entrada: new Date('2021,10,06'), fecha_final: new Date('2021,10,16'), observaciones_trabajo: 'Chequeo de rutina exitoso', idM: 2, idS: 5, idC: 5, idA: 6},
        { _id: 26,fecha_entrada: new Date('2021,10,25'), fecha_final: new Date('2021,10,31'), observaciones_trabajo: 'Afinacion correcta', idM: 2, idS: 4, idC: 5, idA: 7},
        { _id: 27,fecha_entrada: new Date('2021,10,25'), fecha_final: new Date('2021,10,31'), observaciones_trabajo: 'Chequeo completo debido a un sonido raro', idM: 2, idS: 5, idC: 5, idA: 7},
        { _id: 28,fecha_entrada: new Date('2021,11,05'), fecha_final: new Date('2021,11,11'), observaciones_trabajo: 'Cambio de intermitentes', idM: 1, idS: 1, idC: 5, idA: 7},
        { _id: 29,fecha_entrada: new Date('2021,11,05'), fecha_final: new Date('2021,11,11'), observaciones_trabajo: 'Cambio de aceite completo', idM: 1, idS: 3, idC: 5, idA: 8},
        { _id: 30,fecha_entrada: new Date('2021,11,05'), fecha_final: new Date('2021,11,11'), observaciones_trabajo: 'Revisión completa exitosa', idM: 1, idS: 5, idC: 5, idA: 8},
    ]
)

// d) Listado de todos los clientes con sus respectivos automoviles, mostrando el nombre del cliente, la marca, el modelo, el color y el numero de cilindros
db.cliente_consulta.aggregate(
    [
        {
            $lookup:{
                from: "automovil_cliente_consulta",
                localField: "idA",
                foreignField: "_id",
                as: "automovil"
            }
        },
        {
            $project: {
                _id: 0,
                nombre_cliente: 1,
                telefono: 1,
                correo: 1,
                automovilMarca: {
                    $map: {
                        input: "$automovil.marca",
                        as: "autosMa",
                        in: "$$autosMa"
                    }
                },
                automovilModelo: {
                    $map: {
                        input: "$automovil.modelo",
                        as: "autosMo",
                        in: "$$autosMo"
                    }
                },
                automovilColor: {
                    $map: {
                        input: "$automovil.color",
                        as: "autosCo",
                        in: "$$autosCo"
                    }
                },
                automovilN_cilindros: {
                    $map: {
                        input: "$automovil.num_cilindros",
                        as: "autosCi",
                        in: "$$autosCi"
                    }
                }
            }
        }
    ]
)

// e) Listado de los automoviles (su marca, modelo y color) junto con el tipo de servicio(s) realizados
db.automovil_cliente_consulta.aggregate(
    [
        {
            $lookup:{
                from: "taller_consulta",
                localField: "idS",
                foreignField: "_id",
                as: "servicios_auto"
            }
        },
        {
            $project: {
                _id: 1,
                marca: 1,
                modelo: 1,
                color: 1,
                tipoServicios: {
                    $map: {
                        input: "$servicios_auto.servicio",
                        as: "services",
                        in: "$$services"
                    }
                }
            }
        },
    ]
)

// f) Listado del cliente con mayor numero de servicios contratados
db.cliente_consulta.aggregate(
    [
        {
            $project: {
                nombre_cliente: 1,
                numero_servicios: {
                    $size: "$idS"
                },
            }
        },
        {
            $sort: {
                "numero_servicios": -1
            }
        },
        {
            $limit: 1
        },
        {
            $project: {
                _id:0,
                clienteMax: {$concat: ["El cliente ","$nombre_cliente"," es el que tiene el mayor numero de servicios contratados"]}
            }
        }
    ]
)

// g) Listado del cliente con el menor numero de servicios contratados
db.cliente_consulta.aggregate(
    [
        {
            $project: {
                nombre_cliente: 1,
                numero_servicios: {
                    $size: "$idS"
                },
            }
        },
        {
            $sort: {
                "numero_servicios": 1
            }
        },
        {
            $limit: 1
        },
        {
            $project: {
                _id:0,
                clienteMin: {$concat: ["El cliente ","$nombre_cliente"," es el que tiene el menor numero de servicios contratados"]}
            }
        }
    ]
)

// h) Utilidad total de todos los trabajos realizados de cada auto
db.trabajo_consulta.aggregate(
    [
        {
            $lookup: {
                from: "taller_consulta",
                localField: "idS",
                foreignField: "_id",
                as: "servicios"
            }
        },
        {
            $replaceRoot: {newRoot: {$mergeObjects: [{$arrayElemAt:["$servicios", 0]}, "$$ROOT"]}}
        },
        {
            $group: {
                _id: null,
                costoTotal: {
                    $sum: "$costo"
                },
                precioTotal: {
                    $sum: "$precio"
                }
            }
        },
        {
            $project: {
                _id: 0,
                utilidadTotal: {
                    $subtract: ["$precioTotal", "$costoTotal"]
                }
            }
        }
    ]
)