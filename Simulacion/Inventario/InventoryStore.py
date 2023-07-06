from inventario import Inventario
from Evento import Evento
import random


def asignarTiempo():
    x = random.random()
    if x < 1/3:
        return 10
    if x < 2/3:
        return 15
    return 20


def asignarCantidad():
    x = random.random()
    if x < 1/5:
        return 10
    if x < 2/5:
        return 20
    if x < 3/5:
        return 30
    if x < 4/5:
        return 40
    return 50


def calculateEvents(num):
    eventos = []
    tiempo = 0
    cantidad = 0
    for i in range(num):
        if i != 0:
            tiempo = asignarTiempo()
            tiempo += eventos[i-1].tiempo

        cantidad = asignarCantidad()

        newEvento = Evento(tipo='Venta', tiempo=tiempo, cantidad=cantidad)
        eventos.append(newEvento)

    return eventos

def simulate(eventos: list, inventario: Inventario):
    capRes = inventario.capMax
    limite = inventario.limiteReorden
    clock = 0
    ordenesIgnoradas = []

    for i in range(len(eventos)):
        clock += eventos[i].tiempo
        if capRes > limite:
            if capRes - eventos[i].cantidad <= 0:
                ordenesIgnoradas.append(eventos[i])
            else:
                capRes -= eventos[i].cantidad
        else:
            cantidadRefill = inventario.capMax - capRes
            capRes += cantidadRefill

    cantidadPedidosIgnorados = 0
    for i in range(len(ordenesIgnoradas)):
        cantidadPedidosIgnorados += ordenesIgnoradas[i].cantidad

    print(f"Capacidad restante del inventario: {capRes}")
    print(f"Ventas que no fueron realizadas...\nNumero de ordenes: {len(ordenesIgnoradas)}\nCantidad total: {cantidadPedidosIgnorados}")

def main():
    print("Eventos...")
    lstEventos = calculateEvents(7)

    for i in lstEventos:
        print(f"[{i}]\n")

    inventario = Inventario(capMax=200, limiteReorden=80, tiempoReorden=10)
    print(f"\nDetalles del inventario...\n{inventario}")
    simulate(lstEventos, inventario)


if __name__ == "__main__":
    main()
