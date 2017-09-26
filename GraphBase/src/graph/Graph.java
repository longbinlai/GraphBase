package graph;

import java.util.Map;
import java.util.HashMap;

public abstract class Graph {

  protected Map<Integer, Vertex> vertices;

  public Graph() {
    this.vertices = new HashMap<Integer, Vertex>();
  }

  public boolean addVertex(int newVertexId) {
    return addVertex(new Vertex(newVertexId));
  }

  public boolean addVertex(Vertex newVertex) {
    if (vertices.containsKey(newVertex.getId())) {
      return false;
    }
    vertices.put(newVertex.getId(), newVertex);
    return true;
  }

  public abstract Vertex deleteVertex(int vertexId); /*{
    return vertices.remove(vertexId);
  }*/

  public abstract int addEdge(int fromId, int toId);

  public abstract int addEdge(Vertex fromVertex, Vertex toVertex);

  public abstract int addEdge(Edge edge);

  public abstract Edge deleteEdge(int fromId, int toId);

  public abstract Edge deleteEdge(Vertex fromVertex, Vertex toVertex);

  public abstract Edge deleteEdge(Edge edge);

  public Map<Integer, Vertex> getVertices() {
    return vertices;
  }
}