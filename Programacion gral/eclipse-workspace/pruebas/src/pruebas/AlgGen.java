package pruebas;



import java.util.ArrayList;
import java.util.List;

public class AlgGen {


    final static int GENERACIONES = 10000;

    /**
     * Tamaño de la población
     */
    final static int TAM_POBLACION = 1000;

    /**
     * Porcentaje de individuos que van directos a la siguiente población
     */
    final static int ELITISMO = 10;

    /**
     * Probabilidad de mutación
     */
    final static double P_MUTACION = 0.1;

    /**
     * Constructor vacio del algoritmo genetico
     */
    public AlgGen() {
    }

    /**
     * Metodo que me ejecuta el algoritmo genetico
     *
     * @return Me devuelve la ultima poblacion generada despues de pasar varias generaciones de la actual
     */
    public Poblacion metodo_AG() throws CloneNotSupportedException {

        Poblacion pobActual;                    // Almacena la población actual
        Poblacion pobSiguiente;                 // Almacena la población generada a partir de la actual
        List<Individuo> progenitores;           // Almacena los candidatos seleccionados para reproducirse
        List<Individuo> descendientes;          // Almacena la descendencia generada por los progenitores
        List<Individuo> descendientesMutados;   // Almacena la descendencia tras el operador de mutación
        int condParada = 0;

        pobActual = generarPoblacionInicial();

        while (condParada < GENERACIONES) {
            progenitores = seleccionarProgenitores(pobActual);              // Operador selección
            descendientes = cruzarProgenitores(progenitores);               // Operador cruce
            descendientesMutados = mutarDescendientes(descendientes);       // Operador mutación
            pobSiguiente = nuevaPoblacion(pobActual, descendientesMutados); // Generación nueva población
            pobActual = pobSiguiente;                                       // Actualización
            condParada++;                                                   // Generación completada
        }

        return pobActual;

    }

    /**
     * Metodo que me genera la población inicial de forma aleatoriamente
     *
     * @return Me devuelve una poblacion con individuos que se han creado de forma aleatoria
     */
    private static Poblacion generarPoblacionInicial() {
        //   
        Poblacion pobInicial = new Poblacion();
        Individuo c;

        while (pobInicial.poblacion.size() < TAM_POBLACION) {
            c = new Individuo();
            c.generarCromosomaAleatorio();          // Genero un cromosoma aleatoriamente
            if (!pobInicial.poblacion.contains(c)) // Compruebo que no esté ya en la población
            {
                pobInicial.poblacion.add(c);        // Lo inserto en la lista de la población inicial
            }
        }
        // Ordeno la población para dejar facilitar el elitismo (hay compareTo() por debajo)
        pobInicial.ordenarPoblacion();
        System.out.println("Población inicial generada ya ordenada:\n" + pobInicial.toString());
        return pobInicial;
    }

    /**
     * Metodo que me selecciona a los progenitores es decir quieres seran los padres para luego que tengan descendientes
     *
     * @param pobActual Poblacion de la que cogeremos a los progenitores
     * @return Me devuelve una lista de individuos que son los progenitores
     */
    private static List<Individuo> seleccionarProgenitores(Poblacion pobActual) {
        List<Individuo> progenitores = new ArrayList();

        int pos1, pos2, pos3, pos4;

        while (progenitores.size() < TAM_POBLACION * (1.0 - (ELITISMO / 100.0))) { // Relleno progenitores dejando hueco para las soluciones élite
            // Escojo 4 números aleatorios
            pos1 = (int) (Math.random() * (TAM_POBLACION - 1));
            pos2 = pos3 = pos4 = pos1;
            while (pos2 == pos1) {
                pos2 = (int) (Math.random() * (TAM_POBLACION - 1));
            }
            while (pos3 == pos1 || pos3 == pos2) {
                pos3 = (int) (Math.random() * (TAM_POBLACION - 1));
            }
            while (pos4 == pos1 || pos4 == pos2 || pos3 == pos4) {
                pos4 = (int) (Math.random() * (TAM_POBLACION - 1));
            }

            // Hago el torneo entre ellos, seleccionando los dos ganadores
            //// Ganador #1
            if (pobActual.getCromosoma(pos1).getFitness() > pobActual.getCromosoma(pos2).getFitness()) {
                progenitores.add(pobActual.getCromosoma(pos1));
            } else {
                progenitores.add(pobActual.getCromosoma(pos2));
            }
            //// Ganador #2
            if (pobActual.getCromosoma(pos3).getFitness() > pobActual.getCromosoma(pos4).getFitness()) {
                progenitores.add(pobActual.getCromosoma(pos3));
            } else {
                progenitores.add(pobActual.getCromosoma(pos4));
            }
        }
        //System.out.println("Progenitores: "+progenitores.toString());
        return progenitores;
    }

    /**
     * Metodo que me junta a los progenitores para crear descendientes
     *
     * @param progenitores Los padres que van ha tener descendencia
     * @return Me devuelve una lista de individuos que seran los descendientes
     */
    private static List<Individuo> cruzarProgenitores(List<Individuo> progenitores) {
        List<Individuo> descendientes = new ArrayList();

        for (int i = 0; i < progenitores.size(); i = i + 2) { // i=i+2 porque se van cogiendo progenitores de 2 en 2
            //crucePuntoCorte(progenitores.get(i), progenitores.get(i + 1), descendientes); // En concreto, el progenitor i y el i+1
            cruceUniforme(progenitores.get(i), progenitores.get(i + 1), descendientes); // En concreto, el progenitor i y el i+1
        }
        //System.out.println("Descendientes: " + descendientes.toString());
        return descendientes;
    }

