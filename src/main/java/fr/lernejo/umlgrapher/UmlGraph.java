package fr.lernejo.umlgrapher;

public class UmlGraph {
    public UmlGraph(Class<?> classe) {

    }

    public String as(GraphType mermaid) {
        return mermaid.MERMAID.getTypeGraph();
    }

}
