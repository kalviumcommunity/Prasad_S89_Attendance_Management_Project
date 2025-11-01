package com.school;

public interface Storable {
    /**
     * Converts the object state into a comma-separated string format
     * suitable for writing to a text file.
     * @return The data string.
     */
    String toDataString();
}