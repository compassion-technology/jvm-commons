package com.compassion.commons.gui.swt.controls.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.widgets.Combo;

import com.compassion.commons.gui.swt.events.SelectionLambda;
import com.compassion.commons.gui.swt.util.SWTUtilities;
import com.compassion.commons.structs.ObservableSet;

import lombok.val;

public class BuildCombo<T> extends BuildControlWithText<Combo, BuildCombo<T>> {
	private List<T> items;

	protected BuildCombo(Combo combo) {
		super(combo, Combo::setText);
		items = new ArrayList<>();
	}

	public BuildCombo<T> item(T item) {
		items.add(item);
		ref.add(Objects.toString(item, StringUtils.EMPTY));
		return this;
	}

	public BuildCombo<T> clearItems() {
		items.clear();
		ref.removeAll();
		return this;
	}

	public BuildCombo<T> select(T item) {
		val idx = items.indexOf(item);
		ref.deselectAll();
		if (idx >= 0) { ref.select(idx); }
		return this;
	}

	@SafeVarargs @SuppressWarnings("hiding")
	public final BuildCombo<T> items(T... items) {
		for (T item : items) { item(item); }
		return this;
	}

	@SuppressWarnings("hiding")
	public BuildCombo<T> items(Iterable<T> items) {
		for (T item : items) { item(item); }
		return this;
	}

	public BuildCombo<T> items(ObservableSet<T> set) {
		set.addObserver(newSet -> SWTUtilities.run(ref.getDisplay(), () -> {
			clearItems();
			items(newSet);
		}, ref));
		return this;
	}

	public BuildCombo<T> onSelect(Consumer<T> callback) {
		ref.addSelectionListener((SelectionLambda) e -> {
			val idx = ref.getSelectionIndex();
			callback.accept(idx < 0? null : items.get(idx));
		});
		return this;
	}

	@Override
	protected BuildCombo<T> self() { return this; }
}
