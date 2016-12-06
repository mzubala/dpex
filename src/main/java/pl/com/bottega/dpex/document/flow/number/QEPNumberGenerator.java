package pl.com.bottega.dpex.document.flow.number;

import java.util.UUID;

public class QEPNumberGenerator implements NumberGenerator {
	@Override
	public DocumentNumber generate() {
		return new DocumentNumber("QEP-" + UUID.randomUUID().toString());
	}
}
