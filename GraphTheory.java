package test.hacker.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class GraphTheory {

	/**
	 * Snakes and Ladders: The Quickest Way Up
	 * 
	 * @param args
	 */
	public static void snakesAndLaddersShortestPath(String[] args) {

		final int TERAIN_SIZE = 100;
		final int DICE_ROLL = 6;
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {

			// Map of adjacency lists
			Map<Integer, List<Integer>> adj = new HashMap<>();
			List<Integer> coordinates = new ArrayList<>();
			// fill adjacency list with neighbor values as if there were no
			// snakes or ladders
			for (int m = 1; m <= TERAIN_SIZE; m++) {
				List<Integer> newAdj = new ArrayList<>();
				for (int j = 1; j <= DICE_ROLL; j++) {
					if (m + j > TERAIN_SIZE) {
						continue;
					}
					newAdj.add(m + j);
				}
				adj.put(m, newAdj);
			}

			int ladders = s.nextInt();
			for (int j = 0; j < ladders; j++) {
				// ladder coordinates
				int x = s.nextInt();
				int y = s.nextInt();

				for (int k = (x - DICE_ROLL <= 0 ? 1 : x - DICE_ROLL); k < x; k++) {
					adj.get(k).remove(Integer.valueOf(x));
					adj.get(k).add(y);
				}
				coordinates.add(x);
			}
			int snakes = s.nextInt();
			for (int j = 0; j < snakes; j++) {
				// snake coordinates
				int x = s.nextInt();
				int y = s.nextInt();

				for (int k = x - DICE_ROLL; k < x; k++) {
					adj.get(k).remove(Integer.valueOf(x));
					adj.get(k).add(y);
				}
				coordinates.add(x);
			}
			// remove snakes and ladders from adjcency list
			for (Integer coordinate : coordinates) {
				adj.remove(coordinate);
			}

			int[] distanceTo = new int[101];
			boolean[] traversed = new boolean[101];
			Map<Integer, Integer> predecessors = new HashMap<>();
			Arrays.fill(traversed, false);
			// BFS algorithm
			Queue<Integer> queue = new LinkedList<>();
			distanceTo[0] = 0;
			traversed[1] = true;
			queue.add(1);
			while (!queue.isEmpty()) {
				Integer v = queue.poll();
				for (Integer u : adj.get(v)) {
					if (!traversed[u]) {
						traversed[u] = true;
						distanceTo[u] = distanceTo[v] + 1;
						predecessors.put(u, v);
						queue.add(u);
					}
				}
				traversed[v] = true;
			}

			System.out.println(distanceTo[100] != 0 ? distanceTo[100] : String
					.valueOf(-1));
		}

		s.close();
	}
	
	/**
	 * BFS : Shortest Reach . This is a generalization of single source shortest
	 * path algorithm which produces shortest path from any given node to any
	 * given node. Should be able to do that with the Floyd-Warshall algorithm
	 * 
	 * @param args
	 */
	public static void bfs(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {
			int N = s.nextInt();
			int M = s.nextInt();

			Map<Integer, List<Integer>> adj = new HashMap<>();
			for (int j = 1; j <= N; j++) {
				List<Integer> adjList = new ArrayList<>();
				adj.put(j, adjList);
			}

			for (int j = 0; j < M; j++) {
				int nA = s.nextInt();
				int nB = s.nextInt();

				adj.get(nA).add(nB);
				adj.get(nB).add(nA);
			}

			int startingPoint = s.nextInt();

			// bfs algorithm
			boolean[] traversed = new boolean[N + 1];
			Arrays.fill(traversed, false);
			int[] distanceTo = new int[N + 1];
			Arrays.fill(distanceTo, -1);

			Queue<Integer> queue = new LinkedList<>();
			distanceTo[startingPoint] = 0;
			traversed[startingPoint] = true;
			queue.add(startingPoint);

			while (!queue.isEmpty()) {

				Integer v = queue.poll();

				for (Integer u : adj.get(v)) {

					if (!traversed[u]) {
						distanceTo[u] = distanceTo[v] + 6;
						traversed[u] = true;
						queue.add(u);
					}

				}
				traversed[v] = true;
			}
			for (int j = 1; j < distanceTo.length; j++) {
				if (j == startingPoint) {
					continue;
				}
				System.out.print(distanceTo[j] + " ");
			}
			System.out.println();
		}
		s.close();
	}
	
	/**
	 * Even tree : Try counting the children. If the subtree has even number of
	 * nodes then the edge leading to this subtree can be removed. Otherwise,
	 * you have to keep on searching until you find a suitable edge or the
	 * entire tree exhausted. As it always can be decomposed into forests of
	 * even number of nodes, you will always end up with an answer greater than
	 * 1.
	 * 
	 * @param args
	 */
	public static void evenTree(String[] args) {

		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int M = s.nextInt();

		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int j = 1; j <= N; j++) {
			List<Integer> adjList = new ArrayList<>();
			adj.put(j, adjList);
		}

		for (int j = 0; j < M; j++) {
			int nA = s.nextInt();
			int nB = s.nextInt();

			if (nA > nB) {
				adj.get(nB).add(nA);
			} else {
				adj.get(nA).add(nB);
			}

		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		boolean[] traversed = new boolean[N + 1];
		Arrays.fill(traversed, false);
		traversed[1] = true;

		int[] distanceTo = new int[N + 1];
		Arrays.fill(distanceTo, -1);
		distanceTo[1] = 0;

		int[] pi = new int[N + 1];
		Arrays.fill(pi, -1);

		while (!queue.isEmpty()) {
			Integer u = queue.poll();
			for (int v : adj.get(u)) {
				if (!traversed[v]) {
					traversed[v] = true;
					distanceTo[v] = distanceTo[u] + 1;
					pi[v] = u;
					queue.add(v);
				}
				traversed[u] = true;
			}
		}

		// find subgraphOrders
		int[] subgraphOrder = new int[N + 1];
		int removedEdges = 0;
		for (int i : adj.keySet()) {
			subgraphOrder[i] = subgraphOrder(i, distanceTo, pi, adj);
			if (subgraphOrder[i] % 2 == 0) {
				removedEdges++;
			}

		}

		System.out.println(removedEdges);

		s.close();

	}
	
	private static int subgraphOrder(int startingPoint, int[] dt, int[] pi,
			Map<Integer, List<Integer>> adj) {
		int order = 1;
		if (dt[startingPoint] == -1 || dt[startingPoint] == 0) {
			// ignore and return 1
		} else {
			for (int i : adj.get(startingPoint)) {
				order += subgraphOrder(i, dt, pi, adj);
			}
		}
		return order;
	}

}
