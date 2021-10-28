import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
