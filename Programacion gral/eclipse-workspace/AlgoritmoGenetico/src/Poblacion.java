import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Poblacion {
	private Individuo poblacion[]; // coleccion de individuos
	private double fitnessPoblacion = -1; // fitness global

	public Poblacion(int tamanoPoblacion) {
		poblacion = new Individuo[tamanoPoblacion];
	}

	public Poblacion(int tamanoPoblacion, int tamanoCepa) {
		poblacion = new Individuo[tamanoPoblacion]; // instanciacion de la poblacion
		for (int i = 0; i < tamanoPoblacion; i++) {
			Individuo individual = new Individuo(tamanoCepa); // instanciando cada individuo
			poblacion[i] = individual;
		}
	}

	/**
	 * Retorna los individuos de la poblacion
	 * 
	 * @return
	 */
	public Individuo[] getPoblacion() {
		return poblacion;
	}

	/**
	 * poblacion[0] = al mas adaptado poblacion[poblacion.length-1] = el menos
	 * adaptado
	 * 
	 * PoblacionA = {A,B,C,D,E,F} PoblacionA = {B,A,D,F,E,C} PoblacionA.length-1 ->
	 * peor individuo PoblacionB -> individuo regular
	 * 
	 */

	public Individuo getMasAdaptado(int seleccionIndividuo) {
		Arrays.sort(poblacion, new Comparator<Individuo>() {
			@Override
			public int compare(Individuo o1, Individuo o2) {
				if (o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});
		// Return the fittest individual
		return poblacion[seleccionIndividuo];

	}

	public double getFitnessPoblacion() {
		return fitnessPoblacion;
	}

	// Forma para obtener el tamaño de nuestra poblacion
	public int tamañoPoblacion() {
		return poblacion.length;
	}

	public void setFitnessPoblacion(double fitnessPoblacion) {
		this.fitnessPoblacion = fitnessPoblacion;
	}

	public Individuo setIndividuo(int indice, Individuo individuo) {
		return poblacion[indice] = individuo;
	}

	public Individuo getIndividuo(int indice) {
		return poblacion[indice];
	}

	/*
	 * Mezcla la poblacion
	 * 
	 * @param void
	 * @return void
	 */
	public void Mesclar() {
		Random rnd = new Random();
		for (int i = poblacion.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Individuo a = poblacion[index];
			poblacion[i] = a;
		}
	}

}
