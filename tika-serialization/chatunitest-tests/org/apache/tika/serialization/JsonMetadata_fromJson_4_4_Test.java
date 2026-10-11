package org.apache.tika.serialization;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tika.metadata.Metadata;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Writer;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.tika.serialization.serdes.MetadataSerializer;

public class JsonMetadata_fromJson_4_4_Test {

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = Mockito.mock(ObjectMapper.class);
    }

    @Test
    public void testFromJson_withNullReader() throws IOException {
        Reader reader = null;
        Metadata result = JsonMetadata.fromJson(reader);
        assertNull(result);
    }

    @Test
    public void testFromJson_withValidReader() throws IOException {
        String json = "{\"key\":\"value\"}";
        Reader reader = new StringReader(json);
        Metadata result = JsonMetadata.fromJson(reader);
        assertNotNull(result);
        assertEquals("value", result.get("key"));
    }
}
