package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.commands.ArchiveDocumentCommand;
import pl.com.bottega.dpex.document.flow.commands.ChangeDocumentCommand;
import pl.com.bottega.dpex.document.flow.commands.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.commands.CreateNewVersionCommand;
import pl.com.bottega.dpex.document.flow.commands.PublishDocumentCommand;
import pl.com.bottega.dpex.document.flow.commands.VerifyDocumentCommand;

public interface DocumentFlowProcess {

	DocumentNumber create(CreateDocumentCommand cmd);

	void change(ChangeDocumentCommand cmd);

	void verify(VerifyDocumentCommand cmd);

	void publish(PublishDocumentCommand cmd);

	void archive(ArchiveDocumentCommand cmd);

	DocumentNumber createNewVersion(CreateNewVersionCommand cmd);

}
