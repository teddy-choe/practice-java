package Algorithm;

import java.util.Scanner;

//그래프 클래스
class DfsGraph {
    private int nV;
    private int[][] dfsGraph;
    private boolean[] visitArr;

    public DfsGraph(int nV){
        this.nV = nV;
        this.dfsGraph = new int[this.nV+1][this.nV+1];
        this.visitArr = new boolean[this.nV+1];
    }

    public int[][] getGraph() {
        return this.dfsGraph;
    }

    //양방향 그래프 추가
    public void put(int x, int y) {
        this.dfsGraph[x][y] = this.dfsGraph[y][x] = 1;
    }

    //단방향 그래프 추가
    public void putSingle(int x, int y) {
        this.dfsGraph[x][y] = 1;
    }

    //그래프 출력
    public void printGraghToAdjArr() {
        for (int i=1; i<this.dfsGraph.length; i++) {
            for (int j=1; j<this.dfsGraph[i].length; j++) {
                System.out.print(" " + this.dfsGraph[i][j]);
            }
            System.out.println();
        }
    }
    public void clearVisitArr() {
        for (int i=0; i<this.visitArr.length; i++) {
            this.visitArr[i] = false;
        }
    }

    //vIdx는 방문한 정점임
    public void dfs(int vIdx) {
        this.visitArr[vIdx] = true;
        System.out.print(vIdx + " ");

        for (int i=1; i<=this.nV; i++){
            if (dfsGraph[vIdx][i] == 1 && visitArr[i] == false) {
                dfs(i);
            }
        }
    }
}

class DFSAdjArr {
    public static void main(String[] args) {
        int nV = 0;
        int nE = 0;

        Scanner sc = new Scanner(System.in);
        nV = sc.nextInt();
        nE = sc.nextInt();

        DfsGraph dfsGraph = new DfsGraph(nV);

        //nV 5, nE 4
        dfsGraph.put(1, 2);
        dfsGraph.put(1, 3);
        dfsGraph.put(2, 4);
        dfsGraph.put(2, 5);

        sc.close();

        dfsGraph.printGraghToAdjArr();

        System.out.println();
        System.out.print("정점 1부터 탐색 : ");
        dfsGraph.dfs(1);
    }
}

