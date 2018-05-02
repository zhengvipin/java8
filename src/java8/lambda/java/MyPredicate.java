package java8.lambda.java;

@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
