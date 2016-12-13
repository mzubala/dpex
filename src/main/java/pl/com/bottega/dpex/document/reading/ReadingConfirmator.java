package pl.com.bottega.dpex.document.reading;

import pl.com.bottega.dpex.document.reading.command.ConfirmDocumentCommand;
import pl.com.bottega.dpex.document.reading.command.ConfirmDocumentForCommand;

public interface ReadingConfirmator {

    void confirm(ConfirmDocumentCommand command);

    void confirmFor(ConfirmDocumentForCommand command);

}
