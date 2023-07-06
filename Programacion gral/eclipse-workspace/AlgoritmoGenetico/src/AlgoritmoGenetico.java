
public class AlgoritmoGenetico {
	private int tamanoPoblacion;
	private double tazaMutacion;
	private double tazaCruzamiento;
	private int numeroElite;

	public AlgoritmoGenetico(int tamanoPoblacion, double tazaMutacion, double tazaCruzamiento, int numeroElite) {
		this.tamanoPoblacion = tamanoPoblacion;
		this.tazaMutacion = tazaMutacion;
		this.tazaCruzamiento = tazaCruzamiento;
		this.numeroElite = numeroElite; // Elite es al que no se le aplica mutacion ni cruzamiento

	}

	public Poblacion iniciarPoblacion(int tamanoCepa) {
		Poblacion poblacion = new Poblacion(tamanoPoblacion, tamanoCepa);
		return poblacion;
	}

	/*
	 * Calculo del fitness de un individuo Suma la cantidad de genes iguales a 1 y
	 * los divide por el tamaño del cromosoma del individuo
	 * 
	 * Ejemplos: IndA = 11100 IndB = 01000 IndC = 11111
	 * 
	 * f(indA) = 3/5 = 0.6 f(indB) = 1/5 = 0.2 f(indC) = 5/5 = 1
	 */

	public double calcFitness(Individuo individuo) {
		int genesCorrectos = 0;
		for (int indiceGen = 0; indiceGen < individuo.getTamanoCepa(); indiceGen++) {
			if (individuo.getGen(indiceGen) == 1) {
				genesCorrectos += 1;
			}
		}
		double fitness = (double) genesCorrectos / individuo.getTamanoCepa();
		individuo.setFitness(fitness);
		return fitness;
	}

	/**
	 * Evalua el fitness de toda la poblacion realiza la suma del fitness de cada
	 * individuo en la poblacion
	 * 
	 * @param poblacion la poblacion a evaluar
	 */
	public void evalPoblacion(Poblacion poblacion) {
		double poblacionFitness = 0;
		for (Individuo individuo : poblacion.getPoblacion()) {
			poblacionFitness += calcFitness(individuo);
		}
		poblacion.setFitnessPoblacion(poblacionFitness);
	}

	/**
	 * Evalua si alguno de los individuos de una poblacion ha alcanzado el fitness
	 * previsto (fitness = 1)
	 * 
	 * @param poblacion
	 * @return
	 */
	public boolean condicionTerminal(Poblacion poblacion) {
		for (Individuo individuo : poblacion.getPoblacion()) {
			if (individuo.getFitness() == 1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * selecciona al padre para el cruzamiento
	 * 
	 * fitnessPoblacion = 12.5
	 * PosicionRuleta = 0.5* 25 = 12.5
	 * findA = 0.3
	 * findB = 0.9
	 * findC = 0.4
	 * ...
	 * findL = 0.5
	 * agujaRuleta = 11.6
	 * findM = 0.9
	 * agujaRuleta = 12.5
	 * 
	 */

	public Individuo seleccionarPadre(Poblacion poblacion) {
		Individuo individuos[] = poblacion.getPoblacion();

		// Gira la ruleta
		double fitnessPoblacion = poblacion.getFitnessPoblacion();
		double posicionRuleta = Math.random() * fitnessPoblacion;
		// Encuentra al padre
		double agujaRuleta = 0;
		for (Individuo individuo : individuos) {
			agujaRuleta += individuo.getFitness();
			if (agujaRuleta >= posicionRuleta) {
				return individuo;
			}
		}
		return individuos[individuos.length - 1];
	}
	
	public Poblacion poblacionDescendiente(Poblacion poblacion) {
		 //Crea una nueva poblacion
		Poblacion newPoblacion = new Poblacion(poblacion.tamañoPoblacion());
		
		//Recorre la poblacion actual
		for (int indice = 0; indice < poblacion.getPoblacion().length; indice++) {
			Individuo padre1 = poblacion.getMasAdaptado(indice);
			
			//Aplica el cruzamiento a los individuos
			if(this.tazaCruzamiento > Math.random() && indice >= this.numeroElite) {
				
				//Encuentrea el segundo padre
				Individuo padre2 = seleccionarPadre(poblacion);
				
				// Inicia la desendencia
				 Individuo descendente = new Individuo(padre1.getCepa());
				 
				 //Recorre el genoma
				 for(int geneIndex = 0; geneIndex < padre1.getTamanoCepa(); geneIndex ++) {
					 //Usa la mitad de los genes ambos padres
					 if(0.5 > Math.random()) {
						 descendente.setGen(geneIndex, padre1.getGen(geneIndex));
					 }else {
						 descendente.setGen(geneIndex, padre2.getGen(geneIndex));
					 }
				 }
				 //añade la descendente a la nueva poblacion
				 newPoblacion.setIndividuo(indice, descendente);
			}else {
				//añade cada individuo a la nueva poblacion
				newPoblacion.setIndividuo(indice, padre1);
			}
		}
		return newPoblacion;
	}
}
