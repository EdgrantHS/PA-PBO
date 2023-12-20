package Model;

import java.util.HashMap;

/**
 * The {@code Serializable} class serves as a base class for objects that need to support serialization.
 * It provides a mechanism to assign unique identifiers to instances and track the last assigned identifier
 * for a particular class.
 *
 * @author Darmawan Hanif
 */
public class Serializable {

    /**
     * The unique identifier assigned to each instance of the class.
     */
    public int id;

    /**
     * A map that stores the last assigned identifier for each class.
     */
    private static HashMap<Class<?>, Integer> objectCounter = new HashMap<Class<?>, Integer>();

    /**
     * Protected constructor for the {@code Serializable} class.
     * <p>
     * Initializes the unique identifier for each instance based on the class type and maintains a count
     * of the number of instances created for that class.
     * </p>
     */
    protected Serializable() {
        Integer count = objectCounter.get(getClass());
        if (count == null) {
            count = 0;
<<<<<<< HEAD
        } else count++;
=======
        } else {
            count++;
        }
>>>>>>> a7f57236a619a86d932837d17068fdf4d2ff02e5
        objectCounter.put(getClass(), count);
        this.id = count;
    }

    /**
     * Retrieves the last assigned identifier for instances of a specific class.
     *
     * @param checkClass The class for which to retrieve the last assigned identifier.
     * @return The last assigned identifier for instances of the specified class.
     */
    public static Integer getLastId(Class<?> checkClass) {
        return objectCounter.get(checkClass);
    }
}
