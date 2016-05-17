package me.logx.velocity;

import java.io.ByteArrayInputStream;

import org.apache.velocity.runtime.parser.CharStream;
import org.apache.velocity.runtime.parser.Parser;
import org.apache.velocity.runtime.parser.VelocityCharStream;
import org.apache.velocity.runtime.parser.node.SimpleNode;

public class Main {

	public static void main(String[] args) {
		String temp = "我是一名来自$company的$person.business('short'),我叫$person.name";
	    CharStream stream = new VelocityCharStream(new ByteArrayInputStream(temp.getBytes()), 0, 0);
	    Parser t = new Parser(stream);
	    try {
	        SimpleNode n = t.process();
	        n.dump("");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
