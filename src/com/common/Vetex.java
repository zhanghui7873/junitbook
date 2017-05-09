package com.common;

public class Vetex implements Comparable<Vetex> {

    private  String name;
    private int pathlen;
    private boolean isMarked;
    
	public Vetex(String name) {
		this.name = name;
		this.pathlen=Integer.MAX_VALUE;
		this.isMarked=false;
	}
	public Vetex(String name, int pathlen) {
		this.name = name;
		this.pathlen = pathlen;
		this.isMarked=false;
	}
	
	@Override
	public int compareTo(Vetex o) {
		
		return o.pathlen>this.pathlen?-1:1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPathlen() {
		return pathlen;
	}
	public void setPathlen(int pathlen) {
		this.pathlen = pathlen;
	}
	public boolean isMarked() {
		return isMarked;
	}
	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}
	
	
	
}
