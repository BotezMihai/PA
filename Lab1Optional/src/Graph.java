

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Graph {
    public int n;
    public int m;
    public String type;
    public int[][] matrix;

    public void generateN() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an odd integer number.");
        this.n = scanner.nextInt();
        // scanner.nextLine();
    }

    public int getN() {
        return n;
    }


    public void setN(int n) {
        this.n = n;
    }

    public void generateType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of the graph.");
        this.type = scanner.next();
        scanner.close();
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void afis() {
        System.out.println(n);
        System.out.println(type);
    }

    public void generateMatrix() {
        int count = 0, i = 0, j = 0;
        matrix = new int[this.n][this.n];
        Random randomNo = new Random();

        if (Objects.equals(this.type.toLowerCase(), "complete")) {
            // System.out.println("Sunt aici");
            for (i = 0; i < this.n; i++) {
                for (j = 0; j < this.n; j++) {
                    if (i != j)
                        matrix[i][j] = 1;
                    else
                        matrix[i][j] = 0;
                }
            }


        } else if (Objects.equals(this.type.toLowerCase(), "cycle")) {

            int[] noduri = new int[this.n];

            for (i = 0; i < this.n; i++)
                noduri[i] = i;
            for (i = 0; i < this.n; i++) {
                int randomPosition = randomNo.nextInt(this.n);
                int temp = noduri[i];
                noduri[i] = noduri[randomPosition];
                noduri[randomPosition] = temp;

            }
            //System.out.println(Arrays.toString(noduri));

            for (i = 0; i < this.n - 1; i++) {
                matrix[noduri[i]][noduri[i + 1]] = 1;
                matrix[noduri[i + 1]][noduri[i]] = 1;

            }
            matrix[0][noduri[this.n - 1]] = 1;
            matrix[noduri[this.n - 1]][0] = 1;


        } else if (Objects.equals(this.type.toLowerCase(), "random")) {
            for (i = 0; i < this.n; i++) {
                for (j = i + 1; j < this.n; j++) {

                    int random = randomNo.nextInt(2);
                    matrix[i][j] = random;
                    matrix[j][i] = random;
                }
            }
        }

        for (i = 0; i < this.n; i++)
            for (j = 0; j < this.n; j++)
                if (matrix[i][j] == 1)
                    count++;
        this.m = count / 2;

    }

    public void displayMatrix() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++)
                line.append(matrix[i][j]);
            System.out.println(line);
            line.setLength(0);
        }
        //o alta metoda de a afisa o matrice
        //for(int [] row: matrix)
        //System.out.println(Arrays.toString(row));


    }

    public void displayEdgesNumber() {
        System.out.println("The number of edges = " + m);
    }

    public void degrees() {
        int[] counter = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    count++;
            }
            counter[i] = count;
            count = 0;
        }

        Arrays.sort(counter);

        System.out.println('\u0394' + "(G) = " + counter[n - 1]);
        System.out.println("\u0394".toLowerCase() + "(G) = " + counter[0]);

        int first = counter[0];
        boolean flag = true;
        for (int i = 1; i < n; i++)
            if (counter[i] != first)
                flag = false;
        if (flag) {
            System.out.println("The graph is a regular graph.");
        } else {
            System.out.println("The graph is NOT a regular graph.");
        }
    }

    public void checkSum() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    count++;
            }
        }

        if (count == 2 * this.m) {
            System.out.println("Yes, the sum of degrees is equal to 2*m.");
        } else {
            System.out.println("No, the sum of degrees is NOT equal to 2*m.");
        }
    }


    void dfs(int nod, int[] visited) {
        visited[nod] = 1;
        int contor;
        for (contor = 0; contor < this.n; contor++) {
            if (matrix[nod][contor] == 1 && visited[contor] == 0)
                dfs(contor, visited);
        }

    }

    String isConnected() {
        int[] visited = new int[this.n];
        int contor = 0, connectedComponents = 0;
        Arrays.fill(visited, 0);
        for (contor = 0; contor < this.n; contor++)
            if (visited[contor] == 0) {
                dfs(contor, visited);
                connectedComponents++;
            }
        if (connectedComponents == 1)
            return "There is just one connected component.";
        else
            return "The graph has " + (connectedComponents - 1) + " connected components.";
    }

    

}

