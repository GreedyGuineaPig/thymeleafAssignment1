package engine;

import org.thymeleaf.context.IContext;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

class MyContext implements IContext {
    private final Map<String, Object> map;

    public MyContext(Map<String, Object> map) {
        this.map = map;
    }

    public Locale getLocale() {
        return Locale.ENGLISH;
    }

    public boolean containsVariable(String s) {
        return map.containsKey(s);
    }

    public Set<String> getVariableNames() {
        return map.keySet();
    }

    public Object getVariable(String s) {
        return map.get(s);
    }
}
