package ch.hslu.ad.sw01.memory;

import java.util.Objects;

public final class Allocation implements Comparable<Allocation> {
    private final int startAdress;
    private final int allocationSize;

    public Allocation(final int startAdress, final int allocationSize){

        this.startAdress = startAdress;
        this.allocationSize = allocationSize;
    }

    public int getStartAdress() {
        return startAdress;
    }

    public int getAllocationSize() {
        return allocationSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Allocation)) return false;
        Allocation that = (Allocation) o;
        return startAdress == that.startAdress;
    }

    @Override
    public int hashCode() {

        return Objects.hash(startAdress);
    }

    @Override
    public int compareTo(Allocation other) {
        return Integer.compare(this.startAdress, other.startAdress);
    }
}
