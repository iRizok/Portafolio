package pruebas;


/**
 *
 * @author Alebuntu
 */
import java.util.Arrays;
import java.util.Random;

public class Individuo implements Comparable<Individuo> {

    /**
     * Nuevos elementos de la solucion
     */
    public static final int GENES = 10;

    /**
     * Es un solucion o persona o como lo quieras llamar
     */
    public boolean[] genotipo;

    /**
     * Lo mismo que el coste
     */
    public int fitness;

    /**
     * Para obtener numeros aleatorios
     */
    static Random rand = new Random();

    public Individuo() {
        genotipo = new boolean[GENES];
        fitness = -1;
    }

    /**
     * Para crear un individuo aleatorio o como lo quieras llamar
     */
    public void generarCromosomaAleatorio() {

        for (int i = 0; i < genotipo.length; i++) {
            genotipo[i] = 0.5 > rand.nextFloat();
        }
        fitness = calcularFitness();
    }

    /**
     * Metodo que me devuelve el genotipo de un individuo
     *
     * @return Me devuelve un genotipo
     */
    public boolean[] getGenotipo() {
        return genotipo;
    }

    /**
     * Metodo que asigna a un individuo un genotipo
     *
     * @param genotipo Genotipo que vamos a asignarle al individuo
     */
    public void setGenotipo(boolean[] genotipo) {
        this.genotipo = genotipo;
    }

    /**
     * Metodo que nos devuelve el coste del individuo
     *
     * @return Me devuelve lo que vale el coste del individuo
     */
    public int getFitness() {
        return fitness;
    }

    /**
     * Metodo que nos modifica el fitness de un individuo
     *
     * @param fitness Coste del individuo
     */
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    /**
     * Metodo que nos calcula el coste del individuo
     *
     * @return Nos devuelve el coste del individuo
     */
    public int calcularFitness() {
        //Formula del calculo de coste
        int coste = 0;
        int x = binaryToDecimal(genotipo);
        coste += Math.pow(x, 3);
        coste -= 60 * Math.pow(x, 2);
        coste += 900 * x;
        coste += 100;
        return coste;
    }

    /**
     * Metodo para convertir el vector binario en un entero
     *
     * @param sol Solucion que vamos a pasar a decimal
     * @return Nos devuelve un numero decimal a partir de la solucion
     */
    private static int binaryToDecimal(boolean[] sol) {

        int n = 0;
        for (int i = 0; i < sol.length; i++) {
            if (sol[i] != false) {
                n += Math.pow(2, i);
            }
        }
        return n;
    }

    /**
     * Metodo para que la poblacion salga ordenada de mayor a menor
     *
     * @param o Individuo con el que lo vamos a comparar
     * @return Nos devuelve un numero para hacer referencia a si el individuo es menor , mayor o igual
     */
    public int compareTo(Individuo o) {
        double f1 = this.fitness; //calcularFitness();
        double f2 = o.fitness;//calcularFitness();

        if (f1 < f2) {
            return 1;
        } else if (f1 > f2) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Metodo que construye una cadena con los datos del individuo
     *
     * @return Me devuelve en forma de cadena los datos del individuo
     */
    public String toString() {
        return "Genotipo = " + printGenotipo() + ", fitness = " + fitness + "\n";
    }

    /**
     * Metodo que nos fabrica una cadena que tendra los datos del genotipo
     *
     * @return Nos devuelve el genotipo en forma de cadena
     */
    private String printGenotipo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < genotipo.length; i++) {
            sb.append(genotipo[i] == true ? 1 : 0);
        }
        return sb.toString();
    }

    /**
     * Nos clona un individuo
     *
     * @return Nos devuelve la copia del individuo
     */
    public Individuo clone() throws CloneNotSupportedException {
        Individuo copia = new Individuo();
        copia.fitness = this.fitness;
        copia.genotipo = Arrays.copyOf(this.genotipo, GENES);

        return copia;
    }

}

