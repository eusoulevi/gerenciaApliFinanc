package org.cajuinabits.gerenciaaplifinanc.domain;

/**
 *
 * @author levi.soares
 */
import java.sql.Timestamp;
import javax.persistence.Entity;

@Entity(name = "acoes")
public class Acao extends CotaImpl implements Stock {
    
    private Setor setor;
    
    public Acao () {}    
    
    public Setor getSetor() {
        return this.setor;
    }
    
    public void setSetor(Setor setor) {
        this.setor = setor;
    }

}
