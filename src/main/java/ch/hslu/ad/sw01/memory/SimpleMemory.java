package ch.hslu.ad.sw01.memory;

import java.util.ArrayList;
import java.util.List;

public final class SimpleMemory implements Memory {
    List<Allocation> allocationList = new ArrayList<>();
    private final int totalSize;

    /**
     * Constructor of Class SimpleMemory
     * @param totalSize Total size for the Memory allocation
     */
    public SimpleMemory(final int totalSize) {
        this.totalSize = totalSize;
    }

    @Override
    public Allocation malloc(int allocationSize) {
        return null;
    }


}
