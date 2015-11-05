package me.logx.itext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

public class ITextMain {
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/ITextTest.pdf"));
		document.open();

		Anchor anchorTarget = new Anchor("First page of the document.");
		anchorTarget.setName("BackToTop");
		Paragraph paragraph1 = new Paragraph();

		paragraph1.setSpacingBefore(1000);

		paragraph1.add(anchorTarget);
		document.add(paragraph1);

		document.add(new Paragraph("Some more text on the first page with different color and font type.",
				FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0))));
		document.close();
		System.out.println("over");
	}
}
