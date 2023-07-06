package pruebas;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poblacion {

    /**
     * Poblacion es una lista de individuos
     */
    List<Individuo> poblacion;

    /**
     * Declaración de poblacion como una lista de individuos.
     */
    public Poblacion() {
        this.poblacion = new ArrayList();
    }

    /**
     * Contructor con una lista de individuos como parametro
     *
     * @param poblacion Poblacion
     */
    public Poblacion(List<Individuo> poblacion) {
        this.poblacion = new ArrayList();

        for (int i = 0; i < poblacion.size(); i++) {
            this.poblacion.add(poblacion.get(i));
        }
    }

    /**
     * Para obtener la poblacion de la clase poblacion
     *
     * @return Me devuelve una poblacion
     */
    public List<Individuo> getPoblacion() {
        return poblacion;
    }

    /**
     * Metodo que me establece una poblacion
     * @param poblacion Poblacion que queremos establecer
     */
    public void setPoblacion(List<Individuo> poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Metodo que basicamente me ordena una poblacion, basandonos en el compareTo de individuo
     */
    public void ordenarPoblacion() {
        Collections.sort(poblacion);
    }

    /**
     * Metodo que me devuelve un individuo de una poblacion por su indice
     *
     * @param index Indice para indicar el individuo que queremos mostrar de la poblacion
     * @return Me devuelve el individuo de una poblacion
     */
    public Individuo getCromosoma(int index) {
        return poblacion.get(index);
    }

    /**
     * Metodo que me forma una cadena con los datos de una poblacion
     *
     * @return Me devuelve una cadena los datos de una poblacion
     */
    public String toString() {
        String sPoblacion = "";
        for (int i = 0; i < poblacion.size(); i++) {
            sPoblacion += poblacion.get(i).toString();
        }

        return sPoblacion;
    }
}
