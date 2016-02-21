package org.apache.eagle.correlation.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Created by yonzhang on 2/20/16.
 */
public class ConfigExample {
    public static void main(String[] args){
        Config config = ConfigFactory.load();
        int numBolts = config.getInt("eagle.correlation.numBolts");
        System.out.println(numBolts);
    }
}
