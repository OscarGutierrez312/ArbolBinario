
package creararbol;

public class Nodo {
    private int valor;
    private Nodo derecho;
    private Nodo izquierdo;
    
    
    public void setValor(int v){
        valor=v;
    }
    public void setNodoIzquierdo(Nodo izq){
        izquierdo=izq;
    }
    public void setNodoDerecho(Nodo der){
        derecho=der;
    }
    public Nodo getNodoIzquierdo(){
        return izquierdo;
    }
    public Nodo getNodoDerecho(){
        return derecho;
    }
    public int getValorNodo(){
        return valor;
    }
    public Nodo getNodo(){
        return this;
    }
    public void AgregarNodo(Nodo n){
        if(n.valor<this.valor){
            if(izquierdo!=null){
                izquierdo.AgregarNodo(n);
            }else{
                this.setNodoIzquierdo(n);
            }
        }else{
            if(derecho!=null){
                derecho.AgregarNodo(n);
            }else{
                this.setNodoDerecho(n);
            }
        }
    }
}
