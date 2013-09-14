package com.vendertool.sharedtypes.rnr;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.LinkAccount.LinkSiteEnum;

@XmlRootElement
public class LinkOtherSiteResponse extends BaseResponse {
	private List<LinkSiteEnum> linkSites;

	public List<LinkSiteEnum> getLinkSites() {
		if(linkSites == null) {
			linkSites = new ArrayList<LinkSiteEnum>();
		}
		return linkSites;
	}

	public void setLinkSites(List<LinkSiteEnum> linkSites) {
		this.linkSites = linkSites;
	}
}
