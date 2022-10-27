package fr.lernejo.umlgrapher;

public class UmlType {
    private final Class theclasse;
    private final String packageName;
    private final String className;

    public UmlType(Class classe) {
        this.theclasse = classe;
        this.className = classe.getSimpleName();
        this.packageName = classe.getPackageName();
    }

    public Class getTheClasse() {
        return this.theclasse;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getClassName() {
        return this.className;
    }

}
