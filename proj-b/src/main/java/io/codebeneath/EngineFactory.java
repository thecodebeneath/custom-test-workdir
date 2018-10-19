package io.codebeneath;

public class EngineFactory {

    private static final String DEFAULT_SIZE = "V8";
    
    private EngineFactory() { }

    public static Engine getEngine() {
        return getEngine("");
    }
    
    public static Engine getEngine(String size) {
        String engineSize = (size != null) ? size : DEFAULT_SIZE;
        return new Engine(engineSize);
    }
}
