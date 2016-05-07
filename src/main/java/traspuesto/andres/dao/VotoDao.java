
package traspuesto.andres.dao;

import traspuesto.andres.domain.Voto;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
public interface VotoDao extends GenericDao<Voto, Long>{
    
    
    Integer countByItemIdAndVotanteId(Long itemId, Long votanteId);
    
    Integer countByItemId(Long itemId);
}
