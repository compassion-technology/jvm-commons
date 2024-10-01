package com.compassion.commons.jooq;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.NANO_OF_SECOND;
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;
import static java.time.temporal.ChronoField.YEAR;

import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;

import org.jooq.BindingSQLContext;
import org.jooq.Context;
import org.jooq.impl.DefaultBinding;
import org.jooq.impl.SQLDataType;
import org.jooq.tools.StringUtils;

public class CustomTimestampBinding extends DefaultBinding<OffsetDateTime, OffsetDateTime> {
	public CustomTimestampBinding() {
		super(DefaultBinding.binding(SQLDataType.TIMESTAMPWITHTIMEZONE));
	}

	@Override
	public void sql(BindingSQLContext<OffsetDateTime> ctx) throws SQLException {
		ctx.render().sql('\'').sql(escape(ctx.value().format(F_TIMESTAMPTZ), ctx.render())).sql('\'');
	}
	
    private static final DateTimeFormatter F_TIMESTAMPTZ = new DateTimeFormatterBuilder()
            .appendValue(YEAR, 4, 10, SignStyle.NORMAL)
            .appendLiteral('-')
            .appendValue(MONTH_OF_YEAR, 2)
            .appendLiteral('-')
            .appendValue(DAY_OF_MONTH, 2)
            .appendLiteral(' ')
            .appendValue(HOUR_OF_DAY, 2)
            .appendLiteral(':')
            .appendValue(MINUTE_OF_HOUR, 2)
            .appendLiteral(':')
            .appendValue(SECOND_OF_MINUTE, 2)
            .appendFraction(NANO_OF_SECOND, 0, 9, true)
            .appendOffset("+HH:MM", "+00:00")
            .toFormatter();
    
    static final String escape(Object val, Context<?> ctx) {
        return StringUtils.replace(val.toString(), "'", "''");
    }
}
