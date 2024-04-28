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
		
		
		List<Item> itens = new ArrayList<>();
		
		
		//Criar primeiro nivel de rubrica
		for(int i = 0; i <= 10; i++ ) {
			
			Item rubrica = new Item("Rubrica "+i);
			
			for(int irub = 0; irub <= 10; irub++ ) {
				
				Item rubricaSegundoNivel = new Item("Rubrica "+i+"."+irub);
				rubrica.addItens(rubricaSegundoNivel);
				
				for(int irub3 = 0; irub3 <= 2; irub3++ ) {
					
					Item rubricaTerceiroNivel = new Item("Rubrica "+i+"."+irub+"."+irub3);
					rubricaSegundoNivel.addItens(rubricaTerceiroNivel);
				}
			}
			
			itens.add(rubrica);
		}
		
		
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode(TemplateMode.HTML);

	    TemplateEngine templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);

	    Context context = new Context();
	    context.setVariable("to", "Thiago da Silva");
	    context.setVariable("rubs", itens);
	    

	     String process = templateEngine.process("report1", context);

	     String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
	     OutputStream outputStream = new FileOutputStream(outputFolder);

	     ITextRenderer renderer = new ITextRenderer();
	     renderer.setDocumentFromString(process);
	     renderer.layout();
	     renderer.createPDF(outputStream);

	     outputStream.close();
	     
	     
	}

}
