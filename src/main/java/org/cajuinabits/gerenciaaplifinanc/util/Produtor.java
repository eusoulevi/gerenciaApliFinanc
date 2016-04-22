
package org.cajuinabits.gerenciaaplifinanc.util;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import org.cajuinabits.gerenciaaplifinanc.domain.Cotacao;
import org.cajuinabits.gerenciaaplifinanc.domain.CotacaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author levi.soares
 */
@ApplicationScoped
public class Produtor {
    
//    public Produtor() {
//    }
    
    /**
     *
     * @param injectionPoint
     * @return
     */
    @Produces
    public Logger createLogger( InjectionPoint injectionPoint ) {        
        Class classe = injectionPoint.getMember().getDeclaringClass();
        final Logger logger = LoggerFactory.getLogger(classe.getName());
        return logger;
    }

    /**
     *
     */
    @Produces @Named("criaListaCotacoes")
    public List criaListaCotacoes() {
        return new ArrayList<>();
    }
    
    @Produces
    public Timestamp createCalendar() {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        return timeStamp;
    }

}
