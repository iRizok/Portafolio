package pruebas;


import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        // TODO code application logic here
        
        
        AlgGen ag = new AlgGen();
        Poblacion p = ag.metodo_AG();     
        System.out.println("Poblacion final: \n"+p.toString());
        List<Individuo> l = p.getPoblacion();
        System.out.println("Mejor solucion\n");
        System.out.println(l.get(0));

    }

}
