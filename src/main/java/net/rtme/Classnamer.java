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

import java.util.Random;

/**
 * A Java implementation of the famous classnamer.com.
 * This code is completely derived from the original classnamer ruby implementation,
 * all credits go to its author Aaron Beckerman.
 */
public class Classnamer {

    public static final String VERSION = "0.0.1";

    public static final String[] PART_CANDIDATE_FIRST = new String[] {
            "Threadsafe", "Optimized", "Stable", "Automatic", "Abstract", "Serializable",
            "Writable", "Readable", "Blocking", "Nonblocking", "Scriptable", "Smart", "Basic",
            "Remote", "Simple", "Secure", "Cryptographic", "Flexible", "Configurable", "Internal",
            "Cloneable", "Legacy", "Recursive", "Multiple", "Threaded", "Virtual", "Singleton",
            "Stateless", "Stateful", "Localized", "Prioritized", "Generic", "Dynamic", "Shared",
            "Modal", "Fast", "Temporary"
    };

    public static final String[] PART_CANDIDATE_SECOND = new String[] {
            "Byte", "Task", "Object", "Resource", "Mutex", "Memory", "List", "Node", "File",
            "Lock", "Pixel", "Character", "Command", "Client", "Server", "Socket", "Thread",
            "Notification", "Keystroke", "Timestamp", "Raster", "String", "Hash", "Integer",
            "Cache", "Scrollbar", "Grid", "Package", "Connection", "Database", "Graph", "Row",
            "Column", "Record", "Metadata", "Transaction", "Message", "Request", "Response",
            "Query", "Statement", "Result", "Upload", "Download", "User", "Directory", "Button",
            "Device", "Search", "Lolcat", "Robot"
    };

    public static final String[] PART_CANDIDATE_THIRD = new String[] {
            "Sorter", "Allocator", "Tokenizer", "Writer", "Reader", "Randomizer", "Initializer",
            "Factory", "Panel", "Frame", "Container", "Compressor", "Expander", "Counter",
            "Collector", "Collection", "Wrapper", "Accumulator", "Table", "Marshaller",
            "Demarshaller", "Extractor", "Parser", "Scanner", "Interpreter", "Validator",
            "Window", "Dialog", "Stream", "Listener", "Event", "Exception", "Vector", "Lexer",
            "Analyzer", "Iterator", "Set", "Tree", "Concatenator", "Monitor", "Tester", "Buffer",
            "Selector", "Visitor", "Adapter", "Helper", "Annotation", "Permission", "Info",
            "Action", "Channel", "Filter", "Manager", "Mediator", "Operation", "Context", "Queue",
            "Stack", "View", "Engine", "Publisher", "Subscriber", "Delegator", "State",
            "Processor", "Handler", "Generator", "Dispatcher", "Bundle", "Builder", "Logger",
            "Iterator", "Observer", "Encoder", "Decoder", "Importer", "Exporter", "Util",
            "Policy", "Preference", "Formatter", "Sequence", "Comparator", "Definition", "Timer",
            "Classifier", "Controller", "Loader", "Converter", "Constraint", "Module", "Migrator",
            "Descriptor", "Process"
    };

    public static final String[][] PART_CANDIDATE_MATRIX = new String[][]{
            PART_CANDIDATE_FIRST, PART_CANDIDATE_SECOND, PART_CANDIDATE_THIRD};


    private static final Random RANDOM = new Random(System.nanoTime());

    public static String generate(String[][] matrix, Random random) {
        return matrix[0][random.nextInt(matrix[0].length)]
                + matrix[1][random.nextInt(matrix[1].length)]
                + matrix[2][random.nextInt(matrix[2].length)];
    }

    public static String generate(String[][] matrix) {
        return generate(matrix, RANDOM);
    }

    public static String generate() {
        return generate(PART_CANDIDATE_MATRIX, RANDOM);
    }

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--version")) {
            System.out.println(VERSION);
            return;
        }
        System.out.println(generate());
    }
}
