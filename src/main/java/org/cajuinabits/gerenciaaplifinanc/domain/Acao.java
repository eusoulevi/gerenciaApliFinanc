package org.cajuinabits.gerenciaaplifinanc.domain;

/**
 *
 * @author levi.soares
 */
import java.sql.Timestamp;
import javax.persistence.Entity;

@Entity(name = "acoes")
public class Acao extends CotaImpl {
    
    private Setor setor;
    
    public Acao () {}
    
    public Acao(Double cotacao, Timestamp t) {
        super(cotacao, t);
    }
    
    public Setor getSetor() {
        return this.setor;
    }
    
    public void setSetor(Setor setor) {
        this.setor = setor;
    }

}
