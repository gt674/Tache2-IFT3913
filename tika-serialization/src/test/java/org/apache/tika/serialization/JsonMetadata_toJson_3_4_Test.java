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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import org.apache.tika.metadata.Metadata;

public class JsonMetadata_toJson_3_4_Test {

    @Test
    public void testToJson() throws IOException {
        StringWriter stringWriter = new StringWriter();
        Metadata metadata = new Metadata();
        metadata.set("key1", "value1");
        metadata.set("key2", "value2");
        JsonMetadata.toJson(metadata, stringWriter);
        String result = stringWriter.toString();
        assertTrue(result.contains("\"key1\":\"value1\""));
        assertTrue(result.contains("\"key2\":\"value2\""));
    }
}
