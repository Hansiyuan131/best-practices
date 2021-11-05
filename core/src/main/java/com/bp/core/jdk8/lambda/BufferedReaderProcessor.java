package com.bp.core.jdk8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author hansiyuan
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader reader) throws IOException;
}
