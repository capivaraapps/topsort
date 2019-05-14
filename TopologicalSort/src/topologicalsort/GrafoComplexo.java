
package topologicalsort;
        
    import java.io.*; 
    import java.util.*; 
        
public class GrafoComplexo {
    
    static final int ORIGEM = Integer.MAX_VALUE; 
    
    private int numVertices; 
    private LinkedList<Aresta>arestas[]; 
    
    GrafoComplexo(int numVertices){ 
        this.numVertices = numVertices; 
        arestas = new LinkedList[numVertices];
        for (int i=0; i<numVertices; ++i) 
            arestas[i] = new LinkedList<Aresta>(); 
    } 
    
    void addAresta(int vOrigem, int vDestino, int peso){ 
        Aresta aresta = new Aresta(vDestino, peso); 
        arestas[vOrigem].add(aresta); // Adicionamos a aresta origem->destino à lista do vertice origem
    } 

    // Neste caso usamos uma função recursiva para obtener a ordenação topologica
    void topologicalSort(int vertice, Boolean visitados[], Stack pilha){ 
        // Marcamos o vertice recebido como visitado 
        visitados[vertice] = true;
        
        // Percorremos todos os vertices "filhos" do vertice atual
        Iterator<Aresta> it = arestas[vertice].iterator(); 
        while (it.hasNext()){ 
            Aresta aresta =it.next(); 
            if (!visitados[aresta.getVertice()]) 
                // Chyamamos a função de forma recursiva no caso achemos um vertice "filho" sem visitar
                topologicalSort(aresta.getVertice(), visitados, pilha); 
        } 
        // Adicionamos o vertice atual à pilha resultado
        pilha.push(vertice); 
    } 

    // A função para achar o caminho mais curto desde um vertice dado usa a função recursiva de
    // ordenação topologica para obtener o grafo ordenado
    void shortestPath(int s){ 
        Stack stack = new Stack(); 
        int resultado[] = new int[numVertices]; 

        // Marcamos todos os vertices como não visitados
        Boolean visitados[] = new Boolean[numVertices]; 
        for (int i = 0; i < numVertices; i++) 
            visitados[i] = false; 

        // Chamamos a função de ordenação começando por cada um dos vertices não visitados
        for (int i = 0; i < numVertices; i++) 
            if (visitados[i] == false) 
                topologicalSort(i, visitados, stack); 

        // Inicializamos o caminho mais curto desde o vertice imaginario ORIGEM 
        // e indicamos que tem uma distancia (ou peso) até s(vertice origem) igual a 0
        for (int i = 0; i < numVertices; i++) 
            resultado[i] = ORIGEM; 
        resultado[s] = 0; 

        // Obtemos os vertices já ordenados topologicamente
        while (stack.empty() == false){ 
            // Obtemos o proximo vertice da pilha
            int vOrigem = (int)stack.pop(); 

            // Atualizamos as distancias (ou pesos) de todos os vertices "filhos"
            Iterator<Aresta> it; 
            if (resultado[vOrigem] != ORIGEM){ 
                it = arestas[vOrigem].iterator(); 
                while (it.hasNext()){ 
                    Aresta a= it.next(); 
                    if (resultado[a.getVertice()] > resultado[vOrigem] + a.getPeso()) 
                        resultado[a.getVertice()] = resultado[vOrigem] + a.getPeso(); 
                } 
            } 
        } 

        // Mostramos pela consola todos os vertices ordenados pelo caminho mais curto
        for (int i = 0; i < numVertices; i++){ 
            if (resultado[i] == ORIGEM) 
                System.out.print( "ORIGEM "); 
            else
                System.out.print( resultado[i] + " "); 
        }
    }
}

