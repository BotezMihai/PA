import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();

        // argumentele
        int firstArg = 0;
        String secondArg;

        // Daca nu primesc din cmd se executa asa cum trebuie
        if (args.length == 0) {
            graph.generateN();
            if (graph.getN() > 10_000) {
                long start = System.nanoTime();
                graph.generateType();
                graph.afis();
                graph.generateMatrix();
                //graph.displayMatrix();
                graph.degrees();
                graph.checkSum();
                if (graph.getType().equals("random")) {
                    graph.isConnected();
                }
                long end = System.nanoTime();
                long total = end - start;
                System.out.println(total);
            } else {
                graph.generateType();
                graph.afis();
                graph.generateMatrix();
                graph.displayMatrix();
                graph.degrees();
                graph.checkSum();
                if (graph.getType().equals("random")) {
                    graph.isConnected();
                }
            }
            // daca primesti 2 argumente
        } else if (args.length == 2) {

            //verific sa vad daca e int ce imi da in primul argument
            try {
                firstArg = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Syntax: java Main n type ! n(odd integer number), type(one of: {random, cycle, complete})");
            }

            // verific paritatea
            if (firstArg % 2 != 0) {
                secondArg = args[1];

                // verific daca al doilea argument e ceea ce trebuie
                if (Objects.equals(secondArg.toLowerCase(), "random") || Objects.equals(secondArg.toLowerCase()
                        , "cycle") || Objects.equals(secondArg.toLowerCase(), "complete")) {

                    // setez n si type conform argumentelor
                    graph.setN(firstArg);
                    graph.setType(secondArg);

                    // si execut ce trebuie
                    if (graph.getN() > 10_000) {
                        long start = System.nanoTime();
                        //graph.generateType();
                        graph.afis();
                        graph.generateMatrix();
                        //graph.displayMatrix();
                        graph.degrees();
                        graph.checkSum();
                        if (graph.getType().equals("random")) {
                            graph.isConnected();
                        }
                        long end = System.nanoTime();
                        long total = end - start;
                        System.out.println(total);
                    } else {
                        //graph.generateType();
                        graph.afis();
                        graph.generateMatrix();
                        graph.displayMatrix();
                        graph.degrees();
                        graph.checkSum();
                        if (graph.getType().equals("random")) {
                            graph.isConnected();
                        }
                    }

                } else {
                    System.out.println("Syntax: java Main n type ! n(odd integer number), type(one of: {random, cycle, complete})");
                }
            } else {
                System.out.println("Syntax: java Main n type ! n(odd integer number), type(one of: {random, cycle, complete})");
            }

        } else {
            System.out.println("Syntax: java Main n type ! n(odd integer number), type(one of: {random, cycle, complete})");
        }
        // mai sus is else-urile in caz ca ba nu e impar ba nu a introdus ceva cum trebuie
        // mai jos e codu cum era inainte


        /*
        graph.generateN();
        if (graph.getN() > 10_000) {
            long start = System.nanoTime();
            graph.generateType();
            graph.afis();
            graph.generateMatrix();
            //graph.displayMatrix();
            graph.degrees();
            graph.checkSum();
            if (graph.getType().equals("random"){
           graph.isConnected();
            long end = System.nanoTime();
            long total = end - start;
            System.out.println(total);
        } else {
            graph.generateType();
            graph.afis();
            graph.generateMatrix();
            graph.displayMatrix();
            graph.degrees();
            graph.checkSum();
            if (graph.getType().equals("random"){
           graph.isConnected();
        }
        */
    }


}
