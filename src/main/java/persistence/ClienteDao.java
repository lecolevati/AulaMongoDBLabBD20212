package persistence;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ClienteDao {

	private MongoClient cli;
	private MongoDatabase db;
	private MongoCollection<Document> collection;
	
	public ClienteDao() {
		MongoConnection conn = new MongoConnection();
		cli = conn.mongoConn();
		db = cli.getDatabase("AulaLabBD20212");
		collection = db.getCollection("cliente");
	}
	
	public void insertOneCliente(Document cliente) {
		collection.insertOne(cliente);
	}
	
	public void insertManyCliente(List<Document> clientes) {
		collection.insertMany(clientes);
	}
	
	public void updateOneCliente(Bson query, Bson UpdtObj) {
		collection.updateOne(query, UpdtObj);
	}
	
	public void updateManyCliente(Bson query, Bson UpdtObj) {
		collection.updateMany(query, UpdtObj);
	}
	
	public void removeOneCliente(Bson query) {
		collection.deleteOne(query);
	}

	public void removeManyCliente(Bson query) {
		collection.deleteMany(query);
	}

	public FindIterable<Document> findAllCliente(){
		FindIterable<Document> clientes = collection.find();
		return clientes;
	}
	
	public FindIterable<Document> findFilteredCliente(Bson query, Bson sort){
		FindIterable<Document> clientes = collection.find(query);
		if (sort != null) {
			clientes.sort(sort);
		}
		return clientes;
	}
	
}
