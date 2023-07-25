package com.goularDev.Auth.security;

public class ErroDTO {
	private int status;
	private String menssagem;
	
	public ErroDTO() {
		super();
	}
	public ErroDTO(int status, String menssagem) {
		super();
		this.status = status;
		this.menssagem = menssagem;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMenssagem() {
		return menssagem;
	}
	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}
	
}
