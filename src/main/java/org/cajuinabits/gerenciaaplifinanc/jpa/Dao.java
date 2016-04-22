
package org.cajuinabits.gerenciaaplifinanc.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.cajuinabits.gerenciaaplifinanc.domain.Cota;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;

/**
 *
 * @author levi.soares
 */
public interface Dao extends Serializable {

    public void create(Cota cota);

    public void destroy(long id) throws NonexistentEntityException;

    public void edit(Cota cota) throws NonexistentEntityException, Exception;

    public Cota find(String sigla, Class c);
    
    public Cota find(long id, Class c);

    public List<Cota> findEntities(Class c);

    public List<Cota> findEntities(int maxResults, int firstResult);

    public int getCount(Class c);

    public EntityManager getEntityManager();
    
    public void setEntityManager(EntityManager manager);    
    
}
