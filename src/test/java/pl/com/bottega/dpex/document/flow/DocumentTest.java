package pl.com.bottega.dpex.document.flow;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.dpex.document.flow.commands.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.commands.PublishDocumentCommand;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.flow.printing.PrintingCostCalculator;
import pl.com.bottega.dpex.document.flow.validation.DocumentValidator;
import pl.com.bottega.dpex.document.shared.Money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pl.com.bottega.dpex.document.flow.DocumentStatus.DRAFT;
import static pl.com.bottega.dpex.document.flow.DocumentStatus.PUBLISHED;

@RunWith(MockitoJUnitRunner.class)
public class DocumentTest {

    @Mock
    private DocumentNumber documentNumber;

    private CreateDocumentCommand createCmd = new CreateDocumentCommand();

    private String testTitle = "test";

    private Document document;

    @Mock
    private PrintingCostCalculator costCalculator;

    private PublishDocumentCommand publishCmd = new PublishDocumentCommand();

    @Mock
    private Money cost;

    @Mock
    private DocumentValidator documentValidator;

    @Before
    public void setUp() {
        createCmd.setTitle(testTitle);
        document = new Document(documentNumber, createCmd);
        when(costCalculator.cost(document)).thenReturn(cost);
    }

    @Test
    public void shouldGenerateNumber() {
        assertThat(document.getNumber()).isEqualTo(documentNumber);
    }

    @Test
    public void shouldSetTitle() {
        assertThat(document.getTitle()).isEqualTo(testTitle);
    }

    @Test
    public void shouldValidateDocumentOnVerify() {
        document.verify(documentValidator);

        verify(documentValidator).validate(document, DocumentStatus.VERIFIED);
    }

    @Test
    public void shouldBeDraftAfterCreate() {
        assertThat(document.getStatus()).isEqualTo(DRAFT);
    }

    @Test
    public void shouldCalculateCostOnPublish() {
        document.publish(costCalculator, documentValidator, publishCmd);

        assertThat(document.getPrintingCost()).isEqualTo(cost);
    }

    @Test
    public void shouldChnageStatusOnPublish() {
        document.publish(costCalculator, documentValidator, publishCmd);

        assertThat(document.getStatus()).isEqualTo(PUBLISHED);
    }

    @Test
    public void shouldValidateDocumentOnPublish() {
        document.publish(costCalculator, documentValidator, publishCmd);

        verify(documentValidator).validate(document, DocumentStatus.PUBLISHED);
    }

}
