# Projet perso N°2  : Adel OUHABI

## API de graphes

Ce projet a pour but la réalisation d'une bibliothéque java pour traiter toute sorte de graphe 

## prérequis

-java 7 au plus
-Maven3 

## Commencer

## Dependence  Maven de l'Api 

 Ajoutez cette dependence dans votre pom.xml 

```xml 
 <dependency>
  <groupId>com.ensg.graph</groupId>
  <artifactId>projetPerso</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
 </dependency>
 ```
## Lancement


```
mvn package
```


### Exemple utilisation code 

pour creer un graphe on passe par la factory #GraphFactory
```java
GraphFactory graphFactory = new XMLGraph();
AbstractGraph d =g.createGraph(enumGraph.DirictedGraph);
```
on cree notre graphe avec ses sommets et arcs

```java
Vertice v1 = new Vertice<String>("v1");
Vertice v2 = new Vertice<String>("v2");
Vertice v3 = new Vertice<String>("v3");
Vertice v4 = new Vertice<String>("v4");
Vertice v5 = new Vertice<String>("v5");
Vertice v6 = new Vertice<String>("v6");
graph.addEdge(new Edge(v1, v2));
graph.addEdge(new Edge(v1, v4));
graph.addEdge(new Edge(v2, v3));
graph.addEdge(new Edge(v3, v5));
graph.addEdge(new Edge(v4, v5));
```

en suite on exporte notre graphe dans le format de la factory qu'on a choisi au préalable
```java
graphFactory.create(graph, new File("file.xml"));
```
		


