package com.singking.jmock.example2;

import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;


/**
 * http://veerasundar.com/blog/2012/06/easymock-tutorial-getting-started/
 *
 * <code>StockMarket marketMock = EasyMock.createMock(StockMarket.class);
 * EasyMock.expect(marketMock.getPrice("EBAY")).andReturn(42.00);
 * EasyMock.replay(marketMock);
 * </code>
 * <p>
 * <p>
 * In the first line, we ask the EasyMock to create a mock object for our
 * StockMarket interface. And then in the second line, we define how this mock
 * object should behave � i.e., when the getPrice() method is called with the
 * parameter �EBAY�, the mock should return 42.00. And then, we call the
 * replay() method, to make the mock object ready to use.
 */
public class PortfolioTest extends TestCase {

    private Portfolio portfolio;
    private StockMarket marketMock;

    @Before
    public void setUp() {
        portfolio = new Portfolio();
        portfolio.setName("Veera's portfolio.");
        marketMock = EasyMock.createMock(StockMarket.class);
        portfolio.setStockMarket(marketMock);
    }

    @Test
    public void testGetTotalValue() {

        /* = Setup our mock object with the expected values */
        EasyMock.expect(marketMock.getPrice("EBAY")).andReturn(42.00);
        EasyMock.replay(marketMock);

        /* = Now start testing our portfolio */
        Stock ebayStock = new Stock("EBAY", 2);
        portfolio.addStock(ebayStock);
        assertEquals(84.00, portfolio.getTotalValue());
    }

}
