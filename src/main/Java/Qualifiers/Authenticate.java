import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({METHOD,FIELD,TYPE,PARAMETER})
public @interface Authenticate {
    logChoice value();
    public enum logChoice{
        librarian,
        user,
    }
}
