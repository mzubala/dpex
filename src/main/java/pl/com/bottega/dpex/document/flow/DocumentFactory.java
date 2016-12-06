package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.commands.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.number.ISONumberGenerator;
import pl.com.bottega.dpex.document.flow.number.NumberGenerator;
import pl.com.bottega.dpex.document.flow.number.QEPNumberGenerator;
import pl.com.bottega.dpex.document.shared.Settings;

public class DocumentFactory {

    private NumberGenerator numberGenerator;

    public DocumentFactory() {
        if (Settings.CURRENT_SYSTEM.equals("ISO"))
            numberGenerator = new ISONumberGenerator();
        else
            numberGenerator = new QEPNumberGenerator();
    }

    public Document create(CreateDocumentCommand cmd) {
        return new Document(numberGenerator, cmd);
    }

}
