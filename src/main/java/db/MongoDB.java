package db;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * The MongoDB class provides methods to interact with a MongoDB database
 * for a library management system.
 *
 * <p>It includes functionality for obtaining a MongoDB database instance with
 * the necessary codecs for working with POJOs (Plain Old Java Objects) using
 * the MongoDB Java driver.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 *     // Obtain a MongoDB database instance
 *     MongoDatabase database = MongoDB.getDatabaseInstance();
 * </pre>
 *
 * @author Phoebe Ivana
 * @version 1.0
 */
public class MongoDB {
    /**
     * Retrieves a MongoDB database instance for the library management system
     * with the necessary codecs for handling POJOs.
     *
     * @return A MongoDB database instance configured with POJO codecs.
     * @throws MongoException if an error occurs while interacting with MongoDB.
     */
    public static MongoDatabase getDatabaseInstance() {
        // Configure the POJO codecs
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        // Obtain a MongoDB client instance
        MongoClient mongoClient = MyMongoClient.getMongoClient();

        // Send a ping to confirm a successful connection
        // Configure the database instance with POJO codecs
        MongoDatabase database = mongoClient.getDatabase("LibManagement").withCodecRegistry(pojoCodecRegistry);

        return database;
    }

    /**
     * The main method is provided for testing purposes.
     * It can be used to run standalone tests or execute any additional logic.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {

    }
}
