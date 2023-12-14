package GUI;

public interface Displayable {
    void display();

    static  void movePage(Displayable obj) {
        obj.display();
    }
}