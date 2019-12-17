package api.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonFileProvider implements AnnotationConsumer<JsonFileSource>, ArgumentsProvider {

    private String resources;
    private Class<?> type;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void accept(JsonFileSource jsonFileSource) {
        try {
            resources = getResources(jsonFileSource.resources());
            this.type = jsonFileSource.type();
        } catch (IOException exeption) {
            exeption.printStackTrace();
        }
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws IOException {
        return getListFromJson().stream().map(Arguments::of);
    }

    private List<Object> getListFromJson() throws IOException {
        List<Object> objects = mapper.readValue(resources, new TypeReference<List<Object>>() {
        });
        return objects.stream().map(this::convertMapToObject).collect(Collectors.toList());
    }

    private String getResources(String fileName) throws IOException {
        URL resource = getClass().getResource(fileName);
        return Resources.toString(resource, Charsets.UTF_8);
    }

    private <T> T convertMapToObject(Object object) {
        return (T) mapper.convertValue(object, type);
    }

}
