/* ©2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;

import com.elderresearch.viz.gui.UIAction;
import com.elderresearch.viz.gui.swt.events.SelectionLambda;
import com.elderresearch.viz.gui.swt.util.ResourceManager;

public class BuildLink extends BuildControlWithText<Link, BuildLink> {
	private static final String START_TAG = "<a>", END_TAG = "</a>";
	
	protected BuildLink(Link c) {
		super(c, Link::setText);
	}
	
	public BuildLink onSelect(SelectionLambda sl) {
		ref.addSelectionListener(sl);
		return this;
	}

	@Override
	public BuildLink action(UIAction action, ResourceManager rm) {
		super.action(action, rm);
		text(START_TAG + ref.getText() + END_TAG);
		return this;
	}
	
	@Override
	protected BuildLink self() { return this; }
	
	/**
	 * Convenience method to create a link with an accompanying icon for a given action. This is an alternative 
	 * widget to a button but behaves similarly. For layout purposes, two widgets are created in the parent composite.
	 * @param b the builders to use
	 * @param parent the parent composite
	 * @param action the action which determines the image of the icon label, the text and tooltip of the link, and the
	 * action object that is set as the user data for the link.
	 * @return the link for further customization
	 */
	public static BuildLink linkWithImage(SWTBuilders.WithResources b, Composite parent, UIAction action) {
		b.label(parent).image(b.resourceManager().getImage(action.getImage()));
		return b.link(parent).action(action, b.resourceManager());
	}
}
