package DataBase;

public interface ConsoleDisplay<T> {
    void Display(T[] Instances);
    void DisplayHeadLine();
    void DisplayLine(T instance);
}
