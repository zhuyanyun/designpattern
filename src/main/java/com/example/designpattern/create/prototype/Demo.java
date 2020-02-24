package com.example.designpattern.create.prototype;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zyy on 20/2/24.
 */
public class Demo {


        private ConcurrentHashMap<String, SearchWord> currentKeywords = new ConcurrentHashMap<>();
        private long lastUpdateTime = -1;

        public void refresh() {
            // 从数据库中取出更新时间>lastUpdateTime的数据，放入到currentKeywords中
            List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
            long maxNewUpdatedTime = lastUpdateTime;
            for (SearchWord searchWord : toBeUpdatedSearchWords) {
                if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                    maxNewUpdatedTime = searchWord.getLastUpdateTime();
                }
                if (currentKeywords.containsKey(searchWord.getKeyword())) {
                    currentKeywords.replace(searchWord.getKeyword(), searchWord);
                } else {
                    currentKeywords.put(searchWord.getKeyword(), searchWord);
                }
            }

            lastUpdateTime = maxNewUpdatedTime;
        }

        private List<SearchWord> getSearchWords(long lastUpdateTime) {
            // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
            return null;
        }
}
