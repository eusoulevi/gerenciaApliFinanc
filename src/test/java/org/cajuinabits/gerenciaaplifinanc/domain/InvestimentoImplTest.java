
package org.cajuinabits.gerenciaaplifinanc.domain;

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
public class InvestimentoImplTest {
    
    public InvestimentoImplTest() {
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
     * Test of getCapitalInvestido method, of class InvestimentoImpl.
     */
    @Test
    public void testGetCapitalInvestido() {
        System.out.println("getCapitalInvestido");
        Double corretagem = 10.41;
        Double emolumentos = 1.51;
        Double impostos = 10.41;
        int quantidade = 100;
        Double valorAcao = 10.01;
        Cotacao c = new CotacaoImpl(valorAcao);
        Acao acao = new Acao();
        acao.addCotacao(c);
        OperacaoImpl operacao = new OperacaoImpl(corretagem, emolumentos, impostos);
        operacao.setCota(acao);
        operacao.setQuantidade(quantidade);
        InvestimentoImpl investimento = new InvestimentoImpl();
        investimento.setOperacao(operacao);
        Double expResult = acao.getValorAtual() * operacao.getQuantidade();
        
        Double result = investimento.getCapitalInvestido();
        System.out.println("Capital Investido: " + result);

        assertEquals("", expResult, result, 0.001);
    }

    /**
     * Test of ganhoRealValorizacao method, of class InvestimentoImpl.
     */
    @Test
    public void testGanhoRealValorizacao() {
        System.out.println("ganhoRealValorizacao");
        int quantidade = 100;
        Double valorCompra = 9.99;
        InvestimentoImpl investimento = new InvestimentoImpl();
        Double corretagem = 9.41;
        Double emolumentos = 0.49;
        Double impostos = 0.10;
        Operacao operacao = new OperacaoImpl(corretagem, emolumentos, impostos);
        Acao acao = new Acao();
        Cotacao cotacao = new CotacaoImpl(valorCompra);
        acao.addCotacao(cotacao);
        operacao.setQuantidade(quantidade);
        operacao.setCota(acao);
        investimento.setOperacao(operacao);
        Double valorAtual = 10.989;
        Double expResult = (valorAtual * quantidade) - ((valorCompra * quantidade) - corretagem 
                - emolumentos - impostos);
        acao.addCotacao(new CotacaoImpl(valorAtual));
        Double result = investimento.ganhoRealValorizacao();
        
        System.out.println("Ganho Real com Valorizacao: " + result);
        System.out.println("Ganho Real com Valorizacao: " + expResult);
        assertEquals("",expResult, result,0.01);
    }

    /**
     * Test of getTotal method, of class InvestimentoImpl.
     */
    @Test
    public void testGetTotalInvestido() {
        System.out.println("getTotalInvestido");
        Double corretagem = 9.41;
        Double emolumentos = 0.49;
        Double impostos = 0.10;
        Double valor = 12.01;
        int quant = 100;
        Acao acao = new Acao(new CotacaoImpl(valor));
        Operacao operacao = new OperacaoImpl(corretagem, emolumentos, impostos, acao, quant);
        InvestimentoImpl investimento = new InvestimentoImpl(operacao);
        Double expResult = (quant * valor) - corretagem - emolumentos - impostos;
        Double result = investimento.getTotalInvestido();
        assertEquals(expResult, result);
    }

    /**
     * Test of juros method, of class InvestimentoImpl.
     */
    @Test
    public void testJuros() {
        System.out.println("juros");
        InvestimentoImpl investimento = new InvestimentoImpl();
        double expResult = 0.0;
        double result = investimento.juros();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPeriodo method, of class InvestimentoImpl.
     */
    @Test
    public void testGetPeriodo() {
        System.out.println("getPeriodo");
        InvestimentoImpl instance = new InvestimentoImpl();
        int expResult = 0;
        int result = instance.getPeriodo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ganhoReal method, of class InvestimentoImpl.
     */
    @Test
    public void testGanhoReal() {
        System.out.println("ganhoReal");
        double inflacao = 0.0;
        InvestimentoImpl instance = new InvestimentoImpl();
        Double expResult = null;
        Double result = instance.ganhoReal(inflacao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
