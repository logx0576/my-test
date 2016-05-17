package me.logx.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class ChannelDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("src/main/java/data/nio-data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48).order(ByteOrder.LITTLE_ENDIAN);
		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			System.out.println("Read " + bytesRead);
			buf.flip();

			while (buf.hasRemaining()) {
//				char ch = (char)buf.get();
//				ch = (char)((ch << 8) + buf.get());
//				System.out.print(ch);
				
//				byte b = buf.get();
//				System.out.println((char) b + " " + (int)b);
				
//				System.out.print(new String(char[]{bytes.getChar()}, "UTF-16"));
				
//				System.out.println(buf.get());
				System.out.println(Integer.toHexString(buf.get()));
			}
//			System.out.println(buf.asCharBuffer());
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}

}
