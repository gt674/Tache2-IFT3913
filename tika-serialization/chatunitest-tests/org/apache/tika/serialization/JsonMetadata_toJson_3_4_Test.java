package org.apache.tika.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.io.StringWriter;
import org.apache.tika.metadata.Metadata;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Reader;
import java.io.Writer;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadConstraints;
import org.apache.tika.serialization.serdes.MetadataSerializer;

public class JsonMetadata_toJson_3_4_Test {

    private JsonMetadata jsonMetadata;

    private ObjectMapper objectMapper;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        jsonMetadata = new JsonMetadata();
        objectMapper = mock(ObjectMapper.class);
        stringWriter = new StringWriter();
    }

    @Test
    public void testToJson() throws IOException {
        Metadata metadata = new Metadata();
        metadata.set("key1", "value1");
        metadata.set("key2", "value2");
        when(objectMapper.writeValueAsString(metadata)).thenReturn("{\"key1\":\"value1\",\"key2\":\"value2\"}");
        jsonMetadata.toJson(metadata, stringWriter);
        String result = stringWriter.toString();
        assert (result.contains("\"key1\":\"value1\""));
        assert (result.contains("\"key2\":\"value2\""));
    }
}
