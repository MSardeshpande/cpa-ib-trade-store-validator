package com.db.cpa.trade.validator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.cpa.trade.model.Trade;
import com.db.cpa.trade.service.TradeService;

@SpringBootTest
class CpaTradeStoreValidatorApplicationTests {

	@Mock
	TradeService ts;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	void lowerersionCheck() {
		Trade otrade = new Trade();
		otrade.setVersion(2);
		
		Trade ntrade = new Trade();
		ntrade.setVersion(1);
		
		assertTrue(ts.isLowerVersionTrade(otrade, ntrade));
	}
	
	@Test
	void otherThanLowerVersionCheck() {
		Trade otrade = new Trade();
		otrade.setVersion(2);
		
		Trade ntrade = new Trade();
		ntrade.setVersion(2);
		assertTrue(!ts.isLowerVersionTrade(otrade, ntrade));
	}
	
	@Test
	void findTrade() {
		Trade otrade = new Trade();
		otrade.setTradeId("T1");
		otrade.setVersion(2);
		otrade.setBookId("1");
		otrade.setCounterpartyId("cpty");
		
		when(ts.findTrade("T1", "2")).thenReturn(otrade);
		
		Trade trade = ts.findTrade("T1", "2");
		assertNotNull(trade);
	}
	
	
	@Test
	void findTradeNeg() {
		Trade otrade = new Trade();
		otrade.setTradeId("T1");
		otrade.setVersion(3);
		otrade.setBookId("1");
		otrade.setCounterpartyId("cpty");
		
		when(ts.findTrade("T1", "3")).thenReturn(otrade);
		
		Trade trade = ts.findTrade("T1", "2");
		assertNull(trade);
	}
	
	@Test
	void updateFlag() {
		
	}
	
	@Test
	void maturityDateCheck() {
		
	}
}