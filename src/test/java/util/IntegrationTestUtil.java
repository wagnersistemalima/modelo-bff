package util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IntegrationTestUtil {

    public static String fromJsonPath(final String jsonPath) throws IOException {
        try (var inputStream = IntegrationTestUtil.class.getClassLoader().getResourceAsStream(jsonPath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Arquivo não encontrado: " + jsonPath);
            }
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }
}
