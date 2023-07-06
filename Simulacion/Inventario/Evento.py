class Evento:

    def __init__(self, tipo, tiempo, cantidad) -> None:
        self.tipo = tipo
        self.tiempo = tiempo
        self.cantidad = cantidad

    def setTipo(self, tipo):
        self.tipo = tipo

    def setTiempo(self, tiempo):
        self.tiempo = tiempo

    def setCantidad(self, cantidad):
        self.cantidad = cantidad

    def __str__(self) -> str:
        return f"Tipo: {self.tipo}\nTiempo: {self.tiempo}\nCantidad: {self.cantidad}"
