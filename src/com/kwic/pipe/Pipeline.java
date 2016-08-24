package com.kwic.pipe;

/**
 * Created by tanmunaw on 23/8/16.
 * An pipeline interface for each pipeline block to follow.
 */
public interface Pipeline {
    /**
     * Next method is called when the current pipelines block has finished its role.
     */
    void next();
}
