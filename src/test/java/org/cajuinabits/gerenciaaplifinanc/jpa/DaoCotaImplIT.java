package org.cajuinabits.gerenciaaplifinanc.jpa;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.domain.Cota;
import org.cajuinabits.gerenciaaplifinanc.domain.Setor;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class DaoCotaImplIT {
    @Inject
    public static DaoCotaImpl dao;
    
    public DaoCotaImplIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class DaoCotaImpl.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Cota cota = new Acao();
        cota.setSigla("TEST");
        cota.setDescricao("Teste");
        cota.setTipo("PN");
        Acao expResult = (Acao)cota;
        expResult.setSetor(Setor.AGROPECUARIA);
        dao.create(expResult);
        Cota result = dao.find(1);
        assertEquals(expResult, cota);
    }

    /**
     * Test of delete method, of class DaoCotaImpl.
     */
    @Test
    public void testDelete() throws NonexistentEntityException {
        System.out.println("delete");
        long id = 0L;
        DaoCotaImpl instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DaoCotaImpl.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Cota cota = null;
        DaoCotaImpl instance = null;
        instance.edit(cota);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DaoCotaImpl.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        long id = 0L;
        DaoCotaImpl instance = null;
        instance.find(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntityManager method, of class DaoCotaImpl.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaoCotaImpl instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
