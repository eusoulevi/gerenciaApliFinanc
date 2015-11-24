/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cajuinabits.gerenciaaplifinanc;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cotacoes")

public class Cotacoes implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotacoes")
    private List<Acoes> acoesList;

    public Cotacoes() {
    }

    public Cotacoes(Long id) {
        this.id = id;
    }

    public Cotacoes(Long id, Date datetime, double valor) {
        this.id = id;
        this.datetime = datetime;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Acoes> getAcoesList() {
        return acoesList;
    }

    public void setAcoesList(List<Acoes> acoesList) {
        this.acoesList = acoesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotacoes)) {
            return false;
        }
        Cotacoes other = (Cotacoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.cajuinabits.gerenciaaplifinanc.Cotacoes[ id=" + id + " ]";
    }
    
}
