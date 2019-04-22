package game;

import base.Board;
import base.Graph;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


public class Player implements Runnable {
    private String name;
    private Game game;
    private Graph graph;

    public static int THINKING_TIME = 500;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            play();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void play() throws InterruptedException {
        if (game.getPlayers().indexOf(this) < game.getPlayers().size() - 1) {
            while (game.getBoard().getComplete().getListOfEdges().size() > 0) {
                graph.addEdge(game.getBoard().extract());
                System.out.println(game.getPlayers().indexOf(this) + ": " + graph.getListOfEdges());
                try {
                    System.out.println(" waiting to get notified at time:" + System.currentTimeMillis());
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        } else {
            while (game.getBoard().getComplete().getListOfEdges().size() > 0) {
                graph.addEdge(game.getBoard().extract());
                System.out.println(game.getPlayers().indexOf(this) + ": " + graph.getListOfEdges());
                System.out.println(" Notifier work done");
                notifyAll();
                Thread.sleep((game.getPlayers().size() - 1) *);
            }
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    // implement the run() method, that will repeatedly extract edges
    // implement the toString() method
}

