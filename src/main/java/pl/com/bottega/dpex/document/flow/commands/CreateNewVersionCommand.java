package pl.com.bottega.dpex.document.flow.commands;

import pl.com.bottega.dpex.document.flow.number.DocumentNumber;

public class CreateNewVersionCommand {

	private DocumentNumber documentNumber;

	public DocumentNumber getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(DocumentNumber documentNumber) {
		this.documentNumber = documentNumber;
	}
	
}
