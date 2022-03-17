package engine;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Map;

public class Engine {

    protected TemplateEngine engine = new TemplateEngine();

    private Engine() {
        engine.setTemplateResolver(getResolver());
    }

    public static Engine tagStripping() {
        return new TagStrippingEngine();
    }
    public static Engine normal() {
        return new Engine();
    }

    private ClassLoaderTemplateResolver getResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        templateResolver.setCheckExistence(true);
        return templateResolver;
    }

    public String render(Map<String, Object> map) {
        IContext context = makeContextFromMap(map);
        return engine.process("mainTemplate", context);
    }

    private IContext makeContextFromMap(Map<String, Object> map) {
        return new MyContext(map);
    }

    private static class TagStrippingEngine extends Engine {
        TagStrippingEngine() {
            super();
            engine.addDialect(new TagStrippingDialect());
        }
    }
}
