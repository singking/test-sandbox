package com.singking.test1;

import java.math.BigDecimal;
import java.util.Date;

public class Cashflow {
	private Date startDate;
	private Date endDate;
	private BigDecimal amount;

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * was not provided in sumission to citi
	 */
	@Override
	public boolean equals(Object other) {

		if (!(other instanceof Cashflow))
			return false;

		Cashflow o = (Cashflow) other;

		if (!o.getStartDate().equals(this.startDate))
			return false;

		if (!o.getEndDate().equals(this.endDate))
			return false;

		return true;
	}

	/**
	 * was not provided in sumission to citi
	 */
	@Override
	public int hashCode() {

		int hash = 1;
		hash = hash * 41 + (startDate == null ? 0 : startDate.hashCode());
		hash = hash * 41 + (endDate == null ? 0 : endDate.hashCode());
		return hash;
	}
}
