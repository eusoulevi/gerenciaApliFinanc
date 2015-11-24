
package org.cajuinabits.gerenciaaplifinanc.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
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

    public Acao find(String sigla);
    
    public Acao find(long id);

    public List<Acao> findEntities();

    public List<Acao> findEntities(int maxResults, int firstResult);

    public int getAcaoCount();

    public EntityManager getEntityManager();
    
}
