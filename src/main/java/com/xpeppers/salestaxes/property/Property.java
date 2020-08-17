package com.xpeppers.salestaxes.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "tax")
public class Property {

    private int basic;
    private int duty;
	public int getBasic() {
		return basic;
	}
	public int getDuty() {
		return duty;
	}
	public void setDuty(int duty) {
		this.duty = duty;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
    
}