package fr.lernejo.umlgrapher;

public class UmlGraph {

    private final Class<?>[] graph_classes;

    public UmlGraph(Class<?>... classes) {
        this.graph_classes = classes;
    }

    public String as(GraphType mermaid) {
        return mermaid.typeGraph;
    }

}
