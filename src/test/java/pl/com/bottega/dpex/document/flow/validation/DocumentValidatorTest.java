package pl.com.bottega.dpex.document.flow.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pl.com.bottega.dpex.document.flow.Document;
import pl.com.bottega.dpex.document.flow.DocumentStatus;
import pl.com.bottega.dpex.document.flow.validation.managerimpl.AuthorChecker;
import pl.com.bottega.dpex.document.flow.validation.managerimpl.DocumentValidationManager;
import pl.com.bottega.dpex.document.flow.validation.managerimpl.ExpirationDateChecker;
import pl.com.bottega.dpex.document.flow.validation.managerimpl.NumberChecker;
import pl.com.bottega.dpex.document.flow.validation.simplechainimpl.AuthorChainValidator;
import pl.com.bottega.dpex.document.flow.validation.simplechainimpl.DocumentChainValidator;
import pl.com.bottega.dpex.document.flow.validation.simplechainimpl.ExpirationDateValidator;
import pl.com.bottega.dpex.document.flow.validation.simplechainimpl.NumberChainValidator;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class DocumentValidatorTest {

    private Document document = mock(Document.class);

    @Parameterized.Parameters
    public static DocumentValidator[] getData() {
        return new DocumentValidator[]{
                DocumentChainValidator.link(
                        new NumberChainValidator(DocumentStatus.VERIFIED),
                        new ExpirationDateValidator(DocumentStatus.PUBLISHED),
                        new AuthorChainValidator(DocumentStatus.PUBLISHED)
                ),
                new DocumentValidationManager(
                        new NumberChecker(DocumentStatus.VERIFIED),
                        new ExpirationDateChecker(DocumentStatus.PUBLISHED),
                        new AuthorChecker(DocumentStatus.PUBLISHED)
                )
        };
    }

    @Parameterized.Parameter
    public DocumentValidator documentValidator;

    @Test
    public void shouldValidateNumber() {
        try {
            documentValidator.validate(document, DocumentStatus.VERIFIED);
        } catch (DocumentValidationException ex) {
            assertThat(ex.getProblems().getProblems()).containsExactly("Document must have a number");
            return;
        }
        fail("document was valid");
    }

    @Test
    public void shouldValidatePublishedState() {
        try {
            documentValidator.validate(document, DocumentStatus.PUBLISHED);
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
    public void shouldPassValidation() {
        when(document.getExpirationDate()).thenReturn(new Date());
        when(document.getAuthor()).thenReturn("ssss");
        documentValidator.validate(document, DocumentStatus.PUBLISHED);
    }

}
