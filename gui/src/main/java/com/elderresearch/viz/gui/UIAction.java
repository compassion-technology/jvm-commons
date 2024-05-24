/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui;

/**
 * Stores all the attributes of a user-generated action, without assuming anything
 * about the UI toolkit being used.
 *  
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Sep 25, 2014
 */
public class UIAction {
	private Object name, desc, image, accel;
	private boolean moreInputNeeded;
	
	/**
	 * Creates a new UI action.
	 * @param name the name of the action. This should be short and each word should
	 * be capitalized. This is an object so that the name can be dynamically provided
	 * when {@link Object#toString()} is invoked on the provided object.
	 * @param description a longer description of the operation (optional). This is
	 * usually used for "tool tip" text. This is an object so that the name can be
	 * dynamically provided  when {@link Object#toString()} is invoked on the provided object.
	 * @param image the icon representing the action (optional)
	 * @param accelerator the keyboard shortcut to invoke the action (optional) 
	 */
	public UIAction(Object name, Object description, Object image, Object accelerator) {
		this(name, description, image, accelerator, false);
	}
	
	/**
	 * Creates a new UI action.
	 * @param name the name of the action. This should be short and each word should
	 * be capitalized. This is an object so that the name can be dynamically provided
	 * when {@link Object#toString()} is invoked on the provided object.
	 * @param description a longer description of the operation (optional). This is
	 * usually used for "tool tip" text. This is an object so that the name can be
	 * dynamically provided  when {@link Object#toString()} is invoked on the provided object.
	 * @param image the icon representing the action (optional)
	 * @param accelerator the keyboard shortcut to invoke the action (optional)
	 * @param moreInputNeeded if more input is needed from the user before finishing this action.
	 * This is typically used to provide a hint to the user that they will be prompted for more
	 * input with an ellipsis ({@code "..."}) following the action name.  
	 */
	public UIAction(Object name, Object description, Object image, Object accelerator, boolean moreInputNeeded) {
		this.name  = name;
		this.desc  = description;
		this.image = image;
		this.accel = accelerator;
		this.moreInputNeeded = moreInputNeeded;
	}
	
	public String  getName()           { return name == null? null : name.toString(); }
	public Object  getNameObj()        { return name; }
	public String  getDescription()    { return desc == null? null : desc.toString(); }
	public Object  getDescriptionObj() { return desc; }
	public Object  getImage()          { return image; }
	public Object  getAccelerator()    { return accel; }
	public boolean isMoreInputNeeded() { return moreInputNeeded; }
	
	public void setImage(Object image) { this.image = image; }
	
	@Override
	public String toString() { return getName(); }
}
