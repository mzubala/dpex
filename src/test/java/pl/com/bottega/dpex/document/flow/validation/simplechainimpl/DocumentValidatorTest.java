package pl.com.bottega.dpex.document.flow.validation.simplechainimpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.DocumentValidationException;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DocumentValidatorTest {

    @Mock
    private Document document;

    DocumentChainValidator chainValidator = DocumentChainValidator.link(
            new NumberChainValidator(DocumentStatus.VERIFIED),
            new ExpirationDateValidator(DocumentStatus.PUBLISHED),
            new AuthorChainValidator(DocumentStatus.PUBLISHED)
    );

    @Test
    public void shouldValidateNumber() {
        try {
            chainValidator.validate(document, DocumentStatus.VERIFIED);
        } catch (DocumentValidationException ex) {
            assertThat(ex.getProblems().getProblems()).containsExactly("Document must have a number");
            return;
        }
        fail("document was valid");
    }

    @Test
    public void shouldValidatePublishedState() {
        try {
            chainValidator.validate(document, DocumentStatus.PUBLISHED);
        } catch (DocumentValidationException ex) {
            assertThat(ex.getProblems().getProblems()).containsExactly(
                    "Document must have an author",
                    "Document must have expiration date"
            );
            return;
        }
        fail("document was valid");
    }

    @Test
    public  void shouldPassValidation() {
        when(document.getExpirationDate()).thenReturn(new Date());
        when(document.getAuthor()).thenReturn("ssss");
        chainValidator.validate(document, DocumentStatus.PUBLISHED);
    }

}
