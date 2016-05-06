package traspuesto.andres.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
@Entity
@Table(name = "votante_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VotanteItem.findAll", query = "SELECT v FROM VotanteItem v"),
    @NamedQuery(name = "VotanteItem.findById", query = "SELECT v FROM VotanteItem v WHERE v.id = :id"),
    @NamedQuery(name = "VotanteItem.findByPuntuacion", query = "SELECT v FROM VotanteItem v WHERE v.puntuacion = :puntuacion"),
    @NamedQuery(name = "VotanteItem.findByFecha", query = "SELECT v FROM VotanteItem v WHERE v.fecha = :fecha")})
public class VotanteItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "puntuacion")
    private Integer puntuacion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Item itemId;

    @JoinColumn(name = "votante_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Votante votanteId;

    public VotanteItem() {
    }

    public VotanteItem(Long id) {
        this.id = id;
    }

    public VotanteItem(Long id, int puntuacion, Date fecha) {
        this.id = id;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public Votante getVotanteId() {
        return votanteId;
    }

    public void setVotanteId(Votante votanteId) {
        this.votanteId = votanteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        boolean equals = false;
        if (object != null && object instanceof VotanteItem ) {
            VotanteItem other = (VotanteItem) object;
            if (this.id == null && other.id == null ) {
                equals = true;
            } else if(this.id != null && !this.id.equals(other.id)){
                equals = true;
            }
        }
        return equals;
    }

    @Override
    public String toString() {
        return "VotanteItem[ id=" + id + " ]";
    }

}
