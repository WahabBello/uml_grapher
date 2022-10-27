package fr.lernejo.umlgrapher;

import java.util.Set;

public class UmlRelation {
    private final Set<UmlType> Tree;

    public UmlRelation(Set<UmlType> arbre) {
        this.Tree = arbre;
    }

    public String allRelation(Set<MermaidRelations> links, Set<UmlType> types) {
        String link = "";
        links = new UmlRelation(types).Relation(links);
        for (MermaidRelations i : links) {
            link += i.getLink();
        }
        return link;
    }

    public Set<MermaidRelations> Relation(Set<MermaidRelations> allLinks) {
        String relation = "";
        for (UmlType i : Tree) {
            Class[] j = i.getTheClasse().getInterfaces();
            for (Class k : j) {
                if (i.getTheClasse().getSuperclass() == null) {
                    relation = k.getSimpleName() + " <|-- " + i.getTheClasse().getSimpleName() + " : extends";
                } else {
                    relation = k.getSimpleName() + " <|.. " + i.getTheClasse().getSimpleName() + " : implements";
                }
                relation += "\n";
                allLinks.add(new MermaidRelations(k, i.getTheClasse(), relation));
            }
        }
        return allLinks;
    }


}
