package com.db.cpa.trade.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.db.cpa.trade.model.Trade;

/*
 * This is a service class helps you to store, fetch, validate trades.
 */
@Service
public class TradeService {

	private static final String PATTERN = "dd-MM-YYYY";

	/**
	 * This method helps storing trade details to DB. 
	 * This could actually be a facade to call trade service to store trade to a db
	 */
	public void storeTrade(final Trade trade) {
		//call service  to store trade in database
	}

	/*
	 * Function to format a date on given pattern
	 */
	Function<String, String> cdf = new Function<String, String>() {

		@Override
		public String apply(String dt) {
			return sup.get().format(dt);
		}
	};

	/*
	 * Supplier for Simple Date format
	 */
	Supplier<SimpleDateFormat> sup = new Supplier<>() {

		@Override
		public SimpleDateFormat get() {
			return new SimpleDateFormat(PATTERN); 
		}
	};

	/*
	 * 
	 */
	public void processTrade(final String tradeId, final String tradeVersion, final String maturityDt, final String cpty, final String book) {
		/*
		 * 1. First check if trade exists in DB
		 */

		Trade newTrade = new Trade();
		newTrade.setBookId(book);
		newTrade.setCounterpartyId(cpty);

		String currentDt = cdf.apply(new Date().toString());

		String maturityDate =cdf.apply(maturityDt); 

		newTrade.setCreationDate(currentDt);

		newTrade.setMaturityDate(maturityDate);

		final Trade trade = findTrade(tradeId, tradeVersion);

		if(trade == null) {
			storeTrade(trade);
		} else {
			if(!isTradeValid(trade, newTrade)) {
				storeTrade(newTrade);
			} else {
				System.err.println("Log a business exception on lower version or maturity flag");
			}
		}
	}

	/*
	 * This method helps you to validate trade through given set of rules.
	 */
	public boolean isTradeValid(final Trade oldTrade, final Trade newTrade) {
		return (isTradeMatured(oldTrade, newTrade) || isLowerVersionTrade(oldTrade, newTrade)) ? true:false;
	}

	/*
	 * check if this is lower version trade 
	 */
	public boolean isLowerVersionTrade(Trade oldTrade, Trade newTrade) {
		return oldTrade.getVersion() < newTrade.getVersion() ? true : false;
	}

	/*
	 * check if trade matured
	 */
	public boolean isTradeMatured(final Trade oldTrade, final Trade newTrade) {
		return oldTrade.getMaturityDate().hashCode() < newTrade.getMaturityDate().hashCode();
	}

	/*
	 * function to check if trade expired
	 */
	public boolean isTradeExpired(Trade trade) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * return trades from DB
	 */
	public Trade findTrade(final String tradeId, final String version) {
		//return trade from database
		return new Trade();

	}

	/**
	 * At 00:01 on every day-of-week from Monday through Friday updates expirty flag
	 * 
	 */
	@Scheduled(cron = "0 01 * * 1-5")
	public void updateMaturityFlag() {
		//call db service to update expiry flag
		// we can write update query directly to get this done
		// update trade set expiry = 'Y' where maturity_dt < trunc(sysdate);
	}

}