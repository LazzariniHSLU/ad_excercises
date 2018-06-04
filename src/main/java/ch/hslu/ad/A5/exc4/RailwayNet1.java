package ch.hslu.ad.A5.exc4;

public class RailwayNet1 {
    private static final String NEWLINE = System.getProperty("line.separator");
    private int numberOfNodes;
    private int numberOfEdges;
    private String[] nodeNames = new String[0];
    private int[][] adjaMx = new int[0][0];

    public RailwayNet1(String[] nodeName) {
        this.numberOfNodes = nodeName.length;
        this.nodeNames = nodeName;
        this.adjaMx = new int[numberOfNodes][numberOfNodes];

        // initialize Matrix
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                adjaMx[i][j] = 0;
            }
        }
    }

    public RailwayNet1() {

    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public boolean addEdge(String from, String to, int weight) {
        int indexFrom = getIndex(from);
        int indexTo = getIndex(to);
        if (indexFrom == -1 || indexTo == -1)
            return false;

        if (indexFrom < adjaMx.length && indexTo < adjaMx.length && (adjaMx[indexFrom][indexTo] == 0 || adjaMx[indexTo][indexFrom] == 0)) {
            this.adjaMx[indexFrom][indexTo] = weight;
            this.adjaMx[indexTo][indexFrom] = weight;
            numberOfEdges++;
        }
        return true;
    }

    public boolean addNode(String nodeName) {
        if (getIndex(nodeName) == -1) {
            int nextIndex = this.nodeNames.length;

            //Add Node
            String[] tmp = new String[this.nodeNames.length + 1];
            System.arraycopy(this.nodeNames, 0, tmp, 0, this.nodeNames.length);
            this.nodeNames = tmp; //tmp will be deleted by GC
            this.nodeNames[nextIndex] = nodeName;
            this.numberOfNodes++;

            //Add line to AdjaMx
            int[][] tmpMx = new int[numberOfNodes + 1][numberOfNodes + 1];
            System.arraycopy(this.adjaMx, 0, tmpMx, 0, adjaMx.length);
            this.adjaMx = tmpMx;
            for (int i = 0; i < adjaMx.length; i++) {
                adjaMx[nextIndex][i] = 0;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removeNode(String nodeName) {
        int index = getIndex(nodeName);
        if (index == -1)
            return false;
        String[] tmpNames = new String[this.nodeNames.length - 1];
        System.arraycopy(this.nodeNames, 0, tmpNames, 0, index);
        System.arraycopy(this.nodeNames, index + 1, tmpNames, index, this.nodeNames.length - (index + 1));
        this.nodeNames = tmpNames;

        int countEdges = 0;
        for (int i = 0; i < adjaMx.length; i++) {
            if (adjaMx[index][i] > 0) {
                countEdges++;
            }
        }
        for (int i = 0; i < adjaMx.length; i++) { //shrink cols
            int[] tmpArray = new int[adjaMx.length - 1];
            System.arraycopy(this.adjaMx[i], 0, tmpArray, 0, index);
            System.arraycopy(this.adjaMx[i], index + 1, tmpArray, index, this.adjaMx[i].length - (index + 1));
            this.adjaMx[i] = tmpArray;
        }
        int[][] tmpMx = new int[numberOfNodes - 1][numberOfNodes - 1];
        System.arraycopy(this.adjaMx, 0, tmpMx, 0, index);
        System.arraycopy(this.adjaMx, index + 1, tmpMx, index, this.adjaMx.length - (index + 1));
        this.adjaMx = tmpMx;
        this.numberOfNodes--;
        this.numberOfEdges -= countEdges;
        return true;

    }

    public boolean removeEdge(String from, String to) {
        int indexFrom = getIndex(from);
        int indexTo = getIndex(to);
        if (indexFrom == -1 || indexTo == -1)
            return false;
        adjaMx[indexFrom][indexTo] = 0;
        adjaMx[indexTo][indexTo] = 0;
        this.numberOfEdges--;
        return true;
    }

    public boolean isDirect(String from, String to) {
        int indexFrom = getIndex(from);
        int indexTo = getIndex(to);
        if (indexFrom == -1 || indexTo == -1)
            return false;

        return adjaMx[indexFrom][indexTo] != 0;
    }

    public int getWeight(String from, String to) {
        int indexFrom = getIndex(from);
        int indexTo = getIndex(to);
        if (indexFrom == -1 || indexTo == -1) {
            return 0;
        }
        return adjaMx[indexFrom][indexTo];
    }


    private int getIndex(String nodeName) {
        for (int i = 0; i < this.numberOfNodes; i++) {
            if (this.nodeNames[i] == nodeName) {
                return i;
            }
        }
        return -1; //not found
    }

    // string representation of Graph - O(n^2)
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int v = 0; v < numberOfNodes; v++) {
            s.append(v + ": ");
            for (int w : adjaMx[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
