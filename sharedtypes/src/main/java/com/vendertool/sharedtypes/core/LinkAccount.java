package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class LinkAccount {
	@XmlEnum
	public enum LinkSiteEnum {
		FACEBOOK, GOOGLE, TWITTER;
	}
	
	private LinkSiteEnum linkSite;
	private String linkSiteUsername;
	private String linkSiteAuthNAuthToken;
	private String linkSiteURL;
	public LinkSiteEnum getLinkSite() {
		return linkSite;
	}
	public void setLinkSite(LinkSiteEnum linkSite) {
		this.linkSite = linkSite;
	}
	public String getLinkSiteUsername() {
		return linkSiteUsername;
	}
	public void setLinkSiteUsername(String linkSiteUsername) {
		this.linkSiteUsername = linkSiteUsername;
	}
	public String getLinkSiteAuthNAuthToken() {
		return linkSiteAuthNAuthToken;
	}
	public void setLinkSiteAuthNAuthToken(String linkSiteAuthNAuthToken) {
		this.linkSiteAuthNAuthToken = linkSiteAuthNAuthToken;
	}
	public String getLinkSiteURL() {
		return linkSiteURL;
	}
	public void setLinkSiteURL(String linkSiteURL) {
		this.linkSiteURL = linkSiteURL;
	}
}
