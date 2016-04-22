
package org.cajuinabits.gerenciaaplifinanc.domain;

import javax.inject.Inject;
import org.cajuinabits.gerenciaaplifinanc.WeldJUnit4Runner;
import org.cajuinabits.gerenciaaplifinanc.util.Produtor;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author levi
 */
@RunWith(WeldJUnit4Runner.class)
public class AcaoArquilianTest {

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive jar;
        jar = ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackages(true,Acao.class.getPackage(), Produtor.class.getPackage())
//                .addClasses(CotaImpl.class, Produtor.class, Acao.class, Cota.class)
//                .addAsManifestResource("beans.xml");
                .addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }
        
    @Inject
    public Stock instance;
    @Inject
    public Cotacao cotacao;
    
    @Test
    public void testAddCotacao() {
        System.out.println("addCotacao");
        Double valor = 10.0;
        cotacao.setValor(valor);
        instance.addCotacao(cotacao);
        Cotacao result = instance.getHistorico().get(0);
        Cotacao expResult2 = new CotacaoImpl(20.0, null);
        instance.addCotacao(expResult2);
        Cotacao result2 = instance.getHistorico().get(1);
        assertEquals(cotacao, result);
        assertEquals(expResult2, result2);
    }
    
}
