package com.designDemo;

public class Mail {
private String Receiver;
private String subject;
private String appleation;
private String context;
private String tail;
public Mail(AdvTemplate adv)
{
	this.subject=adv.getSubject();
	this.context=adv.getContext();
}
public String getReceiver() {
	return Receiver;
}
public void setReceiver(String receiver) {
	Receiver = receiver;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getAppleation() {
	return appleation;
}
public void setAppleation(String appleation) {
	this.appleation = appleation;
}
public String getContext() {
	return context;
}
public void setContext(String context) {
	this.context = context;
}
public String getTail() {
	return tail;
}
public void setTail(String tail) {
	this.tail = tail;
}

}
