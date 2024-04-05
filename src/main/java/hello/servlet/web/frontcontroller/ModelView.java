package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {

    private final String viewName;
    private final Map<String, Object> model;

    private ModelView(String viewName) {
        this.viewName = viewName;
        model = new HashMap<>();
    }

    private ModelView(String viewName, Map<String, Object> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public static ModelView from(String viewName) {
        return new ModelView(viewName);
    }

    public static ModelView valueOf(String viewName, Map<String, Object> model) {
        return new ModelView(viewName, model);
    }
}
