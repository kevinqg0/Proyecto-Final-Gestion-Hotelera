package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import interfaces.IUsuario;
import model.Usuario;

public class ClassUsuarioImp implements IUsuario{
	private static final String PERSISTENCE_UNIT_NAME = "ProyectoGestionHotelera";
    private static EntityManagerFactory factory;

    public ClassUsuarioImp() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @Override
    public Usuario validate(String username, String password) {
        EntityManager em = factory.createEntityManager();
        Usuario user = null;
        try {
            user = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.logUsu = :username AND u.pasUsu = :password", Usuario.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Usuario no encontrado
        } finally {
            em.close();
        }
        return user;
    }

    @Override
    public void createUser(Usuario user) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Usuario findUserById(int id) {
        EntityManager em = factory.createEntityManager();
        Usuario user = null;
        try {
            user = em.find(Usuario.class, id);
        } finally {
            em.close();
        }
        return user;
    }

    @Override
    public void updateUser(Usuario user) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteUser(int id) {
        EntityManager em = factory.createEntityManager();
        try {
            Usuario user = em.find(Usuario.class, id);
            if (user != null) {
                em.getTransaction().begin();
                em.remove(user);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

} //fin de la clase
