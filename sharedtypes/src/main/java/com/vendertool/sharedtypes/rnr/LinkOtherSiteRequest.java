package com.vendertool.sharedtypes.rnr;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.LinkAccount;

@XmlRootElement
public class LinkOtherSiteRequest extends BaseRequest {
	private String username;
	private List<LinkAccount> linkAccounts;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<LinkAccount> getLinkAccounts() {
		if(linkAccounts == null){
			linkAccounts = new ArrayList<LinkAccount>();
		}
		return linkAccounts;
	}
	public void setLinkAccounts(List<LinkAccount> linkAccounts) {
		this.linkAccounts = linkAccounts;
	}
}
