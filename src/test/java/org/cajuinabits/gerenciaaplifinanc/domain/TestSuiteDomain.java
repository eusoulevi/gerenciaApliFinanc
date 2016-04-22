
package org.cajuinabits.gerenciaaplifinanc.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author levi.soares
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({org.cajuinabits.gerenciaaplifinanc.domain.InvestimentoImplTest.class, 
                     org.cajuinabits.gerenciaaplifinanc.domain.CotaImplTest.class,
                     org.cajuinabits.gerenciaaplifinanc.domain.OperacaoImplIT.class})
public class TestSuiteDomain {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
