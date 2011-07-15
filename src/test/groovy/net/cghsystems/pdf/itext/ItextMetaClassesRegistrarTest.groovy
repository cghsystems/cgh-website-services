package net.cghsystems.pdf.itext;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import com.itextpdf.text.Document
import com.itextpdf.text.pdf.PdfPTable

class ItextMetaClassesRegistrarTest {


	@Before
	void before() {
		ItextMetaClassesRegistrar.register();
	}

	@Test
	void givenItextMetaClassesRegistrarIsRegisteredShouldHaveRegisteredPdfPTableMetaMethods() {
		def expected = [
			"java.lang.Object <init>(boolean, int)",
			"java.lang.Object addCell(java.lang.String)",
			"java.lang.Object addCell(java.lang.String, int)",
			"java.lang.Object addCell(java.lang.String, int, int)",
			"java.lang.Object addEmptyCells(java.lang.Object)"
		]
		def methods = PdfPTable.metaClass.getMethods()
		methods.each {
			expected.remove(it.getSignature())
		}
		assert expected.isEmpty()
	}

	@Test
	void givenItextMetaClassesRegistrarIsRegisteredShouldHaveRegisteredDocumentMetaMethods() {
		def expected = [
			"java.lang.Object addLineBreak()",
			"java.lang.Object newLine()",
		]
		def methods = Document.metaClass.getMethods()
		methods.each {
			expected.remove(it.getSignature())
		}
		assert expected.isEmpty()
	}
}
