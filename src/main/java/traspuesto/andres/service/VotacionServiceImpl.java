

package traspuesto.andres.service;

import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traspuesto.andres.dao.ItemDao;
import traspuesto.andres.dao.VotanteDao;
import traspuesto.andres.dao.VotoDao;
import traspuesto.andres.domain.Encuestador;
import traspuesto.andres.domain.Item;
import traspuesto.andres.domain.Votante;
import traspuesto.andres.domain.Voto;
import traspuesto.andres.exception.FueraDeFechaException;
import traspuesto.andres.exception.VotanteErroneoException;
import traspuesto.andres.exception.SuperaVotosException;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
@Service
@Transactional
public class VotacionServiceImpl implements VotacionService{
    
    @Autowired
    VotoDao votoDao;
    
    @Autowired
    ItemDao itemDao;
    
    @Autowired
    VotanteDao votanteDao;

    @Override
    public Item votar(Voto voto)
            throws VotanteErroneoException, SuperaVotosException, FueraDeFechaException {        
        Votante votante = votanteDao.findOne(voto.getVotanteId());
        Item item = itemDao.findOne(voto.getItemId());
        
        
        
        //Compruebo si el votante e item son coherentes con el encuestador
        boolean votanteErroneo = validaVotante(votante, item);        
        if(votanteErroneo){
            throw new VotanteErroneoException();
        }
        
        //Compruebo si la fecha esta dento del rango 
        boolean votoFueraDeFecha = validaFechaItem(item);
        if(votoFueraDeFecha){
            throw new FueraDeFechaException();
        }
        //Compruebo si el votante no ha superado el cupo de votos para el item
        Integer nVotos =
                votoDao.countByItemIdAndVotanteId(item.getId(), votante.getId());
        if(nVotos >=item.getMaxVotosVotante()){
            throw new SuperaVotosException();
        }
        
        Integer currVot =item.getVotosAcum()== null?0:item.getVotosAcum();
        item.setVotosAcum(currVot + 1);
        
        Integer curPtos = item.getPuntuacionAcum() == null? 0: item.getPuntuacionAcum();
        Integer ptos = voto.getPuntuacion() == null? 0:voto.getPuntuacion();
        if(ptos < item.getPuntuacionMin()){
            ptos = item.getPuntuacionMin();
        } else if(ptos > item.getPuntuacionMax()){
            ptos = item.getPuntuacionMax();
        }
        ptos = curPtos + voto.getPuntuacion();
        item.setPuntuacionAcum(ptos);
        
        if(item.getVotoAnonimo()){
            //Si el voto es anonimo igualo a cero la puntuacion
            voto.setPuntuacion(0);
        }
        voto.setFecha(LocalDateTime.now());
        
        itemDao.save(item);
        votoDao.save(voto);
        
        return item;
    }
    
    /**
     * Comprueba si el votante y el item pertenecen al mismo encuestador
     * @param votante
     * @param item
     * @return 
     */
    private boolean validaVotante(Votante votante, Item item){
        boolean error = votante == null;
        if(!error){
            error = !votante.isActivo() || votante.getEncuestador() == null;
            if(!error){
                Encuestador encuestadorVot = votante.getEncuestador();
                error = !encuestadorVot.equals(item.getEncuestador());
            }
        }
        return error;
    }

    /**
     * Comprueba si la fecha está dentro de los límites de fechas hábiles
     * fecha inicio no definida se considera que no se ha abierto el plazo
     * fecha fin no definida se considera que no hay fecha límite para votar
     * @param item
     * @return 
     */
    private boolean validaFechaItem(Item item){
        //Si fhInicioVotacion es null se considera que aun no esta abierto
        boolean error = item == null || item.getFhInicioVotacion() == null;
        if(!error){
            LocalDateTime ahora = LocalDateTime.now();
            error = ahora.isBefore(item.getFhInicioVotacion());
            LocalDateTime fhFin = item.getFhFinVotacion();
            
            //Si fhFin no esta definido se considera que no hay fecha limite
            error |= fhFin != null && ahora.isAfter(fhFin);
        }
        return error;
    }
}
