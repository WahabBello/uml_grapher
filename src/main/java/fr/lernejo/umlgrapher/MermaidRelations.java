package fr.lernejo.umlgrapher;

public class MermaidRelations {
    private final String parent_class;
    private final String kid_class;
    private final String link;

    public MermaidRelations(Class parent_class, Class kid_class, String link) {
        this.kid_class = kid_class.getSimpleName();
        this.parent_class = parent_class.getSimpleName();
        this.link = link;
    }

    public String getParentClass() {
        return this.parent_class;
    }

    public String getChildClass() {
        return this.kid_class;
    }

    public String getLink() {
        return this.link;
    }

}
