import ply.lex as lex
import pandas as pd

# Definir las palabras reservadas y otros tokens
reserved = {
    'programa': 'PROGRAMA',
    'inicio': 'INICIO',
    'fin': 'FIN',
    'leer': 'LEER',
    'escribir': 'ESCRIBIR',
    'si': 'SI',
    'sino': 'SINO',
    'mientras': 'MIENTRAS',
    'repetir': 'REPETIR',
    'hasta': 'HASTA',
    'limpiar': 'LIMPIAR',
    'ejecutar': 'EJECUTAR',
    'posxy': 'POSXY',
    'proc': 'PROC',
    'var': 'VAR',
    'encaso': 'ENCASO',
    'valor': 'VALOR'
}

tokens = [
    'MAS', 'MENOS', 'POR', 'DIVISION', 'MODULO', 'IGUAL', #aritmeticos
    'MENOR', 'MENORIGUAL', 'MAYOR', 'MAYORIGUAL', 'EXIGUAL','DISTINTO', #relacionales
    'PYC', 'AND', 'OR', #logicos
    'CORCHIZQ', 'CORCHDER', 'COMA', 'DOSPUNTOS', 'PARIZQ', 'PARDER', 'LLAVEIZQ', 'LLAVEDER', #caractToken
    'BARRAINV', 'PUNTO', 'BCO', 'TAB', 'EOLN', 'EOF',
    'ENTERO', 'REAL', 'IDENTIFICADOR', 'CADENA', 'NUMERO'
]

tokens += list(reserved.values())

# Definir las expresiones regulares para los tokens
t_MAS = r'\+'
t_MENOS = r'-'
t_POR = r'\*'
t_DIVISION = r'/'
t_MODULO = r'%'
t_IGUAL = r'='
t_MENOR = r'<'
t_MENORIGUAL = r'<='
t_MAYOR = r'>'
t_MAYORIGUAL = r'>='
t_EXIGUAL = r'=='
t_DISTINTO = r'!='
t_AND = r'&&'
t_OR = r'\|\|'
t_PYC = r';'
t_COMA = r','
t_DOSPUNTOS = r':'
t_PARIZQ = r'\('
t_PARDER = r'\)'
t_CORCHIZQ = r'\['
t_CORCHDER = r'\]'
t_LLAVEIZQ = r'\{'
t_LLAVEDER = r'\}'
t_BARRAINV = r'\\'
t_PUNTO = r'\.'
t_BCO = r'.'
t_TAB = r'\t'
t_EOLN = r'\n'
#t_ENTERO = r'-?\d{1,5}'
#t_REAL = r'-?\d+\.\d+'

t_ignore = r' \s'

def t_ID(t):
    r'[a-zA-Z_][a-zA-Z0-9_]*'
    t.type = reserved.get(t.value, 'ID')
    return t

def t_STRING(t):
    r'"[^"]*"'
    t.value = t.value[1:-1]
    return t

def t_NUMERO(t):
    r'(\d+\.\d+)|(\d+)'
    if "." in t.value:
        t.value = float(t.value)
        t.type = 'REAL'
    else:
        t.value = int(t.value)
        if t.value > -32768 or t.value < 32767:
            t.type = 'ENTERO'
        else:
            t.type = 'REAL'
    return t

# Manejar los errores
def t_error(t):
    print("Carácter ilegal '%s'" % t.value[0])
    t.lexer.skip(1)

# Crear el analizador léxico
lexer = lex.lex()

# Probar el analizador léxico con un archivo de entrada
with open('codigoPrueba') as archivo:
    for linea in archivo:
        lexer.input(linea)
        for token in lexer:
            print(token)

def tokenize(file_path):
    with open(file_path, 'r') as file:
        token_list = []
        for lineno, line in enumerate(file, start=1):  # Recorrer archivo línea por línea
            lexer.input(line)
            while True:  # Recorrer cada línea token por token
                tok = lexer.token()
                if not tok:
                    break
                token_list.append((tok.type, tok.value, lineno))
    return token_list

if __name__ == "__main__":
    archivo = 'codigoPrueba'
    tokens = tokenize(archivo)
    df = pd.DataFrame(tokens, columns=['Token', 'Value', 'Line'])
    print(df)