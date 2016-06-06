import java.io.*;
import java.util.*;

public class Solution {

    private static HashMap<Character, Pos> char2pos;
    private static int [] [] [] best = new int[52][52][1001];

    static {
        char2pos =  new HashMap<>();
        char2pos.put('D', new Pos(1,0));
        char2pos.put('U', new Pos(-1,0));
        char2pos.put('L', new Pos(0,-1));
        char2pos.put('R', new Pos(0,1));
    }

    private static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Pos(Pos p) {
            this(p.x, p.y);
        }
        int dist(Pos p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
        Pos add(Pos p) {
            return new Pos(this.x + p.x, this.y + p.y);
        }
        @Override
        public String toString() {
            return String.format("(%d,%d)", x, y);
        }
    }

    private static class PosInfo extends Pos {
        int c, k;
        PosInfo(Pos p, int c, int k) {
            super(p);
            this.c = c;
            this.k = k;
        }

        @Override
        public boolean equals(Object ob) {
            if(!(ob instanceof PosInfo)) return false;
            PosInfo that = (PosInfo) ob;

            return that.x == this.x && that.y == this.y &&
                    that.c == this.c && that.k == this.k;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)|c:%d,k:%d", x, y, c, k);
        }
    }

    private static void numChanges(PosInfo p, String [] board) {
        if(p.x >= board.length || p.x < 0) return;
        if(p.y >= board[0].length() || p.y < 0) return;
        if(p.k < 0) return;

        if(p.c < best[p.x][p.y][p.k] || best[p.x][p.y][p.k] == -1) {
            best[p.x][p.y][p.k] = p.c;

            Character ch = board[p.x].charAt(p.y);
            if(ch != '*') {
                for(Map.Entry<Character, Pos> entry: char2pos.entrySet()) {
                    if(ch == entry.getKey())
                        numChanges(new PosInfo(p.add(entry.getValue()), p.c, p.k-1), board);
                    else
                        numChanges(new PosInfo(p.add(entry.getValue()), p.c+1, p.k-1), board);
                }
            } else {
                numChanges(new PosInfo(p, p.c, p.k-1), board);
            }
        }
    }

    public static void main(String[] args) {
        try (
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String [] line = bf.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int k = Integer.parseInt(line[2]);

            String [] board = new String [n];
            Pos exit = new Pos(0,0); // to make the compiler happy
            for(int i = 0; i<n; i++) {
                board[i] = bf.readLine();
                for(int j = 0; j<m; j++)
                    if(board[i].charAt(j) == '*') {
                        exit = new Pos(i, j);
                        break;
                    }
            }

            for(int i = 0; i< 52; i++)
                for(int j = 0; j<52; j++)
                    for(int step = 0; step<1001; step++)
                        best[i][j][step] = -1;

            Pos start = new Pos(0,0);

            numChanges(new PosInfo(start, 0, k), board);

            System.out.println(best[exit.x][exit.y][0]);

        } catch(IOException e) {}
    }
}
