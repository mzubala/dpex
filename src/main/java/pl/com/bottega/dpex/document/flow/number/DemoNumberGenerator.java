package pl.com.bottega.dpex.document.flow.number;

import pl.com.bottega.dpex.document.shared.Settings;

public class DemoNumberGenerator implements NumberGenerator {

    private NumberGenerator decorated;

    public DemoNumberGenerator(NumberGenerator decorated) {
        this.decorated = decorated;
    }

    @Override
    public DocumentNumber generate() {
        DocumentNumber number = decorated.generate();
        if (Settings.DEMO)
            return new DocumentNumber("DEMO-" + number.getNumber());
        return number;
    }
}
