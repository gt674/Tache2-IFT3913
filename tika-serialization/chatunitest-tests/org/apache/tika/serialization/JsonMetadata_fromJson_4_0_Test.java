package org.apache.tika.serialization;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Reader;
import java.io.Writer;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.serialization.serdes.MetadataSerializer;

@ExtendWith(MockitoExtension.class)
public class JsonMetadata_fromJson_4_0_Test {

    @Test
    public void testFromJson_withNullReader() throws IOException {
        // Arrange
        JsonMetadata jsonMetadata = new JsonMetadata();
        // Act
        Metadata result = jsonMetadata.fromJson(null);
        // Assert
        assertNull(result);
    }

    @Test
    public void testFromJson_withNonNullReader() throws IOException {
        // Arrange
        JsonMetadata jsonMetadata = new JsonMetadata();
        String input = "{\"title\":\"Test Title\",\"author\":\"Test Author\"}";
        StringReader reader = new StringReader(input);
        // Act
        Metadata result = jsonMetadata.fromJson(reader);
        // Assert
        assertEquals("Test Title", result.get("title"));
        assertEquals("Test Author", result.get("author"));
    }
}
