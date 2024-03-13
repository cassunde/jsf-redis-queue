package br.com.cassunde.thymeleaf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

public class PDF {

	public static void main(String[] args) throws IOException, DocumentException {
		
		
		List<Author> authors = new ArrayList<>();
		
		
		for(int i= 0; i<= 1000; i++) {
			authors.add(new Author("Autor "+i, "Alguma coisa "));
		}
		
		
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode(TemplateMode.HTML);

	    TemplateEngine templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);

	    Context context = new Context();
	    context.setVariable("to", "Juremas 4");
	    context.setVariable("books", authors);
	    

	     String process = templateEngine.process("Layout", context);

	     String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
	     OutputStream outputStream = new FileOutputStream(outputFolder);

	     ITextRenderer renderer = new ITextRenderer();
	     renderer.setDocumentFromString(process);
	     renderer.layout();
	     renderer.createPDF(outputStream);

	     outputStream.close();
	     
	     
	}

}
