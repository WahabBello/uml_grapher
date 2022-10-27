package fr.lernejo.umlgrapher;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UmlGraph {

    private final Class<?>[] classes;

    private final Set<MermaidRelations> linkers = new TreeSet<>(Comparator
            .<MermaidRelations, String>comparing(t -> t.getChildClass())
            .thenComparing(t -> t.getParentClass()));
            
    private final Set<UmlType> types = new TreeSet<>(Comparator
            .<UmlType, String>comparing(t -> t.getClassName())
            .thenComparing(t -> t.getPackageName()));


    public UmlGraph(Class<?>... classes) {
        this.classes = classes;
    }

    public String as(GraphType graphType) {
        List<Class> listeClasses = null;
        for (Class nClass : classes) {
            switch (graphType) {
                case Mermaid:
                    listeClasses = new InternalGraphRepresentation(nClass).getAllRelations();
                    for (Class i : listeClasses) {
                        types.add(new UmlType(i));
                    }
                    break;
            }
        }
        String result = new MermaidFormatter(types).formatContent() + new UmlRelation(types).allRelation(linkers, types);
        return result;
    }
}
