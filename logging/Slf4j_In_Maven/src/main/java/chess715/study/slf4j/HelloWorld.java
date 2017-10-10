/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess715.study.slf4j;

/**
 *
 * @author ayrat
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        logger.error("Hello World");

    }
}
