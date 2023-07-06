class Inventario:

    def __init__(self, limiteReorden:int, tiempoReorden:int, capMax:int) -> None:
        self.limiteReorden = limiteReorden
        self.tiempoReorden = tiempoReorden
        self.capMax = capMax

    def __str__(self):
        return f"Capacidad máxima: {self.capMax}\nLímite para reordenar: {self.limiteReorden}\nTiempo para reordenar: {self.tiempoReorden}"

