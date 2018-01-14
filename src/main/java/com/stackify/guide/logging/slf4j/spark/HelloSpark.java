package com.stackify.guide.logging.slf4j.spark;

import static spark.Spark.*;

public class HelloSpark {
    public static void main(String[] args) {
        get("/spark", (req, res) -> "Hello Spark");
    }
}
