package fr.lernejo.umlgrapher;

public enum GraphType {

    Mermaid("""
        classDiagram
        class Machin {
            <<interface>>
        }
        """);
    final String typeGraph;

    GraphType(String typeGraph) {
        this.typeGraph = typeGraph;
    }
}
