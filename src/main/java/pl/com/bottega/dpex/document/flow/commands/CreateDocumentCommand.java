package pl.com.bottega.dpex.document.flow.commands;

import pl.com.bottega.dpex.document.flow.printing.DocumentType;

public class CreateDocumentCommand {

	private String title;
	private DocumentType documentType;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
}
