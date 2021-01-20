package com.chango.myBank.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalFormatter {
	public static BigDecimal myDecimalFormat(BigDecimal number)
	{
		return number.setScale(2, RoundingMode.FLOOR);
	}
}
