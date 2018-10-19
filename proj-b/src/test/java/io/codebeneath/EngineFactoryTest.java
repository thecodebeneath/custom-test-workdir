package io.codebeneath;

import org.junit.Test;
import static org.junit.Assert.*;

public class EngineFactoryTest {
    
    @Test
    public void shouldCreateDefaultEngine() {
        Engine e = EngineFactory.getEngine();
        assertTrue(e.toString().contains(":"));
    }
}
