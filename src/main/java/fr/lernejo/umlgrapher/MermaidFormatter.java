package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.Set;

public class MermaidFormatter {
    
    private final Set<UmlType> types;

    public MermaidFormatter(Set<UmlType> types) {
        this.types = types;
    }

    public String formatContent() {
        String words = "classDiagram\n";
        for (UmlType t : types) {
            words += "class " + t.getClassName();
            if (Modifier.isInterface(t.getTheClasse().getModifiers())) {
                words += " {\n    <<interface>>\n}";
            }
            words += "\n";
        }
        return words;
    }
}
