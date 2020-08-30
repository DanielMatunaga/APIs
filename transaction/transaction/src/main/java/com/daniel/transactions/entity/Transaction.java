package com.daniel.transactions.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Pojo of transaction.
 */
public class Transaction extends Entity
{
    /**
     * Description of the transaction.
     */
    private String descricao;

    /**
     * The date of the transaction.
     */
    private long data;

    /**
     * Value of the transaction.
     */
    private Integer valor;

    /**
     * If the transaction is duplicated.
     */
    private boolean duplicated;

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public long getData()
    {
        return data;
    }

    public void setData(long data)
    {
        this.data = data;
    }

    public Integer getValor()
    {
        return valor;
    }

    public void setValor(Integer valor)
    {
        this.valor = valor;
    }

    public boolean isDuplicated()
    {
        return duplicated;
    }

    public void setDuplicated(boolean duplicated)
    {
        this.duplicated = duplicated;
    }

    @Override
    public boolean equals(final Object other)
    {
        if (!(other instanceof Transaction))
        {
            return false;
        }
        Transaction castOther = (Transaction) other;
        return new EqualsBuilder().appendSuper(super.equals(other)).append(descricao, castOther.descricao).append(data, castOther.data).append(valor, castOther.valor).append(duplicated, castOther.duplicated).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(descricao).append(data).append(valor).append(duplicated).toHashCode();
    }

}
