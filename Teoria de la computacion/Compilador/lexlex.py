from rply import LexerGenerator
from rply import Token
from pandas import DataFrame

lg = LexerGenerator()

def add_tokens():
    
    #Constantes
    lg.add('-43',r'["].*["]') #String

    #Tokens de identificadores
    lg.add('-44',r'[a-zA-Z][a-zA-Z0-9]*[$]') #String
    lg.add('-45',r'[a-zA-Z][a-zA-Z0-9]*[%]') #Reales
    lg.add('-46',r'[a-zA-Z][a-zA-Z0-9]*[&]') #Enteros
    lg.add('-47',r'[a-zA-Z][a-zA-Z0-9]*[@]') #Programa/Rutina
    
    lg.add('-1', r'programa')
    lg.add('-2', r'inicio')
    lg.add('-3', r'fin')
    lg.add('-4', r'leer')
    lg.add('-5', r'escribir')
    lg.add('-6', r'si')
    lg.add('-7', r'sino')
    lg.add('-8', r'mientras')
    lg.add('-9', r'repetir')
    lg.add('-10', r'hasta')
    lg.add('-11', r'limpiar')
    lg.add('-12', r'ejecutar')
    lg.add('-13', r'posxy')
    lg.add('-14', r'proc')
    lg.add('-15', r'var')
    lg.add('-16', r'encaso')
    lg.add('-17', r'valor')
    lg.add('-18', r'\+')
    lg.add('-19', r'\-')
    lg.add('-20', r'\*')
    lg.add('-42',r'\/\/.*')
    lg.add('-21', r'\/')
    lg.add('-22', r'\%')
    lg.add('-23', r'\=\=')
    lg.add('-24', r'\=')
    lg.add('-25', r'\<\=')
    lg.add('-26', r'\<')
    lg.add('-27', r'\>\=')
    lg.add('-28', r'\>')
    lg.add('-29', r'\!\=')
    lg.add('-30', r'\!')
    lg.add('-31',r'\&\&')
    lg.add('-32',r'\|\|')
    lg.add('-33',r'\;')
    lg.add('-34',r'\[')
    lg.add('-35',r'\]')
    lg.add('-36',r'\,')
    lg.add('-37',r'\:')
    lg.add('-38',r'\(')
    lg.add('-39',r'\)')
    lg.add('-40',r'\{')
    lg.add('-41',r'\}')

    lg.ignore('\s+')

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

lexer = lg.build()  
add_tokens()

dictValue = []
dictType = []
dictLine = []
dictPosTabla = []

with open('codigoPrueba', 'r') as f:
    for lineno, line in enumerate(f, start=1):
        for token in lexer.lex(line):
            
            tokenType = token.gettokentype()
            tokenValue = token.value
            dictValue.append(tokenValue)
            dictType.append(tokenType)
            dictLine.append(lineno)
            
            if int(tokenType) <= -44:
                dictPosTabla.append("-2")
            else:
                dictPosTabla.append("-1")
                
           # print(f"{tokenType}, {token.value}, {lineno}".format('Token', 'Lexema', 'Linea'))
            
tablaToken=DataFrame({'Token': dictType, 'Lexema': dictValue, 'Linea': dictLine, 'Pos. tabla': dictPosTabla})
print(tablaToken)