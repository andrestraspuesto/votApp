

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
@Entity
@Table(name = "aplicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicacion.findAll", query = "SELECT a FROM Aplicacion a"),
    @NamedQuery(name = "Aplicacion.findById", query = "SELECT a FROM Aplicacion a WHERE a.id = :id"),
    @NamedQuery(name = "Aplicacion.findByActiva", query = "SELECT a FROM Aplicacion a WHERE a.activa = :activa"),
    @NamedQuery(name = "Aplicacion.findByEmail", query = "SELECT a FROM Aplicacion a WHERE a.email = :email")})
public class Aplicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "activa")
    private Boolean activa;
    
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @Size(max = 150)
    @Column(name = "email")
    private String email;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aplicacionId")
    private List<Votante> votanteList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aplicacionId")
    private List<Item> itemList;

    public Aplicacion() {
    }

    public Aplicacion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Votante> getVotanteList() {
        return votanteList;
    }

    public void setVotanteList(List<Votante> votanteList) {
        this.votanteList = votanteList;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Aplicacion)) {
            return false;
        }
        Aplicacion other = (Aplicacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aplicacion[ id=" + id + " ]";
    }

}
