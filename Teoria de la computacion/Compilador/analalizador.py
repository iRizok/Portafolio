from rply import LexerGenerator
from rply import Token
from pandas import DataFrame

LexGen = LexerGenerator()

def tokens():
    #Tokens de identificadores
    #Constantes
    LexGen.add('-45', r'"(?:[^"\\]|\\.)*"') #String
    #Programa/Rutina
    LexGen.add('-49',r'[a-zA-Z][a-zA-Z0-9]*[@]') 
    #Enteros
    LexGen.add('-48',r'[a-zA-Z][a-zA-Z0-9]*[&]') 
    #Reales
    LexGen.add('-47',r'[a-zA-Z][a-zA-Z0-9]*[%]') 
    #String
    LexGen.add('-46',r'[a-zA-Z][a-zA-Z0-9]*[$]') 
    #Reales
    LexGen.add('-42', r'-?\d+\.\d+')
    #Enteros
    LexGen.add('-43', r'-?\d+') 
    
    LexGen.add('-1', r'programa')
    LexGen.add('-2', r'inicio')
    LexGen.add('-3', r'fin')
    LexGen.add('-4', r'leer')
    LexGen.add('-5', r'escribir')
    LexGen.add('-6', r'si')
    LexGen.add('-7', r'sino')
    LexGen.add('-8', r'mientras')
    LexGen.add('-9', r'repetir')
    LexGen.add('-10', r'hasta')
    LexGen.add('-11', r'limpiar')
    LexGen.add('-12', r'ejecutar')
    LexGen.add('-13', r'posxy')
    LexGen.add('-14', r'proc')
    LexGen.add('-15', r'var')
    LexGen.add('-16', r'encaso')
    LexGen.add('-17', r'valor')
    LexGen.add('-18', r'\+')
    LexGen.add('-19', r'\-')
    LexGen.add('-20', r'\*')
    LexGen.add('-44',r'\/\/.*')
    LexGen.add('-21', r'\/')
    LexGen.add('-22', r'\%')
    LexGen.add('-23', r'\=\=')
    LexGen.add('-24', r'\=')
    LexGen.add('-25', r'\<\=')
    LexGen.add('-26', r'\<')
    LexGen.add('-27', r'\>\=')
    LexGen.add('-28', r'\>')
    LexGen.add('-29', r'\!\=')
    LexGen.add('-30', r'\!')
    LexGen.add('-31',r'\&\&')
    LexGen.add('-32',r'\|\|')
    LexGen.add('-33',r'\;')
    LexGen.add('-34',r'\[')
    LexGen.add('-35',r'\]')
    LexGen.add('-36',r'\,')
    LexGen.add('-37',r'\:')
    LexGen.add('-38',r'\(')
    LexGen.add('-39',r'\)')
    LexGen.add('-40',r'\{')
    LexGen.add('-41',r'\}')
    LexGen.add('2', r'.')
    #Ignora
    LexGen.ignore(r'\.')
    LexGen.ignore('\s+')
    


lexer = LexGen.build()  
tokens()

Valor = []
Tipo = []
Lineas = []
PosTabla = []

with open('codigoPrueba', 'r') as f:
    for numlinea, linea in enumerate(f, start=1):
        for token in lexer.lex(linea):
            
            tokenType = token.gettokentype()
            tokenValue = token.value

             # Modificar identificador -43
            if tokenType == '-43':
                if not (-32768 <= int(tokenValue) <= 32767):
                    tokenType = '-42'
            if tokenType == '2':
                tokenValue = 'Error'
                
            Valor.append(tokenValue)
            Tipo.append(tokenType)
            Lineas.append(numlinea)
            
            if int(tokenType) <= -46:
                PosTabla.append("-2")
            else:
                PosTabla.append("-1")
            
                
if __name__ == "__main__": 
    tablaToken = DataFrame({'Token': Tipo, 'Lexema': Valor, 'Linea': Lineas, 'Pos. tabla': PosTabla})
    print(tablaToken)