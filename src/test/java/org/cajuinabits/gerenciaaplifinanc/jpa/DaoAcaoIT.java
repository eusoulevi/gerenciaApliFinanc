
package org.cajuinabits.gerenciaaplifinanc.jpa;

import javax.inject.Inject;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.domain.CotacaoImpl;
import org.cajuinabits.gerenciaaplifinanc.domain.Setor;
import org.cajuinabits.gerenciaaplifinanc.domain.Stock;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author levi.soares
 */
public class DaoAcaoIT {
//    public static EntityManagerFactory emf;
    @Inject
    public DaoAcao dao;

    public DaoAcaoIT() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NonexistentEntityException {
    }
    
    @AfterClass
    public static void tearDownClass() {
//       emf.close();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Inject
    Stock expResult;
    
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        String sigla = "TEST1";

        expResult.setSigla(sigla);
        expResult.addCotacao(new CotacaoImpl(10.01));
        expResult.setDescricao("Teste Create");
        expResult.setTipo("PN");
        expResult.setSetor(Setor.AGROPECUARIA);
        dao.create((Acao) expResult);
        Acao result = dao.find(sigla);
        assertEquals(expResult, result);
    }
    
    public Stock acao;
    @Ignore
    public void testDelete() throws NonexistentEntityException {
        System.out.println("delete");
        String sigla = "TEST2";

        acao.setSigla(sigla);
        acao.addCotacao(new CotacaoImpl(12.01));
        acao.setDescricao("Teste destroy");
        acao.setTipo("ON");
        acao.setSetor(Setor.AGUA);
        dao.create((Acao) acao);
        Acao find = dao.find(sigla);
        System.out.println(find);
        dao.destroy(find.getIdCota());
        
        Acao result =  dao.find(sigla);
        assertNull("Acao Eliminada com sucesso" + sigla, result);
    }
    
//    @Ignore
//    public void testFind() {
//        System.out.println("find(String sigla)");
//        String sigla = "TEST3";
//        Acao expResult = new Acao(sigla, 12.01, null);
//        expResult.setDescricao("Test find");
//        expResult.setTipo("PN");
//        expResult.setSetor(Setor.FINANCEIRO);
//        dao.create(expResult);
//        Acao result = (Acao) dao.find(sigla);
//        assertEquals(expResult.getDescricao(), result.getDescricao());
//        assertEquals(expResult.getSigla(), result.getSigla());
//        assertEquals(expResult.getTipo(), result.getTipo());
//    }
        
}
