/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package traspuesto.andres.service;

import traspuesto.andres.domain.Encuestador;
import traspuesto.andres.domain.Item;
import traspuesto.andres.domain.Votante;

/**
 * Se encarga de gestionar encuestadores, votantes e items que se pueden votar
 * 
 * @author andrestraspuesto@gmail.com
 */
public interface EncuestadorService {

    /**
     * guarda un encuestador, si no existe lo crea
     * @param encuestador
     * @return 
     */
    Encuestador guardaEncuestador(Encuestador encuestador);
    
    /**
     * guarda un votante, si no existe lo crea
     * @param votante
     * @return 
     */
    Votante guardaVotante(Votante votante);
    
    /**
     * guarda un item, si no existe lo crea
     * @param item
     * @return 
     */
    Item guardaItem(Item item);
    
    
}
