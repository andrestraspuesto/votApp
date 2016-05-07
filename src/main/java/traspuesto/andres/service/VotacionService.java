
package traspuesto.andres.service;

import traspuesto.andres.domain.Item;
import traspuesto.andres.domain.Voto;
import traspuesto.andres.exception.FueraDeFechaException;
import traspuesto.andres.exception.VotanteErroneoException;
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
     * @throws traspuesto.andres.exception.VotanteErroneoException 
     * @throws traspuesto.andres.exception.SuperaVotosException 
     * @throws traspuesto.andres.exception.FueraDeFechaException 
     */
    Item votar(Voto voto) throws VotanteErroneoException, SuperaVotosException, FueraDeFechaException;
    
    
}
