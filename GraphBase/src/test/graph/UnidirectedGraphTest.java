package test.graph;

import graph.Edge;
import graph.UnidirectedGraph;
import java.util.Collection;
import java.util.HashSet;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * UnidirectedGraph Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 22, 2017</pre>
 */
public class UnidirectedGraphTest {

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  @Test
  public void testAddEdgeForFromIdToId() throws Exception {
//TODO: Test goes here...
    UnidirectedGraph graph = new UnidirectedGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    assertEquals(graph.getVertices().get(1).isAdjacent(2), true);
    assertEquals(graph.getVertices().get(1).isAdjacent(3), false);
  }

  @Test
  public void testAddEdgeEdge() throws Exception {
//TODO: Test goes here...
    UnidirectedGraph graph = new UnidirectedGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    Edge edge = new Edge(1, 2);
    graph.addEdge(edge);
    assertEquals(graph.getVertices().get(1).isAdjacent(2), true);
    assertEquals(graph.getVertices().get(2).isAdjacent(1), true);
  }

  @Test
  public void testDeleteEdgeForFromIdToId() throws Exception {
//TODO: Test goes here...
    UnidirectedGraph graph = new UnidirectedGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    Edge edge = new Edge(1, 2);
    graph.addEdge(edge);
    graph.deleteEdge(1, 2);
    assertEquals(graph.getVertices().get(1).isAdjacent(2), false);
    assertEquals(graph.getVertices().get(2).isAdjacent(1), false);
  }

  @Test
  public void testDeleteEdgeForFromVertexToVertex() throws Exception {
//TODO: Test goes here...
    UnidirectedGraph graph = new UnidirectedGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    Edge edge = new Edge(1, 2);
    graph.addEdge(edge);
    graph.deleteEdge(graph.getVertices().get(1), graph.getVertices().get(2));
    assertEquals(graph.getVertices().get(1).isAdjacent(2), false);
    assertEquals(graph.getVertices().get(2).isAdjacent(1), false);
  }

  @Test
  public void testDeleteEdgeEdge() throws Exception {
//TODO: Test goes here...
    UnidirectedGraph graph = new UnidirectedGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    Edge edge = new Edge(1, 2);
    graph.addEdge(edge);
    graph.deleteEdge(edge);
    assertEquals(graph.getVertices().get(1).isAdjacent(2), false);
    assertEquals(graph.getVertices().get(2).isAdjacent(1), false);
  }

  @Test
  public void testGetEdges () throws Exception {
    UnidirectedGraph graph = new UnidirectedGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    Edge edge1 = new Edge(1,2);
    Edge edge2 = new Edge(2,3);
    Edge edge3 = new Edge(3,1);
    graph.addEdge(edge1);
    graph.addEdge(edge2);
    graph.addEdge(edge3);
    Collection<Edge> edges = graph.getEdges();
    assertEquals(edges.contains(edge1),true);
    assertEquals(edges.contains(edge2),true);
    assertEquals(edges.contains(edge3),true);
  }

  @Test
  public void testIsEuqal () throws Exception {
    UnidirectedGraph graph1 = new UnidirectedGraph();
    UnidirectedGraph graph2 = new UnidirectedGraph();
    graph1.addVertex(1);
    graph2.addVertex(1);
    graph1.addVertex(2);
    graph2.addVertex(2);
    graph1.addVertex(3);
    graph2.addVertex(3);
    graph1.addEdge(1,2);
    graph2.addEdge(1,2);
    graph1.addEdge(3,2);
    graph2.addEdge(3,2);
    assertEquals(graph1.isEqual(graph2),true);
    assertEquals(graph2.isEqual(graph1),true);
    graph1.deleteEdge(1,2);
    assertEquals(graph1.isEqual(graph2),false);
    assertEquals(graph2.isEqual(graph1),false);
  }

  @Test
  public void testClone() throws Exception {
    UnidirectedGraph graph = new UnidirectedGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addEdge(1,2);
    graph.addEdge(2,3);
    UnidirectedGraph graphCopy = graph.clone();
    assertEquals(graph.isEqual(graphCopy),true);
  }

} 