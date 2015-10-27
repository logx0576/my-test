package me.logx.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;

public class ServletOutputStreamWrapper extends ServletOutputStream {

	public ServletOutputStreamWrapper(OutputStream stream) {
		this.stream = stream;
	}

	public void write(int b) throws IOException {
		stream.write(b);
	}

	public void write(byte b[]) throws IOException {
		stream.write(b);
	}

	public void write(byte b[], int off, int len) throws IOException {
		stream.write(b, off, len);
	}

	private OutputStream stream;

}
