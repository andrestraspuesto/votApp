

package traspuesto.andres.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
@Entity
@Table(name = "item")
@XmlRootElement
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Size(max = 450)
    @Column(name = "uri")
    private String uri;
    
    @Column(name = "puntuacion_min")
    private Integer puntuacionMin;
    
    @Column(name = "puntuacion_max")
    private Integer puntuacionMax;
    
    @Column(name = "puntuacion_acum")
    private Integer puntuacionAcum;
    
    @Column(name = "votos_acum")
    private Integer votosAcum;
    
    @Column(name = "max_votos_votante")
    private Integer maxVotosVotante;
    
    @Column(name = "encuestador_id")
    private Long encuestadorId;
    
    @Column(name = "voto_anonimo")
    private Boolean votoAnonimo;

    
    public Item() {
    }

    public Item(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPuntuacionAcum() {
        return puntuacionAcum;
    }

    public void setPuntuacionAcum(Integer puntuacionAcum) {
        this.puntuacionAcum = puntuacionAcum;
    }

    public Integer getVotosAcum() {
        return votosAcum;
    }

    public void setVotosAcum(Integer votosAcum) {
        this.votosAcum = votosAcum;
    }

    public Integer getMaxVotosVotante() {
        return maxVotosVotante;
    }

    public void setMaxVotosVotante(Integer maxVotosVotante) {
        this.maxVotosVotante = maxVotosVotante;
    }

    public Long getEncuestadorId() {
        return encuestadorId;
    }

    public void setEncuestadorId(Long encuestadorId) {
        this.encuestadorId = encuestadorId;
    }

    public Boolean getVotoAnonimo() {
        return votoAnonimo;
    }

    public void setVotoAnonimo(Boolean votoAnonimo) {
        this.votoAnonimo = votoAnonimo;
    }
    
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getPuntuacionMin() {
        return puntuacionMin;
    }

    public void setPuntuacionMin(Integer puntuacionMin) {
        this.puntuacionMin = puntuacionMin;
    }

    public Integer getPuntuacionMax() {
        return puntuacionMax;
    }

    public void setPuntuacionMax(Integer puntuacionMax) {
        this.puntuacionMax = puntuacionMax;
    }

    public Integer getNumVotosMax() {
        return maxVotosVotante;
    }

    public void setNumVotosMax(Integer numVotosMax) {
        this.maxVotosVotante = numVotosMax;
    }

    public Long getEncuestador() {
        return encuestadorId;
    }

    public void setEncuestador(Long encuestadorId) {
        this.encuestadorId = encuestadorId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item[ id=" + id + " ]";
    }

}
