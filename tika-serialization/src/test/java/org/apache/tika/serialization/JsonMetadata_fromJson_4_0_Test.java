/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tika.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

import org.apache.tika.metadata.Metadata;

public class JsonMetadata_fromJson_4_0_Test {

    @Test
    public void testFromJson_withNullReader() throws IOException {
        Metadata result = JsonMetadata.fromJson(null);
        assertNull(result);
    }

    @Test
    public void testFromJson_withNonNullReader() throws IOException {
        String input = "{\"title\":\"Test Title\",\"author\":\"Test Author\"}";
        StringReader reader = new StringReader(input);
        Metadata result = JsonMetadata.fromJson(reader);
        assertEquals("Test Title", result.get("title"));
        assertEquals("Test Author", result.get("author"));
    }
}
