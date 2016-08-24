package com.kwic.pipeandfilter.filter;

/**
 * Created by tanmunaw on 23/8/16.
 * An filter interface for each filter block to follow.
 */
public interface Filter {
    /**
     * Next method is called when the current filter block has finished its role.
     */
    void sentToPipe();
    /**
     * Execute is called to carry out the function of the block.
     */
    void execute();
}
