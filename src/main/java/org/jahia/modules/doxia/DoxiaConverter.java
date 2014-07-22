package org.jahia.modules.doxia;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.OutputDocument;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTagType;
import org.apache.maven.doxia.Converter;
import org.apache.maven.doxia.ConverterException;
import org.apache.maven.doxia.DefaultConverter;
import org.apache.maven.doxia.UnsupportedFormatException;
import org.apache.maven.doxia.wrapper.InputFileWrapper;
import org.apache.maven.doxia.wrapper.OutputFileWrapper;
import org.apache.tika.io.IOUtils;

import java.io.*;
import java.util.List;

/**
 * Created by loom on 21.07.14.
 */
public class DoxiaConverter {

    public void convert(String inputPath, String inputFormat, String outputPath) throws IOException, UnsupportedFormatException, ConverterException {

        Converter converter = new ExtendedDefaultConverter();
        InputFileWrapper input = InputFileWrapper.valueOf(inputPath, inputFormat, "ISO-8859-1", converter.getInputFormats());
        OutputFileWrapper output = OutputFileWrapper.valueOf(outputPath, "xhtml", "UTF-8", converter.getOutputFormats());

        converter.convert(input, output);

        // extract only the contents of the <body> tag
        Source fullXHTMLSource = new Source(new File(outputPath));
        List<Element> bodyElements = fullXHTMLSource.getAllElements("body");
        StringBuilder bodyContentBuilder = new StringBuilder();
        for (Element bodyElement : bodyElements) {
            bodyContentBuilder.append(bodyElement.getContent().toString());
        }
        FileWriter outputFileWriter = new FileWriter("extracted-" + outputPath);
        IOUtils.write(bodyContentBuilder.toString(), outputFileWriter);
        outputFileWriter.close();
    }
}
