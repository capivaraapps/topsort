
package topologicalsort;

public class TopologicalSort {

    public static void main(String[] args) {
        // Cria um grafo e adicionamos as arestas
        Grafo g = new Grafo(6); 
        g.addAresta(5, 2); 
        g.addAresta(5, 0); 
        g.addAresta(4, 0); 
        g.addAresta(4, 1); 
        g.addAresta(2, 3); 
        g.addAresta(3, 1); 
        System.out.println("Grafo ordenado topologicamente pelo algoritmo de Kahn:"); 
        g.topologicalSort(); 
        
        System.out.println("\n\n\n");
        
        // Cria um grafo e adiciona as arestas com seus pesos
        GrafoComplexo gc = new GrafoComplexo(6); 
        gc.addAresta(0, 1, 5); 
        gc.addAresta(0, 2, 3); 
        gc.addAresta(1, 3, 6); 
        gc.addAresta(1, 2, 2); 
        gc.addAresta(2, 4, 4); 
        gc.addAresta(2, 5, 2); 
        gc.addAresta(2, 3, 7); 
        gc.addAresta(3, 4, -1); 
        gc.addAresta(4, 5, -2); 
  
        int s = 1; 
        System.out.println("Caminho mais curto desde a origem " + s ); 
        gc.shortestPath(s); 
    }
    
}
