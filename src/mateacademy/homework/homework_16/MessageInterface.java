package mateacademy.homework.homework_16;

public interface MessageInterface<T> {
    public String getTo();

    public String getFrom();

    public T getContent();
}
