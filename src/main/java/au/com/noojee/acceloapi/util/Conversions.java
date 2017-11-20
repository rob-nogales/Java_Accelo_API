package au.com.noojee.acceloapi.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.javamoney.moneta.Money;

public interface Conversions
{
	static final CurrencyUnit currencyUnit = Monetary.getCurrency(Locale.getDefault());

	public static Money asMoney(double value)
	{
		return Money.of(value, currencyUnit);
	}

	public static double asDouble(Money value)
	{
		return value.getNumber().doubleValue();
	}

	public static LocalDate toLocalDate(long dateToSeconds)
	{
		LocalDate localDate = Instant.ofEpochSecond(dateToSeconds).atZone(ZoneId.systemDefault()).toLocalDate();

		return (localDate.equals(Constants.DATEZERO) ? null : localDate);
	}

	public static long toLong(LocalDate localDate)
	{
		return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond();

	}

	public static Date toDate(LocalDate localDate)
	{
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

}
