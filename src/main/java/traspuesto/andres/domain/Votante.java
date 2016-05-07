

package traspuesto.andres.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
@Entity
@Table(name = "votante")
@XmlRootElement
public class Votante implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "activo")
    private Boolean activo;
    
    @JoinColumn(name = "encuestador_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Encuestador encuestador;
    
    @Column(name = "fh_alta")
    private LocalDateTime fhAlta;
    
    @Column(name = "fh_baja")
    private LocalDateTime fhBaja;
    
    public Votante() {
    }

    public Votante(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFhAlta() {
        return fhAlta;
    }

    public void setFhAlta(LocalDateTime fhAlta) {
        this.fhAlta = fhAlta;
    }

    public LocalDateTime getFhBaja() {
        return fhBaja;
    }

    public void setFhBaja(LocalDateTime fhBaja) {
        this.fhBaja = fhBaja;
    }

    
    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Encuestador getEncuestador() {
        return encuestador;
    }

    public void setEncuestador(Encuestador encuestador) {
        this.encuestador = encuestador;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Votante)) {
            return false;
        }
        Votante other = (Votante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Votante[ id=" + id + " ]";
    }

}
