package pl.com.bottega.dpex.document.reading;

import pl.com.bottega.dpex.document.flow.DocumentNumber;

public class ConfirmReadingCommand {

	private DocumentNumber documentNumber;
	
	private EmployeeId reader;
	
	private EmployeeId confirmator;

	public EmployeeId getReader() {
		return reader;
	}

	public void setReader(EmployeeId reader) {
		this.reader = reader;
	}

	public EmployeeId getConfirmator() {
		return confirmator;
	}

	public void setConfirmator(EmployeeId confirmator) {
		this.confirmator = confirmator;
	}

	public DocumentNumber getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(DocumentNumber documentNumber) {
		this.documentNumber = documentNumber;
	}
	
}
