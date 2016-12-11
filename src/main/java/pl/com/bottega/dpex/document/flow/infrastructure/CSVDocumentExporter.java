package pl.com.bottega.dpex.document.flow.infrastructure;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import pl.com.bottega.dpex.document.flow.DocumentExporter;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.printing.DocumentType;

import java.io.*;
import java.util.Date;

public class CSVDocumentExporter implements DocumentExporter {

    private OutputStream outputStream;
    private CSVPrinter csvPrinter;
    private Object[] record;


    public CSVDocumentExporter(CSVPrinter csvPrinter) {
        this.csvPrinter = csvPrinter;
    }

    @Override
    public void addTitle(String title) {
        record[0] = title;
    }

    @Override
    public void addContent(String content) {
        record[1] = content;
    }

    @Override
    public void addStatus(DocumentStatus status) {
        record[2] = status;
    }

    @Override
    public void addDocumentType(DocumentType type) {
        record[3] = type;
    }

    @Override
    public void addExpirationDate(Date date) {
        record[4] = date;
    }

    @Override
    public void start() {
        record = new Object[5];
        try {
            csvPrinter = new CSVPrinter(
                    new BufferedWriter(new OutputStreamWriter(outputStream)),
                    CSVFormat.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void finish() {
        try {
            csvPrinter.printRecord(record);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
