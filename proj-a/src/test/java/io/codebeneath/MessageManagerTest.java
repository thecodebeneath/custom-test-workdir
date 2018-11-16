package io.codebeneath;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageManagerTest {

    @Test
    public void shouldReturnMessageStringForUnknownKey() {
        assertTrue(MessageManager.MSG_NOT_FOUND.equals(MessageManager.getMessage("unknown.key")));
    }

    @Test
    public void shouldReturnMessageStringForKnownKey() {
        assertTrue("Engine Size:".equals(MessageManager.getMessage("msg.engine.size")));
    }
}
