package org.jahia.modules.doxia;

import org.apache.commons.io.IOUtils;
import org.apache.maven.doxia.ConverterException;
import org.apache.maven.doxia.UnsupportedFormatException;
import org.junit.Test;

import java.io.*;

/**
 * Created by loom on 21.07.14.
 */
public class DoxiaConverterTest {

    @Test
    public void testConvertApt() throws IOException, UnsupportedFormatException, ConverterException {
        InputStream aptInputStream = this.getClass().getClassLoader().getResourceAsStream("input.apt");
        OutputStream aptOutputStream = null;
        try {
            aptOutputStream = new FileOutputStream("input.apt");
            IOUtils.copy(aptInputStream, aptOutputStream);
        } finally {
            IOUtils.closeQuietly(aptInputStream);
            IOUtils.closeQuietly(aptOutputStream);
        }
        File inputFile = new File("input.apt");
        File outputFile = new File("apt-output.html");
        new DoxiaConverter().convert(inputFile.getPath(), "apt", outputFile.getPath());
    }

    @Test
    public void testConvertMarkdown() throws IOException, UnsupportedFormatException, ConverterException {
        InputStream aptInputStream = this.getClass().getClassLoader().getResourceAsStream("input.md");
        OutputStream aptOutputStream = null;
        try {
            aptOutputStream = new FileOutputStream("input.md");
            IOUtils.copy(aptInputStream, aptOutputStream);
        } finally {
            IOUtils.closeQuietly(aptInputStream);
            IOUtils.closeQuietly(aptOutputStream);
        }
        File inputFile = new File("input.md");
        File outputFile = new File("md-output.html");
        new DoxiaConverter().convert(inputFile.getPath(), "markdown", outputFile.getPath());
    }
}
