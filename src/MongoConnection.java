import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class MongoConnection {
    private static final String CONNECTION_STRING =
        "mongodb+srv://usuario:senha@cluster0.mongodb.net/?retryWrites=true&w=majority";

    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                    .serverApi(serverApi)
                    .build();

            try {
                MongoClient mongoClient = MongoClients.create(settings);
                database = mongoClient.getDatabase("catalogo_db");
                database.runCommand(new org.bson.Document("ping", 1));
                
                // RESPOSTA DO SISTEMA PARA SABER SE DEU CERTO OU NÃO CONECTAR COM MONGODB
                System.out.println("Conexão com MongoDB Atlas bem-sucedida!");
            } catch (MongoException e) {
                System.err.println("❌ Erro ao conectar com MongoDB Atlas: " + e.getMessage());
            }
        }
        return database;
    }
}

