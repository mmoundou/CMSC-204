import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * The Class Graph.
 *
 * @author Matthieu Eric Moundou
 */

public class Graph implements GraphInterface<Town, Road> {

	/** The Djriska's Shorstest Path
	 * 
	 */
	DJShortestPath dsp;

	/** The towns. */
	Set<Town> towns = new TreeSet<Town>(); // V
	
	/** The roads. */
	Set<Road> roads = new TreeSet<Road>(); // E

	/* (non-Javadoc)
	 * @see GraphInterface#getEdge(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {

		Iterator<Road> itRoads = roads.iterator();

		while (itRoads.hasNext()) {
			Road laCalle = itRoads.next();
			ArrayList<Town> ts = laCalle.getTowns();
			if (ts.contains(sourceVertex) && ts.contains(destinationVertex))
				return laCalle;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see GraphInterface#addEdge(java.lang.Object, java.lang.Object, int, java.lang.String)
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String name) {

		Road r = new Road(sourceVertex, destinationVertex, weight, name);
		roads.add(r);
		return r;

	}

	/* (non-Javadoc)
	 * @see GraphInterface#addVertex(java.lang.Object)
	 */
	@Override
	public boolean addVertex(Town u) {

		return towns.add(u);
	}

	/* (non-Javadoc)
	 * @see GraphInterface#containsEdge(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {

		Iterator<Road> itRoads = roads.iterator();

		while (itRoads.hasNext()) {
			Road laCalle = itRoads.next();
			ArrayList<Town> ts = laCalle.getTowns();
			if (ts.contains(sourceVertex) && ts.contains(destinationVertex))
				return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see GraphInterface#containsVertex(java.lang.Object)
	 */
	@Override
	public boolean containsVertex(Town v) {

		Iterator<Town> itTowns = towns.iterator();

		while (itTowns.hasNext()) {
			Town ciudad = itTowns.next();
			if (ciudad.getName().equals(v.getName()))
				return true;
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see GraphInterface#edgeSet()
	 */
	@Override
	public Set<Road> edgeSet() {

		return roads;
	}

	/* (non-Javadoc)
	 * @see GraphInterface#edgesOf(java.lang.Object)
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {

		Iterator<Road> itRoads = roads.iterator();

		Set<Road> myRoads = new HashSet<Road>();

		while (itRoads.hasNext()) {
			Road laCalle = itRoads.next();
			ArrayList<Town> ts = laCalle.getTowns();
			if (ts.contains(vertex))
				myRoads.add(laCalle);

		}

		return myRoads;

	}

	/* (non-Javadoc)
	 * @see GraphInterface#removeEdge(java.lang.Object, java.lang.Object, int, java.lang.String)
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		Iterator<Road> itRoads = roads.iterator();

		while (itRoads.hasNext()) {
			Road laCalle = itRoads.next();
			ArrayList<Town> ts = laCalle.getTowns();
			if (ts.contains(sourceVertex) && ts.contains(destinationVertex)) {
				if (laCalle.getWeight() == weight && laCalle.getName().equals(description)) {
					roads.remove(laCalle);

					return laCalle;
				}
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see GraphInterface#removeVertex(java.lang.Object)
	 */
	@Override
	public boolean removeVertex(Town v) {

		Iterator<Town> itTowns = towns.iterator();

		while (itTowns.hasNext()) {
			Town laCiudad = itTowns.next();
			if (laCiudad.getName().equals(v.getName())) {

				// remove the town from the set
				towns.remove(laCiudad);

				// remove all of its edges as well.
				Iterator<Road> itRoads = roads.iterator();

				while (itRoads.hasNext()) {
					Road nextRoad = itRoads.next();
					ArrayList<Town> connection = nextRoad.getTowns();
					if (connection.get(0).getName().equals(laCiudad.getName())
							|| connection.get(1).getName().equals(laCiudad.getName())) {
						itRoads.remove();
					}
				}

				return true;

			}
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see GraphInterface#vertexSet()
	 */
	@Override
	public Set<Town> vertexSet() {

		return towns;
	}

	/**
	 * Gets the town with name.
	 *
	 * @param townName the town name
	 * @return the town with name
	 */
	Town getTownWithName(String townName) {

		for (Town t : towns) {
			if (t.getName().equals(townName))
				return t;
		}

		return null;
	}

	/**
	 * The Class DJShortestPath.
	 */
	private class DJShortestPath {

		/** The graph. */
		Graph graph;
		
		/** The un settled nodes. */
		Set<Town> unSettledNodes = new HashSet<Town>();
		
		/** The settled nodes. */
		Set<Town> settledNodes = new HashSet<Town>();
		
		/** The predecessors. */
		Map<Town, Town> predecessors = new HashMap<Town, Town>();
		
		/** The distance. */
		Map<Town, Integer> distance = new HashMap<Town, Integer>();

		/**
		 * Instantiates a new DJ shortest path.
		 *
		 * @param g represent the graph
		 */
		DJShortestPath(Graph g) {
			graph = g;
			generateAdjMatrix();
			generateTownList();

		}

		/** The adj matrix. */
		// the Adj Matrix that will be generated
		int[][] adjMatrix = null;

		/** The town list. */
		//Town[][] townMatrix = new Towns[towns.size()][towns.size()];
		HashMap<Town,HashMap<Town,Road>> townList = new HashMap<Town, HashMap<Town, Road>>();


		/**
		 * Generate adjacency matrix.
		 */
		void generateAdjMatrix() {

			// generate and store Adjancy Matrix from Sets
			int ID = 0;

			// add ID value to Town objects. note that the set is already sorted because it
			// is a TreeSet
			for (Town t : towns)
				t.setID(ID++);

			int numberOfTowns = towns.size();
			adjMatrix = new int[numberOfTowns][numberOfTowns];

			for (Road r : roads) {
				ArrayList<Town> connection = r.getTowns();
				Town x = connection.get(0);
				Town y = connection.get(1);

				adjMatrix[x.getID()][y.getID()] = r.getWeight();
				adjMatrix[y.getID()][x.getID()] = r.getWeight();

			}

		}


		/**
		 * Generate town list.
		 */
		void generateTownList()
		{

			for(Town t: towns)
				townList.put(t, new HashMap<Town, Road>());

			for(Road r : roads) {
				ArrayList<Town> connection = r.getTowns();
				Town x = connection.get(0);
				Town y = connection.get(1);

				HashMap<Town, Road> tr = townList.get(x);
				tr.put(y, r);

				tr = townList.get(y);
				tr.put(x, r);

			}
		}



		/**
		 * Execute.
		 *
		 * @param source the source
		 */
		public void execute(Town source) {
			distance.put(source, 0);
			unSettledNodes.add(source);

			while (unSettledNodes.size() > 0) {

				Town node = getMinimum(unSettledNodes);
				settledNodes.add(node);
				unSettledNodes.remove(node);
				findMinimalDistances(node);

			}
		}

		/**
		 * Find minimal distances.
		 *
		 * @param node the node
		 */
		private void findMinimalDistances(Town node) {
			List<Town> adjacentTowns = getNeighbors(node);
			for (Town target : adjacentTowns) {
				if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
					distance.put(target, getShortestDistance(node) + getDistance(node, target));
					predecessors.put(target, node);
					unSettledNodes.add(target);
				}
			}
		}

		/**
		 * Gets the distance.
		 *
		 * @param source the source
		 * @param target the target
		 * @return the distance
		 */
		private int getDistance(Town source, Town target) {

			//return adjMatrix[node.getID()][target.getID()];

			HashMap<Town, Road> tr = townList.get(source);
			return tr.get(target).getWeight();
		}

		/**
		 * Gets the neighbors.
		 *
		 * @param t the t
		 * @return the neighbors
		 */
		private List<Town> getNeighbors(Town t) {
			List<Town> neighbors = new ArrayList<Town>();

			for (Road r : roads) {
				if (r.getTowns().contains(t)) {
					ArrayList<Town> connection = r.getTowns();
					Town t1 = connection.get(0);
					Town t2 = connection.get(1);

					if (t1.equals(t) && !isSettled(t2)) {
						neighbors.add(t2);
					} else if (t2.equals(t) && !isSettled(t1)) {
						neighbors.add(t1);
					}

				}

			}

			return neighbors;

		}

		/**
		 * Gets the minimum.
		 *
		 * @param towns the towns
		 * @return the minimum
		 */
		private Town getMinimum(Set<Town> towns) {
			Town minimum = null;
			for (Town t : towns) {
				if (minimum == null) {
					minimum = t;
				} else {
					if (getShortestDistance(t) < getShortestDistance(minimum)) {
						minimum = t;
					}
				}

			}
			return minimum;
		}

		/**
		 * Gets the shortest distance.
		 *
		 * @param t the t
		 * @return the shortest distance
		 */
		private int getShortestDistance(Town t) {

			Integer d = distance.get(t);
			if (d == null) {
				return Integer.MAX_VALUE;
			} else {
				return d;
			}

		}

		/**
		 * Checks if is settled.
		 *
		 * @param t the t
		 * @return true, if is settled
		 */
		private boolean isSettled(Town t) {
			return settledNodes.contains(t);
		}

		/**
		 * Gets the path.
		 *
		 * @param target the target
		 * @return the path
		 */
		public ArrayList<Town> getPath(Town target) {
			ArrayList<Town> path = new ArrayList<Town>();
			Town step = target;

			// check if path exists
			if (predecessors.get(step) == null) {
				return null;
			}
			path.add(step);
			while (predecessors.get(step) != null) {
				step = predecessors.get(step);
				path.add(step);
			}

			Collections.reverse(path);
			return path;

		}

		/**
		 * Gets the path string.
		 *
		 * @param target the target
		 * @return the path string
		 */
		public ArrayList<String> getPathString(Town target) {

			ArrayList<Town> path = this.getPath(target);
			ArrayList<String> steps = new ArrayList<String>();

			if (path != null) {
				// so now just find the edge between the nodes and add that into the string
				for (int i = 0; i < path.size() - 1; i++) {

					Town u = path.get(i);
					Town v = path.get(i + 1);
					Road r = graph.getEdge(u, v);

					String step = u.getName() + " via " + r.getName() + " to " + v.getName() + " " + r.getWeight()
					+ " mi";
					steps.add(step);
				}


			}

			return steps;
		}

	}

	/* (non-Javadoc)
	 * @see GraphInterface#dijkstraShortestPath(java.lang.Object)
	 */
	@Override
	public void dijkstraShortestPath(Town source) {

		dsp = new DJShortestPath(this);
		dsp.execute(source);

	}

	/* (non-Javadoc)
	 * @see GraphInterface#shortestPath(java.lang.Object, java.lang.Object)
	 */
        
	@Override
	public ArrayList<String> shortestPath(Town source, Town destination) {

		this.dijkstraShortestPath(source);
		return dsp.getPathString(destination);

	}

}

