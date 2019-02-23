package akademia.cars.commons;

public interface Mapper<F, T> {
    T map(F from);
}
