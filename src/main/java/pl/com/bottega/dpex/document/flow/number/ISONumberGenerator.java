package pl.com.bottega.dpex.document.flow.number;

import java.util.UUID;

public class ISONumberGenerator implements NumberGenerator {

	@Override
	public DocumentNumber generate() {
		return new DocumentNumber("ISO-" + UUID.randomUUID().toString());
	}

}
