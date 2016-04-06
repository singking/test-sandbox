package saxparser;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestLinkReadXMLFile {

	// TestLink exported TestSuite
	// <?xml version="1.0" encoding="UTF-8"?>
	// <testsuite name="Apollo DemoBet">
	// <node_order><![CDATA[1]]></node_order>
	// <details><![CDATA[]]></details>
	// <testsuite name="Tablet">
	// <node_order><![CDATA[0]]></node_order>
	public static void main(String argv[]) {

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			for (String f : argv) {
				String filename = f.trim();

				ParseTestSuitesXML handler = new ParseTestSuitesXML(filename.substring(filename.lastIndexOf("/") + 1));
				saxParser.parse(filename, handler);

				try (Writer writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(filename + ".csv"), "utf-8"))) {
					writer.write(handler.getCsvData());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ParseTestSuitesXML extends DefaultHandler {

	private final static String CSV_SEPARATOR = "\t";
	StringBuffer buffer = new StringBuffer();
	StringBuffer summary = new StringBuffer();
	boolean bfname = false;
	boolean blname = false;
	boolean bSummary = false;
	boolean bsalary = false;
	String filename;

	List<String> testsuiteName = new ArrayList<>();
	String testcaseeName = null;
	String externalid = null;

	public ParseTestSuitesXML(String filename) {
		this.filename = filename;
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("testsuite")) {
			bfname = true;
			for (int j = 0; j < attributes.getLength(); j++) {
				if ("name".equals(attributes.getQName(j))) {
					String attrVal = attributes.getValue(j);
					// System.out.println(attrVal);
					testsuiteName.add(attrVal);
				}

			}
		}

		if (qName.equalsIgnoreCase("testcase")) {
			blname = true;
			for (int j = 0; j < attributes.getLength(); j++) {
				if ("name".equals(attributes.getQName(j))) {
					String attrVal = attributes.getValue(j);
					// System.out.println(attrVal);
					testcaseeName = attrVal;
				}
				if ("internalid".equals(attributes.getQName(j))) {
					String attrVal = attributes.getValue(j);
					externalid = attrVal;
				}
			}

		}

		if (qName.equalsIgnoreCase("summary")) {
			bSummary = true;
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("summary")) {
			bSummary = false;
		}

		if (qName.equalsIgnoreCase("testsuite")) {
			testsuiteName = new ArrayList<>();
		}

		if (qName.equalsIgnoreCase("testcase")) {
			StringBuilder sb2 = new StringBuilder();
			for (String s : testsuiteName) {
				if (sb2.length() > 0) {
					sb2.append(", ");// do not use dash '-' as its used in some
										// test suite descriptions
				}
				sb2.append(s);
			}

			String sum = summary.toString().replaceAll("&nbsp;", " ").replace("<p>", "").replace("</p>", "")
					.replace("<strong>", "").replace("</strong>", "").replace("<br/>", "").replace("<br>", "").trim();
			String testcase = String.format("%s\t%s\t%s\t%s\t%s", filename, sb2.toString(), externalid, testcaseeName,
					sum);
			System.out.println(testcase);

			buffer.append(testcase + System.getProperty("line.separator"));
			summary.setLength(0);
		}

	}

	public void characters(char ch[], int start, int length) throws SAXException {
		if (bSummary) {
			summary.append(new String(ch, start, length));
			bSummary = false;
		}
	}

	public String getCsvData() {
		return buffer.toString();
	}

	public void resetBuffer() {
		buffer.setLength(0);
	}
}
