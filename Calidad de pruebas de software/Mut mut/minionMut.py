# Primer mutante: inicializamos la variable total en 1.
def sumArrayMut1(arr):
    total = 1
    for ele in arr:
        total += ele
    return total


# Segundo mutante: inicializamos la variable total en 0 y además iteramos la variable ele en total.
def sumArrayMut2(arr):
    total = 0
    for ele in total:
        total -= ele
    return total


# Tercer mutante: inicializamos la variable total con el ultimo elemento de la variable array
def sumArrayMut3(arr):
    total = arr[-1]
    for ele in arr:
        total += ele
    return total


# Cuarto mutante: cambiamos la variable que regresa la función por la variable ele e inicializamos total en 0.
def sumArrayMut4(arr):
    total = 0
    for ele in total:
        total += ele
    return ele
