package me.logx.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;

public class Main {
	public static void main(String[] args) {
		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);
		CharArraySet chs = analyzer.getStopwordSet();
		Object[] a = chs.toArray();
		System.out.println(a.length);
		for (int i = 0; i < a.length; i++) {
			char[] p = (char[]) a[i];
			for(int j = 0; j < p.length; j++) {
				System.out.print(p[j]);
			}
			System.out.println();
		}
	}
}
