package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.command.*;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;

public interface DocumentFlowProcess {

    DocumentNumber create(CreateDocumentCommand command);

    void change(ChangeDocumentCommand command);

    void verify(VerifyDocumentCommand command);

    void archive(ArchiveDocumentCommand command);

    void publish(PublishDocumentCommand command);

    DocumentNumber newVersion(NewDocumentVersionCommand command);

}
