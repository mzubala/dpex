package pl.com.bottega.dpex.document.flow.commands;

import pl.com.bottega.dpex.document.flow.number.DocumentNumber;

public class ChangeDocumentCommand {

	private DocumentNumber documentNumber;
	
	private String title, content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DocumentNumber getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(DocumentNumber documentNumber) {
		this.documentNumber = documentNumber;
	}
	
}
