package com.kwic.pipeandfilter.pipe;

/**
 * Created by tanmunaw on 24/8/16.
 */
public interface Pipe {

    /**
     * Next method is called to deliver the data to next responsible block.
     */
    void next();
}
