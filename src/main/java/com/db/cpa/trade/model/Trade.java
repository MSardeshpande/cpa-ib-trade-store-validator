package com.db.cpa.trade.model;

import java.io.Serializable;

/**
 * This is a domain class for storing trade details
 */
public class Trade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3960040615320341208L;

	/*
	 * ID of a trade
	 */
	private String tradeId;
	
	/*
	 * Version of a trade
	 */
	private int version;
	
	/*
	 * Counterparty of a trade
	 */
	private String counterpartyId;
	
	/*
	 * Book id of a trade
	 */
	private String bookId;
	
	/*
	 * Expiry flag of a trade
	 */
	private boolean isExpired;
	
	/*
	 * of a trade
	 */
	private String maturityDate;
	
	/*
	 * of a trade
	 */
	private String creationDate;

	/**
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}

	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the counterpartyId
	 */
	public String getCounterpartyId() {
		return counterpartyId;
	}

	/**
	 * @param counterpartyId the counterpartyId to set
	 */
	public void setCounterpartyId(String counterpartyId) {
		this.counterpartyId = counterpartyId;
	}

	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the isExpired
	 */
	public boolean isExpired() {
		return isExpired;
	}

	/**
	 * @param isExpired the isExpired to set
	 */
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	/**
	 * @return the maturityDate
	 */
	public String getMaturityDate() {
		return maturityDate;
	}

	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
}