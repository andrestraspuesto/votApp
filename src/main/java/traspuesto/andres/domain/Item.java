

package traspuesto.andres.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Integer puntuacionMin;
    
    @Column(name = "puntuacion_max")
    @NotNull
    private Integer puntuacionMax;
    
    @Column(name = "puntuacion_acum")
    private Integer puntuacionAcum;
    
    @Column(name = "votos_acum")
    private Integer votosAcum;
    
    @Column(name = "max_votos_votante")
    @NotNull
    private Integer maxVotosVotante;
    
    @JoinColumn(name = "encuestador_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Encuestador encuestador;
    
    @Column(name = "voto_anonimo", columnDefinition="tinyint(1) default 0")
    private Boolean votoAnonimo;

    @Column(name = "fh_inicio_votacion")
    private LocalDateTime fhInicioVotacion;
    
    @Column(name = "fh_fin_votacion")
    private LocalDateTime fhFinVotacion;
    
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

    public LocalDateTime getFhFinVotacion() {
        return fhFinVotacion;
    }

    public void setFhFinVotacion(LocalDateTime fhFinVotacion) {
        this.fhFinVotacion = fhFinVotacion;
    }

    public LocalDateTime getFhInicioVotacion() {
        return fhInicioVotacion;
    }

    public void setFhInicioVotacion(LocalDateTime fhInicioVotacion) {
        this.fhInicioVotacion = fhInicioVotacion;
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

    public Encuestador getEncuestador() {
        return encuestador;
    }

    public void setEncuestador(Encuestador encuestador) {
        this.encuestador = encuestador;
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
