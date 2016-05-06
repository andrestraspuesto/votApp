

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
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "Item.findByUri", query = "SELECT i FROM Item i WHERE i.uri = :uri"),
    @NamedQuery(name = "Item.findByPuntuacionMin", query = "SELECT i FROM Item i WHERE i.puntuacionMin = :puntuacionMin"),
    @NamedQuery(name = "Item.findByPuntuacionMax", query = "SELECT i FROM Item i WHERE i.puntuacionMax = :puntuacionMax"),
    @NamedQuery(name = "Item.findByNumVotosMax", query = "SELECT i FROM Item i WHERE i.numVotosMax = :numVotosMax")})
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
    
    @Column(name = "num_votos_max")
    private Integer numVotosMax;
    
    @JoinColumn(name = "aplicacion_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aplicacion aplicacionId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private List<VotanteItem> votanteItemList;

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
        return numVotosMax;
    }

    public void setNumVotosMax(Integer numVotosMax) {
        this.numVotosMax = numVotosMax;
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
