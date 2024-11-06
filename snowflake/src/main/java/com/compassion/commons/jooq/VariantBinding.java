package com.compassion.commons.jooq;

import java.sql.SQLException;

import org.jooq.BindingSQLContext;
import org.jooq.BindingSetStatementContext;
import org.jooq.impl.DefaultBinding;
import org.jooq.impl.SQLDataType;

public class VariantBinding extends DefaultBinding<String, String> {
	public VariantBinding() {
		super(DefaultBinding.binding(SQLDataType.VARCHAR));
	}
	
	@Override
	public void set(BindingSetStatementContext<String> ctx) throws SQLException {
		ctx.statement().setString(ctx.index(), "parse_json($$" + ctx.value() + "$$)");
	}

	@Override
	public void sql(BindingSQLContext<String> ctx) throws SQLException {
		ctx.render().sql("parse_json($$" + ctx.value() + "$$)");
	}
}
