import java.io.*;
import java.util.*;

public class Solution {

    private static final int [][] adj = new int [100][100];

    private static class IndxDist implements Comparable<IndxDist> {
        int node;
        int dist;
        IndxDist(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(IndxDist that) {
            return this.node - that.node;
        }
        @Override
        public boolean equals(Object thatO) {
            if(!(thatO instanceof IndxDist)) return false;
            IndxDist that = (IndxDist) thatO;

            return this.node == that.node;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(bf.readLine());
            final PriorityQueue<IndxDist> shortestPaths = new PriorityQueue<>();
            int [] edgeTo = new int [100];
            int [] distanceTo = new int [100];

            while(t-- > 0) {
                for(int [] arr : adj)
                    Arrays.fill(arr, -1);
                Arrays.fill(distanceTo, Integer.MAX_VALUE);
                Arrays.fill(edgeTo, -1);
                shortestPaths.clear();

                int n = Integer.parseInt(bf.readLine());
                String [] line;
                int [][] ladders = new int [n][2];
                int i,j;
                for(i = 0; i<n; i++) {
                    line = bf.readLine().split(" ");
                    ladders[i][0] = Integer.parseInt(line[0])-1;
                    ladders[i][1] = Integer.parseInt(line[1])-1;
                }

                int m = Integer.parseInt(bf.readLine());
                int [][] snakes = new int [m][2];
                for(i = 0; i<m; i++) {
                    line = bf.readLine().split(" ");
                    snakes[i][0] = Integer.parseInt(line[0])-1;
                    snakes[i][1] = Integer.parseInt(line[1])-1;
                }

                int src, sink, dist;
                for(i = 0; i<n; i++) {
                    adj[0][ladders[i][0]] = (int)Math.ceil(ladders[i][0] / 6.0);
                    adj[ladders[i][0]][ladders[i][1]] = 0; // climbing up ladders is dice-free
                    adj[ladders[i][1]][99] = (int)Math.ceil((99 - ladders[i][1]) / 6.0);

                    for(j = 0; j<m; j++) {
                        src = ladders[i][1];
                        sink = snakes[j][0];
                        dist = sink - src;
                        if(dist > 0) // sink > src
                            adj[src][sink] = (int)Math.ceil(dist / 6.0);

                        src = snakes[j][1];
                        sink = ladders[i][0];
                        dist = sink - src;
                        if(dist > 0)
                            adj[src][sink] = (int)Math.ceil(dist / 6.0);

                        adj[snakes[j][0]][snakes[j][1]] = 0; //sliding down snakes is dice-free

                        adj[src][99] = (int)Math.ceil((99 - src) / 6);
                    }
                }

                //is it possible to finish?
                boolean possible = true;
                for(i = 98; i>=92; i--) {
                    possible = true;
                    for (j = 0; j < snakes.length; j++) {
                        if (snakes[j][0] == i) {
                            possible = false;
                            break;
                        }
                    }
                    if(possible) break;
                }

                if(!possible) {
                    System.out.println(-1);
                    continue;
                }

                // shortest paths no negative numbers => dijkstra's from 0 to 99
                shortestPaths.add(new IndxDist(0,0));
                IndxDist current;
                while(!shortestPaths.isEmpty()) {
                    current = shortestPaths.poll();

                    for(i = 0; i<100; i++) {
                        dist = adj[current.node][i];

                        if(dist == -1) continue;

                        if(distanceTo[i] <= current.dist + dist) continue;

                        distanceTo[i] = current.dist + dist;
                        edgeTo[i] = current.node;

                        IndxDist newID = new IndxDist(i,distanceTo[i]);
                        IndxDist curr;
                        Iterator<IndxDist> it;
                        if(shortestPaths.contains(newID)) {
                            it = shortestPaths.iterator();
                            while (it.hasNext()) {
                                curr = it.next();
                                if (curr.node == i) {
                                    it.remove();
                                    break;
                                }
                            }
                        }

                        shortestPaths.add(newID);
                    }

                }

                int diceThrows = distanceTo[99];
                System.out.println(diceThrows);

            }
        } catch(IOException e) {}
    }
}
