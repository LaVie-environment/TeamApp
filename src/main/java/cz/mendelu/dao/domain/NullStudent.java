package cz.mendelu.dao.domain;

public class NullStudent extends Student {
    public NullStudent() {
        super("Unknown");
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
