package com.roytuts.email.dto;

public class EmailContent {

	private String recipient;
	private String emailFromAddress;
	private String emailReplyToAddress;
	private String subject;
	private String content;

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getEmailFromAddress() {
		return emailFromAddress;
	}

	public void setEmailFromAddress(String emailFromAddress) {
		this.emailFromAddress = emailFromAddress;
	}

	public String getEmailReplyToAddress() {
		return emailReplyToAddress;
	}

	public void setEmailReplyToAddress(String emailReplyToAddress) {
		this.emailReplyToAddress = emailReplyToAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "EmailContent [recipient=" + recipient + ", emailFromAddress=" + emailFromAddress
				+ ", emailReplyToAddress=" + emailReplyToAddress + ", subject=" + subject + ", content=" + content
				+ "]";
	}

}
