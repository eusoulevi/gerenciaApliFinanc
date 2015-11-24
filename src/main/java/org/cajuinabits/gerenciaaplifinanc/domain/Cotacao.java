
package org.cajuinabits.gerenciaaplifinanc.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author levi.soares
 */
@Entity(name = "cotacoes")
public class Cotacao implements Comparable<Cotacao>, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCotacao;
    
    @ManyToOne()
    @JoinColumn(name = "idCota")
    private Cota cota;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Timestamp datetime;
    
    private Double valor;

    public Cotacao() {
        this.datetime = new Timestamp(System.nanoTime());
    }

    public Cotacao(Double valor) {
        this();
        this.valor = valor;
    }
    
    public Cotacao(String value) {
        this();
        this.valor = Double.valueOf(value);
    }
    
    public Cotacao(Double valor, Timestamp t) {
        if (t==null) {
            t = new Timestamp(System.nanoTime());
        }        
        this.datetime = t;
        this.valor = valor;
    }

    public Long getId() {
        return this.idCotacao;
    }

    public void setId(Long id) {
        this.idCotacao = id;
    }        

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idCotacao);
        hash = 79 * hash + Objects.hashCode(this.datetime);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cotacao other = (Cotacao) obj;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) {
            return false;
        }
        if (this.getDatetime() != other.getDatetime() && (this.getDatetime() == null || !this.getDatetime().equals(other.getDatetime()))) {
            return false;
        }
        if (this.getValor() != other.getValor() && (this.getValor() == null || !this.valor.equals(other.getValor()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cotacao{" + "id=" + idCotacao + ", datetime=" + datetime + ", valor=" + getValor() + '}';
    }

    @Override
    public int compareTo(Cotacao o) {
        return this.valor.compareTo(o.getValor());
    }

    public Cota getCota() {
        return this.cota;
    }

    public void setCota(Cota cota) {
        this.cota = cota;
    }

}
