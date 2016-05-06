
package traspuesto.andres.service;

import traspuesto.andres.domain.Item;
import traspuesto.andres.domain.Voto;
import traspuesto.andres.exception.NullVotanteException;
import traspuesto.andres.exception.SuperaVotosException;

/**
 * Se encarga de gestionar la votación
 * 
 * @author andrestraspuesto@gmail.com
 */
public interface VotacionService {
    
    /**
     * 
     * @param voto
     * @return 
     */
    Item votar(Voto voto) throws NullVotanteException, SuperaVotosException;
    
    
}
