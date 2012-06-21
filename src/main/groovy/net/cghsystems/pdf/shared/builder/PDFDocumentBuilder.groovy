package net.cghsystems.pdf.shared.builder

/**
 * Provides the contract where by a Domain object is provided to build a PDF document.
 * 
 * @author chris
 *
 * @param <T> THe domain object to build the PDF document for.
 */
interface PDFDocumentBuilder<T> {

    /**
     * Should generate an PDF representation of T and write it to the provided outputStream
     *
     * @param T. The domain object to generate the PDF representation for.
     * @param outputStream to write the PDF to.
     */
    void generate(T t, OutputStream pdfOutputStream)
}
