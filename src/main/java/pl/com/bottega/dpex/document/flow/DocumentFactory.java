package pl.com.bottega.dpex.document.flow;

import pl.com.bottega.dpex.document.flow.command.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.flow.number.ISONumberGenerator;
import pl.com.bottega.dpex.document.flow.number.NumberGenerator;
import pl.com.bottega.dpex.document.flow.number.QEPNumberGenerator;
import pl.com.bottega.dpex.document.shared.QualitySystem;
import pl.com.bottega.dpex.document.shared.Settings;

public class DocumentFactory {

    private NumberGenerator numberGenerator;

    public DocumentFactory() {
        if(Settings.getQualitySystem() == QualitySystem.ISO)
            numberGenerator = new ISONumberGenerator();
        else if(Settings.getQualitySystem() == QualitySystem.QEP)
            numberGenerator = new QEPNumberGenerator();
    }

    public Document create(CreateDocumentCommand cmd) {
        DocumentNumber number = numberGenerator.generate(cmd.getDocumentType());
        return new Document(number, cmd);
    }

}
