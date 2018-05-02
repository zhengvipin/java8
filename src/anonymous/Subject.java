package anonymous;

public interface Subject {
    public abstract void teach();
}

class English implements Subject{

    @Override
    public void teach() {
        System.out.println("口语发音");
    }
}
