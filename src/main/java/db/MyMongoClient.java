package db;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MyMongoClient {

    private static MongoClient mongoClient;

    private MyMongoClient() {
        // private constructor to prevent instantiation
    }

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

    public static void closeMongoClient() {
        if (mongoClient != null) {
            // Closing the MongoClient instance when it's no longer needed
            mongoClient.close();
            mongoClient = null;
        }
    }
}