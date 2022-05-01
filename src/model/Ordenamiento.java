package model;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Ordenamiento {
    
        
    
    private static int contador = 0;

    //Ordena segun fecha de registro
    public static void quicksortFecha(ArrayList<Trabajador> a, int izq, int der) {
        contador++;
        System.out.println(contador +" en fecha");

        //Para colocar el elemento en su lugar
        Trabajador pivote, aux;
        int i = izq, j = der;
        pivote = a.get(izq);

        while (i < j) {
            while ((a.get(i).getFechaRegistro().isBefore(pivote.getFechaRegistro()) || a.get(i).getFechaRegistro().isEqual(pivote.getFechaRegistro())) && i < j) {
                i++;
            }
            while (a.get(j).getFechaRegistro().isAfter(pivote.getFechaRegistro())) {
                j--;
            }
            if (i < j) {
                aux = a.get(i);
                a.set(i, a.get(j));
                a.set(j, aux);
            }
        }
        //Coloca el elemento donde se debe encontrar
        a.set(izq, a.get(j));
        a.set(j, pivote);

        //Recursion, divide los arreglos
        if (izq < j - 1) {
            quicksortFecha(a, izq, j - 1);
        }
        if (der > j + 1) {
            quicksortFecha(a, j + 1, der);
        }
    }

    //Ordenar por nombre
    public static void quicksortNombre(ArrayList<Trabajador> a, int izq, int der) {
contador++;System.out.println(contador+" en nombre");
        //Para colocar el elemento en su lugar
        Trabajador pivote, aux;
        int i = izq, j = der;
        pivote = a.get(izq);

        while (i < j) {
            while (a.get(i).getNombre().compareToIgnoreCase(pivote.getNombre()) <= 0 && i < j) {
                i++;
            }
            while (a.get(j).getNombre().compareToIgnoreCase(pivote.getNombre()) > 0) {
                j--;
            }
            if (i < j) {
                aux = a.get(i);
                a.set(i, a.get(j));
                a.set(j, aux);
            }
        }
        //Coloca el elemento donde se debe encontrar
        a.set(izq, a.get(j));
        a.set(j, pivote);

        //Recursion, divide los arreglos
        if (izq < j - 1) {
            quicksortNombre(a, izq, j - 1);
        }
        if (der > j + 1) {
            quicksortNombre(a, j + 1, der);
        }
    }

    //Ordenar por apellido
    public static void quicksortApellido(ArrayList<Trabajador> a, int izq, int der) {
contador++;System.out.println(contador+" en apellido");
        //Para colocar el elemento en su lugar
        Trabajador pivote, aux;
        int i = izq, j = der;
        pivote = a.get(izq);

        while (i < j) {
            while (a.get(i).getApellido().compareToIgnoreCase(pivote.getApellido()) <= 0 && i < j) {
                i++;
            }
            while (a.get(j).getApellido().compareToIgnoreCase(pivote.getApellido()) > 0) {
                j--;
            }
            if (i < j) {
                aux = a.get(i);
                a.set(i, a.get(j));
                a.set(j, aux);
            }
        }
        //Coloca el elemento donde se debe encontrar
        a.set(izq, a.get(j));
        a.set(j, pivote);

        //Recursion, divide los arreglos
        if (izq < j - 1) {
            quicksortApellido(a, izq, j - 1);
        }
        if (der > j + 1) {
            quicksortApellido(a, j + 1, der);
        }
    }

    //Ordenar por salario
    public static void quicksortSalario(ArrayList<Trabajador> a, int izq, int der) {
contador++;System.out.println(contador+" en salario");
        //Para colocar el elemento en su lugar
        Trabajador pivote, aux;
        int i = izq, j = der;
        pivote = a.get(izq);

        while (i < j) {
            while (a.get(i).getSalario() <= pivote.getSalario() && i < j) {
                i++;
            }
            while (a.get(j).getSalario() > pivote.getSalario()) {
                j--;
            }
            if (i < j) {
                aux = a.get(i);
                a.set(i, a.get(j));
                a.set(j, aux);
            }
        }
        //Coloca el elemento donde se debe encontrar
        a.set(izq, a.get(j));
        a.set(j, pivote);

        //Recursion, divide los arreglos
        if (izq < j - 1) {
            quicksortSalario(a, izq, j - 1);
        }
        if (der > j + 1) {
            quicksortSalario(a, j + 1, der);
        }
    }
    
    //Ordenar por retardos
    public static void quicksortRetardos(ArrayList<Trabajador> a, int izq, int der) {
contador++;System.out.println(contador+" en reatrdos");
        //Para colocar el elemento en su lugar
        Trabajador pivote, aux;
        int i = izq, j = der;
        pivote = a.get(izq);

        while (i < j) {
            while (a.get(i).getRetardos() <= pivote.getRetardos() && i < j) {
                i++;
            }
            while (a.get(j).getRetardos() > pivote.getRetardos()) {
                j--;
            }
            if (i < j) {
                aux = a.get(i);
                a.set(i, a.get(j));
                a.set(j, aux);
            }
        }
        //Coloca el elemento donde se debe encontrar
        a.set(izq, a.get(j));
        a.set(j, pivote);

        //Recursion, divide los arreglos
        if (izq < j - 1) {
            quicksortRetardos(a, izq, j - 1);
        }
        if (der > j + 1) {
            quicksortRetardos(a, j + 1, der);
        }
    }
    
    //Ordenar por faltas
    public static void quicksortFaltas(ArrayList<Trabajador> a, int izq, int der) {
contador++;System.out.println(contador+" en faltas");
        //Para colocar el elemento en su lugar
        Trabajador pivote, aux;
        int i = izq, j = der;
        pivote = a.get(izq);

        while (i < j) {
            while (a.get(i).getFaltas() <= pivote.getFaltas() && i < j) {
                i++;
            }
            while (a.get(j).getFaltas() > pivote.getFaltas()) {
                j--;
            }
            if (i < j) {
                aux = a.get(i);
                a.set(i, a.get(j));
                a.set(j, aux);
            }
        }
        //Coloca el elemento donde se debe encontrar
        a.set(izq, a.get(j));
        a.set(j, pivote);

        //Recursion, divide los arreglos
        if (izq < j - 1) {
            quicksortFaltas(a, izq, j - 1);
        }
        if (der > j + 1) {
            quicksortFaltas(a, j + 1, der);
        }
    }
}
