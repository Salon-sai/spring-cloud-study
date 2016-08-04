package simple.demo;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by sai on 16-8-3.
 */
@Configuration
public class MongoConfig
{

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private Integer port;

    @Value("${mongodb.database}")
    private String dbName;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception
    {
        return new SimpleMongoDbFactory(new MongoClient(host, port), dbName);
    }

    @Bean
    public MongoOperations mongoOperations() throws Exception{
        return new MongoTemplate(mongoDbFactory());
    }

}
