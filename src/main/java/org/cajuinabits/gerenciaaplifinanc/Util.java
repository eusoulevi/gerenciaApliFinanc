
package org.cajuinabits.gerenciaaplifinanc;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author levi
 */
public class Util {
    static EntityManagerFactory emf;
    
    public static EntityManagerFactory getInstance() {
        emf = Persistence.createEntityManagerFactory("default");
        return emf;
    }
}