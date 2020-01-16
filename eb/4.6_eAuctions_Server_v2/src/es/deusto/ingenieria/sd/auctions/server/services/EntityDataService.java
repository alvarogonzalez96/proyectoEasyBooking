package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;
import es.deusto.ingenieria.sd.auctions.server.db.DBManager;

public class EntityDataService {
	
	private static EntityDataService instance;

	private EntityDataService() { }
	
	public static EntityDataService getInstance() {
		if (instance == null) {
			instance = new EntityDataService();
		}

		return instance;
	}

	public List<CategoryDTO> getCategories() {
		return CategoryAssembler.getInstance().entityToDTO(DBManager.getInstance().getCategories());
	}

	public List<ArticleDTO> getArticles(String category) {
		return ArticleAssembler.getInstance().entityToDTO(DBManager.getInstance().getArticles(category));
	}
}