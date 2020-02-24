package com.example.designpattern.create.prototype;

import lombok.Data;

/**
 * Created by zyy on 20/2/24.
 */

@Data
public class SearchWord {

    private Long lastUpdateTime;

    private String keyword;

    private Integer count;
}
