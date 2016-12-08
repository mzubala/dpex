package pl.com.bottega.dpex.document.flow.number;

import pl.com.bottega.dpex.document.shared.Settings;

public class AuditorNumberGenerator implements NumberGenerator {

    private NumberGenerator decorated;

    public AuditorNumberGenerator(NumberGenerator decorated) {
        this.decorated = decorated;
    }

    @Override
    public DocumentNumber generate() {
        DocumentNumber number = decorated.generate();
        if (Settings.AUDIT)
            return new DocumentNumber("AUDIT-" + number.getNumber());
        return number;
    }
}
