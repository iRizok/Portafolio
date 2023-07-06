import java.util.Vector;

public class Individuo {
	char beta[];
	char alpha[];
	char omicron[];
	char bat[];
	int puntos;

	// Constructor apartir de secuencias
	public Individuo(char beta[], char alpha[], char omicron[], char bat[]) {
		this.beta = beta.clone();
		this.alpha = alpha.clone();
		this.omicron = omicron.clone();
		this.bat = bat.clone();

		/*
		 * valpha = new Vector();//Constructor for(char c :
		 * cadena.toCharArray())//Rellenar nuevo vector con un string cadena
		 * valpha.add(c);
		 */
	}
	// Constructor clonar ind aclonar
	// this.beta = aclonar.beta.clone()

	public char[] getBeta() {
		return beta;
	}

	public char[] getAlpha() {
		return alpha;
	}

	public char[] getOmicron() {
		return omicron;
	}

	public char[] getBat() {
		return bat;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setBeta(char[] beta) {
		this.beta = beta;
	}

	public void setAlpha(char[] alpha) {
		this.alpha = alpha;
	}

	public void setOmicron(char[] omicron) {
		this.omicron = omicron;
	}

	public void setBat(char[] bat) {
		this.bat = bat;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	// Constructor ind padre ind madre

	 /*public void Cruzamiento(int tamanoCorte) {
			for(int i,j; i<alpha.length && j<tamanoCorte; i++) {
					if(alpha[j] != '-') {
						
					}else {
						
					}
				
			}
		
	/*	for (char c : valpha) {// Rellenar nuevo vector con un string cadena
			System.out.print(c);
			if (j == tamanoCorte)
				break;
			if (c != '-')
				j++;
		}
	}*/

	/*
	 * int para tamaño del corte *lengh/3 representa el numero de caracteres no -
	 * que debe de tomar for desde 0 a lengh para tomar la parte de madre detener
	 * cuando se tomen el numero de caracteres no - que se especifica en el corte
	 * Saltarse esos caracteres para el siguiente corte de la parte del padre Se
	 * vuelven a omitir los - y se toman el numero de caracteres diferentes a -
	 * MM--MMM--MMM P-PPP-PP-P-P ESTO ESTA INCOMPLETO MMMPPPMM ESTO ESTA BIEN
	 * MM--MP-PPMM for(int i, j; i<alpha.length, j<tamañoCorte; i++) if(alpha[j] !=
	 * '-') **** for(
	 * 
	 * 
	 * *** Vector<Character> pegado =new Vector(valpha.size()+1);
	 * pegado.addAll(valpha.subList(0, posicion)); pegado.add('-');
	 * pegado.addAll(valpha.subList(posicion, valpha.size()));
	 * 
	 */

	// Metodo para dar la misma longitud apartir de beta.length alpha.length,
	// omicron.length, bat.length
	public void igualarTamanos() {
		for (int i = 0; i < alpha.length; i++) {
			if (alpha.length == beta.length && alpha.length == omicron.length && alpha.length == bat.length) {
			} else {

			}
		}
	}

	// Metodo para agregar un gap en la secuancia alpha beta omicron y bat swith 1 2
	// 3 4 break entre 0 y lenght
	// Al final igualar la longitud maxima

	// Metodo para seleccionar aleatoriamente cuando agregar un gap
	// Se espera que este igualado si no igualarlo
	// igualar()
	// cuantos gaps quieres generar

	// Metodo para evaluar individuo (ver que esten alineados) regresar un puntaje
	// en int o en long
	// Variable local para guardar puntaje
	// Repetir para todas las columnas for desde 0 a cualquier secuencia.length
	// if(beta[i] == alpha[i] && beta[i] == omicron[í] && beta[i] == bat[í]) /... +2
	// Si no esta alineada dar 0
	// Si tiene un gap dar -1 if(beta[i] == '-' || omicron[i] == '-' || bat[í] ==
	// '-' || alpha[i] == '-')
	// Actualizar puntaje del objeto

}
