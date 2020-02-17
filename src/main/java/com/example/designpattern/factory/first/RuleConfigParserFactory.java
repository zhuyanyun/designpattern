//package com.example.designpattern.factory.first;
//
///**
// * Created by zyy on 20/2/16.
// */
//public class RuleConfigParserFactory {
//
//        private static final Map<String, RuleConfigParser> cachedParsers = new HashMap<>();
//
//        static {
//            cachedParsers.put("json", new JsonRuleConfigParser());
//            cachedParsers.put("xml", new XmlRuleConfigParser());
//            cachedParsers.put("yaml", new YamlRuleConfigParser());
//            cachedParsers.put("properties", new PropertiesRuleConfigParser());
//        }
//
//        public static IRuleConfigParser createParser(String configFormat) {
//            if (configFormat == null || configFormat.isEmpty()) {
//                return null;//返回null还是IllegalArgumentException全凭你自己说了算
//            }
//            IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
//            return parser;
//        }
//}
