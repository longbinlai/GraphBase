package algorithm;

import graph.Graph;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class TraversalIterator implements Iterator<Integer> {

  private final Graph graph;
  private final int start;
  private Collection<Integer> unvisited;
  private Collection<Integer> queue;
  private boolean isBFS;

  public TraversalIterator(Graph graph, int start, String method) {

    method = method.toLowerCase();
    boolean isBFS;
    if (method.equals("bfs")) {
      isBFS = true;
    } else if (method.equals("dfs")) {
      isBFS = false;
    } else {
      throw new IllegalArgumentException("Unknown method: " + method);
    }

    if (!graph.contains(start)) {
      throw new NoSuchElementException();
    }

    this.graph = graph;
    this.start = start;
    this.unvisited = graph.getVertexIDs();
    this.isBFS = isBFS;

    if (isBFS) {
      this.queue = new LinkedList<>();
      offer(start);
    } else {
      this.queue = new Stack<>();
      push(start);
    }

    this.unvisited.remove(start);
  }

  public Graph getGraph() {
    return graph;
  }

  public int getStart() {
    return start;
  }

  @Override
  public Integer next() {
    if (queue.isEmpty()) {
      if (this.unvisited.isEmpty()) {
        throw new NoSuchElementException();
      }
      int newStart = this.unvisited.iterator().next();
      if (isBFS) {
        offer(newStart);
      } else {
        push(newStart);
      }
      this.unvisited.remove(newStart);
    }

    int current = isBFS ? poll() : pop();

    Collection<Integer> neighbors = this.graph.getVertex(current).getNeighbors();
    for (int n : neighbors) {
      if (this.unvisited.contains(n)) {
        if (isBFS) {
          offer(n);
        } else {
          push(n);
        }
        this.unvisited.remove(n);
      }
    }
    return current;
  }

  @Override
  public boolean hasNext() {
    return !(this.queue.isEmpty() && this.unvisited.isEmpty());
  }

  private void push(int id) {
    ((Stack<Integer>) this.queue).push(id);
  }

  private int pop() {
    return ((Stack<Integer>) this.queue).pop();
  }

  private void offer(int id) {
    this.queue.add(id);
  }

  private int poll() {
    return ((Queue<Integer>) this.queue).poll();
  }

}