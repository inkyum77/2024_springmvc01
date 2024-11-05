package com.ict.sns.controller;

public class KakaoUserResponse {
	private Long id;
	private Properties properties;
	private String connected_at;
	//get, set
	
	public static class Properties{
		private String nickname;
		private String profile_image;
		
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getProfile_image() {
			return profile_image;
		}
		public void setProfile_image(String profile_image) {
			this.profile_image = profile_image;
		}
		
	}
	
	
}
