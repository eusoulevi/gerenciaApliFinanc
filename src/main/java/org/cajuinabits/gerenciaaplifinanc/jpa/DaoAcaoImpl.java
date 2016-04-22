
package org.cajuinabits.gerenciaaplifinanc.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author levi.soares
 */
public class DaoAcaoImpl implements DaoAcao, Serializable {
    
    private static final long serialVersionUID = 28065345642899881L;

    @Inject
    private Dao dao;
    
    @Inject
    private List<Acao> acoes;
    
    @Inject
    private Logger logger;
       
    public DaoAcaoImpl() {
    }

    @Override
    public void create(Acao acao) {
        dao.create(acao);
    }

    @Override
    public void destroy(long id) throws NonexistentEntityException {
        try {
            dao.destroy(id);
        } catch (org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(Acao acao) throws NonexistentEntityException, Exception {
        dao.edit(acao);
    }

    @Override
    public Acao find(String sigla) {
        return (Acao) dao.find(sigla,Acao.class);
    }

    @Override
    public Acao find(long id) {
        return (Acao) dao.find(id, Acao.class);
    }

    @Override
    public List<Acao> list() {
        this.acoes = dao.(Acao.class);
        return acoes;
    }

    @Override
    public List<Acao> list(int maxResults, int firstResult) {
        List retorno = dao.list(maxResults, firstResult, Acao.class);
        return (List<Acao>) retorno;
    }

    @Override
    public int getCount() {
        return dao.getCount(Acao.class);
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Dao getDao() {
        return this.dao;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
       
}
