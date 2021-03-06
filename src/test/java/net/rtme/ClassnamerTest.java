/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Sebastian Utz
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.rtme;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

public class ClassnamerTest {

    @Test
    public void testGenerate() throws Exception {
        String generatedClassName = Classnamer.generate();
        String[] parts = generatedClassName.split("(?<=.)(?=\\p{Lu})");

        assertThat(parts[0], isIn(Classnamer.PART_CANDIDATE_FIRST));
        assertThat(parts[1], isIn(Classnamer.PART_CANDIDATE_SECOND));
        assertThat(parts[2], isIn(Classnamer.PART_CANDIDATE_THIRD));
    }

    @Test
    public void testGenerateWithCustomMatrix() throws Exception {
        String[][] matrix = new String[][]{
                new String[]{"My"}, new String[]{"Awesome"}, new String[]{"Class"}};

        String generatedClassName = Classnamer.generate(matrix);
        String[] parts = generatedClassName.split("(?<=.)(?=\\p{Lu})");

        assertThat(parts[0], is("My"));
        assertThat(parts[1], is("Awesome"));
        assertThat(parts[2], is("Class"));
    }

    @Test
    public void testGenerateWithCustomMatrixAndRandom() throws Exception {
        String[][] matrix = new String[][]{
                new String[]{"My"}, new String[]{"Awesome"}, new String[]{"Class"}};
        Random random = new Random();

        String generatedClassName = Classnamer.generate(matrix, random);
        String[] parts = generatedClassName.split("(?<=.)(?=\\p{Lu})");

        assertThat(parts[0], is("My"));
        assertThat(parts[1], is("Awesome"));
        assertThat(parts[2], is("Class"));
    }
}
