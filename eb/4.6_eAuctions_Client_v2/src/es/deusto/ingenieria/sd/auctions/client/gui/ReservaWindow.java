package es.deusto.ingenieria.sd.auctions.client.gui;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import es.deusto.ingenieria.sd.auctions.client.controller.ReservarController;
//import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.VueloDTO;

public class ReservaWindow {
	private static NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
	public ReservarController controller;
	
	public ReservaWindow(ReservarController controller) {
		this.controller = controller;
	}

	public void busquedaWeb() {
		//Hacer
		/*System.out.println(" - Getting all the categories...");
		
		List<CategoryDTO> categories = this.controller.getCategories();
		
		for (CategoryDTO category : categories) {
			System.out.println("    * " + category.getName());
		}
		*/
	}

	public void reserva(Cliente cliente, String nReserva, Vuelo vuelo, int nPersonas) { 
		//Hacer
		/*String category = "iPad";
		
		System.out.println(" - Getting the products for the category '" + category + "'");
		
		List<ArticleDTO> articles = this.controller.getArticles(category);
		
		for (ArticleDTO article : articles) {
			System.out.println("    * " + article.getNumber() + " - " + article.getTitle() + " - " + numberFormatter.format(article.getActualPrice()));
		}*/
		
		this.controller.reserva(cliente, nReserva, vuelo, nPersonas);
	}
}