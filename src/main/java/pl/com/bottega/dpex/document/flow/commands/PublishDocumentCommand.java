package pl.com.bottega.dpex.document.flow.commands;

import java.util.Collection;

import pl.com.bottega.dpex.document.flow.DepartmentId;
import pl.com.bottega.dpex.document.flow.DocumentNumber;

public class PublishDocumentCommand {

	private DocumentNumber documentNumber;

	private Collection<DepartmentId> departmentIds;
	
	public DocumentNumber getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(DocumentNumber documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Collection<DepartmentId> getDepartmentIds() {
		return departmentIds;
	}

	public void setDepartmentIds(Collection<DepartmentId> departmentIds) {
		this.departmentIds = departmentIds;
	}
	
}