    //Método para hacer un cruce bit a bit. Invocar a este método en vez de cruceUniforme si se quiere 
    //probar diferentes formas de hacer los cruces
    /**
     * Metodo que me hace el cruce entre los porgenitores para que me den descendientes
     *
     * @param progenitor1 Padres o madre
     * @param progenitor2 Padre o madre
     * @param descendientes Hijo o hija
     */
    private static void crucePuntoCorte(Individuo progenitor1, Individuo progenitor2, List<Individuo> descendientes) {
        // Selecciono aleatoriamente un bit de cada progenitor para cada descendiente 
        Individuo descendiente1 = new Individuo();
        Individuo descendiente2 = new Individuo();
        int puntoCorte;

        //puntoCorte = (int) (Math.random() * (progenitor1.genotipo.length)); // Punto de corte dinámico
        puntoCorte = (int)progenitor1.genotipo.length/2; // Punto de corte estático para todos

        for (int i = 0; i < puntoCorte; i++) { // Copio medio progenitor en cada descendiente
            descendiente1.genotipo[i] = progenitor1.genotipo[i];
            descendiente2.genotipo[i] = progenitor2.genotipo[i];
        }

        for (int i = puntoCorte; i < progenitor1.genotipo.length; i++) { // Y ahora el medio restante
            descendiente1.genotipo[i] = progenitor2.genotipo[i];
            descendiente2.genotipo[i] = progenitor1.genotipo[i];
        }
        // Calculo el fitness de los nuevos descendientes
        descendiente1.setFitness(descendiente1.calcularFitness());
        descendiente2.setFitness(descendiente2.calcularFitness());

        //descendiente1.setFitness(calcularFitness(descendiente1.getGenotipo()));
        // Los añado a la lista de descendientes
        descendientes.add(descendiente1);
        descendientes.add(descendiente2);
    }

    /**
     *
     * Método para hacer un cruce uniforme. 
     * Invocar a este método en vez de crucePuntoCorte si se quiere probar diferentes formas de hacer los cruces
     *
     * @param progenitor1 Padres o madre
     * @param progenitor2 Padre o madre
     * @param descendientes Hijo o hija
     */
    private static void cruceUniforme(Individuo progenitor1, Individuo progenitor2, List<Individuo> descendientes) {
        // Selecciono aleatoriamente un bit de cada progenitor para cada descendiente 
        Individuo descendiente1 = new Individuo();
        Individuo descendiente2 = new Individuo();
        boolean b;

        for (int i = 0; i < progenitor1.genotipo.length; i++) {
            b = Math.random() >= 0.5;
            if (b) {
                descendiente1.genotipo[i] = progenitor1.genotipo[i];
                descendiente2.genotipo[i] = progenitor2.genotipo[i];
            } else {
                descendiente1.genotipo[i] = progenitor2.genotipo[i];
                descendiente2.genotipo[i] = progenitor1.genotipo[i];

            }
        }
        descendiente1.fitness = descendiente1.calcularFitness();
        descendiente2.fitness = descendiente2.calcularFitness();

        descendientes.add(descendiente1);
        descendientes.add(descendiente2);
    }

    /**
     * Este metodo me cambia a los descendientes porque puedes salir mutados al juntarse los progenitores
     * @param descendientes Lista de descendientes
     * @return Lista de descendientes con algunos mutados
     */
    private static List<Individuo> mutarDescendientes(List<Individuo> descendientes) throws CloneNotSupportedException {
        List<Individuo> descendientesMutados = new ArrayList();
        int i;
        boolean mutar;
        int gen;
        Individuo mutado;

        for (i = 0; i < descendientes.size(); i++) {
            mutado = descendientes.get(i).clone();
            mutar = (Math.random() <= P_MUTACION);      //Aplico la probabilidad de mutación
            if (mutar) { // Si se cumple, selecciono aleatoriamente un bit (gen) para mutar
                gen = (int) (Math.random() * (Individuo.GENES));
                mutado.genotipo[gen] = !mutado.genotipo[gen];
                mutado.setFitness(mutado.calcularFitness());
            }
            //Añado el descendiente mutado (o sin mutar) a la lista de descendientes mutados
            descendientesMutados.add(mutado);
        }

        //System.out.println("Descendientes mutados: " + descendientesMutados.toString());
        return descendientesMutados;
    }

    /**
     * Nueva poblacion generada con los descendientes formados de los progenitores de la poblacion anterior
     * @param pobActual Poblacion actual
     * @param descendientes Descendientes que parten de la Poblacion actual
     * @return Nueva poblacion generada
     */
    private static Poblacion nuevaPoblacion(Poblacion pobActual, List<Individuo> descendientes) {
        Poblacion pobSiguiente = new Poblacion(descendientes);  // Vuelco los descendientes mutados ya generados
        int j = (int) (TAM_POBLACION * ELITISMO / 100.0);       // Determino cuántos individuos élite envío a la siguiente generación

        for (int i = 0; i < j && pobSiguiente.poblacion.size() < TAM_POBLACION; i++) {
            pobSiguiente.poblacion.add(pobActual.poblacion.get(i));     // Y los añado
        }
        // Dejamos ordenado para la siguiente iteración (para coger las soluciones élite fácilmente)
        pobSiguiente.ordenarPoblacion();

        return pobSiguiente;
    }
}

