package info.skrzypczak.dagmara.restfulClient;

import java.math.BigDecimal;

public class Alert {
	private String pair;
	private BigDecimal limit;

	public Alert(String pair, BigDecimal limit) {
		super();
		this.pair = pair;
		this.limit = limit;
	}

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
	}

	public BigDecimal getLimit() {
		return limit;
	}

	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}

}
