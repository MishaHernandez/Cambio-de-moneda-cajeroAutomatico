/*
Devolver el numero de billetes de un retiro en un cajero automatico:
Retiro maximo de 3000.
valor de billetes disponibles: 200, 100, 50, 20, 10.
Priorizar la menor cantidad de billetes.
*/

//Hecho por: Mijail J. Hernandez R.

package aplicacion;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Aplicacion {

    public static void main(String[] args) {
        Aplicacion ap;
        ap=new Aplicacion();

        ap.vuelto(); //llamamos al metodo principal
    }

    public void vuelto(){
        int[] Billetes={200, 100, 50, 20, 10}; //billetes disponibles en el cajero
        ArrayList Solucion = new ArrayList(); //conjunto solucion/ billetes devueltos

        int retiro=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese Monto")); //solicitar el monto a retirar
        int x=0; //billete seleccionado para devolver
        int i=0; //contador
        int acum=0; //acumula los billetes devueltos
        int dif=retiro; //diferencia en cada retiro respecto al monto solicitado

        if(retiro<=3000){ //verificamos el maximo retiro que se puede solicitar (ej. 3000)
            while(acum != retiro){ //mientras los billetes hasta ahora devueltos no cumplan el valor solicitado...
                dif=dif-x; //se acumula la diferencia
                x=seleccionar(Billetes, dif); //eleccion del billete adecuado y guardar -> revisar en linea 48
                acum=acum+x; //guarda el billete elegido
                Solucion.add(x); //agregar al conjunto solucion
                i++;
            }
            for (int j = 0; j<Solucion.size(); j++) { //recorrido e impresion del conjunto solución
                System.out.println(Solucion.get(j));
            }

        }
    }

    int seleccionar(int[] Bill, int dif){ //metodo de eleccion del billete ideal
        int aux=0;

        for (int j = 0; j < Bill.length; j++) { //recorrido de los billetes disponibles
            if(Bill[j]<=dif){ //si es menor que la cantidad por devolver
                aux=Bill[j]; //guardar billete ideal
                break;
            }
        }
        return aux; //-> revisar linea 36
    }

}