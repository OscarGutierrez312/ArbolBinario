
package creararbol;

import java.util.HashSet;
import java.util.Set;

public class Arbol extends Nodo{
    public Arbol raiz;
    
    public Arbol(){
        super();
    }
    public Arbol CrearArbol(int [] arr){
        raiz=new Arbol();
        raiz.setValor(arr[0]);
        Nodo n;
        for(int i=1;i<arr.length;i++){
            n=new Nodo();
            n.setValor(arr[i]);
            raiz.AgregarNodo(n.getNodo());
        }
        return raiz;
    }
}
