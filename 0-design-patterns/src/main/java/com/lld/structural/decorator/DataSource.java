package com.lld.structural.decorator;

/**
 * Component interface for the Decorator pattern.
 *
 * Implementations provide basic read/write operations. Decorators will also
 * implement this interface so they can be composed around concrete components
 * and around other decorators transparently.
 */
public interface DataSource {
    /** Write data to the underlying source (or decorated chain). */
    void writeData(String data);

    /** Read data from the underlying source (or decorated chain). */
    String readData();
}
