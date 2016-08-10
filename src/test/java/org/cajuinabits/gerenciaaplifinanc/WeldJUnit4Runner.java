
package org.cajuinabits.gerenciaaplifinanc;


import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;
import org.cajuinabits.gerenciaaplifinanc.interfaces.Padrao;
import org.cajuinabits.gerenciaaplifinanc.util.Produtor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 *
 * @author levi.soares
 */

public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {
    private final Class klass;
    private final Weld weld;
    private final WeldContainer container;
    
    public WeldJUnit4Runner(final Class klass) throws InitializationError {
        super(klass);
        this.klass = klass;
        Class [] classes = {Acao.class, Produtor.class, org.slf4j.LoggerFactory.class, 
                        NonexistentEntityException.class, Padrao.class};
        this.weld = new Weld().enableDiscovery().addPackages(true,classes);
        this.container = weld.initialize();
    }
    
    @Override
    protected Object createTest() throws Exception {
        final Object test = container.instance().select(klass).get();
        return test;
    }    
}
