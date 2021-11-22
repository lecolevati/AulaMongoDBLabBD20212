package persistence;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnection {
	public final int PORT = 27017;
	public final String USERNAME = "admin";
	public final String PASS = "P4sww0rd";
	public final String DB = "admin";

	public MongoClient mongoConn() {
		ConnectionString connectionString = new ConnectionString("mongodb://" + USERNAME + ":" + PASS + "@localhost:"
				+ PORT + "/?authSource=admin&readPreference=primary&ssl=false");
		MongoClientSettings settings = MongoClientSettings.builder()
			.applyConnectionString(connectionString)
			.build();
		MongoClient mongoClient = MongoClients.create(settings);
		return mongoClient;
	}
}
