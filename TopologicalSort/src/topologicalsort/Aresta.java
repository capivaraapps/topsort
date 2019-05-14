
package topologicalsort;

public class Aresta {
    
    private int vertice; 
    private int peso; 
    
    Aresta(int vertice, int peso){
        this.vertice = vertice;
        this.peso = peso;
    }
    
    public int getVertice(){
        return vertice;
    } 
    public int getPeso(){
        return peso;
    }
}
