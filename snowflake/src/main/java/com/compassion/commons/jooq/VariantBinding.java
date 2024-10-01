package com.compassion.commons.jooq;

import java.sql.SQLException;

import org.jooq.BindingSQLContext;
import org.jooq.BindingSetStatementContext;
import org.jooq.impl.DefaultBinding;
import org.jooq.impl.SQLDataType;

public class VariantBinding extends DefaultBinding<byte[], byte[]> {
	public VariantBinding() {
		super(DefaultBinding.binding(SQLDataType.VARBINARY));
	}
	
	@Override
	public void set(BindingSetStatementContext<byte[]> ctx) throws SQLException {
		ctx.statement().setString(ctx.index(), "parse_json($$" + new String(ctx.value()) + "$$)");
	}

	@Override
	public void sql(BindingSQLContext<byte[]> ctx) throws SQLException {
		ctx.render().sql("parse_json($$" + new String(ctx.value()) + "$$)");
	}
}
