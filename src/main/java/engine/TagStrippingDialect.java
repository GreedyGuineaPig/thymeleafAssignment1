package engine;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.processor.element.IElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.processor.element.MatchingAttributeName;
import org.thymeleaf.processor.element.MatchingElementName;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.Set;

class TagStrippingDialect implements IProcessorDialect {
    public String getName() {
        return null;
    }

    public String getPrefix() {
        return "th";
    }

    public int getDialectProcessorPrecedence() {
        return -1;
    }

    public Set<IProcessor> getProcessors(String s) {
        return Set.of(new TagStrippingProcessor());
    }

    private static class TagStrippingProcessor implements IElementTagProcessor {
        public TemplateMode getTemplateMode() {
            return TemplateMode.HTML;
        }

        public int getPrecedence() {
            return -1;
        }


        public void process(ITemplateContext context, IProcessableElementTag tag, IElementTagStructureHandler handler) {
            for (IAttribute attribute : tag.getAllAttributes()) {
                String name = attribute.getAttributeCompleteName();
                if (name.startsWith("th")) {
                    handler.removeAttribute(name);
                }
            }
        }

        public MatchingElementName getMatchingElementName() {
            return MatchingElementName.forAllElements(TemplateMode.HTML);
        }

        public MatchingAttributeName getMatchingAttributeName() {
            return MatchingAttributeName.forAllAttributesWithPrefix(TemplateMode.HTML, "th");
        }
    }
}
