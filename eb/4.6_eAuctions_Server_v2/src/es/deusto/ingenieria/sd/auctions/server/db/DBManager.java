package es.deusto.ingenieria.sd.auctions.server.db;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.auctions.server.data.Credito;
import es.deusto.ingenieria.sd.auctions.server.data.Aeropuerto;
import es.deusto.ingenieria.sd.auctions.server.data.Aerolinea;
import es.deusto.ingenieria.sd.auctions.server.data.Cliente;
import es.deusto.ingenieria.sd.auctions.server.data.FormaDePago;
import es.deusto.ingenieria.sd.auctions.server.data.PayPal;
import es.deusto.ingenieria.sd.auctions.server.data.Reserva;
import es.deusto.ingenieria.sd.auctions.server.data.Vuelo;

public class DBManager {	
	private static DBManager instance = null;
	private PersistenceManagerFactory pmf = null;
	
	private DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");		
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
			instance.initializeData();
		}		
		
		return instance;
	}
	
	public void deleteData() {
		List<User> users = DBManager.getInstance().getUsers();
		
		for (Cliente cliente : clientes) {
			DBManager.getInstance().deleteObjectFromDB(user);
		}
	}
	
	public void deleteObjectFromDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println(" * Delete an object: " + object);
			
			pm.deletePersistent(object);
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	public void storeObjectInDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("  * Storing an object: " + object);
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	public void store(Cliente cliente) {
		DBManager.getInstance().storeObjectInDB(cliente);	
	}
	
	public void store(Aerolinea aerolinea) {
		DBManager.getInstance().storeObjectInDB(aerolinea);	
	}

	public void store(Aeropuerto aeropuerto) {
		DBManager.getInstance().storeObjectInDB(aeropuerto);	
	}

	public void store(Reserva reserva) {
		DBManager.getInstance().storeObjectInDB(reserva);	
	}

	public void store(Vuelo vuelo) {
		DBManager.getInstance().storeObjectInDB(vuelo);
	}
	
	public List<Vuelo> getVuelos() {
		List<Vuelo> vuelos = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all the Vuelos");

			tx.begin();
			
			Extent<Vuelo> extent = pm.getExtent(Vuelo.class, true);

			for (Vuelo vuelo : extent) {
				vuelos.add(vuelo);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Vuelos: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return vuelos;		
	}

/*	public Article getArticle(long number) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Article article = null; 

		try {
			System.out.println("  * Querying an Article by number: " + number);
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Article.class.getName() + " WHERE number == " + number);
			query.setUnique(true);
			article = (Article) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying an Article: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return article;
	}
*/
	public ArrayList<Reserva> getReservas(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		ArrayList<Reserva> reservas = new ArrayList<>();

		try {
			System.out.println("  * Querying products of a Cliente: " + email);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Cliente.class.getEmail() + " WHERE name == '" + email + "'");
			query.setUnique(true);
			Cliente cliente = (Cliente) query.execute();
			
			tx.commit();
			
			if (cliente != null) {				
				HashSet<Reserva> reservasSet = (HashSet<Reserva>)cliente.getReservas();				
				reservas = new ArrayList<Reserva>(reservasSet);
			}			
		} catch (Exception ex) {
			System.out.println("  $ Error querying Reservas of a Cliente: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return reservas;
	}
/*
	public User getUser(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		User user = null; 

		try {
			System.out.println("  * Querying a User by email: " + email);
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE email == '" + email + "'");
			query.setUnique(true);
			user = (User) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return user;
	}
	*/
	/*
	public List<User> getUsers() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		List<User> users = new ArrayList<>(); 

		try {
			System.out.println("  * Querying all users");
			tx.begin();
			
			Extent<User> userExtent = pm.getExtent(User.class, true);
			
			for (User user : userExtent) {
				users.add(user);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return users;
	}
	*/
	private void initializeData() {
		System.out.println(" * Initializing data base");
		//Create Sample data
		Cliente cliente0 = new Cliente();
		cliente0.setEmail("kike@gmail.com");
		cliente0.setPassword("kike");
						
		Cliente user1 = new User();
		cliente1.setEmail("pablo@gmail.com");
		cliente1.setPassword("pablo");		
						
		Category iPadCat = new Category();
		iPadCat.setName("iPad");
		
		Category cComputer = new Category();
		cComputer.setName("Computers & Tablets ");
		
		Category cPhoto = new Category();
		cPhoto.setName("Cameras & Photography ");
		
		Category cPhone = new Category();
		cPhone.setName("Cell Phones & Accessories");

		Article iPadCover = new Article();
		iPadCover.setNumber(1);
		iPadCover.setTitle("iPad 2 Cover");
		iPadCover.setActive(true);		
		iPadCover.setInitialPrice(10.0f);
		
		iPadCat.addArticle(iPadCover);
		iPadCover.setCategory(iPadCat);
		user2.addArticle(iPadCover);
		iPadCover.setOwner(user2);
		
		Article iPadStylus = new Article();
		iPadStylus.setNumber(2);
		iPadStylus.setTitle("iPad Stylus");
		iPadStylus.setActive(true);
		iPadStylus.setInitialPrice(15.50f);		
		
		iPadCat.addArticle(iPadStylus);
		iPadStylus.setCategory(iPadCat);
		user2.addArticle(iPadStylus);
		iPadStylus.setOwner(user2);
						
		Article fujiCam = new Article();
		fujiCam.setNumber(3);
		fujiCam.setActive(true);		
		fujiCam.setTitle("Fuji FinePix S4500 (White)");
		fujiCam.setInitialPrice(145.00f);
		
		cPhoto.addArticle(fujiCam);
		fujiCam.setCategory(cPhoto);
		user0.addArticle(fujiCam);
		fujiCam.setOwner(user0);
		
		Article canonCam = new Article();
		canonCam.setNumber(4);
		canonCam.setActive(true);
		canonCam.setTitle("Canon PowerShot ELPH 310 HS (Purple)");						
		canonCam.setInitialPrice(99.99f);

		cPhoto.addArticle(canonCam);
		canonCam.setCategory(cPhoto);
		user0.addArticle(canonCam);
		canonCam.setOwner(user0);

		Article sonyCam = new Article();
		sonyCam.setNumber(5);
		sonyCam.setActive(true);		
		sonyCam.setTitle("Sony Cyber-shot DSC-W650 16MP (Black)");
		sonyCam.setInitialPrice(64.99f);
		
		cPhoto.addArticle(sonyCam);
		sonyCam.setCategory(cPhoto);
		user0.addArticle(sonyCam);
		sonyCam.setOwner(user0);
								
		Article tablet = new Article();
		tablet.setNumber(6);
		tablet.setActive(true);		
		tablet.setTitle("10.1' Android 4.03 ICS Tablet 8GB VC0882");
		tablet.setInitialPrice(107.98f);
		
		tablet.setCategory(cComputer);		
		cComputer.addArticle(tablet);
		tablet.setOwner(user1);
		user1.addArticle(tablet);
		
		Article ipad = new Article();
		ipad.setNumber(7);
		ipad.setActive(true);		
		ipad.setTitle("Apple iPad mini 64GB, Wi-Fi + 4G (AT&T)");
		ipad.setInitialPrice(560.00f);
				
		ipad.setCategory(iPadCat);		
		iPadCat.addArticle(ipad);
		ipad.setOwner(user1);
		user1.addArticle(ipad);

		Article kindle = new Article();
		kindle.setNumber(8);
		kindle.setActive(true);		
		kindle.setTitle("NEW Amazon Kindle Fire HD 32GB");
		kindle.setInitialPrice(255.50f);
		
		cComputer.addArticle(kindle);
		kindle.setCategory(cComputer);
		user1.addArticle(kindle);
		kindle.setOwner(user1);
				
		Article galaxy = new Article();
		galaxy.setNumber(9);
		galaxy.setActive(true);		
		galaxy.setTitle("Samsung Galaxy S III (T-Mobile)");
		galaxy.setInitialPrice(349.99f);
		
		cPhone.addArticle(galaxy);
		galaxy.setCategory(cPhone);
		user2.addArticle(galaxy);
		galaxy.setOwner(user2);
		
		Article iphone = new Article();
		iphone.setNumber(10);
		iphone.setActive(true);		
		iphone.setTitle("Apple iPhone 5 32GB (Sprint)");
		iphone.setInitialPrice(316.00f);
		
		cPhone.addArticle(iphone);
		iphone.setCategory(cPhone);
		user2.addArticle(iphone);
		iphone.setOwner(user2);
						
		Article motorola = new Article();
		motorola.setNumber(11);
		motorola.setActive(true);		
		motorola.setTitle("Motorola DROID RAZR XT912 LTE (Verizon)");
		motorola.setInitialPrice(318.40f);
				
		cPhone.addArticle(motorola);		
		motorola.setCategory(cPhone);
		user2.addArticle(motorola);
		motorola.setOwner(user2);
		
		try {
			//Store users in DB
			DBManager.getInstance().store(user0);
			DBManager.getInstance().store(user1);
			DBManager.getInstance().store(user2);
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}