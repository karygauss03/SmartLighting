package tn.smart_lighting.entities;

public enum Role {
    Technician(1L),
    Administrator(1L<<1L);

    private final long value;
    Role(long value) {
        this.value = value;
    }

    public long getValue(){
        return value;
    }
}
