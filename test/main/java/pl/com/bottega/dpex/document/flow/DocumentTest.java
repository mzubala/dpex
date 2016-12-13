package pl.com.bottega.dpex.document.flow;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.dpex.document.flow.command.CreateDocumentCommand;
import pl.com.bottega.dpex.document.flow.number.DocumentNumber;
import pl.com.bottega.dpex.document.flow.number.NumberGenerator;
import pl.com.bottega.dpex.document.flow.printing.PrintCostCalculator;
import pl.com.bottega.dpex.document.shared.Money;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DocumentTest {

    private CreateDocumentCommand createCommand = new CreateDocumentCommand();

    @Mock
    private NumberGenerator numberGenerator;

    private DocumentNumber documentNumber = new DocumentNumber("MOCK-PROCEDURE");

    @Mock
    private PrintCostCalculator printCostCalculator;

    private Money cost = new Money(new BigDecimal(15));
    private Document document;

    //alternatywa dla mockito:
    //private NumberGenerator numberGenerator = new MockNumberGenerator();

    @Before
    public void setUp() {
        createCommand.setDocumentType(DocumentType.PROCEDURE);
        createCommand.setTitle("test");
        document = createDocument();
        when(printCostCalculator.calculateCost(document)).thenReturn(cost);
    }

    @Test
    public void shouldGenerateNumberOnCreate() {
        //then
        assertThat(document.getNumber()).isEqualTo(documentNumber);
        verify(numberGenerator).generate(DocumentType.PROCEDURE);
    }

    @Test
    public void shouldCalculatePrintingCostOnPublish() {
        //given
        document.verify();

        //when
        document.publish(printCostCalculator);

        //then
        assertThat(document.getPrintCost()).isEqualTo(cost);
    }

    private Document createDocument() {
        when(numberGenerator.generate(DocumentType.PROCEDURE)).thenReturn(documentNumber);
        return new Document(numberGenerator, createCommand);
    }

    class MockNumberGenerator implements NumberGenerator {

        @Override
        public DocumentNumber generate(DocumentType t) {
            return documentNumber;
        }

    }

}
