package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	private final Set<Pair<N, Set<N>>> adjacency; 
	
	public GraphImpl() {
		this.adjacency = new HashSet<>();
	}

	public void addNode(N node) {
		this.adjacency.add(new Pair<>(node, new HashSet<>()));
	}

	public void addEdge(N source, N target) {
		for(Pair<N, Set<N>> nodeEdgesPair : this.adjacency) {
			if(nodeEdgesPair.getFirst().equals(source)) {
				nodeEdgesPair.getSecond().add(target);
			}
		}
	}

	public Set<N> nodeSet() {
		Set<N> set = new HashSet<>();
		for(Pair<N, Set<N>> nodeEdgesPair : this.adjacency) {
			set.add(nodeEdgesPair.getFirst());
		}
		return Set.copyOf(set);
	}

	public Set<N> linkedNodes(N node) {
		for(Pair<N, Set<N>> nodeEdgesPair : this.adjacency) {
			if(nodeEdgesPair.getFirst().equals(node)) {
				return Set.copyOf(nodeEdgesPair.getSecond());
			}
		}
		return new HashSet<N>();
	}
	
	public List<N> getPath(N source, N target) {
		return this.pathBuilder(source, target, new ArrayList<N>());
	}
	
	private List<N> pathBuilder(N elem, N target, List<N> path) {
		if(!(path.size() != 0 && this.getLast(path).equals(target))) {
			path.add(elem);
			for(Pair<N, Set<N>> nodeEdgesPair : this.adjacency) {
				if(this.getLast(path).equals(nodeEdgesPair.getFirst())) {
					for(N edge : nodeEdgesPair.getSecond()) {
						pathBuilder(edge, target, path);
					}
				}
			}
		}
		return List.copyOf(path);
	}
	
	private N getLast(List<N> list) {
		return list.get(list.size() - 1);
	}

}

