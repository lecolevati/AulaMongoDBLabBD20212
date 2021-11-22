package view;

import controller.ClienteController;

public class Principal {
	
	public static void main(String[] args) {
		ClienteController cCont = new ClienteController();
//		cCont.saveCliente();
//		cCont.modifyCliente();
//		cCont.deleteCliente();
		cCont.selectCliente();
	}
	
}
