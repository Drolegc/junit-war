package uytube.models;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import uytube.models.Usuario;
import uytube.models.Video;
import uytube.models.Lista;
import uytube.models.Categoria;
/**
 * @author imssbora
 */
public class HibernateUtil {
  private static StandardServiceRegistry registry;
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        StandardServiceRegistryBuilder registryBuilder = 
            new StandardServiceRegistryBuilder();

        Map<String, String> settings = new HashMap<>();
        settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/uytube");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.hbm2ddl.auto", "update");

        registryBuilder.applySettings(settings);

        registry = registryBuilder.build();

        MetadataSources sources = new MetadataSources(registry)
            .addAnnotatedClass(Usuario.class)
            .addAnnotatedClass(Categoria.class)
            .addAnnotatedClass(Video.class)
            .addAnnotatedClass(Canal.class)
            .addAnnotatedClass(Comentario.class)
            .addAnnotatedClass(Lista.class)
        	.addAnnotatedClass(ValoracionVideo.class);

        Metadata metadata = sources.getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
      } catch (Exception e) {
    	  System.out.println(e);
    	 if (registry != null) {
          StandardServiceRegistryBuilder.destroy(registry);
        }
      }
    }
    return sessionFactory;
  }

  public static void shutdown() {
    if (registry != null) {
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }
}
