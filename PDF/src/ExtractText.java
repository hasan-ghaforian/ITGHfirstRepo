import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class ExtractText {
	private final int it = 0;
	private final int i = 100;
	
	public static void main(String[] args) {
		PDDocument pd;
		BufferedWriter wr;
		try {
			File input = new File(
					"E:\\Data\\Data for DataBase\\Highschool\\class4\\English 4 high school\\EnglishPish.pdf"); // The
																												// PDF
																												// file
																												// from
																												// where
																												// you
																												// would
																												// like
																												// to
																												// extract
			File output = new File(
					"E:\\\\Data\\\\Data for DataBase\\\\Highschool\\\\class4\\\\English 4 high school\\\\EnglishPishWords.txt"); // The
																																	// text
																																	// file
																																	// where
																																	// you
																																	// are
																																	// going
																																	// to
																																	// store
																																	// the
																																	// extracted
																																	// data
			pd = PDDocument.load(input);
			System.out.println(pd.getNumberOfPages());
			System.out.println(pd.isEncrypted());
			pd.save("CopyOfInvoice.pdf"); // Creates a copy called
											// "CopyOfInvoice.pdf"
			PDFTextStripper stripper = new PDFTextStripper();
			stripper.setStartPage(97); // Start extracting from page 3
			stripper.setEndPage(97); // Extract till page 5
			wr = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(output)));
			stripper.writeText(pd, wr);
			if (pd != null) {
				pd.close();
			}
			// I use close() to flush the stream.
			wr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("finished");
	}
}
