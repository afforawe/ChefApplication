package com.example.chef.util;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class CaloriesUtils {

    final int PERCENT_DIVISOR = 100;

    public BigDecimal caloriesCount(BigDecimal caloriesOneHundred, BigDecimal weight) {
        var div = new BigDecimal(PERCENT_DIVISOR);
        BigDecimal result = caloriesOneHundred.multiply(weight);
        return result.divide(div);
    }
}
