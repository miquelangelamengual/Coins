package net.jungly.coins.mongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import fr.javatic.mongo.jacksonCodec.JacksonCodecProvider;
import fr.javatic.mongo.jacksonCodec.ObjectMapperFactory;
import lombok.Getter;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class MongoConnector {

  private MongoClient mongoClient;
  private MongoDatabase mongoDatabase;
  private MongoClientURI mongoClientURI;

  public void setup() {
    ObjectMapper objectMapper = this.createObjectMapper();

    CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(new JacksonCodecProvider(objectMapper)));
    MongoClientOptions.Builder clientOptions = MongoClientOptions.builder()
            .codecRegistry(codecRegistry);

    this.mongoClientURI = new MongoClientURI(
            "mongodb+srv://harpylmao:CANZOqO6BhBoiY2H@privatedb.u5zb8.mongodb.net/coins?retryWrites=true&w=majority",
            clientOptions
    );

    this.mongoClient = new MongoClient(mongoClientURI);
    this.mongoDatabase = this.mongoClient.getDatabase("coins");

    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
    mongoLogger.setLevel(Level.OFF);
  }

  private ObjectMapper createObjectMapper() {
    ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();
    mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    mapper.registerModule(new Jdk8Module());
    return mapper;
  }
}
