package org.cajuinabits.gerenciaaplifinanc.domain;

import static java.lang.Thread.sleep;
import java.sql.Timestamp;
import javax.inject.Inject;
import org.cajuinabits.gerenciaaplifinanc.WeldJUnit4Runner;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author levi.soares
 */
@RunWith(Arquillian.class)
public class CotaImplTest {
    
    public CotaImplTest() {
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
     * Test of addCotacao method, of class CotaImpl.
     */
    @Inject
    Stock instance;
    @Inject
    Cotacao expResult;
    
    @Test
    public void testAddCotacao() {
        System.out.println("addCotacao");
        Double valor = new Double(10);
        expResult.setValor(valor);
        instance.addCotacao(expResult);
        Cotacao result = instance.getHistorico().get(0);
        Cotacao expResult2 = new CotacaoImpl();
        expResult2.setValor(20.0);
        instance.addCotacao(expResult2);
        Cotacao result2 = instance.getHistorico().get(1);
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getValor method, of class CotaImpl.
     */
    @Test
    public void testGetValor() throws InterruptedException {
        System.out.println("getValor");
        CotaImpl acao = new Acao();
        Timestamp t1 = new Timestamp(System.nanoTime());
        Cotacao cotacaoPrimeira = new CotacaoImpl(10.01,t1);
 
        sleep(1);
        Timestamp t2 = new Timestamp(System.nanoTime());
        Cotacao cotacao2 = new CotacaoImpl(11.99,t2);

        sleep(1);
        Cotacao cotacaoUltima = new CotacaoImpl(13.0,new Timestamp(System.currentTimeMillis()));
        Timestamp t3 = cotacaoUltima.getDatetime();
        
        acao.addCotacao(cotacaoPrimeira);
        acao.addCotacao(cotacaoUltima);
        acao.addCotacao(cotacao2);
        
        Double expResult1 = cotacaoPrimeira.getValor();
        Double result1 = acao.getValor(t1);

        Double expResult2 = cotacao2.getValor();
        Double result2 = acao.getValor(t2);
        
        Double expResult3 = cotacaoUltima.getValor();
        Double result3 = acao.getValor(t3);
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of getValorAtual method, of class CotaImpl.
     */
    @Inject
    Cotacao cotacao1;
    @Test
    public void testGetValorAtual() throws InterruptedException {
        System.out.println("getValorAtual");
        cotacao1.setValor(10.0);
        CotaImpl acao = new Acao();
        sleep(100);
        Cotacao cotacao2 = new CotacaoImpl(11.0);
        sleep(100);
        Cotacao cotacao3 = new CotacaoImpl(14.0);
        sleep(100);
        Cotacao cotacao4 = new CotacaoImpl(12.0);
        sleep(100);
        Cotacao cotacaoUltima = new CotacaoImpl(13.0);
        
        acao.addCotacao(cotacao1);
        acao.addCotacao(cotacaoUltima);
        acao.addCotacao(cotacao2);
        acao.addCotacao(cotacao3);
        acao.addCotacao(cotacao4);
        
        Double expResult = cotacaoUltima.getValor();
        Double result = acao.getValorAtual();
        assertEquals(expResult, result);

        Cotacao expResult2 = new CotacaoImpl(20.0, new Timestamp(System.currentTimeMillis()));
        acao.addCotacao(expResult2);
        Double result2 = acao.getValorAtual();
        
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getCotacaoMax method, of class CotaImpl.
     */
    @Test
    public void testGetValorMax() throws InterruptedException {
        System.out.println("getValorMax");
        CotaImpl acao = new Acao();
        Cotacao cotacao1 = new CotacaoImpl(10.0);
        sleep(100);
        Cotacao cotacao2 = new CotacaoImpl(11.0);
        sleep(100);
        Cotacao cotacaoMaxima = new CotacaoImpl(14.0);
        sleep(100);
        Cotacao cotacao3 = new CotacaoImpl(12.0);
        sleep(100);
        Cotacao cotacao4 = new CotacaoImpl(13.0);
        
        acao.addCotacao(cotacao1);
        acao.addCotacao(cotacao2);
        acao.addCotacao(cotacaoMaxima);
        acao.addCotacao(cotacao3);
        acao.addCotacao(cotacao4);
        
        Double expResult = cotacaoMaxima.getValor();
        Cotacao result = acao.getCotacaoMax();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetValorMin method, of class CotaImpl.
     */
    @Test
    public void testGetValorMin() throws InterruptedException {
        System.out.println("getValorMin");
        CotaImpl acao = new Acao();
        Cotacao cotacao1 = new CotacaoImpl(10.0);
        sleep(100);
        Cotacao cotacao2 = new CotacaoImpl(11.0);
        sleep(100);
        Cotacao cotacaoMaxima = new CotacaoImpl(14.0);
        sleep(100);
        Cotacao cotacaoMin = new CotacaoImpl(9.0);
        sleep(100);
        Cotacao cotacao4 = new CotacaoImpl(13.0);
        
        acao.addCotacao(cotacao1);
        acao.addCotacao(cotacao2);
        acao.addCotacao(cotacaoMaxima);
        acao.addCotacao(cotacaoMin);
        acao.addCotacao(cotacao4);
        
        Double expResult = cotacaoMin.getValor();
        Cotacao result = acao.getCotacaoMin();
        assertEquals(expResult, result);
    }
    
}
