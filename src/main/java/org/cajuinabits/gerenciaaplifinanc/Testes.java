package org.cajuinabits.gerenciaaplifinanc;

import javax.persistence.EntityManagerFactory;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.domain.Cota;
import org.cajuinabits.gerenciaaplifinanc.domain.Setor;
import org.cajuinabits.gerenciaaplifinanc.jpa.DaoCotaImpl;

/**
 *
 * @author levi.soares
 */
public class Testes {

    public static void main(String[] args) throws Exception {
        salvarCotacao();
    }
    
    public static void salvarAcao() throws Exception {
        EntityManagerFactory emf = Util.getInstance();
        DaoCotaImpl dao = new DaoCotaImpl(emf);
        Cota cota = new Acao();
        cota.setSigla("TEST");
        cota.setDescricao("Teste");
        cota.setTipo("PN");
        Acao expResult = (Acao)cota;
        expResult.setSetor(Setor.AGROPECUARIA);
        dao.create(expResult);
        emf.close();
    }
    
    public static void salvarCotacao() throws Exception {
        EntityManagerFactory emf = Util.getInstance();
        DaoCotaImpl dao = new DaoCotaImpl(emf);
        Cota cota = new Acao();
        cota.setSigla("TEST");
        cota.setDescricao("Teste");
        cota.setTipo("PN");
        Acao expResult = (Acao)cota;
        expResult.setSetor(Setor.AGROPECUARIA);
        dao.create(expResult);
        emf.close();
    }
}
