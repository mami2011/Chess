package com.kryptonite.rest.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.neo4j.graphdb.Node;

import com.kryptonite.constants.LoginType;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class UserModel {
	
	private String id;
	private String password;
	private LoginType loginType;
	private String email;
	private String firstName;
	private String lastName;
	private String country;
	private String state;
	private String city;
	private String zipcode;
	private String gender;
	private String phone;
	private List<String> followerUserIds;
	private List<String> followingUserIds;
	private List<String> followingDreamIds;
	@JsonIgnore
	private List<Node> followingUserNodes;
	@JsonIgnore
	private List<Node> followingDreamNodes;
	private AchieverModel achieverDetails;
	private EnablerModel enablerDetails;
	private List<EnableRequestModel> enableRequestsReceivedForThisUserDreams;	//enable requests received for this user dreams
	private List<EnableRequestModel> enableRequestsReceivedForOtherUserDreams;	//enable requests received for other users dreanms
	private List<EnableRequestModel> enableRequestsSentForThisUserDreams;	//enable requests sent for this user dreams
	private List<EnableRequestModel> enableRequestsSentForOtherUserDreams;	//enable requests sent for other user dreams
	private List<String> imageKeys;
	
	public List<String> getImageKeys() {
		return imageKeys;
	}

	public void setImageKeys(List<String> imageKeys) {
		this.imageKeys = imageKeys;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public List<String> getFollowerUserIds() {
		return followerUserIds;
	}

	public void setFollowerUserIds(List<String> followers) {
		this.followerUserIds = followers;
	}
	
	public AchieverModel getAchieverDetails() {
		return achieverDetails;
	}

	public void setAchieverDetails(AchieverModel achieverDetails) {
		this.achieverDetails = achieverDetails;
	}

	public EnablerModel getEnablerDetails() {
		return enablerDetails;
	}

	public void setEnablerDetails(EnablerModel enablerDetails) {
		this.enablerDetails = enablerDetails;
	}

	public List<String> getFollowingUserIds() {
		return followingUserIds;
	}

	public void setFollowingUserIds(List<String> followingers) {
		this.followingUserIds = followingers;
	}

	public List<Node> getFollowingUserNodes() {
		return followingUserNodes;
	}

	public void setFollowingUserNodes(List<Node> followingerNodes) {
		this.followingUserNodes = followingerNodes;
	}

	public List<String> getFollowingDreamIds() {
		return followingDreamIds;
	}

	public void setFollowingDreamIds(List<String> followingDreamIds) {
		this.followingDreamIds = followingDreamIds;
	}

	public List<Node> getFollowingDreamNodes() {
		return followingDreamNodes;
	}

	public void setFollowingDreamNodes(List<Node> followingDreamNodes) {
		this.followingDreamNodes = followingDreamNodes;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<EnableRequestModel> getEnableRequestsReceivedForOtherUserDreams() {
		return enableRequestsReceivedForOtherUserDreams;
	}

	public void setEnableRequestsReceivedForOtherUserDreams(
			List<EnableRequestModel> enableRequestsReceivedForOtherUserDreams) {
		this.enableRequestsReceivedForOtherUserDreams = enableRequestsReceivedForOtherUserDreams;
	}

	public List<EnableRequestModel> getEnableRequestsReceivedForThisUserDreams() {
		return enableRequestsReceivedForThisUserDreams;
	}

	public void setEnableRequestsReceivedForThisUserDreams(
			List<EnableRequestModel> enableRequestsReceivedForThisUserDreams) {
		this.enableRequestsReceivedForThisUserDreams = enableRequestsReceivedForThisUserDreams;
	}

	public List<EnableRequestModel> getEnableRequestsSentForThisUserDreams() {
		return enableRequestsSentForThisUserDreams;
	}

	public void setEnableRequestsSentForThisUserDreams(
			List<EnableRequestModel> enableRequestsSentForThisUserDreams) {
		this.enableRequestsSentForThisUserDreams = enableRequestsSentForThisUserDreams;
	}

	public List<EnableRequestModel> getEnableRequestsSentForOtherUserDreams() {
		return enableRequestsSentForOtherUserDreams;
	}

	public void setEnableRequestsSentForOtherUserDreams(
			List<EnableRequestModel> enableRequestsSentForOtherUserDreams) {
		this.enableRequestsSentForOtherUserDreams = enableRequestsSentForOtherUserDreams;
	}
}
