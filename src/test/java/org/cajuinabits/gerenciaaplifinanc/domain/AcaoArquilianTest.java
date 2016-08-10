
package org.cajuinabits.gerenciaaplifinanc.domain;

import javax.inject.Inject;
import org.cajuinabits.gerenciaaplifinanc.WeldJUnit4Runner;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;
import org.cajuinabits.gerenciaaplifinanc.interfaces.Padrao;
import org.cajuinabits.gerenciaaplifinanc.util.Produtor;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author levi
 */
@RunWith(WeldJUnit4Runner.class)
public class AcaoArquilianTest {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar;
        jar = ShrinkWrap.create(JavaArchive.class, "test.jar")
//                .addPackages(true,Acao.class.getPackage(), Produtor.class.getPackage(), 
//                        org.slf4j.LoggerFactory.class.getPackage(), 
//                        NonexistentEntityException.class.getPackage(), Padrao.class.getPackage())
//                .addClasses(CotaImpl.class, Produtor.class, Acao.class, Cota.class, Stock.class)
                .addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }
        
    @Inject
    public Stock instance;
    @Inject
    public Cotacao expResult;
    
    @Test
    public void testInjections() {
        assertNotNull(instance);
        assertNotNull(expResult);
    }
    
    @Test
    public void testAddCotacao() {
        System.out.println("addCotacao");
        expResult.setValor(10.0);
        instance.addCotacao(expResult);
        Cotacao result = instance.getHistorico().get(0);
        Cotacao expResult2 = new CotacaoImpl(20.0, null);
        instance.addCotacao(expResult2);
        Cotacao result2 = instance.getHistorico().get(1);
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }
    
}
