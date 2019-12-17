package api.util;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ArgumentsSource(JsonFileProvider.class)

public @interface JsonFileSource {
    Class<?>  type();

    String resources();

}
