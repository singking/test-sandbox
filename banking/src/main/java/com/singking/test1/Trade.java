package com.singking.test1;

import java.math.BigDecimal;
import java.util.Date;
import java.util.SortedSet;

public class Trade {

    private String tradeId;
    private String tradingBook;
    private BigDecimal notionalAmount;
    private String counterparty;
    private BuySell buySell;
    private Date maturity;
    private SortedSet<Cashflow> cashflows;

    public Trade(String tradeId, String tradingBook) {
        this.tradeId = tradeId;
        this.tradingBook = tradingBook;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradingBook(String tradingBook) {
        this.tradingBook = tradingBook;
    }

    public String getTradingBook() {
        return tradingBook;
    }

    public void setNotionalAmount(BigDecimal notionalAmount) {
        this.notionalAmount = notionalAmount;
    }

    public BigDecimal getNotionalAmount() {
        return notionalAmount;
    }

    public void setCounterparty(String counterparty) {
        this.counterparty = counterparty;
    }

    public String getCounterparty() {
        return counterparty;
    }

    public void setBuySell(BuySell buySell) {
        this.buySell = buySell;
    }

    public BuySell getBuySell() {
        return buySell;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setCashflows(SortedSet<Cashflow> cashflows) {
        this.cashflows = cashflows;
    }

    public SortedSet<Cashflow> getCashflows() {
        return cashflows;
    }

    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Trade))
            return false;

        Trade o = (Trade) other;

        if (!o.getTradeId().equalsIgnoreCase(this.tradeId))
            return false;

        if (!o.getTradingBook().equalsIgnoreCase(this.tradingBook))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 41 + (tradeId == null ? 0 : tradeId.hashCode());
        hash = hash * 41 + (tradingBook == null ? 0 : tradingBook.hashCode());
        return hash;
    }
}
