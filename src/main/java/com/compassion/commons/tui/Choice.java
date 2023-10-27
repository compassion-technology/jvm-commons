/* ©2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.tui;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(fluent = true, chain = true)
public class Choice {
	private int ordinal;
	private boolean selected, selectedByDefault;
	
	private String name, description;
	
	public boolean toggle() {
		return this.selected = !selected;
	}
}
