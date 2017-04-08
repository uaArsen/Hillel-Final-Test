package com.arsenzhd;

import com.arsenzhd.models.IncrementSynchronize;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ArsZhd on 08.04.17.
 * Tests for "synchronize" task.
 * The approach for testing is next we create 3 threads, that once increment value. Than we check that value is
 * equals 3, repeat 100 times to check that method is synchronized.
 */
public class SynchronizeTest {

    @Test
    public void testFirstExample() throws Exception {
        for (int i = 0; i < 100; i++) {
            ExecutorService executor = Executors.newFixedThreadPool(3);
            final IncrementSynchronize incrementSynchronize = new IncrementSynchronize();
            for (int j = 0; j < 3; j++) {
                executor.submit(new Runnable() {
                    public void run() {
                        incrementSynchronize.firstExample();
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
            Assert.assertEquals(3, incrementSynchronize.getValue());
        }
    }

    @Test
    public void testSecondExample() throws Exception {
        for (int i = 0; i < 100; i++) {
            ExecutorService executor = Executors.newFixedThreadPool(3);
            final IncrementSynchronize incrementSynchronize = new IncrementSynchronize();
            for (int j = 0; j < 3; j++) {
                executor.submit(new Runnable() {
                    public void run() {
                        incrementSynchronize.secondExample();
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
            Assert.assertEquals(3, incrementSynchronize.getValue());
        }
    }

    @Test
    public void testThirdExample() throws Exception {
        for (int i = 0; i < 100; i++) {
            ExecutorService executor = Executors.newFixedThreadPool(3);
            final IncrementSynchronize incrementSynchronize = new IncrementSynchronize();
            for (int j = 0; j < 3; j++) {
                executor.submit(new Runnable() {
                    public void run() {
                        incrementSynchronize.thirdExample();
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
            Assert.assertEquals(3, incrementSynchronize.getValue());
        }
    }
}
