package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.commands.*;
import pl.com.bottega.dpex.document.flow.infrastructure.InMemoryDocumentRepository;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.flow.number.ISONumberGenerator;
import pl.com.bottega.dpex.document.flow.number.NumberGenerator;
import pl.com.bottega.dpex.document.flow.number.QEPNumberGenerator;
import pl.com.bottega.dpex.document.flow.printing.BWPrintCalculator;
import pl.com.bottega.dpex.document.flow.printing.PrintingCostCalculator;
import pl.com.bottega.dpex.document.flow.printing.RGBCostCalculator;
import pl.com.bottega.dpex.document.shared.Settings;

public class StandardDocumentFlowProcess implements DocumentFlowProcess {

    private NumberGenerator numberGenerator;
    private DocumentRepository documentRepository;
    private PrintingCostCalculator printingCostCalculator;

    public StandardDocumentFlowProcess() {
        if (Settings.CURRENT_SYSTEM.equals("ISO"))
            numberGenerator = new ISONumberGenerator();
        else
            numberGenerator = new QEPNumberGenerator();
        documentRepository = new InMemoryDocumentRepository();
        if(Settings.CURRENT_PRINTER.equals("COLOR"))
            printingCostCalculator = new RGBCostCalculator();
        else
            printingCostCalculator = new BWPrintCalculator();
    }

    @Override
    public DocumentNumber create(CreateDocumentCommand cmd) {
        Document document = new Document(numberGenerator, cmd);
        documentRepository.put(document);
        return document.getNumber();
    }

    @Override
    public void change(ChangeDocumentCommand cmd) {

    }

    @Override
    public void verify(VerifyDocumentCommand cmd) {

    }

    @Override
    public void publish(PublishDocumentCommand cmd) {
        Document document = documentRepository.get(cmd.getDocumentNumber());
        document.publish(printingCostCalculator, cmd);
    }

    @Override
    public void archive(ArchiveDocumentCommand cmd) {

    }

    @Override
    public DocumentNumber createNewVersion(CreateNewVersionCommand cmd) {
        return null;
    }
}
