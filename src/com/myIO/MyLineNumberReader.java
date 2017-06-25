package com.myIO;

import java.io.IOException;
import java.io.Reader;

public class MyLineNumberReader extends MyBufferReader {
private int lineNumber;
	public MyLineNumberReader(Reader isr) {
		super(isr);
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
    public String  MyReadLine() throws IOException
    {
    	lineNumber++;
    	return super.MyreadLine();
    }
}
