package recorridoarboles;

import java.util.Scanner;
import creararbol.*;
import java.util.ArrayList;

/**
 * @author  Oscar Camilo Gutierrez Villarraga
 *          Ciencias de la Computación 3
 *          Estudiante Ingeniería de Sistemas
 *          Universidad Distrital Francisco José de Caldas
 */
public class RecorridoArboles {
     
    public static void main(String[] args) {
        Arbol a=new Arbol();
        RecorridoArboles r=new RecorridoArboles();
        a=a.CrearArbol(r.PrepararArbol(r.OrdenarArreglo(r.CrearArreglo())));
        System.out.println("Recorrido en Pre-Orden: ");r.PreOrden(a);System.out.print("\n");
        System.out.println("Recorrido en In-Orden: ");r.InOrden(a);System.out.print("\n");
        System.out.println("Recorrido en Post-Orden: ");r.PostOrden(a);System.out.print("\n");
    }
    
    public int[] CrearArreglo(){
       Scanner datos=new Scanner(System.in);
       System.out.print("Ingrese cadena de enteros separados por coma: "); 
       String cadena=datos.nextLine();
       String[]aux=cadena.split(",");
       int len=aux.length;
       int []arr=new int[len];
       for (int i=0;i<len;i++){
           arr[i]=Integer.parseInt(aux[i]);
       }
       return arr;
    }
    public int[] OrdenarArreglo(int []arr){
       int aux;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    aux = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
        return arr;
    }
    public int[] PrepararArbol(int []arr){
        ArrayList<int[]> a=new ArrayList<int[]>();
        int centro,len;
        int []aux, aux2;
        a.add(arr);
        for (int i=0;i<a.size();i++){
            if(a.get(i).length!=1){
                len=a.get(i).length;
                centro= len % 2==0 ? ((len)/2)-1 : (len)/2;
                aux=new int[centro];
                for(int j=0;j<aux.length;j++){
                    aux[j]=a.get(i)[j];
                }
                if(aux.length!=0)a.add(aux);
                aux=new int[len-(centro+1)];
                int cont=0;
                for(int j=centro+1;j<len;j++){
                    aux[cont]=a.get(i)[j];
                    cont++;
                }
                if(aux.length!=0)a.add(aux);
                int []c=new int[1];
                c[0]=a.get(i)[centro];
                a.set(i,c);
            }
        }
        int []ar=new int[a.size()];
        for(int i=0;i<a.size();i++){
            ar[i]=a.get(i)[0];
        } 
        return ar;
    }
    public void PreOrden(Nodo raiz){
        if(raiz==null)return;
        System.out.print(raiz.getValorNodo() + " ");
        PreOrden(raiz.getNodoIzquierdo());
        PreOrden(raiz.getNodoDerecho());
    }
    public void InOrden(Nodo raiz){
        if (raiz == null)return;
        InOrden(raiz.getNodoIzquierdo());
        System.out.print(raiz.getValorNodo() + " ");
        InOrden(raiz.getNodoDerecho());
    }
    public void PostOrden(Nodo raiz){
        if (raiz==null)return;
        PostOrden(raiz.getNodoIzquierdo());
        PostOrden(raiz.getNodoDerecho());
        System.out.print(raiz.getValorNodo() + " ");
    }
}
