package org.binvin.samples.immutableq;


import org.binvin.samples.immutableq.core.Queue;
import org.binvin.samples.immutableq.core.ImmutableQueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class ImmutableQueueTest {

    @Test
    public void testDequeue() {
        Queue<Integer> queue = new ImmutableQueue<Integer>();
        final Integer item = 260;
        queue = queue.enQueue(item);
        queue = queue.deQueue();
        assertEquals(queue.head(), null);
    }

    @Test
    public void testEnqueue1() {
        Queue<Integer> queue = new ImmutableQueue<Integer>();
        final Integer item = 100;
        queue = queue.enQueue(item);
        assertEquals(queue.head(), item);
    }


    @Test
    public void testEnqueue2() {
        Queue<Integer> queue = new ImmutableQueue<Integer>();
        final Integer[] items = {1,6,10};
        queue = queue.enQueue(items[0]);
        queue = queue.enQueue(items[1]);
        queue = queue.enQueue(items[2]);
        queue = queue.deQueue();
        queue = queue.deQueue();
        assertEquals(queue.head(), items[2]);
    }

    


}