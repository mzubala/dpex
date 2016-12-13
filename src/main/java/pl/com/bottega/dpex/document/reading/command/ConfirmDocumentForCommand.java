package pl.com.bottega.dpex.document.reading.command;

public class ConfirmDocumentForCommand {

    private String documentNumber;

    private Long employeeId, otherEmployeeId;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getOtherEmployeeId() {
        return otherEmployeeId;
    }

    public void setOtherEmployeeId(Long otherEmployeeId) {
        this.otherEmployeeId = otherEmployeeId;
    }

}
