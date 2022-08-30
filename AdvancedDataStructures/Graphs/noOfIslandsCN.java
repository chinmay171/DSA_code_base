import java.util.*;
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

public class noOfIslandsCN {
    static int[][] dir = {{+1, 0},{-1, 0},{0, +1},{0, -1}};
    public static int[] numOfIslandsII(int row, int col, int[][] queries) {
        DSU set = new DSU(row * col +1);
        
        int[] ans = new int[queries.length];
        boolean[] vis = new boolean[row * col + 1];
        int islands = 0;
         
        for(int i = 0; i < queries.length; ++i){
            int r = queries[i][0];
            int c = queries[i][1];
            int idx = r * col + c;
            
            if(vis[idx] == true){
                ans[i] = islands;
                continue;
            }
            vis[idx] = true;
            islands++;
            
            for(int j = 0; j < 4; ++j){
                int nr = r + dir[j][0];
                int nc = c + dir[j][1];
                int nidx = nr * col + nc;
                
                if(nr < 0 || nc < 0 || nr >= row || nc >= col || vis[nidx] == false){
                    continue;
                }
                if(set.find(idx) == set.find(nidx)){
                    continue;
                }
                set.union(idx, nidx);
                islands--;
            }
            ans[i] = islands;
        }
        return ans;
    }
}