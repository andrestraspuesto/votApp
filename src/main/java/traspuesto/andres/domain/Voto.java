package traspuesto.andres.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "voto")
@XmlRootElement
public class Voto implements Serializable {

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
    private LocalDateTime fecha;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "votante_id")
    private Long votanteId;

    public Voto() {
    }

    public Voto(Long id) {
        this.id = id;
    }

    public Voto(Long id, int puntuacion, LocalDateTime fecha) {
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getVotanteId() {
        return votanteId;
    }

    public void setVotanteId(Long votante) {
        this.votanteId = votante;
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
        if (object != null && object instanceof Voto ) {
            Voto other = (Voto) object;
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
