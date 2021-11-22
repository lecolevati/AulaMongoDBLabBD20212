package controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

import persistence.ClienteDao;

public class ClienteController {

	public void saveCliente() {
		ClienteDao cDao = new ClienteDao();
		
		Document cliente7 = new Document("_id", "7");
		cliente7.append("nome", "Karma Kameleon")
				.append("email", "karma@kameleon.com");

		Document cliente8 = new Document("_id", "8");
		cliente8.append("nome", "Layla Got On My Knees")
				.append("email", "layla@got.com");

		Document cliente9 = new Document("_id", "9");
		cliente9.append("nome", "Charlie Brown")
				.append("email", "charlie@brown.com")
				.append("telefone", "977777777");
		
		List<Document> clientes = new ArrayList<Document>();
		clientes.add(cliente8);
		clientes.add(cliente9);
		
		cDao.insertOneCliente(cliente7);
		cDao.insertManyCliente(clientes);
	}

	public void modifyCliente() {
		ClienteDao cDao = new ClienteDao();
		
		Bson query1 = Filters.eq("_id", "8");
		Bson updtObj1 = Updates.set("email", "layla@goton.com");
		
		Bson query2 = Filters.gte("_id","7");
		Bson updtObj2 = Updates.set("credito", "1950.00");
		
		cDao.updateOneCliente(query1, updtObj1);
		cDao.updateManyCliente(query2, updtObj2);
	}
	
	public void deleteCliente() {
		ClienteDao cDao = new ClienteDao();
		
		Bson query1 = Filters.eq("_id","9");
		cDao.removeOneCliente(query1);
	}
	
	public void selectCliente() {
		ClienteDao cDao = new ClienteDao();
		FindIterable<Document> clientes = cDao.findAllCliente();
		for (Document d : clientes) {
			System.out.println(d.toJson());
		}
		
		System.out.print("===============================================================================");
		System.out.print("===============================================================================");
		System.out.println("===============================================================================");
		
		ArrayList<Document> listClientes = clientes.into(new ArrayList<Document>());		
		listClientes.forEach(d -> System.out.println(d.toJson()));

		System.out.print("===============================================================================");
		System.out.print("===============================================================================");
		System.out.println("===============================================================================");
		
		Bson query = Filters.lt("credito", "3000.00");
		FindIterable<Document> clientesFiltrados = cDao.findFilteredCliente(query, null);
		for (Document d : clientesFiltrados) {
			System.out.println(d.toJson());
		}
		
		System.out.print("===============================================================================");
		System.out.print("===============================================================================");
		System.out.println("===============================================================================");
		
		Bson sort = Sorts.ascending("nome");
		FindIterable<Document> clientesFiltradosOrdenados = 
				cDao.findFilteredCliente(query, sort);
		for (Document d : clientesFiltradosOrdenados) {
			System.out.println(d.toJson());
		}
	}
	
}
