package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.MarketEnum;

@XmlRootElement
public class AuthorizeMarketRequest extends BaseRequest {
	private MarketEnum market;
	private String marketAuthNAuthToken;
	
	public MarketEnum getMarket() {
		return market;
	}
	public void setMarket(MarketEnum market) {
		this.market = market;
	}
	public String getMarketAuthNAuthToken() {
		return marketAuthNAuthToken;
	}
	public void setMarketAuthNAuthToken(String marketAuthNAuthToken) {
		this.marketAuthNAuthToken = marketAuthNAuthToken;
	}
}
