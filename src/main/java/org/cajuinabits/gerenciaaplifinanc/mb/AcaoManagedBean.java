
package org.cajuinabits.gerenciaaplifinanc.mb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;
import org.cajuinabits.gerenciaaplifinanc.jpa.DaoAcao;

/**
 *
 * @author levi.soares
 */
@ManagedBean
@RequestScoped
public class AcaoManagedBean {

    @Inject
    private DaoAcao dao;
    @Inject
    private Acao acao;
    @Inject
    private Logger logger;

    /**
     * Creates a new instance of AcaoManagedBean
     */
    public AcaoManagedBean() {
    }
    
    public void criar() {
        try {
            dao.create(acao);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletar() throws NonexistentEntityException {
        try {
            dao.destroy(acao.getIdCota());
        } catch (org.cajuinabits.gerenciaaplifinanc.jpa.exceptions.NonexistentEntityException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public Acao getAcao() {
        return this.acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }
    
}
