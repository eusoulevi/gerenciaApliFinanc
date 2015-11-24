
package org.cajuinabits.gerenciaaplifinanc.mb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import org.cajuinabits.gerenciaaplifinanc.Util;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;
import org.cajuinabits.gerenciaaplifinanc.jpa.Dao;
import org.cajuinabits.gerenciaaplifinanc.jpa.DaoCotaImpl;

/**
 *
 * @author levi.soares
 */
@ManagedBean
@RequestScoped
public class AcaoManagedBean {
    private EntityManagerFactory emf;
    private final Dao dao;
    private Acao acao;

    /**
     * Creates a new instance of AcaoManagedBean
     */
    public AcaoManagedBean() {
        acao = new Acao();
        emf = Util.getInstance();
        dao = new DaoCotaImpl(emf);
    }
    
    public void criar() {
        try {
            dao.create(acao);
        } catch (Exception ex) {
            Logger.getLogger(AcaoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletar() throws NonexistentEntityException {
        dao.destroy(acao.getIdCota());
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Acao getAcao() {
        return this.acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }
    
}
