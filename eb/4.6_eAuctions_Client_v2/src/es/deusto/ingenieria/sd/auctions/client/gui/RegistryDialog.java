package es.deusto.ingenieria.sd.auctions.client.gui;

import es.deusto.ingenieria.sd.auctions.client.controller.SesionController;

public class RegistryDialog {
	
	public SesionController controller;
	
	private String email = "sample@gmail.com";
	private String password = "12345";	

	public RegistryDialog(SesionController controller) {
		this.controller = controller;
	}
	
	public void login() {
		System.out.println(" - Login into the server: '" + email + "' - '" + password + "'");
		
		boolean loginResult = controller.login(email, password);
		
		System.out.println("    * Login result: " + loginResult);
	}
}