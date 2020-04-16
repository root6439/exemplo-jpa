package programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Pessoa;

public class Main {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null, "Jaison Silva", "jayjay@gmail.com");
		Pessoa p2 = new Pessoa(null, "Jaison Silva", "jayjay@gmail.com");
		Pessoa p3 = new Pessoa(null, "Jaison Silva", "jayjay@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //verificar persistence.xml
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		
		Pessoa p4 = em.find(Pessoa.class, 1);
		System.out.println(p4);
		
		em.getTransaction().begin();
		em.remove(p4);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
