package com.compassion.commons.gui.swt.cli;

import com.compassion.commons.gui.swt.controls.builders.BuildCombo;
import com.compassion.commons.structs.ObservableSet;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter @Accessors(fluent = true)
class ObservableSelection<T> {
	private ObservableSet<T> items;
	private ObservableSet<T> selection;

	ObservableSelection(BuildCombo<T> combo) {
		this.items = new ObservableSet<>();
		this.selection = new ObservableSet<>();
		
		combo.items(items);
		combo.onSelect(selection::set);
	}
}
