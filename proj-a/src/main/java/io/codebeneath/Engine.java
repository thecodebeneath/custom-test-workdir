package io.codebeneath;

public class Engine {

    private static final String DEFAULT_SIZE = "V8";
    private final String size;
    
    public Engine(String size) {
        this.size = size;
    }
    
    public String getSize() {
        return (size != null) ? size : DEFAULT_SIZE;
    }
    
    public String toString() {
        return MessageManager.getMessage("msg.engine.size") + size;
    }
}
