package org.apache.tika.serialization;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;

@RunWith(value = JUnitPlatform.class)
@SelectClasses(value = { JsonMetadata_fromJson_4_4_Test.class, JsonMetadata_toJson_3_4_Test.class, JsonMetadata_fromJson_4_0_Test.class, JsonMetadata_Suite.class })
public class JsonMetadata_Suite {
}
