package db;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * The MyMongoClient class provides a singleton MongoClient instance for
 * connecting to a MongoDB server. It ensures that only one MongoClient is
 * created and reused throughout the application.
 *
 * <p>It includes methods for obtaining the MongoClient instance and closing
 * the MongoClient when it is no longer needed. The MongoClient is configured
 * with a MongoDB connection string and an optional ServerApi for specifying the
 * server API version.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 *     // Obtain a MongoClient instance
 *     MongoClient client = MyMongoClient.getMongoClient();
 *
 *     // ... (use the MongoClient instance)
 *
 *     // Close the MongoClient when it's no longer needed
 *     MyMongoClient.closeMongoClient();
 * </pre>
 *
 * <p>Note: The MongoDB connection string and other configuration parameters
 * should be replaced with actual values based on your MongoDB setup.</p>
 *
 * @author Phoebe Ivana
 * @version 1.0
 */
public class MyMongoClient {

    private static MongoClient mongoClient;

    /**
     * Private constructor to prevent instantiation of the class.
     * This class follows the Singleton pattern.
     */
    private MyMongoClient() {
        // private constructor to prevent instantiation
    }

    /**
     * Retrieves the singleton MongoClient instance for connecting to a MongoDB server.
     * If the MongoClient instance does not exist, it is created with the specified
     * MongoDB connection string and an optional ServerApi for server versioning.
     *
     * @return The MongoClient instance configured for the application.
     */
    public static MongoClient getMongoClient() {

        if (mongoClient == null) {
            // MongoDB connection string (replace with your actual connection string)
            String connectionString = "mongodb+srv://PhoebeIvana:P8mjvMQw8FsRj0JN@phoebeivana.mxdrqog.mongodb.net/?retryWrites=true&w=majority";

            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(connectionString))
                    .serverApi(serverApi)
                    .build();

            // Creating a new client and connecting to the server
            mongoClient = MongoClients.create(settings);
        }
        return mongoClient;
    }

    /**
     * Closes the MongoClient instance if it exists.
     * This method should be called when the MongoClient is no longer needed.
     */
    public static void closeMongoClient() {
        if (mongoClient != null) {
            // Closing the MongoClient instance when it's no longer needed
            mongoClient.close();
            mongoClient = null;
        }
    }
}