/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cajuinabits.gerenciaaplifinanc;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
@Embeddable
public class AcoesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCotacoes")
    private long idCotacoes;

    public AcoesPK() {
    }

    public AcoesPK(long id, long idCotacoes) {
        this.id = id;
        this.idCotacoes = idCotacoes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCotacoes() {
        return idCotacoes;
    }

    public void setIdCotacoes(long idCotacoes) {
        this.idCotacoes = idCotacoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idCotacoes;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcoesPK)) {
            return false;
        }
        AcoesPK other = (AcoesPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idCotacoes != other.idCotacoes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.cajuinabits.gerenciaaplifinanc.AcoesPK[ id=" + id + ", idCotacoes=" + idCotacoes + " ]";
    }
    
}
