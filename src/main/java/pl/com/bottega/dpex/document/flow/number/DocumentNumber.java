package pl.com.bottega.dpex.document.flow.number;

public class DocumentNumber {

    private final String number;

    public DocumentNumber(String nr) {
        this.number = nr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentNumber number1 = (DocumentNumber) o;

        return number.equals(number1.number);

    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }


}
