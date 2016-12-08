package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.commands.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.number.*;
import pl.com.bottega.dpex.document.shared.Settings;

public class DocumentFactory {

    private NumberGenerator numberGenerator;

    public DocumentFactory() {
        if (Settings.CURRENT_SYSTEM.equals("ISO"))
            numberGenerator = new ISONumberGenerator();
        else
            numberGenerator = new QEPNumberGenerator();
        numberGenerator = new AuditorNumberGenerator(numberGenerator);
        numberGenerator = new DemoNumberGenerator(numberGenerator);
    }

    public Document create(CreateDocumentCommand cmd) {
        return new Document(numberGenerator.generate(), cmd);
    }

}
