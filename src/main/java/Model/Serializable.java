package Model;

import java.util.HashMap;

public class Serializable {
    public int id;
    private static HashMap<Class<?>, Integer> objectCounter = new HashMap<Class<?>, Integer>();

    protected Serializable() {
        Integer count = objectCounter.get(getClass());
        if (count == null) {
            count = 0;
        } else count++;
        objectCounter.put(getClass(), count);
        this.id = count;
    }

    public static Integer getLastId(Class<?> checkClass) {
        return objectCounter.get(checkClass);
    }
}
