package org.cajuinabits.gerenciaaplifinanc.domain;

import java.util.List;
import javax.persistence.Entity;
/**
 * @author levi.soares
 */
@Entity(name = "fiis")
public class Fii extends CotaImpl {
    private String administrador;
    private List<String> ativos;
        
    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void addAtivos(String ativos) {
        this.ativos.add(ativos);
    }

    public void removeAtivos(String ativo) {
        this.ativos.remove(ativo);
    }

    public List<String> getAtivos() {
        return ativos;
    }
}
