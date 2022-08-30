import java.util.*;

// class Pair{
//     int dest;
//     int weight;
    
//     Pair(int dest){
//         this.dest = dest;
//         this.weight = 1;
//     }
    
//     Pair(int dest, int weight){
//         this.dest = dest;
//         this.weight = weight;
//     }
// }

// class Graph{
//     ArrayList<Pair>[] adj;
    
//     Graph(int n){
//         adj = new ArrayList[n];
//         for(int i = 0; i<n; ++i){
//             adj[i] = new ArrayList<>();
//         }
//     }
    
//     //unweighted graph
//     public void addEdge(int src, int dest, boolean isDirected){
//         adj[src].add(new Pair(dest));
//         if(isDirected == false)
//             adj[dest].add(new Pair(src));
//     }
    
//     //weighted graph
//     public void addEdge(int src, int dest, int weight, boolean isDirected){
//         adj[src].add(new Pair(dest, weight));
//         if(isDirected == false)
//             adj[dest].add(new Pair(src, weight));
//     }
    
//     public void printAdjList(){
//         for(int i = 0 ; i < adj.length; ++i){
//             for(int j = 0; j < adj[i].size(); ++j){
//                 System.out.println(i + " -> " + 
//                                   adj[i].get(j).dest + " " + adj[i].get(j).weight);
//             }
//         }
//     }
    
//     public boolean dfs(int source, int destination, boolean[] vis){
//         if(source == destination)return true;
//         if(vis[source] == true)return false;
//         vis[source] = true;
//         for(int nbr : adj[source]){
//             if(dfs(nbr, destination, vis) == true)return true;
//         }
//         return false;
//     }
    
//     public boolean bfs(int src, int dest){
//         Queue<Integer> q = new ArrayDeque<>();
//         boolean[] vis = new boolean[adj.length];
        
//         q.add(src);
//         while(q.size() > 0){
//             int front = q.remove();
//             if(vis[front] == true)continue;
//             if(front == dest) return true;
//             vis[front] = true;
            
//             for(Integer nbr : adj[front]){
//                 if(vis[nbr] == false){
//                     q.add(nbr);
//                 }
//             }
//         }
//         return false;
//     }
// }

class DSU{
    int[] parent;
    int[] rank;
    
    DSU(int n){
        parent = new int[n];
        Arrays.fill(parent, -1);
        rank = new int[n];
    }
    
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb){
            return;
        }
        
        if(rank[pa] > rank[pb]){
            parent[pb] = pa;
            rank[pa] += rank[pb];
        }else{
            parent[pa] = pb;
            rank[pb] += rank[pa];
        }
    }
    
    public int find(int a){
        if(parent[a] == -1){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}

public class graphClass{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
//         int vtces = sc.nextInt();
//         Graph g = new Graph(vtces);
        
//         int edges = sc.nextInt();
//         for(int i = 0 ; i < edges; ++i){
//             int src = sc.nextInt();
//             int dest = sc.nextInt();
//             int weight = sc.nextInt();
            
//             g.addEdge(src, dest, weight, false);
//         }
//         g.printAdjList();
        
        //DSU
        
        int n = sc.nextInt();
        DSU set = new DSU(n+1);
        
        int e = sc.nextInt();
        while(e-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            set.union(a, b);
        }
        
        int components = 0;
        for(int i = 0; i <= n; ++i){
            if(set.find(i) == i){
                components++;
            }
        }
        System.out.println(components);
        
    }
}
