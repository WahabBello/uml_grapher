package fr.lernejo.umlgrapher;

import java.util.ArrayList;
import java.util.List;

public class InternalGraphRepresentation {
    private final Class classe;

    public InternalGraphRepresentation(Class classe) {
        this.classe = classe;
    }

    public List<Class> recursiveRelations(List<Class> recursiveList, Class... table) {
        for (Class aClassFromTable : table) {
            if (!recursiveList.contains(aClassFromTable)) {
                recursiveList.add(aClassFromTable);
                recursiveList = recursiveRelations(recursiveList, aClassFromTable.getInterfaces());
            }
        }
        return recursiveList;
    }

    public List<Class> getAllRelations() {
        List<Class> tList = new ArrayList<>();
        tList = recursiveRelations(tList, this.classe);
        return tList;
    }

}
