

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
@Entity
@Table(name = "votante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Votante.findAll", query = "SELECT v FROM Votante v"),
    @NamedQuery(name = "Votante.findById", query = "SELECT v FROM Votante v WHERE v.id = :id"),
    @NamedQuery(name = "Votante.findByActivo", query = "SELECT v FROM Votante v WHERE v.activo = :activo")})
public class Votante implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "activo")
    private Boolean activo;
    
    @JoinColumn(name = "aplicacion_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aplicacion aplicacionId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "votanteId")
    private List<VotanteItem> votanteItemList;

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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Aplicacion getAplicacionId() {
        return aplicacionId;
    }

    public void setAplicacionId(Aplicacion aplicacionId) {
        this.aplicacionId = aplicacionId;
    }

    @XmlTransient
    public List<VotanteItem> getVotanteItemList() {
        return votanteItemList;
    }

    public void setVotanteItemList(List<VotanteItem> votanteItemList) {
        this.votanteItemList = votanteItemList;
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
