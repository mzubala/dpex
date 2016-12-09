package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.commands.*;
import pl.com.bottega.dpex.document.flow.infrastructure.InMemoryDocumentRepository;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.flow.validation.DocumentValidatorFactory;

public class StandardDocumentFlowProcess implements DocumentFlowProcess {

    private DocumentRepository documentRepository;
    private DocumentFactory documentFactory;
    private PrintingCostCalculatorFactory printingCostCalculatorFactory;
    private DocumentValidatorFactory documentValidatorFactory;

    public StandardDocumentFlowProcess() {
        documentRepository = new InMemoryDocumentRepository();
        documentFactory = new DocumentFactory();
        printingCostCalculatorFactory = new PrintingCostCalculatorFactory();
        documentValidatorFactory = new DocumentValidatorFactory();
    }

    @Override
    public DocumentNumber create(CreateDocumentCommand cmd) {
        Document document = documentFactory.create(cmd);
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
        document.publish(printingCostCalculatorFactory.create(), documentValidatorFactory.create(), cmd);
    }

    @Override
    public void archive(ArchiveDocumentCommand cmd) {

    }

    @Override
    public DocumentNumber createNewVersion(CreateNewVersionCommand cmd) {
        return null;
    }
}
