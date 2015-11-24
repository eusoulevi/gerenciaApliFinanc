
package org.cajuinabits.gerenciaaplifinanc.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author levi.soares
 */
@Entity
public abstract class CotaImpl implements Cota, Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @NotNull
    private long idCota;
    
    @NotNull
    @Column(length = 10)
    private String sigla;
    
    private String descricao;
    
    @Column(length = 3)
    private String tipo;
    
    @OneToMany(mappedBy = "Cotacao")
    @Basic(fetch = FetchType.LAZY)
    private List<Cotacao> cotacoes = new ArrayList<Cotacao>();

    public CotaImpl() {}

    CotaImpl(Double cotacao, Timestamp t) {
        this.cotacoes.add(new Cotacao(cotacao, t));
    }

    public long getIdCota() {
        return idCota;
    }

    public void setIdCota(long idCota) {
        this.idCota = idCota;
    }    
    
    @Override
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String getSigla() {
        return this.sigla;
    }

    @Override
    public void setDescricao(String desc) {
        this.descricao = desc;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public void addCotacao(Double valor, Timestamp t) {
        if (t==null) {
            t = new Timestamp(System.nanoTime());
        }
        Cotacao h = new Cotacao(valor, t);
        this.cotacoes.add(h);
    }
    
    public void addCotacao(Cotacao c) {
        addCotacao(c.getValor(), c.getDatetime());
    }

    @Override
    public List<Cotacao> getHistorico() {
        return this.cotacoes;
    }

    public void setCotacoes(List<Cotacao> cotacoes) {
        this.cotacoes = cotacoes;
    }    

    @Override
    public Double getValor(Timestamp datetime) {
        Double valor = null;
        List<Cotacao> historico = getHistorico();
        for (Iterator<Cotacao> iterator = historico.iterator(); iterator.hasNext();) {
            Cotacao cotacao = iterator.next();
            if (cotacao.getDatetime().equals(datetime)) {
                valor = cotacao.getValor();
            }            
        }
        return valor;
    }

    @Override
    public Double getValorAtual() {
        // Pega a Ultima cotacao apos comparar a que teve o maior timestamp
        List<Cotacao> historico = this.getHistorico();
        Cotacao ultimaCotacao = historico.get(0);
        ListIterator<Cotacao> listIterator = historico.listIterator();
        while (listIterator.hasNext()) {
            Cotacao next = listIterator.next();
            if(next.getDatetime().after(ultimaCotacao.getDatetime())) {
                ultimaCotacao = next;
            }
        }
        return ultimaCotacao.getValor();
    }

    public Cotacao getCotacaoAtual() {
        // Pega a Ultima cotacao apos comparar a que teve o maior timestamp
        List<Cotacao> historico = this.getHistorico();
        Cotacao ultimaCotacao = historico.get(0);
        ListIterator<Cotacao> listIterator = historico.listIterator();
        while (listIterator.hasNext()) {
            Cotacao next = listIterator.next();
            if(next.getDatetime().after(ultimaCotacao.getDatetime())) {
                ultimaCotacao = next;
            }
        }
        return ultimaCotacao;
    }

    public Double getValorMax() {
        // Pega a maior cotacao apos comparar todos os valores
        Cotacao cMax = Collections.max(this.cotacoes);
        return cMax.getValor();
    }

    public Double getValorMin() {
        // Pega a menor cotacao apos comparar todos os valores
        Cotacao cMin = Collections.min(this.cotacoes);
        return cMin.getValor();
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }
    
}
